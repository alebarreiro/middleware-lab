package ticketinco.dao;

import ticketinco.model.Evento;
import java.util.List;
import java.util.Date;

public interface IEventoDAO {

    public void setEventos(List<Evento> eventos);

    public  List<Evento> getEventos();

    public Evento getEventoById (int id);

    public Evento getEventoByIdAndDate (int id, Date fecha);

}