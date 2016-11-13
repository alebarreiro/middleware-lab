package ticketinco.datatype;

import java.awt.Image;
import java.util.List;


public class DataNotificacionReserva {

    private long idConfirmacionReserva;
    private java.util.List<Image> imagenes;
    private boolean error = false;
    private String msgError = "";

    public DataNotificacionReserva () {
    }

    public DataNotificacionReserva(long idConfirmacionReserva, List<Image> imagenes) {
        this.idConfirmacionReserva = idConfirmacionReserva;
        this.imagenes = imagenes;
    }

    public DataNotificacionReserva(long idConfirmacionReserva, List<Image> imagenes, boolean error, String msgError) {
        this.idConfirmacionReserva = idConfirmacionReserva;
        this.imagenes = imagenes;
        this.error = error;
        this.msgError = msgError;
    }

    public long getIdConfirmacionReserva() {
        return idConfirmacionReserva;
    }

    public void setIdConfirmacionReserva(long idConfirmacionReserva) {
        this.idConfirmacionReserva = idConfirmacionReserva;
    }

    public List<Image> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Image> imagenes) {
        this.imagenes = imagenes;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    @Override
    public String toString() {
        return "DataNotificacionReserva{" +
                "idConfirmacionReserva=" + idConfirmacionReserva +
                ", imagenes=" + imagenes +
                ", error=" + error +
                ", mensaje=" + msgError +
                '}';
    }
}

