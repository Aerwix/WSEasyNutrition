package ws;

import POJOS.alimentos;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("api")
public class NutritionWS {

    @Context
    private UriInfo context;
    
    public NutritionWS() {
    }
    
    // RA: http://localhost:8084/WSEN/webresources/api/@Paths
    @Path("prueba")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public alimentos getHolaMundo() {
        alimentos al = new alimentos("1", "Uva", 200, "1");
        return al;
    }
}
