package ws;


import POJOS.DietaAlimento;
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

@Path("DietaAlimentos")
public class DietaAlimentoWS {
    @Context
    private UriInfo context;
    
    public DietaAlimentoWS(){
    }
        
    @Path("nuevo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje nuevo(
            @FormParam("idDietaAlimento") Integer idDietaAlimento,
            @FormParam("idAlimento") Integer idAlimento,
            @FormParam("cantidad") double cantidad,
            @FormParam("idDieta") Integer idDieta,
            @FormParam("idHorario") Integer idHorario){
        
        Mensaje resultado = null;
        DietaAlimento  cat = new DietaAlimento(idDietaAlimento, idAlimento, cantidad, idDieta, idHorario);
        SqlSession conn = MyBatisUtil.getSession();
        if (conn != null) {
            try {
                int result = conn.insert("DietaAlimentos.nuevo", cat);
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
            @FormParam("idDietaAlimento") Integer idDietaAlimento,
            @FormParam("idAlimento") Integer idAlimento,
            @FormParam("cantidad") double cantidad,
            @FormParam("idDieta") Integer idDieta,
            @FormParam("idHorario") Integer idHorario){
    
        Mensaje resultado = null;
        DietaAlimento  cat = new DietaAlimento(idDietaAlimento, idAlimento, cantidad, idDieta, idHorario);
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("DietaAlimentos.actualizarDietaAlimento" , cat);
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
    public Mensaje eliminar(@FormParam("idDietaAlimento") Integer idDietaAlimento){
    
        Mensaje resultado = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("DietaAlimentos.eliminarDietaAlimento", idDietaAlimento);
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
    
    @Path("getAllByIdDieta/{idDieta}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DietaAlimento> getByIdDieta(@PathParam("idDieta") Integer idDieta){
        List<DietaAlimento> resultado = null;
        SqlSession conn = MyBatisUtil.getSession();
        
        if (conn != null ){
            try {
                resultado = conn.selectList("DietaAlimentos.getByIdDieta", idDieta);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
}