package ticketinco.model;

import ticketinco.datatype.enumeration.TipoEstado;

public class Reserva {

    private long id;
    private TipoEstado estado;
    private double precioFinal;

    private Disponibilidad disponibilidad;
    private Comprador comprador;

    public Reserva(long id, TipoEstado estado, double precioFinal, Disponibilidad disponibilidad, Comprador comprador) {
        this.id = id;
        this.estado = estado;
        this.precioFinal = precioFinal;
        this.disponibilidad = disponibilidad;
        this.comprador = comprador;
    }
}
