package com.middleware.clases;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by acabrera on 9/18/16.
 */
public class Facturacion {
    private double monto;
    private int moneda;
    private int cuotas;

    public double getMonto() {
        return monto;
    }

    @XmlElement
    public void setMonto(double monto) {
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

    public boolean monedaSoportada() {
        boolean esSoportada = false;
        int moneda = this.getMoneda();

        String monedaSoportada = Constantes.tipoMoneda.get(moneda);

        if (monedaSoportada != null) {
            esSoportada = true;
        }

        return esSoportada;
    }
}