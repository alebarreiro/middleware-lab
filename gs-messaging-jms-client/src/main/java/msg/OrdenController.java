package msg;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import javax.jms.*;

@RestController
public class OrdenController {

    public OrdenController() {
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void test (@RequestBody Item item) {


        System.out.println(item.getNombre());
        System.out.println(item.getCategoria());


    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public String testGet () {
        System.out.println("TEST GET");
        return new String("texto");
    }

}
