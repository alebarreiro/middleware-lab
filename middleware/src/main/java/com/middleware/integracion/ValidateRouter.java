package com.middleware.integracion;

import com.middleware.clases.OrderMessage;

/**
 * Created by acabrera on 9/19/16.
 */
public class ValidateRouter {

    public String routeValid(OrderMessage orderMessage) {
        String nextChannel = routeToValid();

        if (!orderMessage.isEsValida()) {
            nextChannel = routeToInvalid();
        } else {

            // TODO: move this to a service activator or something similar
            try {
                orderMessage.getOrder().validar();
            } catch(Exception e) {
                orderMessage.setEsValida(false);
                orderMessage.setRazonInvalida(e.getMessage());
                nextChannel = routeToInvalid();
            }
        }

        return nextChannel;
    }

    private String routeToInvalid() {
        return "invalidOrders";
    }

    private String routeToValid() {
        return "validOrders";
    }
}
