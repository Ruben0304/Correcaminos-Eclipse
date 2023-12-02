package controllers;

import java.util.ArrayList;

import auth.Auth;
import models.gestion.GestorDepartamentos;
import models.gestion.Correcaminos;
import models.gestion.estudiantes.Secretaria;
import models.gestion.estudiantes.GestorResponsabilidadesEstudiantes;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Admin;
import models.usuarios.Estudiante;
import models.usuarios.Usuario;
import views.admin.CasosPendientes;
import views.admin.PanelAdministracion;
import views.layouts.Pricipal;

public class ControladorAdmin {

    public static void mostrarGestionLicencias() {
        ArrayList<Estudiante> usuariosPendientes = new ArrayList<>();
        Usuario usuarioAutenticado = Auth.usuarioAutenticado();
        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();
        ArrayList<ResponsabilidadesEstudiantes> listadoResponsabilidades = new ArrayList<>();
        Pricipal instancia = Pricipal.getInstancia();
        switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
                // usuariosPendientes.addAll(gestDep.getBiblioteca().getEstudiantesPendientes(listadoResponsabilidades));

                instancia.setVista(new CasosPendientes(usuariosPendientes).getPanelCasosPendientes());
                Pricipal.getInstancia().revalidate();
                Pricipal.getInstancia().repaint();

                break;
            case Secretaria:
                // usuariosPendientes.addAll(gestDep.getSecretaria().getEstudiantesPendientes(listadoResponsabilidades));
                ArrayList<SolicitudBajaEstudiante> solicitudBajaEstudiantes = Secretaria.gestorEstudiantes()
                        .getGestorSolicitudes().getSolicitudesBajaAceptadas();
                       

                instancia.setVista(PanelAdministracion.getPanelAdministracion(solicitudBajaEstudiantes));
                instancia.revalidate();
                instancia.repaint();
                break;
            case AlmacenLibrosDocentes:
                usuariosPendientes
                        .addAll(gestDep.getAlmacenDeLibros().getEstudiantesPendientes(listadoResponsabilidades));

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
                usuariosPendientes
                        .addAll(gestDep.getSeguridadInformatica().getEstudiantesPendientes(listadoResponsabilidades));

                instancia.setVista(new CasosPendientes(usuariosPendientes).getPanelCasosPendientes());
                Pricipal.getInstancia().revalidate();
                Pricipal.getInstancia().repaint();
                break;

            case DireccionBecas:
                usuariosPendientes
                        .addAll(gestDep.getDireccionDeBecas().getEstudiantesPendientes(listadoResponsabilidades));

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
        GestorResponsabilidadesEstudiantes gestorResponsabilidadesEstudiantes = Secretaria.gestorEstudiantes()
                .getGestorResponsabilidadesEstudiantes();
        Secretaria gestorEstudiantes = Secretaria.gestorEstudiantes();

        // switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
        //     case Biblioteca:
        //         gestorDepartamentos.getBiblioteca().recogerLibrosPrestados(
        //                 gestorEstudiantes.buscarEstudiantePorCi(carnet),
        //                 gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());

        //         break;
        //     case Secretaria:
        //         gestorDepartamentos.getSecretaria().devolverCarnetCujae(gestorEstudiantes.buscarEstudiantePorCi(carnet),
        //                 gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
        //         break;
        //     case AlmacenLibrosDocentes:
        //         gestorDepartamentos.getAlmacenDeLibros().recogerLibrosDocentes(
        //                 gestorEstudiantes.buscarEstudiantePorCi(carnet),
        //                 gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
        //         break;

        //     case Economia:
        //         gestorDepartamentos.getEconomia().confirmarEntregas(gestorEstudiantes.buscarEstudiantePorCi(carnet),
        //                 gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());

        //         break;

        //     case SeguridadInformatica:
        //         gestorDepartamentos.getSeguridadInformatica().cerrarCuenta(
        //                 gestorEstudiantes.buscarEstudiantePorCi(carnet),
        //                 gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
        //         break;

        //     case DireccionBecas:
        //         gestorDepartamentos.getDireccionDeBecas().recogerPertenenciasDeEstudiante(
        //                 gestorEstudiantes.buscarEstudiantePorCi(carnet),
        //                 gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
        //         break;
        //     default:

        //         break;
        // }
        mostrarGestionLicencias();
    }

}
