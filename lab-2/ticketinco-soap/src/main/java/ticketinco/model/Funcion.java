package ticketinco.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcion {

    private Date hora;

    private List<Ticket> tickets = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public Funcion(Date hora, List<Ticket> tickets, List<Reserva> reservas) {
        this.hora = hora;
        this.tickets = tickets;
        this.reservas = reservas;
    }

}
