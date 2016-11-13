package callback.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.MTOM;

import org.apache.log4j.Logger;

@MTOM(enabled = true)
@WebService(name="ConfirmarReservaCallback")
public class CallbackWs {

    final static Logger logger = Logger.getLogger(CallbackWs.class);

    @WebMethod(action="confirmarReserva")
    public DataNotificacionReserva confirmarReserva(@WebParam(name="dataConfirmacion") DataNotificacionReserva notif) {
        logger.info("Confirmar reserva callback: " + notif.getIdConfirmacionReserva());
        return notif;
    }

}
