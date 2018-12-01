package POJOS;

public class Dieta {
    private Integer idDieta;
    private String nombreDieta;
    private Double totalCalorias;
    private Integer idMedico;

    public Dieta() {
    }

    public Dieta(Integer idDieta, String nombreDieta, Double totalCalorias, Integer idMedico) {
        this.idDieta = idDieta;
        this.nombreDieta = nombreDieta;
        this.totalCalorias = totalCalorias;
        this.idMedico = idMedico;
    }

    public Integer getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Integer idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombreDieta() {
        return nombreDieta;
    }

    public void setNombreDieta(String nombreDieta) {
        this.nombreDieta = nombreDieta;
    }

    public Double getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(Double totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }
    
    
    
    
}
