package ticketinco.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Horario {

    private Date hora;

    private Evento evento;
    private List<Disponibilidad> disponibilidades = new ArrayList<>();

    public Horario(Date hora, Evento evento, List<Disponibilidad> disponibilidades) {
        this.hora = hora;
        this.evento = evento;
        this.disponibilidades = disponibilidades;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Disponibilidad> getDisponibilidades() {
        return disponibilidades;
    }

    public void setDisponibilidades(List<Disponibilidad> disponibilidades) {
        this.disponibilidades = disponibilidades;
    }
}
