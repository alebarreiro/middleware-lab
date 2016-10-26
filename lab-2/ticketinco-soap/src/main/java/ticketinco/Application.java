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
import ticketinco.util.TicketIncoUtil;

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
		inicializarDatos();
		obtenerDisponibilidadEventos();
	}

	public static void inicializarDatos(){
		TicketIncoUtil tic = new TicketIncoUtil();
		tic.initData();
	}

	public static void obtenerDisponibilidadEventos() {

		try {
			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
			Date fecha1 = fecha.parse("25/10/2015");

			VentaController vc = new VentaController();
			List<DataDisponibilidad> ldc = vc.getDisponibilidadParaEvento(1, fecha1);

			for (DataDisponibilidad dd : ldc) {
				System.out.println(dd.toString());
			}

		} catch  (java.text.ParseException e) {

		}

	}
}
