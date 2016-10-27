package ticketinco.dao;

import ticketinco.dao.common.GenericJpaDAO;
import ticketinco.model.Evento;
import ticketinco.model.Reserva;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

public class ReservaDAOJpa<T> extends GenericJpaDAO<T, Serializable> implements IReservaDAO {

    public ReservaDAOJpa(EntityManager em, Class<T> entityClass) {
        super(em, entityClass);
    }

    public List<Reserva> getReservas() {
        TypedQuery<Reserva> query = em.createQuery("SELECT * FROM Reserva", Reserva.class);
        return query.getResultList();
    }

    public Reserva getReserva(long id) {
        return (Reserva) this.read(id);
    }

}