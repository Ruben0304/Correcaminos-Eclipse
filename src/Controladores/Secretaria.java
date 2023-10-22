package Controladores;

import java.util.ArrayList;

import Modelos.Becado;
import Modelos.Estudiante;
import Modelos.SolicitudLicenciaEstudiante;


public class Secretaria {
    ArrayList<SolicitudLicenciaEstudiante> solicitudesLicencia;

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

}
