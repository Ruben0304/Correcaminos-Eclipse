package controllers;

import java.util.ArrayList;

import auth.Auth;
import models.departamentos.Biblioteca;
import models.departamentos.Secretaria;
import models.gestion.GestorDepartamentos;
import models.gestion.GestorPrincipal;
import models.gestion.estudiantes.GestorEstudiantes;
import models.gestion.estudiantes.GestorResponsabilidadesEstudiantes;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Admin;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import models.usuarios.Usuario;
import views.Pricipal;
import views.Reportes;
import views.admin.CasosPendientes;
import views.old.SecretariaPendientes;

public class ControladorAdmin {

    public static void mostrarGestionLicencias() {
        ArrayList<Estudiante> usuariosPendientes = new ArrayList<>();
        Usuario usuarioAutenticado = Auth.usuarioAutenticado();
        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();
        ArrayList<ResponsabilidadesEstudiantes> listadoResponsabilidades = GestorEstudiantes.gestorEstudiantes()
                .getGestorResponsabilidadesEstudiantes().getResponsabilidadesEstudiantesPendientes();
        Pricipal instancia = Pricipal.getInstancia();
        switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
                usuariosPendientes.addAll(gestDep.getBiblioteca().getEstudiantesPendientes(listadoResponsabilidades));

                instancia.setVista(new CasosPendientes(usuariosPendientes).getPanelCasosPendientes());
                Pricipal.getInstancia().revalidate();
                Pricipal.getInstancia().repaint();

                break;
            case Secretaria:
                usuariosPendientes.addAll(gestDep.getSecretaria().getEstudiantesPendientes(listadoResponsabilidades));

                instancia.setVista(new CasosPendientes(usuariosPendientes).getPanelCasosPendientes());
                Pricipal.getInstancia().revalidate();
                Pricipal.getInstancia().repaint();
                break;
            case AlmacenLibrosDocentes:
                usuariosPendientes.addAll(gestDep.getAlmacenDeLibros().getEstudiantesPendientes(listadoResponsabilidades));

                instancia.setVista(new CasosPendientes(usuariosPendientes).getPanelCasosPendientes());
                Pricipal.getInstancia().revalidate();
                Pricipal.getInstancia().repaint();
                break;

            case Economia:
                usuariosPendientes.addAll(gestDep.getEconomia().getEstudiantesPendientes(listadoResponsabilidades));

                instancia.setVista(new CasosPendientes(usuariosPendientes).getPanelCasosPendientes());
                Pricipal.getInstancia().revalidate();
                Pricipal.getInstancia().repaint();
                break;

            case SeguridadInformatica:
                usuariosPendientes.addAll(gestDep.getSeguridadInformatica().getEstudiantesPendientes(listadoResponsabilidades));

                instancia.setVista(new CasosPendientes(usuariosPendientes).getPanelCasosPendientes());
                Pricipal.getInstancia().revalidate();
                Pricipal.getInstancia().repaint();
                break;

            case DireccionBecas:
                usuariosPendientes.addAll(gestDep.getDireccionDeBecas().getEstudiantesPendientes(listadoResponsabilidades));

                instancia.setVista(new CasosPendientes(usuariosPendientes).getPanelCasosPendientes());
                Pricipal.getInstancia().revalidate();
                Pricipal.getInstancia().repaint();
                break;

            default:
                break;
        }

    }

    public static void confirmarEntrega(String carnet) {
        Admin usuarioAutenticado = (Admin) Auth.usuarioAutenticado();
        GestorDepartamentos gestorDepartamentos = GestorDepartamentos.gestorDepartamentos();
        GestorResponsabilidadesEstudiantes gestorResponsabilidadesEstudiantes = GestorEstudiantes.gestorEstudiantes()
                .getGestorResponsabilidadesEstudiantes();
        GestorEstudiantes gestorEstudiantes = GestorEstudiantes.gestorEstudiantes();

        switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
                gestorDepartamentos.getBiblioteca().recogerLibrosPrestados(
                        gestorEstudiantes.buscarEstudiantePorCi(carnet),
                        gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());

                break;
            case Secretaria:
                gestorDepartamentos.getSecretaria().devolverCarnetCujae(gestorEstudiantes.buscarEstudiantePorCi(carnet),
                        gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
                break;
            case AlmacenLibrosDocentes:
                gestorDepartamentos.getAlmacenDeLibros().recogerLibrosDocentes(
                        gestorEstudiantes.buscarEstudiantePorCi(carnet),
                        gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
                break;

            case Economia:
                gestorDepartamentos.getEconomia().confirmarEntregas(gestorEstudiantes.buscarEstudiantePorCi(carnet),
                        gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());

                break;

            case SeguridadInformatica:
                gestorDepartamentos.getSeguridadInformatica().cerrarCuenta(
                        gestorEstudiantes.buscarEstudiantePorCi(carnet),
                        gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
                break;

            case DireccionBecas:
                gestorDepartamentos.getDireccionDeBecas().recogerPertenenciasDeEstudiante(
                        gestorEstudiantes.buscarEstudiantePorCi(carnet),
                        gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
                break;
            default:

                break;
        }
        mostrarGestionLicencias();
    }

    public ArrayList<SolicitudLicencia> filtrarLicencias (String filtro){
        
    }

}
