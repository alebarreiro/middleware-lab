package msg;

import msg.dto.Item;
import msg.dto.Order;
import msg.util.JmsController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import msg.util.JaxbContext;

@RestController
public class OrdenController {

    public OrdenController() {
    }

    @RequestMapping(value = "/orden", method = RequestMethod.POST)
    public void test (@RequestBody Order order) {
        System.out.println(order.toString());
        StringWriter sw = new StringWriter();

        try {

            //Parse objeto a xml
            JAXBContext jaxbContext = JaxbContext.newInstance();
            Marshaller jaxbUnmarshaller = jaxbContext.createMarshaller();
            jaxbUnmarshaller.marshal(order, sw);
            String orderXml = sw.toString();

            //Mandar mensaje a la cola activemq orders
            JmsController jc = new JmsController();
            jc.sendMsg(orderXml);

        } catch (JAXBException e) {
            System.out.println("Error al parsear el item a xml:" + e.getMessage());
        }
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET, produces = "application/json")
    public List<Item> items () {
        List<Item> items = new ArrayList<>();



        items.add(new Item(1,1,1, "Item cat 1", 0, 10.0));
        items.add(new Item(2,2,2, "Item cat 2", 0, 10.0));
        items.add(new Item(3,3,3, "Item cat 3", 0, 10.0));

        return items;
    }

}
