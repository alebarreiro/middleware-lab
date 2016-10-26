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

    public Date getHorario() {
        return horario;
    }

    public List<Disponibilidad> getDisponibilidad() {
        return disponibilidad;
    }
}
