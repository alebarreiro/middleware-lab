package com.middleware.integracion;

import com.middleware.clases.Order;
import com.middleware.clases.OrderMessage;
import com.middleware.util.JaxbContext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlTransformerOrder {

    public OrderMessage transform(String xml) {
        OrderMessage orderMessage = new OrderMessage();
        Order order = null;

        try {
            order = jaxbMarshal(xml);
        } catch (JAXBException e) {
            orderMessage.setEsValida(false);
            orderMessage.setRazonInvalida("Error de sintaxis del XML:" + e.getMessage());
        }

        if (order != null) {
            orderMessage.setEsValida(true);
            orderMessage.setOrder(order);
        }

        System.out.println(orderMessage);

        return orderMessage;
    }

    private Order jaxbMarshal(String xml) throws JAXBException {
        JAXBContext jaxbContext = JaxbContext.newInstance();

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        StringReader stringReader = new StringReader(xml);

        return (Order) jaxbUnmarshaller.unmarshal(stringReader);
    }
}