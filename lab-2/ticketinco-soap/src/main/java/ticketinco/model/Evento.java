package ticketinco.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {

    private long id;
    private Date fecha;
    private List<Horario> horarios = new ArrayList<>();

    public Evento(){}

    public Evento(long id, Date fecha, List<Horario> horarios) {
        this.id = id;
        this.fecha = fecha;
        this.horarios = horarios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return "Evento{" +
                    "id=" + id +
                    ", fecha=" + fecha +
                    ", horarios=" + horarios.toString() +
                '}';
    }
}
