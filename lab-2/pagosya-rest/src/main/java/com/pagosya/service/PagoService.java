package com.pagosya.service;

import com.pagosya.datatype.DataAnulacion;
import com.pagosya.datatype.DataConfirmacion;
import com.pagosya.datatype.DataError;
import com.pagosya.datatype.DataVenta;
import com.pagosya.datatype.exception.VencimientoInvalidoException;
import com.pagosya.util.ManejadorPagos;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.NoSuchElementException;
import org.apache.log4j.Logger;


@Path("/pago")
@Produces(MediaType.APPLICATION_JSON)
public class PagoService {
    final static Logger logger = Logger.getLogger(PagoService.class);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response confirmarPago(DataVenta venta) {
        logger.info("confirmarPago: venta: " + venta.toString());

        try {
            DataConfirmacion confirmacion = new DataConfirmacion(ManejadorPagos.confirmarPago(venta));

            logger.info("confirmarPago: confirmacion: " + confirmacion.toString());

            return Response.ok(confirmacion).build();

        } catch (VencimientoInvalidoException error) {
            logger.warn("confirmarPago: vencimiento invalido");

            return Response.status(422).entity(new DataError(error.getMessage())).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @DELETE
    @Path("/{idPago : \\d+}")
    public Response anularPago(@PathParam("idPago") long idPago) {
        logger.info("anularPago: " + idPago);

        try {
            long idAnulacion = ManejadorPagos.anularPago(idPago);

            DataAnulacion anulacion = new DataAnulacion(idAnulacion);

            logger.info("anularPago: anulacion: " + anulacion.toString());

            return Response.ok(anulacion).build();
        } catch (NoSuchElementException error) {
            logger.warn("anularPago: No se encontro el pago");

            return Response.status(Response.Status.NOT_FOUND).entity(new DataError(error.getMessage())).type(MediaType.APPLICATION_JSON).build();
        }
    }
}
