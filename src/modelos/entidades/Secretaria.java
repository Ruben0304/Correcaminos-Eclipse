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

    // private boolean verificarRequisitos(Estudiante e) {

    // return !(e.tieneDeuda() || e.tieneEstipendio() || e.tieneCuentaCerrada() ||
    // e.tieneLibrosDeBiblioteca()
    // || e.tieneLibrosDocentes());

    // }

    // private boolean verificarRequisitos(Becado b) {

    // return !(b.tieneDeuda() || b.tieneEstipendio() || b.tieneCuentaCerrada() ||
    // b.tieneLibrosDeBiblioteca()
    // || b.tieneLibrosDocentes() || b.entregoCarnet() || b.entregoPertenencias());

    // }

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

    public ArrayList<Estudiante> getSolicitudesLicenciaPendientes() {
        ArrayList<Estudiante> solicitudLicenciaEstudiantes = new ArrayList<>();
        for (SolicitudLicenciaEstudiante s : this.solicitudesLicencia) {
            if (s.getEstado().equals(Estado.PENDIENTE)) {
                solicitudLicenciaEstudiantes.add(s.getEstudiante());
            }

        }
        return solicitudLicenciaEstudiantes;
    }

    public ArrayList<Estudiante> getSolicitudesLicenciaPendientes(TipoDepartamento d) {
        ArrayList<Estudiante> solicitudLicenciaEstudiantesRequisitos = new ArrayList<>();
        switch (d) {
            case Biblioteca:
                for (SolicitudLicenciaEstudiante s : this.solicitudesLicencia) {
                    if (s.getEstudiante().tieneLibrosDeBiblioteca() && s.getEstado().equals(Estado.PENDIENTE)) {
                        solicitudLicenciaEstudiantesRequisitos.add(s.getEstudiante());
                    }
                }
                break;

            default:
                break;
        }

        return solicitudLicenciaEstudiantesRequisitos;
    }

    public ArrayList<Estudiante> getSolicitudesLicenciaPendientes(TipoDepartamento d,
            String requisito) {
        ArrayList<Estudiante> solicitudLicenciaEstudiantesRequisitos = new ArrayList<>();
        switch (d) {
            case Economia:
                if (requisito.equals("ESTIPENDIO")) {
                    for (SolicitudLicenciaEstudiante s : this.solicitudesLicencia) {
                        if (s.getEstudiante().tieneEstipendio() && s.getEstado().equals(Estado.PENDIENTE)) {
                            solicitudLicenciaEstudiantesRequisitos.add(s.getEstudiante());
                        }
                    }
                } else if (requisito.equals("DEUDA")) {
                    for (SolicitudLicenciaEstudiante s : this.solicitudesLicencia) {
                        if (s.getEstudiante().tieneDeuda() && s.getEstado().equals(Estado.PENDIENTE)) {
                            solicitudLicenciaEstudiantesRequisitos.add(s.getEstudiante());
                        }
                    }
                }
                break;
            case DireccionBecas:
                if (requisito.equals("CARNET_BECADO")) {
                    for (SolicitudLicenciaEstudiante s : this.solicitudesLicencia) {
                        if (s.getEstudiante() instanceof Becado) {
                            if (!((Becado) s.getEstudiante()).entregoCarnetBecado() && s.getEstado().equals(Estado.PENDIENTE)) {
                                solicitudLicenciaEstudiantesRequisitos.add(s.getEstudiante());
                            }
                        }

                    }
                } else if (requisito.equals("PERTENENCIAS")) {
                    for (SolicitudLicenciaEstudiante s : this.solicitudesLicencia) {
                        if (s.getEstudiante() instanceof Becado) {
                            if (!((Becado) s.getEstudiante()).entregoPertenencias() && s.getEstado().equals(Estado.PENDIENTE)) {
                                solicitudLicenciaEstudiantesRequisitos.add(s.getEstudiante());
                            }
                        }
                    }
                }
                break;

            default:
                break;
        }

        return solicitudLicenciaEstudiantesRequisitos;
    }

    public ArrayList<Estudiante> getEstudiantes() {

        return estudiantes;
    }

}
