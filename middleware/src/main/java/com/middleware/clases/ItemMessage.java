package com.middleware.clases;

import java.util.Date;

/**
 * Created by acabrera on 9/19/16.
 */
public class ItemMessage {
    private Item item;
    private long idCliente;
    private long idOrden;
    private Date fechaCreacion;

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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "ItemMessage{" +
                "item=" + item +
                ", idCliente=" + idCliente +
                ", idOrden=" + idOrden +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
