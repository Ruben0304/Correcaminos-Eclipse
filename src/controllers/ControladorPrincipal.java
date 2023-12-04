package controllers;

import java.security.Principal;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import auth.Auth;
import models.departamentos.Biblioteca;
import models.departamentos.Economia;
import models.gestion.GestorDepartamentos;
import models.gestion.Correcaminos;
import models.gestion.empleados.GestorEmpleados;
import models.gestion.estudiantes.Secretaria;
import models.gestion.estudiantes.GestorResponsabilidadesEstudiantes;
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
import views.Inicio;
import views.Reportes;
import views.TramitesEmpleados;
import views.auth.CuentaJP;
import views.chat.ChatPanel;
import views.client.EstudiantesTramites;
import views.client.RequisitosEstudiante;
import views.layouts.Pricipal;

public class ControladorPrincipal {

    public static void mostrarInicio() {

        if (Auth.hayUsuarioAutenticado()) {
            boolean estudianteSolicitaLicencia = false;
            if (Auth.usuarioAutenticado() instanceof Estudiante) {
                estudianteSolicitaLicencia = Correcaminos.getGestorPrincipal().getGestorEstudiantes()
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
            GestorSolicitudesEstudiante gestorSolicitudesEstudiante = Secretaria.gestorEstudiantes()
                    .getGestorSolicitudes();
            if (Auth.usuarioAutenticado() instanceof Estudiante) {

                Estudiante usuarioAutenticado = (Estudiante) Auth.usuarioAutenticado();
                if (!(gestorSolicitudesEstudiante.verificarEstudianteSolicitaAlgo(usuarioAutenticado))) {
                    mostrarTramites();
                } else {
                    GestorResponsabilidadesEstudiantes gestorResponsabilidades = Secretaria.gestorEstudiantes()
                            .getGestorResponsabilidadesEstudiantes();
                    BooleanosEstudianteBaja booleanos = new BooleanosEstudianteBaja();

                    booleanos.setTieneLibrosPrestados(gestDep.getBiblioteca().tieneLibrosPrestados(null));
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

    public static void mostrarAccount() {

        Pricipal instancia = Pricipal.getInstancia();
        instancia.setVista(new CuentaJP());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();

    }

    public static void mostrarChats() {
        if (Auth.hayUsuarioAutenticado()) {
           
            if (Auth.usuarioAutenticado() instanceof Persona) {
                Pricipal.getInstancia().setVista(new ChatPanel());
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

        Correcaminos.getGestorPrincipal().actualizarDatos();
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
