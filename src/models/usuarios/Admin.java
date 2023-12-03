package models.usuarios;

import util.TipoDepartamento;

public class Admin {
    private TipoDepartamento tipoDepartamento;

    public Admin(TipoDepartamento tipoDepartamento) {
        this.tipoDepartamento = tipoDepartamento;
    }

    public TipoDepartamento getTipoDepartamento() {
        return tipoDepartamento;
    }


    
}
