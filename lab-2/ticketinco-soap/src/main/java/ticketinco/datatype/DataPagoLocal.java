package ticketinco.datatype;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pago")
public class DataPagoLocal {

    public String nroTarjeta;
    public String tarjeta;
    public String digitoVerificador;
    public String monto;

    public DataPagoLocal () {}

    public DataPagoLocal(String nroTarjeta, String tarjeta, String monto, String digitoVerificador) {
        this.nroTarjeta = nroTarjeta;
        this.tarjeta = tarjeta;
        this.monto = monto;
        this.digitoVerificador = digitoVerificador;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    @XmlElement(name="nro-tarjeta")
    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    @XmlElement(name="tarjeta")
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getMonto() {
        return monto;
    }

    @XmlElement(name="monto")
    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getDigitoVerificador() {
        return digitoVerificador;
    }

    @XmlElement(name="digito-verificador")
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
