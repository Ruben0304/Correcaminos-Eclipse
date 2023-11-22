package controllers;

import java.security.Principal;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import auth.Auth;
import models.departamentos.Biblioteca;
import models.departamentos.Economia;
import models.gestion.GestorDepartamentos;
import models.gestion.GestorPrincipal;
import models.gestion.empleados.GestorEmpleados;
import models.gestion.estudiantes.GestorEstudiantes;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Becado;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import models.usuarios.Usuario;
import util.BooleanosEstudianteBaja;
import util.BooleanosEstudianteBecadoBaja;
import util.Colores;
import views.ChatPanel;
import views.Inicio;
import views.Pricipal;
import views.Reportes;
import views.TramitesEmpleados;
import views.old.EstudianteTramites;
import views.old.Inicios;
import views.old.RequisitosBajaEstudiantes;
import views.usuarios.EstudiantesTramites;
import views.usuarios.RequisitosEstudiante;

public class ControladorPrincipal {

    public static void mostrarInicio() {

        if (Auth.hayUsuarioAutenticado()) {
            boolean estudianteSolicitaLicencia = false;
            if (Auth.usuarioAutenticado() instanceof Estudiante) {
                estudianteSolicitaLicencia = GestorPrincipal.getGestorPrincipal().getGestorEstudiantes()
                        .getGestorSolicitudes()
                        .verificarEstudianteSolicitaLicencia((Estudiante) Auth.usuarioAutenticado());
            }

            // Inicios inicio = new Inicios(Auth.usuarioAutenticado(),
            // estudianteSolicitaLicencia);
            // inicio.setVisible(true);
        }

        Pricipal instancia = Pricipal.getInstancia();
        instancia.setVista(
                Inicio.getVista(Auth.hayUsuarioAutenticado() ? Auth.usuarioAutenticado() : null).getPanel_lateral());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();

    }

    public static void mostrarRequisitosBajaEstudiantes() {

        if (!Auth.hayUsuarioAutenticado()) {
            ControladorLogin.mostrarLogin();
        } else {

            GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();
            GestorSolicitudesEstudiante gestorSolicitudesEstudiante = GestorEstudiantes.gestorEstudiantes()
                    .getGestorSolicitudes();
            if (Auth.usuarioAutenticado() instanceof Estudiante) {

                Estudiante usuarioAutenticado = (Estudiante) Auth.usuarioAutenticado();
                if (!(gestorSolicitudesEstudiante.verificarEstudianteSolicitaLicencia(usuarioAutenticado)
                        || gestorSolicitudesEstudiante.verificarEstudianteSolicitaBaja(usuarioAutenticado))) {
                    mostrarTramites();
                } else {
                    ResponsabilidadesEstudiantes respEst = GestorEstudiantes.gestorEstudiantes()
                            .getGestorResponsabilidadesEstudiantes()
                            .getListadoDeUnEstudiante(usuarioAutenticado);
                    BooleanosEstudianteBaja booleanos = new BooleanosEstudianteBaja();

                    booleanos.setTieneLibrosPrestados(gestDep.getBiblioteca().tieneLibrosPrestados(respEst));
                    booleanos.setTieneEstipendio(gestDep.getEconomia().tieneEstipendio(respEst));
                    booleanos.setTieneDeuda(gestDep.getEconomia().tieneDeuda(respEst));
                    booleanos.setTieneLibrosDocentes(gestDep.getAlmacenDeLibros().tieneLibrosDocentes(respEst));
                    booleanos.setTieneCarnetDeEstudiante(gestDep.getSecretaria().tieneCarnetDeEstudiante(respEst));
                    booleanos.setTieneCuentaUsuarioAbierta(gestDep.getSeguridadInformatica()
                            .tieneCuentaUsuarioAbierta(respEst));

                    if (Auth.usuarioAutenticado() instanceof Becado) {
                        usuarioAutenticado = (Becado) usuarioAutenticado;

                        BooleanosEstudianteBecadoBaja booleanosBecado = (BooleanosEstudianteBecadoBaja) booleanos;

                        booleanosBecado.setTienePertenenciasDeLaCUJAE(gestDep.getDireccionDeBecas()
                                .tienePertenenciasDeLaCUJAE(respEst));

                        booleanosBecado
                                .setTieneCarnetDeBecado(gestDep.getDireccionDeBecas().tieneCarnetDeBecado(respEst));

                        Pricipal instancia = Pricipal.getInstancia();

                        instancia.setVista(RequisitosEstudiante.getVista(booleanosBecado)
                                .getPanel_RequisitosEstud());
                        Pricipal.getInstancia().revalidate();
                        Pricipal.getInstancia().repaint();

                    } else {

                        if (!(booleanos.isTieneCarnetDeEstudiante() | booleanos.isTieneCuentaUsuarioAbierta()
                                || booleanos.isTieneDeuda() || booleanos.isTieneEstipendio()
                                || booleanos.isTieneLibrosDocentes() || booleanos.isTieneLibrosPrestados())) {
                            JOptionPane.showMessageDialog(null, "Su solicitud ha sido aceptada");
                        } else {
                            Pricipal instancia = Pricipal.getInstancia();

                            instancia.setVista(RequisitosEstudiante.getVista(booleanos).getPanel_RequisitosEstud());
                            Pricipal.getInstancia().revalidate();
                            Pricipal.getInstancia().repaint();
                        }

                    }
                }

            }

        }

    }

    public static void mostrarChats() {
        if (Auth.hayUsuarioAutenticado()) {
            Usuario autenticado = Auth.usuarioAutenticado();
            if (autenticado instanceof Persona) {
                Pricipal.getInstancia().setVista(new ChatPanel(autenticado));
                Pricipal.getInstancia().revalidate();
                Pricipal.getInstancia().repaint();
            }
        } else {
            ControladorLogin.mostrarLogin();
        }

    }

    public static void modoOscuro(boolean modoOscuro) {
        if (modoOscuro) {
            Colores.modoOscuro();
        } else {
            Colores.modoClaro();
        }
        mostrarInicio();
    }

    public static void actualizarDatos() {

        GestorPrincipal.getGestorPrincipal().actualizarDatos();
        mostrarInicio();

    }

    public static void mostrarTramites() {
        Pricipal instancia = Pricipal.getInstancia();
        instancia.setVista(EstudiantesTramites.getVista((Estudiante) Auth.usuarioAutenticado()).getPanel_lateral());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();
    }

    public static void mostrarReportes() {
        Pricipal instancia = Pricipal.getInstancia();
        instancia.setVista(Reportes.getVista().getPanel());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();
    }

}
