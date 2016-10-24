package ticketinco.model;

import ticketinco.datatype.enumeration.TipoEstado;

public class Reserva {

    private long id;
    private TipoEstado estado;
    private double precioFinal;

    private Disponibilidad disponibilidad;
    private Comprador comprador;

}
