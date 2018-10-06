package POJOS;

public class alimentos {
    private String IdAlimento;
    private String nombre;
    private double calorias;
    private String porcion;

    public alimentos() {
    }

    public alimentos(String IdAlimento, String nombre, double calorias, String porcion) {
        this.IdAlimento = IdAlimento;
        this.nombre = nombre;
        this.calorias = calorias;
        this.porcion = porcion;
    }

    public String getIdAlimento() {
        return IdAlimento;
    }

    public void setIdAlimento(String IdAlimento) {
        this.IdAlimento = IdAlimento;
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
