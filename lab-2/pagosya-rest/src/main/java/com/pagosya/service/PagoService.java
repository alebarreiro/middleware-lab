package com.pagosya.service;

import com.pagosya.datatype.DataAnulacion;
import com.pagosya.datatype.DataConfirmacion;
import com.pagosya.datatype.DataError;
import com.pagosya.datatype.DataVenta;
import com.pagosya.util.ManejadorPagos;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.NoSuchElementException;

@Path("/pago")
@Produces(MediaType.APPLICATION_JSON)
public class PagoService {

    @DELETE
    @Path("/{idPago : \\d+}")
    public Response anularPago(@PathParam("idPago") long idPago) {
        try {
            long idAnulacion = ManejadorPagos.anularPago(idPago);
            return Response.ok(new DataAnulacion(idAnulacion)).build();
        } catch (NoSuchElementException error) {
            return Response.status(Response.Status.NOT_FOUND).entity(new DataError(error.getMessage())).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response confirmar(DataVenta venta) {

        System.out.println(venta.toString());

        DataConfirmacion confirmacion = new DataConfirmacion(ManejadorPagos.confirmarPago(venta));

        return Response.ok(confirmacion).build();
    }
}
