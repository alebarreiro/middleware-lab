package com.middleware.clases;

/**
 * Created by acabrera on 9/19/16.
 */
public class ItemMessage {
    private Item item;
    private Long idCliente;
    private Long idOrden;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    @Override
    public String toString() {
        return "ItemMessage{" +
                "item=" + item +
                ", idCliente=" + idCliente +
                ", idOrden=" + idOrden +
                '}';
    }
}
