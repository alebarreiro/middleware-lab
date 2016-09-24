package com.middleware;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by acabrera on 9/18/16.
 */
public class Facturacion {
    private int monto;
    private int moneda;
    private int cuotas;

    public int getMonto() {
        return monto;
    }

    @XmlElement
    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getMoneda() {
        return moneda;
    }

    @XmlElement
    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public int getCuotas() {
        return cuotas;
    }

    @XmlElement
    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    @Override
    public String toString() {
        return "Facturacion{" +
                "monto=" + monto +
                ", moneda=" + moneda +
                ", cuotas=" + cuotas +
                '}';
    }
}