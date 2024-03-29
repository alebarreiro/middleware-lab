package ticketinco.controller;

import ticketinco.dao.*;
import ticketinco.datatype.DataNotificacionReserva;
import ticketinco.datatype.DataReservaConfirmada;
import ticketinco.datatype.DataReservaPendiente;
import ticketinco.datatype.DataHorario;
import ticketinco.datatype.enumeration.TipoEstadoReserva;
import ticketinco.exception.BusinessException;
import ticketinco.model.*;
import ticketinco.util.DateUtil;
import ticketinco.util.EmfUtil;
import org.apache.log4j.Logger;
import ws.com.ticketinco.esb.DataVenta;
import ws.com.ticketinco.esb.WsPagosLocalService;
import ws.com.ticketinco.esb.WsPagosYaService;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import ticketinco.model.Disponibilidad;

public class ReservaController {
    final static Logger logger = Logger.getLogger(ReservaController.class);

    private EntityManager em;
    private ReservaDAOJpa reservaDAOJpa;
    private DisponibilidadDAO disponibilidadDAO;
    private HorarioDAO horarioDAO;
    private PagoDAOJpa pagoDAO;

    static {
        try {
            Class.forName("ticketinco.controller.JobController");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ReservaController() {
        em = EmfUtil.getInstance().getEntityManager();
        reservaDAOJpa = new ReservaDAOJpa(em, Reserva.class);
        disponibilidadDAO = new DisponibilidadDAO(em, Reserva.class);
        horarioDAO = new HorarioDAO(em, Horario.class);
        pagoDAO = new PagoDAOJpa(em, Pago.class);
    }

    public long reservarEntrada(DataReservaPendiente dataReservaPendiente) throws Exception {
        List<Disponibilidad> disponibilidades = this.getDisponibilidadesAReservar(dataReservaPendiente);

        for (Disponibilidad disponibilidad: disponibilidades) {
            if (disponibilidad.getCantidadDisponible() == 0) {
                throw new BusinessException("Sin Disponibilidad", 422, "No hay entradas disponibles para el sector" + disponibilidad.getSector());
            }
        }

        em.getTransaction().begin();
        Reserva reserva = new Reserva(
                TipoEstadoReserva.PENDIENTE,
                getPrecioFinal(disponibilidades),
                disponibilidades
        );

        reservaDAOJpa.create(reserva);
        this.actualizarCantidadDisponibles(disponibilidades);

        em.getTransaction().commit();
        em.close();

        return reserva.getId();
    }
    public int cancelarReserva(long idPago, long idMedioPago, long idAnulacion) throws Exception {
        int resultado = 1;

        em.getTransaction().begin();

        Pago pago = pagoDAO.obtenerPago(idPago, idMedioPago);

        if (pago != null) {
            pago.setIdAnulacionParner(idAnulacion);
            pago.setFechaAnulacion(new Date());

            Reserva reserva = pago.getReserva();

            if (reserva != null) {
                reserva.setEstado(TipoEstadoReserva.CANCELADO);
            }
        } else {
            resultado = -1;
        }

        em.getTransaction().commit();
        em.close();

        return resultado;
    }

    private List<Disponibilidad> getDisponibilidadesAReservar(DataReservaPendiente dataReservaPendiente) {
        List<Disponibilidad> res = new ArrayList<>();

        for (DataHorario horario: dataReservaPendiente.getHorarios()) {
            List<Disponibilidad> disponibilidades = horarioDAO
                    .getDisponibilidadesDeHorarioPorEvento(dataReservaPendiente.getIdEvento(), horario.getHorario(), horario.getDisponibilidades());

            res.addAll(disponibilidades);
        }

        return res;
    }

    private double getPrecioFinal(List<Disponibilidad> disponibilidades) {
        int precioFinal = 0;

        for (Disponibilidad disponibilidad: disponibilidades) {
            precioFinal += disponibilidad.getPrecio();
        }

        return precioFinal;
    }

    private void actualizarCantidadDisponibles(List<Disponibilidad> disponibilidades) {
        disponibilidadDAO.actualizarCantidadDisponibles(disponibilidades);
    }

    public void expirarReservas() {
        Date fechaLimiteExpiracion = DateUtil.addSeconds(new Date(), -60 * 3);

        logger.debug("expirarReservas - fecha limite: " + fechaLimiteExpiracion);

        em.getTransaction().begin();
        reservaDAOJpa.expirarReservas(fechaLimiteExpiracion);
        em.getTransaction().commit();

        em.close();
    }

    public DataNotificacionReserva confirmarReserva(DataReservaConfirmada dataReservaConfirmada) {
        logger.info("REQUEST confrirmarReserva: " + dataReservaConfirmada.toString());

        long idReserva = dataReservaConfirmada.getIdReserva();
        Reserva reserva;

        try {
            reserva = reservaDAOJpa.getReserva(idReserva);
        } catch (Exception e) {
            return new DataNotificacionReserva(0, null, true, "No existe reserva con id: " + idReserva);
        }

        if (reserva.getEstado() != TipoEstadoReserva.PENDIENTE) {
            return new DataNotificacionReserva(0, null, true, "La reserva " + idReserva + "  no se encuentra en estado pendiente");
        }

        DataVenta dv = new DataVenta();
        dv.setMonto(reserva.getPrecioFinal());
        dv.setDigitoVerificador(dataReservaConfirmada.getDigitoVerificador());
        dv.setNroTarjeta(Long.parseLong(dataReservaConfirmada.getNroTarjeta(), 10));

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setTimeZone(tz);
        String dateAsISO = df.format(dataReservaConfirmada.getFechaVencimiento());
        dv.setFechaVencimiento(dateAsISO);

        long idConfirmacion;

        //Obtenemos id confirmacion pago
        switch ((int) dataReservaConfirmada.getIdMedioPago()) {
            case 1:
                //PagosYa REST
                WsPagosYaService wsPagosYa = new WsPagosYaService();
                idConfirmacion = wsPagosYa.getWsPagosYaPort().confirmarPago(dv).getIdConfirmacion();
                break;
            case 2:
                //Pago Local JMS
                WsPagosLocalService wsPagosLocal = new WsPagosLocalService();
                idConfirmacion = wsPagosLocal.getWsPagosLocalPort().confirmarPago(dv).getIdConfirmacion();
                break;
            default:
                return new DataNotificacionReserva(0, null, true, "Id de medio de pago desconocido");
        }

        java.util.List<Image> tickets = new ArrayList<Image>();

        try {
            List<Disponibilidad> disponibilidades = reserva.getDisponibilidades();

            logger.info("disponibilidades: " + disponibilidades.toString());

            //Generamos tickets
            for (Disponibilidad d : disponibilidades) {
                logger.info("GENERANDO TICKET PARA DISPONIBILIDAD " + d.toString());

                BufferedImage ticketTemplate = new BufferedImage(800, 200, BufferedImage.TYPE_INT_ARGB);
                Graphics g = ticketTemplate.getGraphics();
                g.setFont(g.getFont().deriveFont(30f));
                g.setColor(Color.black);

                if (dataReservaConfirmada.getIdMedioPago() == 1) {
                    g.drawString("Pagado por PagosYA - Reserva #" + idReserva, 70, 60);
                } else {
                    g.drawString("Pagado por TicketInco - Reserva #" + idReserva, 70, 60);
                }

                g.drawString("Horario: " + d.getHorario().getHora(), 70, 90);
                g.drawString("Sector: " + d.getSector(), 70, 120);
                g.drawString("Precio: " + d.getPrecio(), 70, 150);
                g.drawString("Número de confirmación: " + idConfirmacion, 70, 190);
                g.dispose();

                tickets.add(ticketTemplate);
            }

            em.getTransaction().begin();

            Pago pago = new Pago();
            pago.setDigitoVerificador(dataReservaConfirmada.getDigitoVerificador());
            pago.setFechaVencimiento(dataReservaConfirmada.getFechaVencimiento());
            pago.setIdConfirmacionPartner(idConfirmacion);
            pago.setIdMedioPago(dataReservaConfirmada.getIdMedioPago());
            pago.setReserva(reserva);
            pago.setTarjeta(dataReservaConfirmada.getNroTarjeta());

            pagoDAO.create(pago);

            reserva.setEstado(TipoEstadoReserva.CONFIRMADO);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.info("ERROR GENERANDO TICKET: " + e.getMessage());
            return new DataNotificacionReserva(0, null, true, e.getMessage());
            //throw new BusinessException("INTERNAL_ERROR", 500, e.getMessage());
        }

        logger.info("FIN GENERAR RESERVA : " + idConfirmacion );
        return new DataNotificacionReserva(idConfirmacion, tickets);
    }

    public int getEstadoReserva (long idReserva) {
        Reserva reserva = reservaDAOJpa.getReserva(idReserva);
        if (reserva != null) {
            return reserva.getEstado().ordinal();
        }
        return -1;
    }

}
