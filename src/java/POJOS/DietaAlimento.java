package POJOS;

public class DietaAlimento {
    private Integer idDietaAlimento;
    private Integer idAlimento;
    private Double cantidad;
    private Integer idDieta;
    private Integer idHorario;

    public DietaAlimento(Integer idDietaAlimento, Integer idAlimento, Double cantidad, Integer idDieta, Integer idHorario) {
        this.idDietaAlimento = idDietaAlimento;
        this.idAlimento = idAlimento;
        this.cantidad = cantidad;
        this.idDieta = idDieta;
        this.idHorario = idHorario;
    }

    public DietaAlimento() {
    }

    public Integer getIdDietaAlimento() {
        return idDietaAlimento;
    }

    public void setIdDietaAlimento(Integer idDietaAlimento) {
        this.idDietaAlimento = idDietaAlimento;
    }

    public Integer getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Integer idDieta) {
        this.idDieta = idDieta;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }
    
    

}
