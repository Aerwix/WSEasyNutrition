package ws;

import POJOS.MedidasConsulta;
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

@Path("MedidasConsulta")
public class MedidasConsultaWS {
    @Context
    private UriInfo context;
    
    public MedidasConsultaWS(){
    }

    @Path("nuevo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje nuevo(
            @FormParam("talla") String talla,
            @FormParam("peso") String peso,
            @FormParam("estatura") String estatura,
            @FormParam("imc") String imc,
            @FormParam("idPorcion") Integer idPorcion){
        
        Mensaje resultado = null;
        MedidasConsulta  cat = new MedidasConsulta(idMedicion, talla, peso, estatura, imc, idPorcion);
        SqlSession conn = MyBatisUtil.getSession();
        if (conn != null) {
            try {
                int result = conn.insert("MedidasConsulta.nuevo", cat);
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
    
    @Path("actualizar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje actualizar(
            @FormParam("idMedicion") Integer idMedicion,
            @FormParam("talla") String talla,
            @FormParam("peso") String peso,
            @FormParam("estatura") String estatura,
            @FormParam("imc") String imc,
            @FormParam("idPorcion") Integer idPorcion){
    
        Mensaje resultado = null;
        MedidasConsulta  cat = new MedidasConsulta(idMedicion, talla, peso, estatura, imc, idPorcion);
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("MedidasConsulta.actualizar" , cat);
                if(result ==1){
                    conn.commit();
                    resultado = new Mensaje(false, "Modificado correctamente.");
                }else{
                    conn.rollback();//deshace la operación
                    resultado = new Mensaje(false, "No se pudo modificar");
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
    
    @Path("eliminar")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminar(@FormParam("idMedicion") Integer idMedicion){
    
        Mensaje resultado = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("MedidasConsulta.eliminar", idMedicion);
                if(result ==1){
                    conn.commit();
                    resultado = new Mensaje(false, "Eliminado correctamente.");
                }else{
                    conn.rollback();
                    resultado = new Mensaje(false, "No se pudo eliminar");
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
    
    @Path("getMedidasByIdConsulta/{idConsulta}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MedidasConsulta getById(@PathParam("idConsulta") Integer idConsulta){
        MedidasConsulta resultado = new MedidasConsulta();
        SqlSession conn = MyBatisUtil.getSession();
        
        if (conn != null ){
            try {
                resultado = conn.selectOne("MedidasConsulta.getMedicionByIdConsulta", idConsulta);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
}