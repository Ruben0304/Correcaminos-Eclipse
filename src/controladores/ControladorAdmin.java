package controladores;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import autenticacion.Auth;
import interfaces.Autenticable;
import modelos.gestion.Correcaminos;
import modelos.gestion.GestorDepartamentos;
import modelos.gestion.empleados.GestorEmpleados;
import modelos.gestion.empleados.GestorSolicitudesEmpleados;
import modelos.gestion.estudiantes.GestorSolicitudesEstudiante;
import modelos.gestion.estudiantes.Secretaria;

import modelos.usuarios.Admin;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;
import modelos.usuarios.Persona;
import util.TipoDepartamento;
import util.modelos.DepartamentoVerificadorLibrosTableModel;
import vistas.admin.CasosPendientes;
import vistas.admin.DepartamentosModelo;
import vistas.admin.PanelAdministracion;
import vistas.template.Pricipal;

public class ControladorAdmin {

    public static void mostrarPanelAdmin() {
        Pricipal instancia = Pricipal.getInstancia();
        instancia.setVista(PanelAdministracion.getPanelAdministracion());
    }

    public static void verDeudas(String carnet) {
        Pricipal instancia = Pricipal.getInstancia();
        Set<String> deudas = new TreeSet<>();
        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();
        

        switch (((Admin) Auth.usuarioAutenticado()).getTipoDepartamento()) {

            case Biblioteca:
                deudas = gestDep.getBiblioteca().obtenerDeudas(carnet);
                break;

            case AlmacenLibrosDocentes:
                deudas = gestDep.getAlmacenDeLibros().obtenerDeudas(carnet);
                break;

            case DireccionBecas:
                deudas = gestDep.getAlmacenDeLibros().obtenerDeudas(carnet);
                break;
            case Contabilidad:
                JOptionPane.showMessageDialog(null, gestDep.getContabilidad().obtenerDeudaEmpleado(carnet),
                        "Total",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            default:

                break;
        }
        if (!((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.Contabilidad)) {
            instancia.setVista(
                    new DepartamentosModelo(
                            new DepartamentoVerificadorLibrosTableModel(deudas)));
            Pricipal.getInstancia().revalidate();
            Pricipal.getInstancia().repaint();
        }

    }

    public static void mostrarGestionLicencias() {
        Pricipal instancia = Pricipal.getInstancia();
        ArrayList<Persona> usuariosPendientes = obtenerCasosPendientesDepartamento();
        // switch (((Admin) Auth.usuarioAutenticado()).getTipoDepartamento()) {

        // case Biblioteca:
        // instancia
        // break;

        // case AlmacenLibrosDocentes:
        // instancia.setVista(
        // new DepartamentosModelo(
        // new DepartamentoVerificadorLibrosTableModel(usuariosPendientes, "Libros
        // Pendientes")));
        // break;

        // case DireccionBecas:
        // instancia.setVista(
        // new DepartamentosModelo(
        // new DepartamentoVerificadorLibrosTableModel(usuariosPendientes,
        // "Pertenencias")));
        // break;

        // default:

        // break;
        // }
        instancia.setVista(
                new DepartamentosModelo(new DepartamentoVerificadorLibrosTableModel(usuariosPendientes)));
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();
    }

    public static ArrayList<Persona> obtenerCasosPendientesDepartamento() {

        ArrayList<Persona> usuariosPendientes = new ArrayList<>();
        Autenticable usuarioAutenticado = Auth.usuarioAutenticado();
        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();
        ArrayList<Estudiante> estudiantes = Secretaria.gestorEstudiantes().getGestorSolicitudes()
                .obtenerEstudiantesPendientes();
        ArrayList<Empleado> empleados = GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados()
                .obtenerEstudiantesPendientes();

        switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
                usuariosPendientes.addAll(gestDep.getBiblioteca().getEstudiantesPendientes(estudiantes));
                usuariosPendientes.addAll(gestDep.getBiblioteca().getEmpleadosPendientes(empleados));

                break;

            case Secretaria:

                usuariosPendientes.addAll(estudiantes);

                break;
            case AlmacenLibrosDocentes:
                usuariosPendientes
                        .addAll(gestDep.getAlmacenDeLibros().getEstudiantesPendientes(estudiantes));

                break;

            case Economia:
                usuariosPendientes.addAll(gestDep.getEconomia().getEstudiantesPendientes(
                        estudiantes));

                break;

            case SeguridadInformatica:
                usuariosPendientes
                        .addAll(gestDep.getSeguridadInformatica().getEstudiantesPendientes(
                                estudiantes));

                usuariosPendientes
                        .addAll(gestDep.getSeguridadInformatica().getEmpleadosPendientes(
                                empleados));

                break;

            case DireccionBecas:
                usuariosPendientes
                        .addAll(gestDep.getDireccionDeBecas().getEstudiantesPendientes(
                                estudiantes));

                break;

            default:
                break;
        }

        return usuariosPendientes;
    }

    public static void confirmarEntrega(String carnet) {
        Admin usuarioAutenticado = (Admin) Auth.usuarioAutenticado();
        GestorDepartamentos gestorDepartamentos = GestorDepartamentos.gestorDepartamentos();

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
