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

}
