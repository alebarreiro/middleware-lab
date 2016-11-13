package ticketinco.dao;

import ticketinco.dao.common.GenericJpaDAO;
import ticketinco.datatype.DataDisponibilidad;
import ticketinco.model.Disponibilidad;
import ticketinco.model.Horario;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HorarioDAO<T> extends GenericJpaDAO<T, Serializable> {

    public HorarioDAO(EntityManager em, Class<T> entityClass) {
        super(em, entityClass);
    }

    public List<Disponibilidad> getDisponibilidadesDeHorarioPorEvento(int eventoId, Date hora, List<DataDisponibilidad> disponibilidades) {
        Query query = em.createQuery(
                "SELECT d " +
                        "FROM Disponibilidad d " +
                        "WHERE d.horario.hora = :hora " +
                        "AND d.sector IN :sectores " +
                        "AND d.horario.evento.id = :eventoId"
        );

        List<String> sectores = new ArrayList<>();

        for (DataDisponibilidad disponibilidad: disponibilidades) {
            sectores.add(disponibilidad.getSector());
        }

        query.setParameter("eventoId", eventoId);
        query.setParameter("hora", hora);
        query.setParameter("sectores", sectores);

        return (List<Disponibilidad>) query.getResultList();
    }

    public List<Horario> getHorariosEvento(int eventoId, List<Date> horarios) {
        Query query = em.createQuery(
                "SELECT h.id " +
                "FROM Horario AS h " +
                "WHERE h.evento.id = :eventoId " +
                "AND h.hora IN :horarios"
        );

        query.setParameter("eventoId", eventoId);
        query.setParameter("horarios", horarios);

        return (List<Horario>) query.getResultList();
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