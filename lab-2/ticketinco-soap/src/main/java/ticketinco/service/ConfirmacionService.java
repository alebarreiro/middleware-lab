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

import org.apache.log4j.Logger;

@MTOM(enabled=true)
@Addressing(enabled = true, required = false)
@WebService(name = "ConfirmarReserva", targetNamespace = "http://service.ticketinco/")
public class ConfirmacionService {

    final static Logger logger = Logger.getLogger(ConfirmacionService.class);

    @WebResult(name="reserva")
    @WebMethod(action = "confirmarReserva")
    public DataNotificacionReserva confirmarReserva(@WebParam(name = "reserva") DataReservaConfirmada dataReservaConfirmada) {
        ReservaController vc = new ReservaController();
        DataNotificacionReserva dnr = vc.confirmarReserva(dataReservaConfirmada);

        logger.info("confirmarReserva.confirmarReserva SUCCESS: " + dnr.toString());

        return dnr;
    }
}
