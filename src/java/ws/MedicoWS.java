package ws;

import POJOS.Medico;
import POJOS.Mensaje;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @Path("actualizarMedico")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje actualizaCita(
            @FormParam("idMedico") Integer idMedico,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("direccion") String direccion,
            @FormParam("correo") String correo,
            @FormParam("password") String password,
            @FormParam("telefono") String telefono,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("sexo") String sexo
            ){
    
        Mensaje resultado = null;
        Medico  cat = new Medico(idMedico, nombre, apellidoPaterno, apellidoMaterno, direccion, correo, password, telefono, fechaNacimiento, sexo);
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("medicos.actualizarMedico" , cat);
                if(result ==1){
                    conn.commit();
                    resultado = new Mensaje(false, "Medico modificado correctamente.");
                }else{
                    conn.rollback();//deshace la operación
                    resultado = new Mensaje(false, "El Medico no se pudo modificar");
                }
            } catch (Exception e) {
                e.printStackTrace();
                resultado = new Mensaje(false, e.getMessage());
            }finally{
                conn.close();
            }
        }
        return resultado;
    }
    
    @Path("eliminarMedico")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarMedico(@FormParam("idMedico") Integer idMedico){
    
        Mensaje resultado = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("medicos.eliminarMedico", idMedico);
                if(result ==1){
                    conn.commit();
                    resultado = new Mensaje(false, "Medico eliminado correctamente.");
                }else{
                    conn.rollback();
                    resultado = new Mensaje(false, "El Medico no se pudo eliminar");
                }               
            } catch (Exception e) {
                e.printStackTrace();
                resultado = new Mensaje(false, e.getMessage());
            }finally{
                conn.close();
            }
        }
        return resultado;
    }
    
    @Path("getMedicoByCorreo/{correo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Medico getByCorreo(@PathParam("correo") String correo){
        Medico resultado = new Medico();
        SqlSession conn = MyBatisUtil.getSession();
        
        if (conn != null ){
            try {
                resultado = conn.selectOne("medicos.getMedicoByEmail", correo);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
}
