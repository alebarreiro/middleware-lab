package ticketinco.model;

import javax.persistence.*;
import ticketinco.datatype.enumeration.TipoEstadoReserva;

import java.util.Date;
import java.util.List;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        Date now = new Date();

        if (this.createdAt == null) {
            this.updatedAt = now;
        }

        this.createdAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    @ManyToMany
    @JoinTable(
            name="reserva_disponibilidad",
            joinColumns={ @JoinColumn(name="reserva_id") },
            inverseJoinColumns={ @JoinColumn(name="disponibilidad_id") }
    )
    private List<Disponibilidad> disponibilidades;

    @ManyToOne()
    @JoinColumn(name="comprador_id")
    private Comprador comprador;

    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL)
    private Pago pago;

    public Reserva() {}

    public Reserva(TipoEstadoReserva estado, double precioFinal, List<Disponibilidad> disponibilidades) {
        this.estado = estado;
        this.precioFinal = precioFinal;
        this.disponibilidades = disponibilidades;
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

    public List<Disponibilidad> getDisponibilidades() {
        return disponibilidades;
    }

    public void setDisponibilidades(List<Disponibilidad> disponibilidades) {
        this.disponibilidades = disponibilidades;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", estado=" + estado +
                ", precioFinal=" + precioFinal +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", disponibilidades=" + disponibilidades +
                ", comprador=" + comprador +
                ", pago=" + pago +
                '}';
    }
}
