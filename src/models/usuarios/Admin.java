package models.usuarios;

import interfaces.Autenticable;
import util.TipoDepartamento;

public class Admin implements Autenticable{
    private TipoDepartamento tipoDepartamento;

    public Admin(TipoDepartamento tipoDepartamento) {
        this.tipoDepartamento = tipoDepartamento;
    }

    public TipoDepartamento getTipoDepartamento() {
        return tipoDepartamento;
    }


    
}
