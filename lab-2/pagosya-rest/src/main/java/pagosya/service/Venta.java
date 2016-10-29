package pagosya.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
public class Venta {

    @GET
    @Path("/confirmar")
    public String confirmar(@QueryParam("name") String name) {

        return "Hello " + name + "!";
    }

}
