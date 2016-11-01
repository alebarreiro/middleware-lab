package ticketinco.service;

import ticketinco.controller.ReservaController;
import ticketinco.controller.VentaController;
import ticketinco.datatype.DataConfirmacionReserva;
import ticketinco.datatype.DataHorario;
import ticketinco.exception.BusinessException;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.Date;
import java.util.List;


@WebService
public class VentaService {

    @WebMethod
    public List<DataHorario> obtenerDisponibilidad(int id, Date fecha) {
        VentaController vc = new VentaController();
        return vc.getDisponibilidadParaEvento(id, fecha);
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

    @WebMethod
    public long reservarEntrada(@WebParam(name = "confirmacion") DataConfirmacionReserva dataConfirmacionReserva) throws Exception {
        ReservaController vc = new ReservaController();

        return vc.reservarEntrada(dataConfirmacionReserva);
    }
}
