package ticketinco.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class JaxbContext {
    public static JAXBContext newInstance() throws JAXBException {
        return JAXBContext.newInstance(
                ticketinco.datatype.DataPagoLocal.class
        );
    }
}