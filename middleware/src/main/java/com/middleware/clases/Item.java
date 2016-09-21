package com.middleware.clases;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Item {
    private Long id;
    private Long idProducto;
    private int categoria;
    private String descripcionProducto;
    private Integer cantidad;
    private Double precio;

    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    @XmlElement(name = "id-producto")
    public void setIdProducto(Long idProducto) {
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

    public Integer getCantidad() {
        return cantidad;
    }

    @XmlElement
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    @XmlElement
    public void setPrecio(Double precio) {
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
}