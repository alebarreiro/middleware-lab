package msg.dto;

import javax.xml.bind.annotation.XmlElement;

public class Facturacion {
    private Double monto;
    private int moneda;
    private int cuotas;

    public Facturacion() {}

    public Double getMonto() {
        return monto;
    }

    @XmlElement
    public void setMonto(Double monto) {
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