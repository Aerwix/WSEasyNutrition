package ws;

import POJOS.Cita;
import POJOS.Mensaje;
import POJOS.Paciente;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

@Path("citas")
public class CitaWS {

    @Context
    private UriInfo context;
    
    public CitaWS() {
    }
       
    @Path("nuevaCita")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje nuevaCita(
            @FormParam("idCita") Integer idCita,
            @FormParam("idPaciente") Integer idPaciente,
            @FormParam("idMedico") Integer idMedico,
            @FormParam("fecha") String fecha,
            @FormParam("hora") String hora
            ){
        
        Mensaje resultado = null;
        Cita cat = new Cita(idCita, idPaciente, idMedico, fecha, hora);
        SqlSession conn = MyBatisUtil.getSession();
        if (conn != null) {
            try {
                int result = conn.insert("citas.nuevaCita", cat);
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
    
    @Path("actualizarCita")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje actualizaCita(
            @FormParam("idCita") Integer idCita,
            @FormParam("idPaciente") Integer idPaciente,
            @FormParam("idMedico") Integer idMedico,
            @FormParam("fecha") String fecha,
            @FormParam("hora") String hora
            ){
    
        Mensaje resultado = null;
        Cita  cat = new Cita(idCita, idPaciente, idMedico, fecha, hora);
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("citas.actualizarCita" , cat);
                if(result ==1){
                    conn.commit();
                    resultado = new Mensaje(false, "Cita modificada correctamente.");
                }else{
                    conn.rollback();//deshace la operación
                    resultado = new Mensaje(false, "La cita no se pudo modificar");
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
    
    @Path("eliminarCita")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminaCita(@FormParam("idCita") Integer idCita){
    
        Mensaje resultado = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("citas.eliminarCita", idCita);
                if(result ==1){
                    conn.commit();
                    resultado = new Mensaje(false, "Cita eliminada correctamente.");
                }else{
                    conn.rollback();
                    resultado = new Mensaje(false, "La cita no se pudo eliminar");
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
       
    @Path("getCitasByMedico/{idCita}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Cita getCitasByMedico(
            @PathParam("idCita") Integer idCita
    ){
        Cita resultado = new Cita();
        SqlSession conn = MyBatisUtil.getSession();
        
        if (conn != null ){
            try {
                resultado = conn.selectOne("citas.getCitasByMedico", idCita);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
}