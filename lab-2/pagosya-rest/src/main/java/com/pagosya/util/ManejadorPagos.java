package com.pagosya.util;

import com.pagosya.datatype.DataVenta;
import com.pagosya.model.Pago;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class ManejadorPagos {
    private static ManejadorPagos instance = new ManejadorPagos();
    private static Map<Long, Pago> pagos = new HashMap<>();
    private static long id = 1;
    private static long idAnulacion = 1;

    public static ManejadorPagos getInstance() {
        return instance;
    }

    private ManejadorPagos() {
    }

    public static void addPago(long idPago, Pago pago) {
        ManejadorPagos.pagos.put(idPago, pago);
    }

    public static Pago getPago(long idPago) {
        return ManejadorPagos.pagos.get(idPago);
    }

    public static long confirmarPago(DataVenta venta) {
        long pagoId = id++;
        Pago pago = new Pago(pagoId, venta);

        ManejadorPagos.pagos.put(pagoId, pago);

        return pago.getId();
    }

    public static long anularPago(long idPago) {
        Pago pago = ManejadorPagos.pagos.get(idPago);

        if (pago == null) {
            throw new NoSuchElementException("No existe un pago con id: " + idPago);
        }

        Long idPagoAnulacion = pago.getIdAnulacion();

        if (idPagoAnulacion == null) {
            idPagoAnulacion = ManejadorPagos.idAnulacion++;
            pago.setIdAnulacion(idPagoAnulacion);
        }

        return pago.getIdAnulacion();
    }
}
