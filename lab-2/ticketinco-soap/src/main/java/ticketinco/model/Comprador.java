package ticketinco.model;

import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "comprador")
public class Comprador {

    @Id
    @SequenceGenerator(name="comprador_id_seq", sequenceName="comprador_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comprador_id_seq")
    private long id;

    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "comprador")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Reserva> reservas;

    public Comprador(String nombre, List<Reserva> reservas) {
        this.nombre = nombre;
        this.reservas = reservas;
    }
}
