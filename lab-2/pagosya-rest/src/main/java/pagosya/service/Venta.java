package pagosya.service;

import datatype.DataVenta;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Venta {

    @POST
    @Path("/confirmar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response confirmar(DataVenta venta) {

        System.out.println(venta.toString());

        return Response.ok(1, MediaType.APPLICATION_JSON).build();
    }

}
