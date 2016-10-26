package pagosya.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
public class Hello {

    @GET
    @Path("/")
    public String sayHello(@QueryParam("name") String name) {

        return "Hello " + name + "!";
    }
}
