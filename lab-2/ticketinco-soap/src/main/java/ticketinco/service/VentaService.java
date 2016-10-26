package ticketinco.service;

import ticketinco.controller.VentaController;
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
public class VentaService {

    @WebMethod
    public List<DataDisponibilidad> obtenerDisponibilidad(long id, Date fecha) {
        VentaController vc = new VentaController();
        return vc.getDisponibilidadParaEvento(id,fecha);
    }

}
