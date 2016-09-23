package com.middleware.clases;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "item")
public class ProcessableItem {
    private long id;
    private int categoria;
    private long idProducto;
    private String descripcionProducto;
    private int cantidad;
    private long idCliente;
    private long idOrden;
    private Date fechaCreacion;

    public ProcessableItem() {}

    public ProcessableItem(Item item, long idCliente, long idOrden, Date fechaCreacion) {
        fillFromItem(item);
        this.idCliente = idCliente;
        this.idOrden = idOrden;
        this.fechaCreacion = fechaCreacion;
    }

    private void fillFromItem(Item item) {
        this.id = item.getId();
        this.idProducto = item.getIdProducto();
        this.descripcionProducto = item.getDescripcionProducto();
        this.cantidad = item.getCantidad();
        this.categoria = item.getCategoria();
    }

    public long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(long id) {
        this.id = id;
    }

    public long getIdProducto() {
        return idProducto;
    }

    @XmlElement(name = "id-producto")
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    @XmlElement(name = "descripcion-producto")
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    @XmlElement
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getIdCliente() {
        return idCliente;
    }

    @XmlElement(name = "id-cliente")
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdOrden() {
        return idOrden;
    }

    @XmlElement(name = "id-orden")
    public void setIdOrden(long idOrden) {
        this.idOrden = idOrden;
    }

    public int getCategoria() {
        return categoria;
    }

    @XmlElement
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @XmlElement(name = "fecha-creacion")
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "ProcessableItem{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", idProducto=" + idProducto +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                ", cantidad=" + cantidad +
                ", idCliente=" + idCliente +
                ", idOrden=" + idOrden +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}