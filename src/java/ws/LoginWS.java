package ws;

import POJOS.Medicos;
import POJOS.Mensaje;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

@Path("auth")
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
    
    @Path("LoginMedico")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Medicos LoginParaMedico(
            @FormParam("correo") String correo,
            @FormParam("password") String password
    ){
     Medicos resultado = new Medicos(correo, password);
     SqlSession conn = MyBatisUtil.getSession();
     if (conn != null){
         try {
             resultado = conn.selectOne("login.Medico", resultado);
         } catch(Exception e) {
             e.printStackTrace();
         } finally {
             conn.close();
         }
     }
     return resultado;
    }
}
