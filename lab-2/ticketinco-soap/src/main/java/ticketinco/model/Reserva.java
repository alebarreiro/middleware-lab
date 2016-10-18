package ticketinco.model;

import ticketinco.datatype.enumeration.TipoEstado;

public class Reserva {

    private long id;
    private TipoEstado estado;
    private String imagen;
    private long idConfirmacion;

    private Ticket ticket;
    private Funcion funcion;

    public Reserva(long id, TipoEstado estado, String imagen, long idConfirmacion, Ticket ticket, Funcion funcion) {
        this.id = id;
        this.estado = estado;
        this.imagen = imagen;
        this.idConfirmacion = idConfirmacion;
        this.ticket = ticket;
        this.funcion = funcion;
    }

}
