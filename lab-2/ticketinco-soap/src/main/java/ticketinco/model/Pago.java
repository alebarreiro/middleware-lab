package ticketinco.model;

import java.util.Date;

public class Pago {

    private long id;
    private String nroTarjeta;
    private Date vencimiento;
    private int digitoVerificador;

    private Reserva reserva;

    public Pago(long id, String nroTarjeta, Date vencimiento, int digitoVerificador, Reserva reserva) {
        this.id = id;
        this.nroTarjeta = nroTarjeta;
        this.vencimiento = vencimiento;
        this.digitoVerificador = digitoVerificador;
        this.reserva = reserva;
    }

}
