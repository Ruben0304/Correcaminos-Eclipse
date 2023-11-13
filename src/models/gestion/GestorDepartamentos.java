package models.gestion;

import models.departamentos.Biblioteca;
import models.departamentos.Economia;
import models.departamentos.RecursosHumanos;
import models.departamentos.Secretaria;


public class GestorDepartamentos {
    private static GestorDepartamentos gestorDepartamentos;
    private Secretaria secretaria;
    private RecursosHumanos recursosHumanos;
    private Biblioteca biblioteca;
    private Economia economia;

    public GestorDepartamentos() {
        secretaria = new Secretaria();
        recursosHumanos = new RecursosHumanos();
        biblioteca = new Biblioteca();
        economia = new Economia();
    }

    public static GestorDepartamentos gestorDepartamentos() {
        if (gestorDepartamentos == null) {
            gestorDepartamentos = new GestorDepartamentos();
        }
        return gestorDepartamentos;
    }
    
    public Secretaria getSecretaria() {
        return secretaria;
    }

    public RecursosHumanos getRecursosHumanos() {
        return recursosHumanos;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public Economia getEconomia() {
        return economia;
    }

  

    

    
}
