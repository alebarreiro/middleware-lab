package ticketinco.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @SequenceGenerator(name="pago_id_seq", sequenceName="pago_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pago_id_seq")
    private long id;

    @Column(name = "id_medio_pago")
    private long idMedioPago;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @Column(name = "nro_tarjeta")
    private String nroTarjeta;

    @Column(name = "digito_verificador")
    private int digitoVerificador;

    @Column(name = "tarjeta")
    private String tarjeta;

    @Column(name = "fecha_anulacion")
    private Date fechaAnulacion;

    @Column(name = "id_confirmacion_partner")
    private long idConfirmacionPartner;

    @Column(name = "id_anulacion_partner")
    private long idAnulacionParner;

    private byte[] imagen;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "pago", cascade = CascadeType.ALL)
    private Reserva reserva;

    public Pago() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public long getIdConfirmacionPartner() {
        return idConfirmacionPartner;
    }

    public void setIdConfirmacionPartner(long idConfirmacionPartner) {
        this.idConfirmacionPartner = idConfirmacionPartner;
    }

    public long getIdAnulacionParner() {
        return idAnulacionParner;
    }

    public void setIdAnulacionParner(long idAnulacionParner) {
        this.idAnulacionParner = idAnulacionParner;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
