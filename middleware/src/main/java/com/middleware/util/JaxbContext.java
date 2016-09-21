package com.middleware.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Created by acabrera on 9/19/16.
 */
public class JaxbContext {
    public static JAXBContext newInstance() throws JAXBException {
        return JAXBContext.newInstance(
                com.middleware.clases.Order.class,
                com.middleware.clases.ProcessableItem.class
        );
    }
}
