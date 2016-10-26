package ticketinco.datatype;

import ticketinco.model.Disponibilidad;

import java.util.Date;
import java.util.List;

public class DataDisponibilidad {

    public Date horario;
    public List<Disponibilidad> disponibilidades;

    public DataDisponibilidad(Date horario, List<Disponibilidad> disponibilidades) {
        this.horario = horario;
        this.disponibilidades = disponibilidades;
    }

    public Date getHorario() {
        return horario;
    }

    public List<Disponibilidad> getDisponibilidad() {
        return disponibilidades;
    }

    @Override
    public String toString() {
        return "DataDisponibilidad{" +
                    "horario=" + horario +
                    ", disponibilidad=" + disponibilidades.toString() +
                '}';
    }
}
