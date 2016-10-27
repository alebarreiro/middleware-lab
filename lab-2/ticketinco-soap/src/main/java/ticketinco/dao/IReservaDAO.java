package ticketinco.dao;

import ticketinco.model.Evento;
import ticketinco.model.Reserva;

import java.util.Date;
import java.util.List;

public interface IReservaDAO {

    public List<Reserva> getReservas();

    public Reserva getReserva(long id);

}