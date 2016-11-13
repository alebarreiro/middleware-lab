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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservaController {
    final static Logger logger = Logger.getLogger(ReservaController.class);

    private EntityManager em;
    private ReservaDAOJpa reservaDAOJpa;
    private DisponibilidadDAO disponibilidadDAO;
    private HorarioDAO horarioDAO;

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
    }

    public long reservarEntrada(DataReservaPendiente dataReservaPendiente) throws Exception {
        List<Disponibilidad> disponibilidades = this.getDisponibilidadesAReservar(dataReservaPendiente);

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
    public int cancelarReserva(long idReserva) throws Exception {
        em.getTransaction().begin();
        Reserva reserva = reservaDAOJpa.getReserva(idReserva);
        int resultado;
        if (reserva != null){
            reserva.setEstado(TipoEstadoReserva.CANCELADO);
            resultado = 1;
        }else{
            resultado = -1;
        }

        em.getTransaction().commit();
        em.close();
        return resultado;
    }
    // TODO: move this to its controller
    private List<Disponibilidad> getDisponibilidadesAReservar(DataReservaPendiente dataReservaPendiente) {
        List<Disponibilidad> res = new ArrayList<>();

        System.out.println("iterando horarios");
        for (DataHorario horario: dataReservaPendiente.getHorarios()) {
            System.out.println("current horario: " + horario.toString());
            List<Disponibilidad> disponibilidades = horarioDAO
                    .getDisponibilidadesDeHorarioPorEvento(dataReservaPendiente.getIdEvento(), horario.getHorario(), horario.getDisponibilidades());

            res.addAll(disponibilidades);
        }

        System.out.println("disponibilidades obtenidas" + res.toString());

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
        Date fechaLimiteExpiracion = DateUtil.addSeconds(new Date(), -60);

        logger.debug("expirarReservas - fecha limite: " + fechaLimiteExpiracion);

        em.getTransaction().begin();
        reservaDAOJpa.expirarReservas(fechaLimiteExpiracion);
        em.getTransaction().commit();

        em.close();
    }

    public DataNotificacionReserva confirmarReserva(DataReservaConfirmada dataReservaConfirmada) throws BusinessException {
        logger.info("REQUEST confrirmarReserva: " + dataReservaConfirmada.toString());

        long idReserva = dataReservaConfirmada.getIdReserva();
        Reserva reserva;

        try {
            reserva = reservaDAOJpa.getReserva(idReserva);
        } catch (Exception e) {
            throw new BusinessException("NOT_FOUND", 404, "No existe reserva con id: " + idReserva);
        }

        if (reserva.getEstado() != TipoEstadoReserva.PENDIENTE) {
            throw new BusinessException("UNPROCESSABLE_ENTITY", 422, "La reserva " + idReserva + "  no se encuentra en estado pendiente: " + reserva.getEstado());
        }

        DataVenta dv = new DataVenta();
        dv.setMonto(reserva.getPrecioFinal());
        dv.setDigitoVerificador(dataReservaConfirmada.getDigitoVerificador());
        dv.setNroTarjeta(Long.parseLong(dataReservaConfirmada.getNroTarjeta(), 10));
        dv.setFechaVencimiento(dataReservaConfirmada.getFechaVencimiento().toString());

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
                throw new BusinessException("UNPROCESSABLE_ENTITY", 422, "Id de medio de pago desconocido" + dataReservaConfirmada.getIdMedioPago());
        }

        java.util.List<Image> tickets = new ArrayList<Image>();

        try {
            List<Disponibilidad> disponibilidades = reserva.getDisponibilidades();

            logger.info("disponibilidades: " + disponibilidades.toString());

            //Generamos tickets
            for (Disponibilidad d : disponibilidades) {
                logger.info("GENERANDO TICKET PARA DISPONIBILIDAD " + d.toString());

                BufferedImage ticketTemplate = new BufferedImage(600, 200, BufferedImage.TYPE_INT_ARGB);
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

            //Marcamos la reserva como confirmada
            em.getTransaction().begin();
            reserva.setEstado(TipoEstadoReserva.CONFIRMADO);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.info("ERROR GENERANDO TICKET: " + e.getMessage());
            throw new BusinessException("INTERNAL_ERROR", 500, e.getMessage());
        }
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
