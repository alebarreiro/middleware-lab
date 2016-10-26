package ticketinco.datatype;

import ticketinco.model.Disponibilidad;

import java.util.Date;
import java.util.List;

public class DataDisponibilidad {

    public Date horario;
    public List<Disponibilidad> disponibilidad;

    public DataDisponibilidad(Date horario, List<Disponibilidad> disponibilidad) {
        this.horario = horario;
        this.disponibilidad = disponibilidad;
    }
}
