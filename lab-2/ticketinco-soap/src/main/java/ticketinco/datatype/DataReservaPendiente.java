package ticketinco.datatype;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DataReservaPendiente implements Serializable {

    private int idEvento;
    private Date fechaEvento;
    List<DataHorario> horarios;

    public DataReservaPendiente() {}

    public DataReservaPendiente(int idEvento, Date fechaEvento, List<DataHorario> horarios) {
        this.idEvento = idEvento;
        this.fechaEvento = fechaEvento;
        this.horarios = horarios;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public List<DataHorario> getHorarios() {
        return horarios;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public void setHorarios(List<DataHorario> horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return "DataReservaPendiente{" +
                "idEvento=" + idEvento +
                ", fechaEvento=" + fechaEvento +
                ", horarios=" + horarios +
                '}';
    }
}
