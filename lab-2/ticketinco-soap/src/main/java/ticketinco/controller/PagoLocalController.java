package ticketinco.controller;

import org.apache.activemq.ActiveMQConnectionFactory;
import ticketinco.datatype.DataPagoLocal;

import javax.jms.*;

import java.io.StringWriter;
import ticketinco.util.JaxbContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class PagoLocalController {

    public PagoLocalController () {}

    public String parsePagoDataToXmlString (DataPagoLocal dataPago) {
        try {
            System.out.println(dataPago.toString());
            StringWriter sw = new StringWriter();
            JAXBContext jaxbContext = JaxbContext.newInstance();
            Marshaller jaxbUnmarshaller = jaxbContext.createMarshaller();
            jaxbUnmarshaller.marshal(dataPago, sw);
            return sw.toString();
        } catch (JAXBException e) {
            System.out.println("Error al parsear el item a xml: " + e.getMessage());
            return "Error";
        }
    }

    public void enviarPagoLocal (String pagoXml) {

        try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("pagos");

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Create a messages
            TextMessage message = session.createTextMessage(pagoXml);

            // Tell the producer to send the message
            System.out.println("Sent message: " + pagoXml);
            producer.send(message);

            // Clean up
            session.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }



    }

}
