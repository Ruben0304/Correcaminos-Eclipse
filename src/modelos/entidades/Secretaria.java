package modelos.entidades;

import java.util.ArrayList;

import modelos.datos.EstudianteFactory;
import modelos.datos.SolicitudFactory;

public class Secretaria {
    ArrayList<Estudiante> estudiantes;
    ArrayList<SolicitudLicenciaEstudiante> solicitudesLicencia;
    ArrayList<SolicitudBajaEstudiante> solicitudesBaja;

    public Secretaria() {
        estudiantes = new ArrayList<>();
        solicitudesLicencia = new ArrayList<>();
        solicitudesBaja = new ArrayList<>();
    }

    public ArrayList<Estudiante> registrarEstudianteFictisios() {
        estudiantes.addAll(EstudianteFactory.inicializarEstudiantes());
        return estudiantes;
    }

    public ArrayList<SolicitudLicenciaEstudiante> registrarLicenciasEstudiantesFictisios() {
        solicitudesLicencia.addAll(SolicitudFactory.inicializarLicenciasEstudiantesFictisios(estudiantes));
        return solicitudesLicencia;
    }

    public void agregarSolicitudDeLicencia(SolicitudLicenciaEstudiante solicitud) {
        solicitudesLicencia.add(solicitud);
    }

    private boolean verificarRequisitos(Estudiante e) {

        return !(e.tieneDeuda() || e.tieneEstipendio() || e.tieneCuentaCerrada() || e.tieneLibrosDeBiblioteca()
                || e.tieneLibrosDocentes());

    }

    private boolean verificarRequisitos(Becado b) {

        return !(b.tieneDeuda() || b.tieneEstipendio() || b.tieneCuentaCerrada() || b.tieneLibrosDeBiblioteca()
                || b.tieneLibrosDocentes() || b.entregoCarnet() || b.entregoPertenencias());

    }

    public boolean verificarEstudianteSolicitaLicencia(Estudiante e) {
        boolean encontrado = false;
        for (int i = 0; i < this.solicitudesLicencia.size() && !encontrado; i++) {
          encontrado = e.equals(this.solicitudesLicencia.get(i).getEstudiante());
        }
        return encontrado;
    }

    public ArrayList<SolicitudLicenciaEstudiante> getSolicitudesLicencia() {

        return solicitudesLicencia;
    }

    public ArrayList<Estudiante> getEstudiantes() {

        return estudiantes;
    }

}
