package callback.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.soap.Addressing;

import org.apache.log4j.Logger;

@WebService(name="ConfirmarReservaCallback")
public class CallbackWs {

    final static Logger logger = Logger.getLogger(CallbackWs.class);

    @WebMethod(action="confirmarReserva")
    public long confirmarReserva(@WebParam(name="dataConfirmacion") long id) {
        logger.info("Confirmar reserva: " + id);
        return id;
    }

}
