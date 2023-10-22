package modelos.entidades;

public class Admin extends Usuario{
    private String categoria;

    public Admin(String nombreUsuario, String contrasena, String categoria) {
        super(nombreUsuario, contrasena);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    } 


    
}
