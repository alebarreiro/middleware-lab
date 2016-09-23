package com.middleware.clases;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Item {
    private long id;
    private long idProducto;
    private int categoria;
    private String descripcionProducto;
    private int cantidad;
    private double precio;

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

    public int getCategoria() {
        return categoria;
    }

    @XmlElement
    public void setCategoria(int categoria) {
        this.categoria = categoria;
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

    public double getPrecio() {
        return precio;
    }

    @XmlElement
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", idProducto=" + idProducto +
                ", categoria=" + categoria +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }

    public double getPrecioTotal() {
        return this.getCantidad() * this.getPrecio();
    }
}