package com.pagosya.model;

import com.pagosya.datatype.DataVenta;

/**
 * Created by acabrera on 10/31/16.
 */
public class Pago {
    private long id;
    private Long idAnulacion;
    private Venta venta;


    public Pago() {

    }

    public Pago(long idPago, DataVenta dataVenta) {
        this.id = idPago;
        this.venta = new Venta(
                dataVenta.getNroTarjeta(),
                dataVenta.getFechaVencimiento(),
                dataVenta.getMonto(),
                dataVenta.getDigitoVerificador()
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long idConfirmacion) {
        this.id = idConfirmacion;
    }

    public Long getIdAnulacion() {
        return idAnulacion;
    }

    public long setIdAnulacion(long idAnulacion) {
        return this.idAnulacion = idAnulacion;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
