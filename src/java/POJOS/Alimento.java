package POJOS;

public class Alimento {
    private Integer idAlimento;
    private String nombreAlimento;
    private double calorias;
    private Integer idPorcion;

    public Alimento() {
    }

    public Alimento(Integer idAlimento, String nombreAlimento, double calorias, Integer idPorcion) {
        this.idAlimento = idAlimento;
        this.nombreAlimento = nombreAlimento;
        this.calorias = calorias;
        this.idPorcion = idPorcion;
    }

    public Integer getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public void setNombreAlimento(String nombreAlimento) {
        this.nombreAlimento = nombreAlimento;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public Integer getIdPorcion() {
        return idPorcion;
    }

    public void setIdPorcion(Integer idPorcion) {
        this.idPorcion = idPorcion;
    }
    
    
}

  