package com.middleware.clases;

/**
 * Created by acabrera on 9/19/16.
 */
public class OrderMessage {
    private boolean esValida;
    private String razonInvalida;
    private Order order;

    public boolean isEsValida() {
        return esValida;
    }

    public void setEsValida(boolean esValida) {
        this.esValida = esValida;
    }

    public String getRazonInvalida() {
        return razonInvalida;
    }

    public void setRazonInvalida(String razonInvalida) {
        this.razonInvalida = razonInvalida;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderMessage{" +
                "esValida=" + esValida +
                ", razonInvalida='" + razonInvalida + '\'' +
                ", order=" + order +
                '}';
    }
}
