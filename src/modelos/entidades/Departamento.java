package modelos.entidades;

import utiles.TipoDepartamento;

public class Departamento extends Usuario{
    private TipoDepartamento tipoDepartamento;

    public Departamento(String nombreUsuario, String contrasena, TipoDepartamento tipoDepartamento) {
        super(nombreUsuario, contrasena);
        this.tipoDepartamento = tipoDepartamento;
    }

    public TipoDepartamento getTipoDepartamento() {
        return tipoDepartamento;
    }


    
}
