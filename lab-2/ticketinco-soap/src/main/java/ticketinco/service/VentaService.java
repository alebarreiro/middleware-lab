package ticketinco.service;

import ticketinco.controller.VentaController;
import ticketinco.datatype.DataDisponibilidad;
import ticketinco.exception.BusinessException;

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
    public int estadoReserva(long idReserva) throws BusinessException {
        VentaController vc = new VentaController();
        int estado = vc.getEstadoReserva(idReserva);
        if (estado == -1) {
           throw new BusinessException("NOT_FOUND", 404, "No existe reserva con dicho id");
        }
        return estado;
    }

}
