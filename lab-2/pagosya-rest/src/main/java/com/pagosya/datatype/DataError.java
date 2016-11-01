package com.pagosya.datatype;

import java.io.Serializable;

/**
 * Created by acabrera on 11/1/16.
 */

public class DataError  implements Serializable {
    private String mensaje;

    public DataError() {
    }

    public DataError(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
