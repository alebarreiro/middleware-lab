package com.middleware.integracion;

import com.middleware.clases.Item;
import com.middleware.clases.ItemMessage;
import com.middleware.clases.Order;
import com.middleware.clases.OrderMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acabrera on 9/19/16.
 */
public class ItemSplitter {
    public List<ItemMessage> split(OrderMessage orderMessage) {
        List<ItemMessage> itemMessages = new ArrayList<>();
        Order order = orderMessage.getOrder();
        long idCliente = order.getIdCliente();
        long idOrden = order.getIdCliente();

        for (Item item: orderMessage.getOrder().getItems()) {
            ItemMessage itemMessage = new ItemMessage();
            itemMessage.setItem(item);
            itemMessage.setIdCliente(idCliente);
            itemMessage.setIdOrden(idOrden);

            itemMessages.add(itemMessage);
        }

        return itemMessages;
    }
}
