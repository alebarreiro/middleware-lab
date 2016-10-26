package ticketinco.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "disponibilidad")
public class Disponibilidad {

    @Id
    @SequenceGenerator(name="disponibilidad_id_seq", sequenceName="disponibilidad_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="disponibilidad_id_seq")
    private long id;

    private String sector;
    private double precio;

    @Column(name = "cantidad_disponible")
    private int cantidadDisponible;

    @ManyToOne(optional = false)
    @JoinColumn(name="horario_id", nullable = false)
    private Horario horario;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "disponibilidad")
    @Fetch(value = FetchMode.SUBSELECT)
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

    @Override
    public String toString() {
        return "Disponibilidad{" +
                "id=" + id +
                    ", sector=" + sector +
                    ", precio=" + precio +
                    ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }
}
