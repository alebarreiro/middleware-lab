package ticketinco.dao;

import ticketinco.dao.common.GenericJpaDAO;
import ticketinco.model.Pago;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;

public class PagoDAOJpa<T> extends GenericJpaDAO<T, Serializable> {

    public PagoDAOJpa(EntityManager em, Class<T> entityClass) {
        super(em, entityClass);
    }

    public Pago obtenerPago(long idConfirmacion, long idMedioPago) {
        Query query = em.createQuery(
                "SELECT p " +
                        "FROM Pago p " +
                        "WHERE p.idConfirmacionPartner = :idConfirmacion " +
                        "AND p.idMedioPago = :idMedioPago "
        );

        query.setParameter("idConfirmacion", idConfirmacion);
        query.setParameter("idMedioPago", idMedioPago);

        return (Pago) query.getSingleResult();
    }
}