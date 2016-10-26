package ticketinco.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @SequenceGenerator(name="horario_id_seq", sequenceName="horario_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="horario_id_seq")
    private long id;

    @Temporal(TemporalType.TIME)
    private Date hora;

    @ManyToOne(optional = false)
    @JoinColumn(name="evento_id", nullable = false)
    private Evento evento;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "horario")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Disponibilidad> disponibilidades = new ArrayList<>();

    public Horario() {};

    public Horario(Date hora, Evento evento, List<Disponibilidad> disponibilidades) {
        this.hora = hora;
        this.evento = evento;
        this.disponibilidades = disponibilidades;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Disponibilidad> getDisponibilidades() {
        return disponibilidades;
    }

    public void setDisponibilidades(List<Disponibilidad> disponibilidades) {
        this.disponibilidades = disponibilidades;
    }

    @Override
    public String toString() {
        return "Horario{" +
                  "hora=" + hora +
                '}';
    }
}
