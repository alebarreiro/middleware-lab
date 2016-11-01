package ticketinco.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @SequenceGenerator(name="evento_id_seq", sequenceName="evento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="evento_id_seq")
    private int id;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evento")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Horario> horarios = new ArrayList<>();

    public Evento(){}

    public Evento(int id, Date fecha, String nombre, List<Horario> horarios) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
        this.horarios = horarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", nombre='" + nombre + '\'' +
                ", horarios=" + horarios +
                '}';
    }
}
