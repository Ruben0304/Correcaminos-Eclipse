package controladores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import autenticacion.Auth;
import interfaces.Autenticable;
import modelos.admin.SeguridadInformatica;
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
                            new DepartamentoVerificadorLibrosTableModel(deudas, carnet)));

            Pricipal.getInstancia().revalidate();
            Pricipal.getInstancia().repaint();
        }

    }

    public static void mostrarGestionLicencias() {
        Pricipal instancia = Pricipal.getInstancia();
        ArrayList<Persona> usuariosPendientes = obtenerCasosPendientesDepartamento();
        if (((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.Secretaria)) {
            instancia.setVista(
                    new DepartamentosModelo(new DepartamentoVerificadorLibrosTableModel(usuariosPendientes)));
        } else if (((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.RecursosHumanos)) {

        } else {
            instancia.setVista(
                    new DepartamentosModelo(new DepartamentoVerificadorLibrosTableModel(usuariosPendientes)));
        }

        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();
    }

    public static void entregarDeuda(Set<String> deudas, String carnet) {
        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();
        switch (((Admin) Auth.usuarioAutenticado()).getTipoDepartamento()) {

            case Biblioteca:
                gestDep.getBiblioteca().recogerDeudas(carnet, deudas);
                if (gestDep.getBiblioteca().obtenerDeudas(carnet).size() == 0) {
                    confirmarEntrega(carnet);
                } else {
                    verDeudas(carnet);
                }
                break;

            case AlmacenLibrosDocentes:
                gestDep.getAlmacenDeLibros().recogerDeudas(carnet, deudas);
                if (gestDep.getAlmacenDeLibros().obtenerDeudas(carnet).size() == 0) {
                    confirmarEntrega(carnet);
                } else {
                    verDeudas(carnet);
                }

                break;

            case DireccionBecas:
                gestDep.getDireccionDeBecas().recogerDeudas(carnet, deudas);
                if (gestDep.getDireccionDeBecas().obtenerDeudas(carnet).size() == 0) {
                    confirmarEntrega(carnet);
                } else {
                    verDeudas(carnet);
                }
                break;
            case Contabilidad:
                confirmarEntrega(carnet);
                break;

            default:

                break;
        }

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

        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();
        switch (((Admin) Auth.usuarioAutenticado()).getTipoDepartamento()) {

            case Biblioteca:
                gestDep.getBiblioteca().confirmarEntrega(carnet);
                break;
            case Secretaria:
                Secretaria.gestorEstudiantes().getGestorSolicitudes().aceptarSolicitud(carnet);
                break;

            case AlmacenLibrosDocentes:
                gestDep.getAlmacenDeLibros().confirmarEntrega(carnet);
                ;
                break;

            case DireccionBecas:
                gestDep.getDireccionDeBecas().confirmarEntrega(carnet);
                ;
                break;
            case Contabilidad:
                gestDep.getContabilidad().saldarDeuda(carnet);
                break;
            case Economia:
                gestDep.getEconomia().cancelarPagoEstipendio(carnet);
                break;
            case SeguridadInformatica:
                gestDep.getSeguridadInformatica().cerrarCuenta(carnet);
                break;
            case RecursosHumanos:
                gestDep.getRecursosHumanos().confirmarEntrega(carnet);
                GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados().aceptarSolicitud(carnet);
                break;
            default:

                break;
        }

        mostrarGestionLicencias();
    }

}
