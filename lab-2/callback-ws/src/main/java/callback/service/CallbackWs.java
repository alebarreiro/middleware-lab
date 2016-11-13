package callback.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.MTOM;

import org.apache.log4j.Logger;

@MTOM(enabled = true)
@WebService(name = "ConfirmarReserva", targetNamespace = "http://service.ticketinco/")
public class CallbackWs {

    final static Logger logger = Logger.getLogger(CallbackWs.class);

    @WebMethod(action = "confirmarReserva")
    public DataNotificacionReserva confirmarReserva(@WebParam(name="reserva") DataNotificacionReserva reserva) {
        logger.info("Confirmar reserva callback: " + reserva);
        return reserva;
    }

    @WebMethod(action = "confirmarReservaResponse")
    public void confirmarReservaResponse(@WebParam(name="reserva") DataNotificacionReserva reserva) {
        System.out.println("Target!!");
        logger.info("CONFIRMAR RESERVA LLAMADO!!! >>" + reserva.toString());
    }

    @WebResult(name="reserva")
    @WebMethod(action = "saySomething")
    public DataNotificacionReserva saySomething(@WebParam(name="reserva") DataNotificacionReserva reserva) {
        logger.info("CALLBACK LLAMADO SAY!!!");
        return reserva;
    }

    @WebMethod(action = "saySomethingResponse")
    public void saySomethingResponse(@WebParam(name="reserva") DataNotificacionReserva reserva) {
        System.out.println("Target!!");
        logger.info("CALLBACK LLAMADO!!! >>" + reserva.toString());
    }
}
