package ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("login")
public class LoginWS {
    @Context
    private UriInfo context;
    
    public LoginWS(){
    }
    
    @Path("pruebaLogin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHolaMundo() {
        //alimentos al = new alimentos(1, "Prueba", 200, 2);
        return "Hola Login" ;
    }
}
