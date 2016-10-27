package ticketinco.model;

import javax.persistence.*;
import ticketinco.datatype.enumeration.TipoEstadoReserva;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @SequenceGenerator(name="reserva_id_seq", sequenceName="reserva_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="reserva_id_seq")
    private long id;

    @Enumerated(EnumType.STRING)
    private TipoEstadoReserva estado;

    private double precioFinal;

    @ManyToOne(optional = false)
    @JoinColumn(name="disponibilidad_id", nullable = false)
    private Disponibilidad disponibilidad;

    @ManyToOne(optional = false)
    @JoinColumn(name="comprador_id", nullable = false)
    private Comprador comprador;

    public Reserva() {}

    public Reserva(long id, TipoEstadoReserva estado, double precioFinal, Disponibilidad disponibilidad, Comprador comprador) {
        this.id = id;
        this.estado = estado;
        this.precioFinal = precioFinal;
        this.disponibilidad = disponibilidad;
        this.comprador = comprador;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public TipoEstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(TipoEstadoReserva estado) {
        this.estado = estado;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
}
