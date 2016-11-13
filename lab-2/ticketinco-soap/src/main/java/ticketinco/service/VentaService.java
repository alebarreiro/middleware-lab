package ticketinco.service;

import org.apache.log4j.Logger;
import ticketinco.datatype.DataNotificacionReserva;
import ticketinco.datatype.DataReservaConfirmada;
import ticketinco.datatype.DataReservaPendiente;
import ticketinco.controller.ReservaController;
import ticketinco.controller.VentaController;
import ticketinco.datatype.DataHorario;
import ticketinco.exception.BusinessException;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.Action;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.MTOM;
import java.util.Date;
import java.util.List;

@MTOM(enabled=true)
@WebService
public class VentaService {
    final static Logger logger = Logger.getLogger(VentaService.class);

    @WebMethod(action = "obtenerDisponibilidad", operationName = "obtenerDisponibilidad")
    public List<DataHorario> obtenerDisponibilidad(int id, Date fecha) {

        logger.info("obtenerDisponibilidad: id:" + id + " fecha:" + fecha);

        VentaController vc = new VentaController();
        return vc.getDisponibilidadParaEvento(id, fecha);
    }

    @WebMethod(action = "estadoReserva", operationName = "estadoReserva")
    public int estadoReserva(long idReserva) throws BusinessException {
        logger.info("estadoReserva: idReserva:" + idReserva);

        ReservaController rc = new ReservaController();
        int estado = rc.getEstadoReserva(idReserva);
        if (estado == -1) {
           throw new BusinessException("NOT_FOUND", 404, "No existe reserva con dicho id");
        }
        return estado;
    }

    @WebMethod(action = "reservarEntrada", operationName = "reservarEntrada")
    public long reservarEntrada(@WebParam(name = "confirmacion") DataReservaPendiente dataReservaPendiente) throws Exception {
        logger.info("reservarEntrada: dataReservaPendiente:" + dataReservaPendiente);

        ReservaController vc = new ReservaController();

        return vc.reservarEntrada(dataReservaPendiente);
    }

    @WebMethod(action = "cancelarVenta", operationName = "cancelarVenta")
    public long cancelarVenta(@WebParam(name = "idConfirmacion")long idConfirmacion,@WebParam(name = "idPago") long idPago)  throws Exception {
        logger.info("cancelarVenta: idConfirmacion: " + idConfirmacion + "medioDePago: " + idPago);

        long resultado;
        WsPagosLocalService wsPagosLocal = new WsPagosLocalService();
        WsPagosYaService wsPagosYa = new WsPagosYaService();

        if (idPago==1){
           resultado = wsPagosLocal.getWsPagosLocalPort().anularPago(idConfirmacion).getIdAnulacion();

        }else {
            resultado = wsPagosYa.getWsPagosYaPort().anularPago(idConfirmacion).getIdAnulacion();
        }
        ReservaController vc = new ReservaController();
        int estado = vc.cancelarReserva(idConfirmacion);
        if (estado == -1) {
           throw new BusinessException("NOT_FOUND", 404, "No existe reserva con dicho id");
        }
        return estado;
    }

    @ResponseWrapper(targetNamespace="https://localhost:8443/callback-ws-0.1.0/CallbackWsx",localName="confirmarReserva")
    @Action(
            output="https://localhost:8443/callback-ws-0.1.0/CallbackWsx/confirmarReserva")
    @WebMethod(action = "confirmarReserva", operationName = "confirmarReserva")
    public DataNotificacionReserva confirmarReserva(@WebParam(name = "reserva") DataReservaConfirmada dataReservaConfirmada) throws BusinessException {
        logger.info("confirmarReserva: DataReservaConfirmada:" + dataReservaConfirmada);

        ReservaController vc = new ReservaController();
        return vc.confirmarReserva(dataReservaConfirmada);
    }
}
