package ticketinco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ticketinco.controller.VentaController;
import ticketinco.dao.EventoDAOMemory;
import ticketinco.dao.IEventoDAO;
import ticketinco.datatype.DataDisponibilidad;
import ticketinco.model.Disponibilidad;
import ticketinco.model.Evento;
import ticketinco.model.Horario;

import javax.sound.midi.Soundbank;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		testDisponibilidad();
	}

	public static void testDisponibilidad(){
		try {

			System.out.println("HELLO WORLD");

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date eventDate = sdf.parse("25/10/2015");
			SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm");
			Date eventHour = sdf2.parse("22:00");
			List<Horario> horarios = new ArrayList<>();
			List<Disponibilidad> disponibilidades = new ArrayList<>();
			Evento e1 = new Evento();
			Horario h = new Horario(eventHour,e1, disponibilidades);
			Disponibilidad d = new Disponibilidad(2, "A", 200.0, 20, null);
			disponibilidades.add(d);
			horarios.add(h);
			e1.setId(1);
			e1.setFecha(eventDate);
			e1.setHorarios(horarios);

			IEventoDAO eventoDAO = EventoDAOMemory.getInstancia();
			List<Evento> eventos = new ArrayList<>();
			eventos.add(e1);
			eventoDAO.setEventos(eventos);

			VentaController vc = new VentaController();
			List<DataDisponibilidad> ldc = vc.getDisponibilidadParaEvento(1, eventDate);

			for (DataDisponibilidad dd : ldc) {
				System.out.println(dd.getHorario());
				for (Disponibilidad disp : dd.getDisponibilidad()) {
					System.out.println(disp.getPrecio());
				}
			}

		} catch (java.text.ParseException e) {

		}
	}
}
