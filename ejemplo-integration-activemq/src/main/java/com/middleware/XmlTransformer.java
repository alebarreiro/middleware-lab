package com.middleware;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlTransformer {

    public Order trasform(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        StringReader stringReader = new StringReader(xml);

        Order order = (Order) jaxbUnmarshaller.unmarshal(stringReader);

        System.out.println(order.toString());

        return order;
    }
}