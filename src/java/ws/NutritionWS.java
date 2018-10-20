package ws;

import POJOS.alimentos;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

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
        alimentos al = new alimentos(1, "Prueba", 200, "1");
        return al;
    }
    
    @Path("getAllAlimentos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<alimentos> getAllAlimentos(){
        List<alimentos> list = null;
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
    public alimentos getById(@PathParam("idAlimento") Integer idAlimento){
        alimentos resultado = new alimentos();
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
    public alimentos getByName(@PathParam("nombre") String nombre){
        alimentos resultado = new alimentos();
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
}
