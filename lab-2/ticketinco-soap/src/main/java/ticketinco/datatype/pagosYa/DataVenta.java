package ticketinco.datatype.pagosYa;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by alejandrobarreiro on 29/10/16.
 */
public class DataVenta implements Serializable {

    private long nroTarjeta;
    private Date fechaVencimiento;
    private double monto;
    private int digitoVerificador;

    public DataVenta() {

    }

    public DataVenta(long nroTarjeta, Date fechaVencimiento, double monto, int digitoVerificador) {
        this.nroTarjeta = nroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.monto = monto;
        this.digitoVerificador = digitoVerificador;
    }

    public long getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(long nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(int digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "nroTarjeta=" + nroTarjeta +
                ", fechaVencimiento=" + fechaVencimiento +
                ", monto=" + monto +
                ", digitoVerificador=" + digitoVerificador +
                '}';
    }
}
