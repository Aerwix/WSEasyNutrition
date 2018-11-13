package ws;

import POJOS.Mensaje;
import POJOS.Paciente;
import POJOS.Alimento;
import POJOS.Cita;
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
    public Alimento getHolaMundo() {
        Alimento al = new Alimento(1, "Prueba", 200, 2);
        return al;
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
            @FormParam("nombre") String nombre,
            @FormParam("calorias") double calorias,
            @FormParam("porcion") Integer porcion){
        
        Mensaje resultado = null;
        Alimento  cat = new Alimento(idAlimento, nombre, calorias, porcion);
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
            @FormParam("nombre") String nombre,
            @FormParam("calorias") double calorias,
            @FormParam("porcion") Integer porcion){
    
        Mensaje resultado = null;
        Alimento cat = new Alimento(idAlimento, nombre, calorias, porcion);
        SqlSession conn = MyBatisUtil.getSession();
        if(conn !=null){
            try {
                int result = conn.update("alimentos.actualizarAlimento" , cat);
                if(result ==1){
                    conn.commit();
                    resultado = new Mensaje(false, "Cliente modificado correctamente.");
                }else{
                    conn.rollback();//deshace la operación
                    resultado = new Mensaje(false, "El cliente no se pudo modificar");
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
    
    // Servicio de Citas //
    
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
        Cita  cat = new Cita(idCita, idPaciente, idMedico, fecha, hora);
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
    
    @Path("getCitasByMedico/{idMedico}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Cita getByIdMedico(@PathParam("idMedico") Integer idMedico){
        Cita resultado = new Cita();
        SqlSession conn = MyBatisUtil.getSession();
        
        if (conn != null ){
            try {
                resultado = conn.selectOne("citas.getCitasByMedico", idMedico);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
    
    
    @Path("registropaciente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registraPaciente(@FormParam("idPaciente") Integer idPaciente,
                @FormParam("nombre") String nombre,
                @FormParam("apellidoPatrno") String apellidoMaterno,
                @FormParam("apellidoMaterno") String apellidoPaterno,
                @FormParam("direccion")String direccion,
                @FormParam("correo") String correo,
                @FormParam("password") String password,
                @FormParam("telefono") String telefono,
                @FormParam("fechaNacimiento") String fechaNacimiento,
                @FormParam("sexo") String sexo,
                @FormParam("IdEstatus")Integer idEstatus){
        
        Mensaje resultado = null;
         Paciente pac = new Paciente(0,nombre,apellidoPaterno,apellidoMaterno,direccion,correo,password,telefono,fechaNacimiento,sexo,idEstatus);
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
    
    @Path("actualizarpaciente")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje actualizarPaciente(@FormParam("idPaciente") Integer idPaciente,
             @FormParam("nombre") String nombre,
                @FormParam("apellidoMaterno") String apellidoMaterno,
                @FormParam("apellidoPaterno") String apellidoPaterno,
                @FormParam("direccion")String direccion,
                @FormParam("correo") String correo,
                @FormParam("password") String password,
                @FormParam("telefono") String telefono,
                @FormParam("fechaNacimiento") String fechaNacimiento,
                @FormParam("sexo") String sexo,
                @FormParam("idEstatus") Integer idEstatus){
        
        Mensaje resultado = null;
         Paciente cat = new Paciente(0,nombre,apellidoMaterno,apellidoPaterno,direccion,correo,password,telefono,fechaNacimiento,sexo,idEstatus);
         SqlSession conn = MyBatisUtil.getSession();
         
         if(conn != null){
             try{
                 int result = conn.update("Paciente.actualizarPaciente", cat);
                 if(result ==1){
                      conn.commit();//commit confirma la operacion que si la haga
                      resultado = new Mensaje(false, "El paciente se ha actualizado correctamente");
                 }else{
                     conn.rollback();
                     resultado = new Mensaje(true, "El paciente No se pudo actualizar");
                     
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
}
