package com.middleware.clases;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class ProcessableItem {
    private Long id;
    private int categoria;
    private Long idProducto;
    private String descripcionProducto;
    private Integer cantidad;
    private Long idCliente;
    private Long idOrden;

    public ProcessableItem() {}

    public ProcessableItem(Item item, Long idCliente, Long idOrden) {
        fillFromItem(item);
        this.idCliente = idCliente;
        this.idOrden = idOrden;
    }

    private void fillFromItem(Item item) {
        this.id = item.getId();
        this.idProducto = item.getIdProducto();
        this.descripcionProducto = item.getDescripcionProducto();
        this.cantidad = item.getCantidad();
        this.categoria = item.getCategoria();
    }

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

    public Long getIdCliente() {
        return idCliente;
    }

    @XmlElement(name = "id-cliente")
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    @XmlElement(name = "id-orden")
    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public int getCategoria() {
        return categoria;
    }

    @XmlElement
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ProcessableItem{" +
                "id=" + id +
                ", idProducto=" + idProducto +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                ", cantidad=" + cantidad +
                ", idCliente=" + idCliente +
                ", idOrden=" + idOrden +
                '}';
    }
}