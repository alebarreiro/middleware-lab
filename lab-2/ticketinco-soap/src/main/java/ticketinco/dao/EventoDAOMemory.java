package ticketinco.dao;

import ticketinco.model.Evento;

import java.util.Date;
import java.util.List;

public class EventoDAOMemory implements IEventoDAO {


    private List<Evento> eventos;

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public List<Evento> getEventos() {
        return eventos;
    }

    @Override
    public Evento getEventoById (long id) {
        for (Evento e : eventos) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Evento getEventoByIdAndDate (long id, Date fecha) {
        for (Evento e : eventos) {
            if (e.getId() == id && e.getFecha() == fecha ) {
                return e;
            }
        }
        return null;
    }
}
