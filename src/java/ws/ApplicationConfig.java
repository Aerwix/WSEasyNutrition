package ws;

import java.util.Set;
import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ws.AlimentoWS.class);
        resources.add(ws.CitaWS.class);
        resources.add(ws.ConsultaWS.class);
        resources.add(ws.DietaAlimentoWS.class);
        resources.add(ws.DietaWS.class);
        resources.add(ws.LoginWS.class);
        resources.add(ws.MedicoWS.class);
        resources.add(ws.MedidasConsultaWS.class);
        resources.add(ws.PacienteWS.class);
    }
    
}
