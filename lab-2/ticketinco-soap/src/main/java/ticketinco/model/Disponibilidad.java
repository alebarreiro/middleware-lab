package ticketinco.model;

import java.util.ArrayList;
import java.util.List;

public class Disponibilidad {

    private long id;
    private String sector;
    private double precio;
    private int cantidadDisponible;

    private List<Reserva> reservas = new ArrayList<>();

    public Disponibilidad(long id, String sector, double precio, int cantidadDisponible, List<Reserva> reservas) {
        this.id = id;
        this.sector = sector;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.reservas = reservas;
    }
}
