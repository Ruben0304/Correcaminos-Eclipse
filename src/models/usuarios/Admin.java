package models.usuarios;

import utiles.TipoDepartamento;

public class Admin extends Usuario{
    private TipoDepartamento tipoDepartamento;

    public Admin(String nombreUsuario, String contrasena, TipoDepartamento tipoDepartamento) {
        super(nombreUsuario, contrasena);
        this.tipoDepartamento = tipoDepartamento;
    }

    public TipoDepartamento getTipoDepartamento() {
        return tipoDepartamento;
    }


    
}
