package com.middleware.integracion;

import com.middleware.clases.Order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlTransformerOrder {

    public Order transform(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        StringReader stringReader = new StringReader(xml);

        Order order = (Order) jaxbUnmarshaller.unmarshal(stringReader);

        System.out.println(order.toString());

        return order;
    }
}