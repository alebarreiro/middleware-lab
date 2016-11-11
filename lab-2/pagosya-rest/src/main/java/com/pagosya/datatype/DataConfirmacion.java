package com.pagosya.datatype;

/**
 * Created by acabrera on 11/5/16.
 */
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

    @Override
    public String toString() {
        return "DataConfirmacion{" +
                "idConfirmacion=" + idConfirmacion +
                '}';
    }
}
