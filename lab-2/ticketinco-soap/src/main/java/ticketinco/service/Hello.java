package ticketinco.service;

import ticketinco.dao.EventoDAOJpa;
import ticketinco.datatype.DataDisponibilidad;
import ticketinco.model.Evento;
import ticketinco.model.Horario;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService
public class Hello {

    @WebMethod
    public List<DataDisponibilidad> sayHello() {
        // Ejemplo de uso de emf

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresds");
//
//        List<DataDisponibilidad> resultado = new ArrayList<>();
//        EntityManager em = emf.createEntityManager();
//
//        System.out.println("em is:" + em);
//
//        EventoDAOJpa eventoDAOJpa = new EventoDAOJpa(em, Evento.class);
//
//        Evento evento = eventoDAOJpa.getEventoByIdAndDate(4, new Date());
//
//        List<Horario> horarios = evento.getHorarios();
//
//        for (Horario horario : horarios) {
//            DataDisponibilidad dataD = new DataDisponibilidad(horario.getHora(), horario.getDisponibilidades());
//            resultado.add(dataD);
//        }
//
//        return resultado;

        return null;
    }
}