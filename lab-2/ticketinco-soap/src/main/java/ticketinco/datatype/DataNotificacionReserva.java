package ticketinco.datatype;

import java.awt.Image;
import java.util.List;


public class DataNotificacionReserva {

    private long idConfirmacionReserva;
    private java.util.List<Image> imagenes;

    public DataNotificacionReserva () {
    }

    public DataNotificacionReserva(long idConfirmacionReserva, List<Image> imagenes) {
        this.idConfirmacionReserva = idConfirmacionReserva;
        this.imagenes = imagenes;
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

}

