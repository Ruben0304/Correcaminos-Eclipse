package modelos.entidades;

import java.util.ArrayList;

import modelos.datos.EstudianteFactory;


public class Secretaria {
    ArrayList<Estudiante> estudiantes;
    ArrayList<SolicitudLicenciaEstudiante> solicitudesLicencia;

    public Secretaria() {
        this.estudiantes = EstudianteFactory.inicializarEstudiantes();
    }


    private boolean verificarRequisitos(Estudiante e) {

        return !(e.tieneDeuda() || e.tieneEstipendio() || e.tieneCuentaCerrada() || e.tieneLibrosDeBiblioteca()
                || e.tieneLibrosDocentes());

    }

    private boolean verificarRequisitos(Becado b) {

        return !(b.tieneDeuda() || b.tieneEstipendio() || b.tieneCuentaCerrada() || b.tieneLibrosDeBiblioteca()
                || b.tieneLibrosDocentes() || b.tieneCarnet() || b.tienePertenencias());

    }

    private void aprobarSolicitudLicencia() {
        
    }
    
    public ArrayList<SolicitudLicenciaEstudiante> getSolicitudesLicencia(){
    	
    	return solicitudesLicencia;
    }
    
    public  ArrayList<Estudiante> getEstudiantes(){
    	
    	return estudiantes;
    }

}