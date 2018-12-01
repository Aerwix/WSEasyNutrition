package ws;

import POJOS.Dieta;
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

@Path("dietas")
public class DietaWS {
    @Context
    private UriInfo context;
    
    public DietaWS(){
    }
    
    @Path("getAllDietas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dieta> getAllAlimentos(){
        List<Dieta> list = null;
        SqlSession conn = MyBatisUtil.getSession();
        if (conn != null){
            try{
                list = conn.selectList("Dieta.getAllDietas");
            } catch (Exception ex){
                ex.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return list;
    }
    
    @Path("getDietaById/{idDieta}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Dieta getById(@PathParam("idDieta") Integer idDieta){
        Dieta resultado = new Dieta();
        SqlSession conn = MyBatisUtil.getSession();
        
        if (conn != null ){
            try {
                resultado = conn.selectOne("Dieta.getDietaById", idDieta);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
    
    @Path("getAlimentoByName/{nombreDieta}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Dieta getByName(@PathParam("nombreDieta") String nombreDieta){
        Dieta resultado = new Dieta();
        SqlSession conn = MyBatisUtil.getSession();
        
        if (conn != null ){
            try {
                resultado = conn.selectOne("Dieta.getDietaByName", nombreDieta);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
    
    @Path("nuevaDieta")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje nuevaDieta(
            @FormParam("idDieta") Integer idDieta,
            @FormParam("nombreDieta") String nombreDieta,
            @FormParam("totalCalorias") double totalCalorias,
            @FormParam("idMedico") Integer idMedico){
        
        Mensaje resultado = null;
        Dieta  cat = new Dieta(idDieta, nombreDieta, totalCalorias, idMedico);
        SqlSession conn = MyBatisUtil.getSession();
        if (conn != null) {
            try {
                int result = conn.insert("Dieta.nuevaDieta", cat);
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
    
    @Path("actualizarDieta")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje actualizaCatalogo(
            @FormParam("idDieta") Integer idDieta,
            @FormParam("nombreDieta") String nombreDieta,
            @FormParam("totalCalorias") double totalCalorias,
            @FormParam("idMedico") Integer idMedico){
    
        Mensaje resultado = null;
        Dieta  cat = new Dieta(idDieta, nombreDieta, totalCalorias, idMedico);
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("Dieta.actualizarDieta" , cat);
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
    
    @Path("eliminarDieta")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminaAlimento(@FormParam("idDieta") Integer idDieta){
    
        Mensaje resultado = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("Dieta.eliminarDieta", idDieta);
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
}