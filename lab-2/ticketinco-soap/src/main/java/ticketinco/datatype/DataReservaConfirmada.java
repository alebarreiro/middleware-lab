package ticketinco.datatype;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DataReservaConfirmada implements Serializable {

    private long idReserva;
    private long idMedioPago;
    private String nroTarjeta;
    private Date fechaVencimiento;
    private int digitoVerificador;

    public DataReservaConfirmada() {}

    public DataReservaConfirmada(long idReserva, long idMedioPago, String nroTarjeta, Date fechaVencimiento, int digitoVerificador) {
        this.idReserva = idReserva;
        this.idMedioPago = idMedioPago;
        this.nroTarjeta = nroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.digitoVerificador = digitoVerificador;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public long getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(long idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public int getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(int digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }

    @Override
    public String toString() {
        return "DataReservaPendiente{" +
                    "idReserva=" + idReserva +
                    ", idMedioPago=" + idMedioPago +
                    ", nroTarjeta=" + nroTarjeta +
                    ", fechaVencimiento=" + fechaVencimiento +
                    ", digitoVerificador=" + digitoVerificador +
                '}';
    }
}
