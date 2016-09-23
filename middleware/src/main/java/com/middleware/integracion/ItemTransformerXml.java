package com.middleware.integracion;

import com.middleware.clases.ItemMessage;
import com.middleware.clases.ProcessableItem;
import com.middleware.util.JaxbContext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class ItemTransformerXml {

    public String transform(ItemMessage itemMessage) {
        String itemXml = null;

        try {
            itemXml = jaxbUnmarshal(itemMessage);
        } catch (JAXBException e) {
            System.out.println("Error al parsear el item a xml:" + e.getMessage());
        }

        return itemXml;
    }

    private String jaxbUnmarshal(ItemMessage itemMessage) throws JAXBException {
        JAXBContext jaxbContext = JaxbContext.newInstance();

        Marshaller jaxbUnmarshaller = jaxbContext.createMarshaller();

        StringWriter stringWriter = new StringWriter();

        ProcessableItem processableItem = new ProcessableItem(
                itemMessage.getItem(),
                itemMessage.getIdCliente(),
                itemMessage.getIdOrden(),
                itemMessage.getFechaCreaction()
        );

        jaxbUnmarshaller.marshal(processableItem, stringWriter);

        return stringWriter.toString();
    }
}