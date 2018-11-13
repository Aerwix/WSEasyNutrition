package ws;

import POJOS.Consulta;
import POJOS.Mensaje;
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

@Path("consultas")
public class ConsultaWS {

    @Context
    private UriInfo context;
    
    public ConsultaWS() {
    }
       
    @Path("nuevaConsulta")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje nuevaConsulta(
            @FormParam("idConsulta") Integer idConsulta,
            @FormParam("idPaciente") Integer idPaciente,
            @FormParam("idMedico") Integer idMedico,
            @FormParam("idDieta") Integer idDieta,
            @FormParam("observaciones") String observaciones,
            @FormParam("fechaConsulta") String fechaConsulta
            ){
        
        Mensaje resultado = null;
        Consulta cat = new Consulta(idConsulta, idPaciente, idMedico, idDieta, observaciones, fechaConsulta);
        SqlSession conn = MyBatisUtil.getSession();
        if (conn != null) {
            try {
                int result = conn.insert("consultas.nuevaConsulta", cat);
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
