package ticketinco.service;

import ticketinco.controller.VentaController;
import ticketinco.datatype.DataDisponibilidad;

import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.Date;
import java.util.List;


@WebService
public class VentaService {

    @WebMethod
    public List<DataDisponibilidad> obtenerDisponibilidad(long id, Date fecha) {
        VentaController vc = new VentaController();
        return vc.getDisponibilidadParaEvento(id,fecha);
    }

    @WebMethod
    public int estadoReserva(long idReserva) {
        VentaController vc = new VentaController();
        return vc.getEstadoReserva(idReserva);
    }

}
