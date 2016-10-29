package datatype;

/**
 * Created by alejandrobarreiro on 29/10/16.
 */
public class DataVenta {

    public String nroTarjeta;
    public String tarjeta;
    public String digitoVerificador;
    public String monto;

    public DataVenta(String nroTarjeta, String tarjeta, String monto, String digitoVerificador) {
        this.nroTarjeta = nroTarjeta;
        this.tarjeta = tarjeta;
        this.monto = monto;
        this.digitoVerificador = digitoVerificador;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(String digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }

    @Override
    public String toString() {
        return "DataVenta{" +
                    "nroTarjeta=" + nroTarjeta +
                    ", tarjeta=" + tarjeta +
                    ", monto=" + monto +
                    ", digitoVerificador=" + digitoVerificador +
                '}';
    }

}
