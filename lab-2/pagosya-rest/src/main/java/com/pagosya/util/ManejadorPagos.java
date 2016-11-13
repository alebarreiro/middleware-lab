package com.pagosya.util;

import com.pagosya.datatype.DataVenta;
import com.pagosya.datatype.exception.VencimientoInvalidoException;
import com.pagosya.model.Pago;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class ManejadorPagos {
    final static Logger logger = Logger.getLogger(ManejadorPagos.class);
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

    public static long confirmarPago(DataVenta venta) throws VencimientoInvalidoException {
        Date fechaVencimiento = venta.getFechaVencimiento();

        if (fechaVencimiento == null || fechaVencimiento.before(new Date())) {
            throw new VencimientoInvalidoException("El vencimiento de la tarjeta no es valido");
        }

        long pagoId = id++;
        Pago pago = new Pago(pagoId, venta);

        ManejadorPagos.pagos.put(pagoId, pago);

        logger.info("confirmarPago: Pago confirmado, nueva lista: " + pagos);

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
