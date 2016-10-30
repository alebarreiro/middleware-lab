package ticketinco.datatype;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DataHorario implements Serializable {

    private Date horario;
    private List<DataDisponibilidad> disponibilidades;

    public DataHorario() {}

    public DataHorario(Date horario, List<DataDisponibilidad> disponibilidades) {
        this.horario = horario;
        this.disponibilidades = disponibilidades;
    }

    public Date getHorario() {
        return horario;
    }

    public List<DataDisponibilidad> getDisponibilidades() {
        return disponibilidades;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public void setDisponibilidades(List<DataDisponibilidad> disponibilidades) {
        this.disponibilidades = disponibilidades;
    }

    @Override
    public String toString() {
        return "DataHorario{" +
                    "horario=" + horario +
                    ", disponibilidad=" + disponibilidades.toString() +
                '}';
    }
}
