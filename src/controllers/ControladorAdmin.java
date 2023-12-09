package controllers;

import java.util.ArrayList;

import auth.Auth;
import interfaces.Autenticable;
import models.gestion.GestorDepartamentos;
import models.gestion.empleados.GestorEmpleados;
import models.gestion.empleados.GestorSolicitudesEmpleados;
import models.gestion.Correcaminos;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.gestion.estudiantes.Secretaria;

import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Admin;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import views.admin.CasosPendientes;
import views.admin.DepartamentosModelo;
import views.admin.PanelAdministracion;
import views.layouts.Pricipal;
import views.modelos.DepartamentoVerificadorLibrosTableModel;

public class ControladorAdmin {

    public static void mostrarPanelAdmin() {
        Pricipal instancia = Pricipal.getInstancia();
        instancia.setVista(PanelAdministracion.getPanelAdministracion());
    }

    public static void mostrarGestionLicencias() {
        ArrayList<Persona> usuariosPendientes = new ArrayList<>();
        Autenticable usuarioAutenticado = Auth.usuarioAutenticado();
        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();
        ArrayList<Estudiante> estudiantes = Secretaria.gestorEstudiantes().getGestorSolicitudes()
                .obtenerEstudiantesPendientes();
        ArrayList<Empleado> empleados = GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados()
                .obtenerEstudiantesPendientes();

        Pricipal instancia = Pricipal.getInstancia();

        switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
                usuariosPendientes.addAll(gestDep.getBiblioteca().getEstudiantesPendientes(estudiantes));
                usuariosPendientes.addAll(gestDep.getBiblioteca().getEmpleadosPendientes(empleados));
                instancia.setVista(
                        new DepartamentosModelo(
                                new DepartamentoVerificadorLibrosTableModel(usuariosPendientes, "Libros Pendientes")));
                break;

            case Secretaria:

                usuariosPendientes.addAll(estudiantes);
                instancia.setVista(
                        new DepartamentosModelo(new DepartamentoVerificadorLibrosTableModel(usuariosPendientes)));
                break;
            case AlmacenLibrosDocentes:
                usuariosPendientes
                        .addAll(gestDep.getAlmacenDeLibros().getEstudiantesPendientes(estudiantes));
                instancia.setVista(
                        new DepartamentosModelo(
                                new DepartamentoVerificadorLibrosTableModel(usuariosPendientes, "Libros Pendientes")));

                break;

            case Economia:
                usuariosPendientes.addAll(gestDep.getEconomia().getEstudiantesPendientes(
                        estudiantes));
                instancia.setVista(
                        new DepartamentosModelo(new DepartamentoVerificadorLibrosTableModel(usuariosPendientes)));
                break;

            case SeguridadInformatica:
                usuariosPendientes
                        .addAll(gestDep.getSeguridadInformatica().getEstudiantesPendientes(
                                estudiantes));

                usuariosPendientes
                        .addAll(gestDep.getSeguridadInformatica().getEmpleadosPendientes(
                                empleados));
                instancia.setVista(
                        new DepartamentosModelo(new DepartamentoVerificadorLibrosTableModel(usuariosPendientes)));

                break;

            case DireccionBecas:
                usuariosPendientes
                        .addAll(gestDep.getDireccionDeBecas().getEstudiantesPendientes(
                                estudiantes));

                instancia.setVista(
                new DepartamentosModelo(
                        new DepartamentoVerificadorLibrosTableModel(usuariosPendientes, "Pertenencias")));
                
                break;

            default:
                break;
        }

        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();
    }

    public static void confirmarEntrega(String carnet) {
        Admin usuarioAutenticado = (Admin) Auth.usuarioAutenticado();
        GestorDepartamentos gestorDepartamentos = GestorDepartamentos.gestorDepartamentos();
        GestorResponsabilidadesEstudiantes gestorResponsabilidadesEstudiantes = Secretaria.gestorEstudiantes()
                .getGestorResponsabilidadesEstudiantes();
        Secretaria gestorEstudiantes = Secretaria.gestorEstudiantes();

        // switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
        // case Biblioteca:
        // gestorDepartamentos.getBiblioteca().recogerLibrosPrestados(
        // gestorEstudiantes.buscarEstudiantePorCi(carnet),
        // gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());

        // break;
        // case Secretaria:
        // gestorDepartamentos.getSecretaria().devolverCarnetCujae(gestorEstudiantes.buscarEstudiantePorCi(carnet),
        // gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
        // break;
        // case AlmacenLibrosDocentes:
        // gestorDepartamentos.getAlmacenDeLibros().recogerLibrosDocentes(
        // gestorEstudiantes.buscarEstudiantePorCi(carnet),
        // gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
        // break;

        // case Economia:
        // gestorDepartamentos.getEconomia().confirmarEntregas(gestorEstudiantes.buscarEstudiantePorCi(carnet),
        // gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());

        // break;

        // case SeguridadInformatica:
        // gestorDepartamentos.getSeguridadInformatica().cerrarCuenta(
        // gestorEstudiantes.buscarEstudiantePorCi(carnet),
        // gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
        // break;

        // case DireccionBecas:
        // gestorDepartamentos.getDireccionDeBecas().recogerPertenenciasDeEstudiante(
        // gestorEstudiantes.buscarEstudiantePorCi(carnet),
        // gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
        // break;
        // default:

        // break;
        // }
        mostrarGestionLicencias();
    }

}
