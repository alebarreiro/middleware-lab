package ticketinco.util;

import ticketinco.controller.VentaController;
import ticketinco.dao.EventoDAOMemory;
import ticketinco.dao.IEventoDAO;
import ticketinco.datatype.DataDisponibilidad;
import ticketinco.model.Disponibilidad;
import ticketinco.model.Evento;
import ticketinco.model.Horario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketIncoUtil {

    public TicketIncoUtil () {}

    public void initData () {
        try {

            SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora = new SimpleDateFormat("hh:mm");

            Date fecha1 = fecha.parse("25/10/2015");
            Date fecha2 = fecha.parse("26/10/2015");
            Date fecha3 = fecha.parse("26/10/2015");

            Date hora1 = hora.parse("21:00");
            Date hora2 = hora.parse("22:00");
            Date hora3 = hora.parse("23:00");

            List<Horario> horarios1 = new ArrayList<>();
            List<Horario> horarios2 = new ArrayList<>();
            List<Disponibilidad> disponibilidades1 = new ArrayList<>();
            List<Disponibilidad> disponibilidades2 = new ArrayList<>();
            Evento evento1 = new Evento();
            Evento evento2 = new Evento();
            Evento evento3 = new Evento();

            Disponibilidad d1 = new Disponibilidad(1, "A", 200.0, 10, null);
            Disponibilidad d2 = new Disponibilidad(2, "B", 200.0, 20, null);
            Disponibilidad d3 = new Disponibilidad(3, "A", 200.0, 30, null);

            disponibilidades1.add(d1);
            disponibilidades1.add(d2);
            disponibilidades2.add(d3);

            Horario horario1 = new Horario(hora1, evento1, disponibilidades1);
            Horario horario2 = new Horario(hora2, evento1, disponibilidades1);
            Horario horario3 = new Horario(hora3, evento2, disponibilidades2);

            horarios1.add(horario1);
            horarios1.add(horario2);
            horarios1.add(horario3);
            horarios2.add(horario3);

            evento1.setId(1);
            evento1.setFecha(fecha1);
            evento1.setHorarios(horarios1);

            evento2.setId(1);
            evento2.setFecha(fecha2);
            evento2.setHorarios(horarios1);

            evento3.setId(2);
            evento3.setFecha(fecha3);
            evento3.setHorarios(horarios2);

            List<Evento> eventos = new ArrayList<>();
            eventos.add(evento1);
            eventos.add(evento2);
            eventos.add(evento3);

            IEventoDAO eventoDAO = EventoDAOMemory.getInstancia();
            eventoDAO.setEventos(eventos);

            System.out.println("**** Eventos creados ****");
            for (Evento e : eventos) {
                System.out.println(e.toString());
            }
            System.out.println("**** +++++++++++++++ ****");

        } catch (java.text.ParseException e) {

        }
    }
}
