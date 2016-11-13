package com.pagosya.datatype;

public class DataAnulacion {
    private long idAnulacion;

    public DataAnulacion() {

    }

    public DataAnulacion(long idAnulacion) {
        this.idAnulacion = idAnulacion;
    }

    public long getIdAnulacion() {
        return idAnulacion;
    }

    public void setIdAnulacion(long idAnulacion) {
        this.idAnulacion = idAnulacion;
    }

    @Override
    public String toString() {
        return "DataAnulacion{" +
                "idAnulacion=" + idAnulacion +
                '}';
    }
}

