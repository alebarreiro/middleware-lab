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

    }

    @RequestMapping(value = "/items", method = RequestMethod.GET, produces = "application/json")
    public List<Item> items () {
        List<Item> items = new ArrayList<>();

        items.add(new Item(1,1,0,20, "Item de categoria 1"));
        items.add(new Item(2,2,0,50, "Item de categoria 2"));
        items.add(new Item(3,3,0,100, "Item de categoria 3"));

        return items;
    }

}
