package controllers;

import java.util.ArrayList;

import auth.Auth;
import models.departamentos.Biblioteca;
import models.departamentos.Economia;
import models.gestion.GestorDepartamentos;
import models.gestion.GestorPrincipal;
import models.gestion.empleados.GestorEmpleados;
import models.gestion.estudiantes.GestorEstudiantes;
import models.gestion.estudiantes.GestorResponsabilidadesEstudiantes;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.responsabilidades.ResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Becado;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.Usuario;
import util.Colores;
import views.Inicio;
import views.Pricipal;
import views.TramitesEmpleados;
import views.old.EstudianteTramites;
import views.old.Inicios;
import views.old.RequisitosBajaEstudiantes;
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

    public static void mostrarTramites() {

    }

    public static void mostrarRequisitosBajaEstudiantes() {

        if (!Auth.hayUsuarioAutenticado()) {
            ControladorLogin.mostrarLogin();
        } else {

            GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();

            if (Auth.usuarioAutenticado() instanceof Estudiante) {
                Estudiante usuarioAutenticado = (Estudiante) Auth.usuarioAutenticado();

                ResponsabilidadesEstudiantes respEst = GestorEstudiantes.gestorEstudiantes()
                        .getGestorResponsabilidadesEstudiantes()
                        .getListadoDeUnEstudiante(usuarioAutenticado);
                        

                boolean tieneLibrosPrestados = gestDep.getBiblioteca().tieneLibrosPrestados(respEst);

                boolean tieneEstipendio = gestDep.getEconomia().tieneEstipendio(respEst);

                boolean tieneDeuda = gestDep.getEconomia().tieneDeuda(respEst);

                boolean tieneLibrosDocentes = gestDep.getAlmacenDeLibros().tieneLibrosDocentes(respEst);

                boolean tieneCarnetDeEstudiante = gestDep.getSecretaria().tieneCarnetDeEstudiante(respEst);

                boolean tieneCuentaUsuarioAbierta = gestDep.getSeguridadInformatica()
                        .tieneCuentaUsuarioAbierta(respEst);

                if (Auth.usuarioAutenticado() instanceof Becado) {
                    usuarioAutenticado = (Becado) usuarioAutenticado;

                    boolean tienePertenenciasDeLaCUJAE = gestDep.getDireccionDeBecas()
                            .tienePertenenciasDeLaCUJAE(respEst);

                    boolean tieneCarnetDeBecado = gestDep.getDireccionDeBecas().tieneCarnetDeBecado(respEst);

                    Pricipal instancia = Pricipal.getInstancia();

                    instancia.setVista(RequisitosEstudiante.getVista(tieneLibrosPrestados,
                            tieneEstipendio, tieneDeuda, tieneLibrosDocentes, tieneCarnetDeEstudiante,
                            tieneCuentaUsuarioAbierta, tienePertenenciasDeLaCUJAE, tieneCarnetDeBecado)
                            .getPanel_RequisitosEstud());
                    Pricipal.getInstancia().revalidate();
                    Pricipal.getInstancia().repaint();

                } else {

                    Pricipal instancia = Pricipal.getInstancia();

                    instancia.setVista(RequisitosEstudiante.getVista(tieneLibrosPrestados,
                            tieneEstipendio, tieneDeuda, tieneLibrosDocentes, tieneCarnetDeEstudiante,
                            tieneCuentaUsuarioAbierta).getPanel_RequisitosEstud());
                    Pricipal.getInstancia().revalidate();
                    Pricipal.getInstancia().repaint();
                }

            }

            else if (Auth.usuarioAutenticado() instanceof Empleado) {
                // Empleado usuarioAutenticado = (Empleado) Auth.usuarioAutenticado();
                // ResponsabilidadesEmpleados respEst = GestorEmpleados.gestorEmpleados()
                // .getGestorResponsabilidadesEmpleado()
                // .getListadoDeUnEmpleado(usuarioAutenticado);

                // boolean tieneLibrosPrestados =
                // gestDep.getBiblioteca().tieneLibrosPrestados(respEst);

                // Pricipal instancia = Pricipal.getInstancia();
                // instancia.setVista(RequisitosEmpleado.getVista().getPanel_RequisitosEstud(tieneLibrosPrestados,
                // tieneEstipendio, tieneDeuda));
                // Pricipal.getInstancia().revalidate();
                // Pricipal.getInstancia().repaint();
            }

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

    public static void mostrarRequisitosEstudiantes() {
        // Pricipal instancia = Pricipal.getInstancia();
        // instancia.setVista(RequisitosEstudiante.getVista().getPanel_RequisitosEstud());
        // Pricipal.getInstancia().revalidate();
        // Pricipal.getInstancia().repaint();
    }

    public static void mostrarTramitesEmpleados() {
        Pricipal instancia = Pricipal.getInstancia();
        instancia.setVista(TramitesEmpleados.getVista().getPanel());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();
    }

}
