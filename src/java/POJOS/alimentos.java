package POJOS;

public class alimentos {
    private Integer idAlimento;
    private String nombre;
    private double calorias;
    private String porcion;

    public alimentos() {
    }

    public alimentos(Integer idAlimento, String nombre, double calorias, String porcion) {
        this.idAlimento = idAlimento;
        this.nombre = nombre;
        this.calorias = calorias;
        this.porcion = porcion;
    }

    public Integer getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Integer IdAlimento) {
        this.idAlimento = IdAlimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public String getPorcion() {
        return porcion;
    }

    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }
}
