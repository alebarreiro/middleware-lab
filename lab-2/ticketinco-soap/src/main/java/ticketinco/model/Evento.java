package ticketinco.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {

    private long id;
    private Date fecha;
    private List<Horario> horarios = new ArrayList<>();

    public Evento(long id, Date fecha, List<Horario> horarios) {
        this.id = id;
        this.fecha = fecha;
        this.horarios = horarios;
    }

}
