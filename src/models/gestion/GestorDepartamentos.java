package models.gestion;

import models.departamentos.AlmacenDeLibros;
import models.departamentos.Biblioteca;
import models.departamentos.Contabilidad;
import models.departamentos.DireccionDeBecas;
import models.departamentos.Economia;
import models.departamentos.RecursosHumanos;
import models.gestion.estudiantes.Secretaria;
import models.departamentos.SeguridadInformatica;

public class GestorDepartamentos {
    private static GestorDepartamentos gestorDepartamentos;
    private Secretaria secretaria;
    private RecursosHumanos recursosHumanos;
    private Biblioteca biblioteca;
    private Economia economia;
    private Contabilidad contabilidad;
    private AlmacenDeLibros almacenDeLibros;
    private SeguridadInformatica seguridadInformatica;
    private DireccionDeBecas direccionDeBecas;

    private GestorDepartamentos() {
        secretaria = new Secretaria();
        recursosHumanos = new RecursosHumanos();
        biblioteca = new Biblioteca();
        contabilidad = new Contabilidad();
        economia = new Economia();
        almacenDeLibros = new AlmacenDeLibros();
        seguridadInformatica = new SeguridadInformatica();
        direccionDeBecas = new DireccionDeBecas();
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

    public AlmacenDeLibros getAlmacenDeLibros() {
        return almacenDeLibros;
    }

    public SeguridadInformatica getSeguridadInformatica() {
        return seguridadInformatica;
    }

    public DireccionDeBecas getDireccionDeBecas() {
        return direccionDeBecas;
    }
    
    public Contabilidad getContabilidad() {
        return contabilidad;
    }

}
