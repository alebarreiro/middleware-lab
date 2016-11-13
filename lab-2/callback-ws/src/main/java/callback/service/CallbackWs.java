package callback.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.MTOM;

import org.apache.log4j.Logger;

@MTOM(enabled = true)
@WebService(name = "ConfirmarReserva", targetNamespace = "http://service.ticketinco/")
public class CallbackWs {

    final static Logger logger = Logger.getLogger(CallbackWs.class);

    @WebMethod(operationName = "confirmarReserva", action = "confirmarReserva")
    public DataNotificacionReserva confirmarReserva(@WebParam(name="notificacion") DataNotificacionReserva notificacion) {
        logger.info("Confirmar reserva callback: " + notificacion.getIdConfirmacionReserva());
        return notificacion;
    }

}
