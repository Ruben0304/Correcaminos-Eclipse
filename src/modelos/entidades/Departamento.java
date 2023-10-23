package modelos.entidades;

public class Departamento extends Usuario{
    private String categoria;

    public Departamento(String nombreUsuario, String contrasena, String categoria) {
        super(nombreUsuario, contrasena);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    } 


    
}
