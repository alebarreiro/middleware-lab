package ticketinco.service;

import ticketinco.controller.ReservaController;
import ticketinco.datatype.DataNotificacionReserva;
import ticketinco.datatype.DataReservaConfirmada;
import ticketinco.exception.BusinessException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.MTOM;

@MTOM(enabled=true)
@Addressing(enabled = true, required = false)
@WebService(name = "ConfirmarReserva", targetNamespace = "http://service.ticketinco/")
public class ConfirmacionService {

    @WebMethod(action = "confirmarReserva")
    public DataNotificacionReserva confirmarReserva(@WebParam(name = "reserva") DataReservaConfirmada dataReservaConfirmada) throws BusinessException {
        ReservaController vc = new ReservaController();
        return vc.confirmarReserva(dataReservaConfirmada);
    }

}
