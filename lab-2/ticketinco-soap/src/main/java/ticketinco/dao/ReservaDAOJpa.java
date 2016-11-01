package ticketinco.dao;

import ticketinco.dao.common.GenericJpaDAO;
import ticketinco.datatype.enumeration.TipoEstadoReserva;
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
        TypedQuery<Reserva> query = em.createQuery("SELECT r FROM Reserva AS r", Reserva.class);
        return query.getResultList();
    }

    public Reserva getReserva(long id) {
        Reserva reserva = (Reserva) this.read(id);

        return reserva;
    }

    public void expirarReservas(Date limitDate) {
        Date fechaActualizacion = new Date();

        Query query = em.createQuery(
                "UPDATE Reserva " +
                        "SET estado = :estadoAnulado, updatedAt = :updatedAt " +
                        "WHERE createdAt <= :limitDate AND estado = :estado"
        );

        query.setParameter("limitDate", limitDate);
        query.setParameter("estado", TipoEstadoReserva.PENDIENTE);
        query.setParameter("estadoAnulado", TipoEstadoReserva.EXPIRADO);
        query.setParameter("updatedAt", fechaActualizacion);

        query.executeUpdate();
    }
}