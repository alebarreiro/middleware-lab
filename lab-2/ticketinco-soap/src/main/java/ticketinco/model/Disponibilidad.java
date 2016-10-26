package ticketinco.model;

import java.util.ArrayList;
import java.util.List;

public class Disponibilidad {

    private long id;
    private String sector;
    private double precio;
    private int cantidadDisponible;

    private List<Reserva> reservas = new ArrayList<>();

    public Disponibilidad(){}

    public Disponibilidad(long id, String sector, double precio, int cantidadDisponible, List<Reserva> reservas) {
        this.id = id;
        this.sector = sector;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.reservas = reservas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
