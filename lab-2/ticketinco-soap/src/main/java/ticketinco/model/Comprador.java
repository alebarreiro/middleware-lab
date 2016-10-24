package ticketinco.model;

public class Comprador {

    private long id;
    private String nombre;

    private Reserva reserva;

    public Comprador(long id, String nombre, Reserva reserva) {
        this.id = id;
        this.nombre = nombre;
        this.reserva = reserva;
    }
}
