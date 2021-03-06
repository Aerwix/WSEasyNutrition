package ws;

import POJOS.Alimento;
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

@Path("alimentos")
public class AlimentoWS {
    @Context
    private UriInfo context;
    
    public AlimentoWS(){
    }
    
    @Path("getAllAlimentos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alimento> getAllAlimentos(){
        List<Alimento> list = null;
        SqlSession conn = MyBatisUtil.getSession();
        if (conn != null){
            try{
                list = conn.selectList("alimentos.getAllAlimentos");
            } catch (Exception ex){
                ex.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return list;
    }
    
    @Path("getAlimentoById/{idAlimento}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Alimento getById(@PathParam("idAlimento") Integer idAlimento){
        Alimento resultado = new Alimento();
        SqlSession conn = MyBatisUtil.getSession();
        
        if (conn != null ){
            try {
                resultado = conn.selectOne("alimentos.getAlimentoById", idAlimento);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
    
    @Path("getAlimentoByName/{nombre}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Alimento getByName(@PathParam("nombre") String nombre){
        Alimento resultado = new Alimento();
        SqlSession conn = MyBatisUtil.getSession();
        
        if (conn != null ){
            try {
                resultado = conn.selectOne("alimentos.getAlimentoByName", nombre);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
    
    @Path("nuevoAlimento")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje nuevoAlimento(
            @FormParam("idAlimento") Integer idAlimento,
            @FormParam("nombreAlimento") String nombreAlimento,
            @FormParam("calorias") double calorias,
            @FormParam("idPorcion") Integer idPorcion){
        
        Mensaje resultado = null;
        Alimento  cat = new Alimento(idAlimento, nombreAlimento, calorias, idPorcion);
        SqlSession conn = MyBatisUtil.getSession();
        if (conn != null) {
            try {
                int result = conn.insert("alimentos.nuevoAlimento", cat);
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
    
    @Path("actualizarAlimento")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje actualizaCatalogo(
            @FormParam("idAlimento") Integer idAlimento,
            @FormParam("nombreAlimento") String nombreAlimento,
            @FormParam("calorias") double calorias,
            @FormParam("idPorcion") Integer idPorcion){
    
        Mensaje resultado = null;
        Alimento cat = new Alimento(idAlimento, nombreAlimento, calorias, idPorcion);
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("alimentos.actualizarAlimento" , cat);
                if(result ==1){
                    conn.commit();
                    resultado = new Mensaje(false, "Alimento modificado correctamente.");
                }else{
                    conn.rollback();//deshace la operación
                    resultado = new Mensaje(false, "El Alimento no se pudo modificar");
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
    
    @Path("eliminarAlimento")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminaAlimento(@FormParam("idAlimento") Integer idAlimento){
    
        Mensaje resultado = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("alimentos.eliminarAlimento", idAlimento);
                if(result ==1){
                    conn.commit();
                    resultado = new Mensaje(false, "Alimento eliminado correctamente.");
                }else{
                    conn.rollback();
                    resultado = new Mensaje(false, "El alimento no se pudo eliminar");
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