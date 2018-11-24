package ws;

import POJOS.Medico;
import POJOS.Mensaje;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

@Path("medico")
public class MedicoWS {
    @Context
    private UriInfo context;
    
    public MedicoWS(){
    }
    
    @Path("nuevoMedico")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje nuevoMedico(
            @FormParam("idMedico") Integer idMedico,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("direccion") String direccion,
            @FormParam("correo") String correo,
            @FormParam("password") String password,
            @FormParam("telefono") String telefono,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("sexo") String sexo
            ){
        
        Mensaje resultado = null;
        Medico cat = new Medico(idMedico, nombre, apellidoMaterno, apellidoPaterno, direccion, correo, password, telefono, fechaNacimiento, sexo);
        SqlSession conn = MyBatisUtil.getSession();
        if (conn != null) {
            try {
                int result = conn.insert("medicos.registrarMedico", cat);
                if (result == 1){
                    conn.commit();
                    resultado = new Mensaje(false, "Registrado correctamente");
                } else {
                    conn.rollback();
                    resultado = new Mensaje(false, "No se pudo registrar");
                }
            } catch (Exception e){
                e.printStackTrace();
                resultado = new Mensaje(false, e.getMessage());
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
}
