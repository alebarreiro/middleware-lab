package ticketinco.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcion {

    private Date hora;
    private List<Ticket> tickets = new ArrayList<>();

    public Funcion(Date hora, List<Ticket> tickets) {
        this.hora = hora;
        this.tickets = tickets;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
