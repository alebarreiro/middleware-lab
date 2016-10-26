package ticketinco.dao;

import ticketinco.dao.common.GenericJpaDAO;
import ticketinco.model.Evento;

import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.persistence.EntityManager;

public class EventoDAOJpa<T> extends GenericJpaDAO<T, Serializable> implements IEventoDAO {

    public EventoDAOJpa(EntityManager em, Class<T> entityClass) {
        super(em, entityClass);
    }

    public void setEventos(List<Evento> eventos) {}

    public  List<Evento> getEventos() {return null;}

    public Evento getEventoById (long id) {
        return (Evento) this.read(id);
    }

    public Evento getEventoByIdAndDate (long id, Date fecha) {
        return (Evento) this.read(id);
    }
}
