package com.middleware.clases;

import java.util.Date;

/**
 * Created by acabrera on 9/19/16.
 */
public class ItemMessage {
    private Item item;
    private long idCliente;
    private long idOrden;
    private Date fechaCreaction;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(long idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaCreaction() {
        return fechaCreaction;
    }

    public void setFechaCreaction(Date fechaCreaction) {
        this.fechaCreaction = fechaCreaction;
    }

    @Override
    public String toString() {
        return "ItemMessage{" +
                "item=" + item +
                ", idCliente=" + idCliente +
                ", idOrden=" + idOrden +
                ", fechaCreaction=" + fechaCreaction +
                '}';
    }
}
