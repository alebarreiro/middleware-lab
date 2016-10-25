package ticketinco.dao;

import ticketinco.model.Evento;
import java.util.List;
import java.util.Date;

public interface IEventoDAO {

    public  List<Evento> getEventos();

    public Evento getEventoById (long id);

    public Evento getEventoByIdAndDate (long id, Date fecha);

}