package ticketinco.datatype.pagosYa;

/**
 * Created by acabrera on 11/5/16.
 */

//@JsonIgnoreProperties(ignoreUnknown=true)
public class DataConfirmacion {
    private long idConfirmacion;

    public DataConfirmacion() {}

    public DataConfirmacion(long idConfirmacion) {
        this.idConfirmacion = idConfirmacion;
    }

    public long getIdConfirmacion() {
        return idConfirmacion;
    }

    public void setIdConfirmacion(long idConfirmacion) {
        this.idConfirmacion = idConfirmacion;
    }
}
