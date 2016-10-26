package ticketinco.controller;

import ticketinco.dao.EventoDAOMemory;
import ticketinco.dao.IEventoDAO;
import ticketinco.datatype.DataDisponibilidad;
import ticketinco.model.Disponibilidad;
import ticketinco.model.Evento;
import ticketinco.model.Horario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class VentaController {

    private IEventoDAO eventoDAO = EventoDAOMemory.getInstancia();

    public VentaController(){
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

}
