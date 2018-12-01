package POJOS;

public class MedidasConsulta {
    private Integer idMedicion;
    private String talla;
    private String peso;
    private String estatura;
    private String imc;
    private Integer idConsulta;

    public MedidasConsulta(Integer idMedicion, String talla, String peso, String estatura, String imc, Integer idConsulta) {
        this.idMedicion = idMedicion;
        this.talla = talla;
        this.peso = peso;
        this.estatura = estatura;
        this.imc = imc;
        this.idConsulta = idConsulta;
    }

    public MedidasConsulta() {
    }

    public Integer getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(Integer idMedicion) {
        this.idMedicion = idMedicion;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }
    
    
    
}
