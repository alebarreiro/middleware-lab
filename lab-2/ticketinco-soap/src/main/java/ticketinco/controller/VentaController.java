package ticketinco.controller;

import ticketinco.dao.*;
import ticketinco.datatype.DataDisponibilidad;
import ticketinco.model.Disponibilidad;
import ticketinco.model.Evento;
import ticketinco.model.Horario;
import ticketinco.model.Reserva;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

public class VentaController {

    private IEventoDAO eventoDAO;
    private IReservaDAO reservaDAO;
    private EntityManagerFactory emf;
    private EntityManager em;

    public VentaController() {
        emf = Persistence.createEntityManagerFactory("postgresds");
        em = emf.createEntityManager();
        eventoDAO = new EventoDAOJpa(em, Evento.class);
        reservaDAO = new ReservaDAOJpa(em, Reserva.class);
    }

    public List<DataDisponibilidad> getDisponibilidadParaEvento (long eventoId, Date fechaEvento) {
        List<DataDisponibilidad> resultado = new ArrayList<>();

        Evento evento = eventoDAO.getEventoByIdAndDate(eventoId, fechaEvento);

        List<Horario> horarios = evento.getHorarios();

        for (Horario horario : horarios) {
            DataDisponibilidad dataD = new DataDisponibilidad(horario.getHora(), horario.getDisponibilidades());
            resultado.add(dataD);
        }

        return resultado;
    }

    public int getEstadoReserva (long idReserva) {
        Reserva reserva = reservaDAO.getReserva(idReserva);
        if (reserva != null) {
            return reserva.getEstado().ordinal();
        }
        return -1;
    }

}
