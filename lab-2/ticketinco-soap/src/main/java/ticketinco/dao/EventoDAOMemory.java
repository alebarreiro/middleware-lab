package ticketinco.dao;

import ticketinco.model.Evento;

import java.util.Date;
import java.util.List;

public class EventoDAOMemory implements IEventoDAO {

    private static EventoDAOMemory instancia = null;
    private List<Evento> eventos;

    private EventoDAOMemory() {}

    public static EventoDAOMemory getInstancia() {
        if (instancia == null) {
            instancia = new EventoDAOMemory();
        }
        return instancia;
    }

    @Override
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public List<Evento> getEventos() {
        return eventos;
    }

    @Override
    public Evento getEventoById (int id) {
        for (Evento e : eventos) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Evento getEventoByIdAndDate (int id, Date fecha) {
        for (Evento e : eventos) {
            if (e.getId() == id && e.getFecha().equals(fecha) ) {
                return e;
            }
        }
        return null;
    }
}
