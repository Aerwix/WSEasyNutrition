package ws;

import POJOS.Mensaje;
import POJOS.Paciente;
import java.util.List;
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

@Path("pacientes")
public class PacienteWS {
    @Context
    private UriInfo context;
    
    public PacienteWS(){
    }
    
    @Path("nuevoPaciente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registraPaciente(
                @FormParam("idPaciente") Integer idPaciente,
                @FormParam("nombre") String nombre,
                @FormParam("apellidoMaterno") String apellidoMaterno,
                @FormParam("apellidoPaterno") String apellidoPaterno,
                @FormParam("direccion")String direccion,
                @FormParam("correo") String correo,
                @FormParam("password") String password,
                @FormParam("telefono") String telefono,
                @FormParam("fechaNacimiento") String fechaNacimiento,
                @FormParam("sexo") String sexo,
                @FormParam("idEstatus")Integer idEstatus){
        
        Mensaje resultado = null;
         Paciente pac = new Paciente(idPaciente, nombre, apellidoPaterno, apellidoMaterno, direccion, correo, password, telefono, fechaNacimiento, sexo, idEstatus);
         SqlSession conn = MyBatisUtil.getSession();
         
         if(conn != null){
             try{
                 int result = conn.insert("Paciente.registrarPaciente", pac);
                 if(result ==1){
                      conn.commit();//commit confirma la operacion que si la haga
                      resultado = new Mensaje(false, "El paciente ha sido registrado correctamente");
                 }else{
                     conn.rollback();
                     resultado = new Mensaje(true, "El paciente No se pudo registrar");
                     
                 }
                 
             }catch(Exception e){
                 e.printStackTrace();
                 resultado = new Mensaje(true, e.getMessage());
             }finally{
                 conn.close();
             }    
        }
     return resultado;
    }
    
    @Path("actualizarPaciente")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje actualizaPaciente(
            @FormParam("idPaciente") Integer idPaciente,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("direccion") String direccion,
            @FormParam("correo") String correo,
            @FormParam("password") String password,
            @FormParam("telefono") String telefono,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("sexo") String sexo,
            @FormParam("idEstatus") Integer idEstatus
            ){
    
        Mensaje resultado = null;
        Paciente  cat = new Paciente(idPaciente, nombre, apellidoMaterno, apellidoPaterno, direccion, correo, password, telefono, fechaNacimiento, sexo, idEstatus);
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("Paciente.actualizarPaciente" , cat);
                if(result ==1){
                    conn.commit();
                    resultado = new Mensaje(false, "Paciente modificado correctamente.");
                }else{
                    conn.rollback();//deshace la operación
                    resultado = new Mensaje(false, "El paciente no se pudo modificar");
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
    
    @Path("getAllPacientes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> getAllPacientes(){
        List<Paciente> list = null;
        SqlSession conn = MyBatisUtil.getSession();
        if (conn != null){
            try{
                list = conn.selectList("Paciente.getAllPacientes");
            } catch (Exception ex){
                ex.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return list;
    }
    
    @Path("getPacienteByCorreo/{correo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente getByCorreo(@PathParam("correo") String correo){
        Paciente resultado = new Paciente();
        SqlSession conn = MyBatisUtil.getSession();
        
        if (conn != null ){
            try {
                resultado = conn.selectOne("Paciente.getPacienteByEmail", correo);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
}