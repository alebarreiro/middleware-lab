package msg;

import msg.dto.Item;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdenController {

    public OrdenController() {
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void test (@RequestBody Item item) {


        System.out.println(item.getNombre());
        System.out.println(item.getCategoria());


    }

    @RequestMapping(value = "/items", method = RequestMethod.GET, produces = "application/json")
    public List<Item> items () {
        List<Item> items = new ArrayList<>();

        items.add(new Item(1, "cat 1"));
        items.add(new Item(2, "cat 2"));
        items.add(new Item(3, "cat 3"));

        return items;
    }

}
