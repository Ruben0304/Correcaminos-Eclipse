package modelos.gestion;

import modelos.admin.AlmacenDeLibros;
import modelos.admin.Biblioteca;
import modelos.admin.Contabilidad;
import modelos.admin.DireccionDeBecas;
import modelos.admin.Economia;
import modelos.admin.RecursosHumanos;
import modelos.admin.SeguridadInformatica;
import modelos.gestion.estudiantes.Secretaria;

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
