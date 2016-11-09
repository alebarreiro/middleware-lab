package ticketinco.controller;

import ticketinco.dao.*;
import ticketinco.datatype.DataReservaPendiente;
import ticketinco.datatype.DataHorario;
import ticketinco.datatype.enumeration.TipoEstadoReserva;
import ticketinco.model.*;
import ticketinco.util.DateUtil;
import ticketinco.util.EmfUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReservaController {

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

        System.out.println("fecha limite + " + fechaLimiteExpiracion.toString());

        em.getTransaction().begin();
        reservaDAOJpa.expirarReservas(fechaLimiteExpiracion);
        em.getTransaction().commit();

        // TODO: falta actualizar la cantidad disponible

        em.close();
    }



}
