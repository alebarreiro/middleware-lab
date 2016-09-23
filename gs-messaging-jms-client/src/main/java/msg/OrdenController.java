package msg;

import msg.dto.Item;
import msg.dto.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class OrdenController {

    public OrdenController() {
    }

    @RequestMapping(value = "/orden", method = RequestMethod.POST)
    public void test (@RequestBody Order order) {

        System.out.println(order.toString());

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
