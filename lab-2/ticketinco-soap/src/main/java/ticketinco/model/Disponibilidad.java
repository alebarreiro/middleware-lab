package ticketinco.model;

import java.util.ArrayList;
import java.util.List;

public class Disponibilidad {

    private long id;
    private String sector;
    private double precio;
    private int cantidadDisponible;

    private List<Reserva> reservas = new ArrayList<>();

}
