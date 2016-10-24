package ticketinco.model;

import java.io.File;
import java.util.Date;

public class Pago {

    private long id;
    private String nroTarjeta;
    private Date vencimiento;
    private int digitoVerificador;
    private String tarjeta;
    private Date fechaAnulacion;
    private long idAnulacionParner;
    private File imagen;

    private Reserva reserva;

    public Pago(long id, String nroTarjeta, Date vencimiento, int digitoVerificador, String tarjeta, Date fechaAnulacion, long idAnulacionParner, File imagen, Reserva reserva) {
        this.id = id;
        this.nroTarjeta = nroTarjeta;
        this.vencimiento = vencimiento;
        this.digitoVerificador = digitoVerificador;
        this.tarjeta = tarjeta;
        this.fechaAnulacion = fechaAnulacion;
        this.idAnulacionParner = idAnulacionParner;
        this.imagen = imagen;
        this.reserva = reserva;
    }
}
