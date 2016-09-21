package com.middleware.clases;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@XmlRootElement
public class Order {
    private Long id;
    private Date fechaCreacion;
    private Long idCliente;
    private String formaPago;
    private Facturacion facturacion;
    private List<Item> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    @XmlElement(name = "fecha-creacion")
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    @XmlElement(name = "id-cliente")
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getFormaPago() {
        return formaPago;
    }

    @XmlElement(name = "forma-pago")
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Facturacion getFacturacion() {
        return facturacion;
    }

    @XmlElement
    public void setFacturacion(Facturacion facturacion) {
        this.facturacion = facturacion;
    }

    public List<Item> getItems() {
        return items;
    }

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    public void setItems(List<Item> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", fechaCreacion=" + fechaCreacion +
                ", idCliente=" + idCliente +
                ", formaPago='" + formaPago + '\'' +
                ", facturacion=" + facturacion.toString() +
                ", items=" + items.toString() +
                '}';
    }

    public boolean esValida() {
        boolean monedaSoporta = this.monedaSoportada();
        boolean montoValido = this.montoValido();

        return monedaSoporta && montoValido;
    }

    public void validar() throws Exception {
        if (!this.monedaSoportada()) {
            throw new Exception("La moneda no es soportada.");
        }

        if (!this.montoValido()) {
            throw new Exception("El monto no es valido.");
        }
    }

    public boolean monedaSoportada() {
        return this.getFacturacion().monedaSoportada();
    }

    public boolean montoValido() {
        Double costoItems = this.costoItems();
        Double montoOrden = this.getMontoOrden();

        return Double.compare(costoItems, montoOrden) == 0;
    }

    public Double costoItems() {
        Double costo = 0.;

        for (Item item: this.getItems()) {
            costo += item.getPrecioTotal();
        }

        return costo;
    }

    public Double getMontoOrden() {
        return this.getFacturacion().getMonto();
    }
}
