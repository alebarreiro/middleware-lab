package ticketinco.dao;

import ticketinco.dao.common.GenericJpaDAO;
import ticketinco.model.Disponibilidad;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class DisponibilidadDAO<T> extends GenericJpaDAO<T, Serializable> {

    public DisponibilidadDAO(EntityManager em, Class<T> entityClass) {
        super(em, entityClass);
    }

    public List<Disponibilidad> getDisponibilidades() {
        TypedQuery<Disponibilidad> query = em.createQuery("SELECT d FROM Disponibilidad AS d", Disponibilidad.class);
        return query.getResultList();
    }

    public void actualizarCantidadDisponibles(List<Disponibilidad> disponibilidades) {
        Query query = em.createNativeQuery(
                "UPDATE disponibilidad " +
                        "SET cantidad_disponible = cantidad_inicial - cant_reservas_activas " +
                        "FROM ( " +
                        "  SELECT count(rd.reserva_id) cant_reservas_activas, rd.disponibilidad_id " +
                        "  FROM reserva_disponibilidad AS rd " +
                        "    INNER JOIN reserva AS r ON rd.reserva_id = r.id " +
                        "  WHERE rd.disponibilidad_id IN :disponibilidades AND r.estado = 'PENDIENTE' OR r.estado = 'CONFIRMADO' " +
                        "  GROUP BY rd.disponibilidad_id " +
                        ") AS subquery " +
                        "WHERE disponibilidad.id = subquery.disponibilidad_id"
        );

        query.setParameter("disponibilidades", disponibilidades);
        query.executeUpdate();
    }
}
