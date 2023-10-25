package modelos.entidades;

import java.util.ArrayList;

import modelos.datos.EstudianteFactory;
import modelos.datos.SolicitudFactory;
import utiles.Estado;
import utiles.TipoDepartamento;

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

    public Estudiante buscarEstudiante(String id) {
        boolean encontrado = false;
        Estudiante estudianteEncontrado = null;
        for (int i = 0; i < this.estudiantes.size() && !encontrado; i++) {
            encontrado = id.equals(this.estudiantes.get(i).getCi());
            if (encontrado) {
                estudianteEncontrado = this.estudiantes.get(i);
            }
        }
        return estudianteEncontrado;
    }

    public ArrayList<SolicitudLicenciaEstudiante> getSolicitudesLicencia() {

        return solicitudesLicencia;
    }

    public ArrayList<SolicitudLicenciaEstudiante> getSolicitudesLicenciaPendientes() {
        ArrayList<SolicitudLicenciaEstudiante> solicitudLicenciaEstudiantes = new ArrayList<SolicitudLicenciaEstudiante>();
        for (SolicitudLicenciaEstudiante s : this.solicitudesLicencia) {
            if (s.getEstado().equals(Estado.PENDIENTE)) {
                solicitudLicenciaEstudiantes.add(s);
            }

        }
        return solicitudLicenciaEstudiantes;
    }

    public ArrayList<Estudiante> getSolicitudesLicenciaPendientes(TipoDepartamento d, String requisito) {
        ArrayList<SolicitudLicenciaEstudiante> solicitudLicenciaEstudiantes = getSolicitudesLicenciaPendientes();
        ArrayList<Estudiante> solicitudLicenciaEstudiantesRequisitos = new ArrayList<Estudiante>();
        switch (d) {
            case Biblioteca:
            if (requisito.equals("ESTIPENDIO")) {
                for (SolicitudLicenciaEstudiante s : solicitudLicenciaEstudiantes) {
                    if (s.getEstudiante().tieneEstipendio()) {
                        solicitudLicenciaEstudiantesRequisitos.add(s.getEstudiante());
                    }
                }
            } else if (requisito.equals("DEUDA")){
                for (SolicitudLicenciaEstudiante s : solicitudLicenciaEstudiantes) {
                    if (s.getEstudiante().tieneDeuda()) {
                        solicitudLicenciaEstudiantesRequisitos.add(s.getEstudiante());
                    }
                }
            }
                break;
        
            default:
                break;
        }
        for (SolicitudLicenciaEstudiante s : this.solicitudesLicencia) {
            if (s.getEstado() == Estado.PENDIENTE) {
                solicitudLicenciaEstudiantes.add(s);
            }

        }
        return solicitudLicenciaEstudiantesRequisitos;
    }

    public ArrayList<Estudiante> getEstudiantes() {

        return estudiantes;
    }

}
