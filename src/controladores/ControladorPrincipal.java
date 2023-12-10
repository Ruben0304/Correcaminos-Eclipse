package controladores;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import autenticacion.Auth;
import modelos.admin.Biblioteca;
import modelos.admin.Economia;
import modelos.gestion.Correcaminos;
import modelos.gestion.GestorDepartamentos;
import modelos.gestion.empleados.GestorEmpleados;
import modelos.gestion.estudiantes.GestorSolicitudesEstudiante;
import modelos.gestion.estudiantes.Secretaria;

import modelos.usuarios.Admin;
import modelos.usuarios.Becado;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;
import modelos.usuarios.Persona;


import util.Colores;
import util.ResponsabilidadesTrabajador;
import util.TiposResponsabilidad;

import vistas.admin.DepartamentosModelo;
import vistas.autenticacion.CuentaJP;

import vistas.componentes.Navegacion;
import vistas.template.Pricipal;
import vistas.admin.InicioAdmin;
import vistas.usuarios.InicioEmpleadoJP;
import vistas.usuarios.InicioEstudianteJP;
import vistas.usuarios.RequisitosEmpleados;
import vistas.usuarios.RequisitosEstudiante;
import vistas.usuarios.SolicitudesEmpleados;
import vistas.usuarios.SolicitudesEstudiantes;

public class ControladorPrincipal {

    public static void mostrarInicio() {

        Pricipal instancia = Pricipal.getInstancia();

        instancia.setVisible(true);
        // boolean estudianteSolicitaLicencia = false;
        if (Auth.usuarioAutenticado() instanceof Estudiante) {
            // estudianteSolicitaLicencia =
            // Correcaminos.getGestorPrincipal().getGestorEstudiantes()
            // .getGestorSolicitudes()
            // .verificarEstudianteSolicitaAlgo((Estudiante) Auth.usuarioAutenticado());

            // Inicios inicio = new Inicios(Auth.usuarioAutenticado(),
            // estudianteSolicitaLicencia);
            // inicio.setVisible(true);
            instancia.setVista(new InicioEstudianteJP());

        } else if (Auth.usuarioAutenticado() instanceof Empleado) {
            instancia.setVista(new InicioEmpleadoJP());
        } else {
            instancia.setVista(new InicioAdmin());
        }

        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();

    }

    public static HashMap<TiposResponsabilidad, Boolean> obtenerRequisitosEstudiante() {

        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();

        HashMap<TiposResponsabilidad, Boolean> requisitos = new HashMap<>();
        Estudiante autenticado = (Estudiante) Auth.usuarioAutenticado();

        requisitos.put(TiposResponsabilidad.LIBROS_BIBLIOTECA,
                gestDep.getBiblioteca().verificarRequisitos(autenticado));
        requisitos.put(TiposResponsabilidad.ESTIPENDIO, gestDep.getEconomia().verificarRequisitos(autenticado));
        requisitos.put(TiposResponsabilidad.LIBROS_DOCENTES,
                gestDep.getAlmacenDeLibros().verificarRequisitos(autenticado));
        requisitos.put(TiposResponsabilidad.CUENTA_USUARIO,
                gestDep.getSeguridadInformatica().verificarRequisitos(autenticado));

        if (autenticado instanceof Becado) {

            requisitos.put(TiposResponsabilidad.PERTENENCIAS_BECA,
                    gestDep.getDireccionDeBecas().verificarRequisitos(autenticado));

        }
        return requisitos;
    }

    public static HashMap<TiposResponsabilidad, Boolean> obtenerRequisitosEstudiante(Estudiante e) {

        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();

        HashMap<TiposResponsabilidad, Boolean> requisitos = new HashMap<>();

        requisitos.put(TiposResponsabilidad.LIBROS_BIBLIOTECA,
                gestDep.getBiblioteca().verificarRequisitos(e));
        requisitos.put(TiposResponsabilidad.ESTIPENDIO, gestDep.getEconomia().verificarRequisitos(e));
        requisitos.put(TiposResponsabilidad.LIBROS_DOCENTES,
                gestDep.getAlmacenDeLibros().verificarRequisitos(e));
        requisitos.put(TiposResponsabilidad.CUENTA_USUARIO,
                gestDep.getSeguridadInformatica().verificarRequisitos(e));

        if (e instanceof Becado) {

            requisitos.put(TiposResponsabilidad.PERTENENCIAS_BECA,
                    gestDep.getDireccionDeBecas().verificarRequisitos(e));

        }
        return requisitos;
    }

    public static int cantidadDeRequisitosEstudiante() {
        int contador = 0;
        for (Map.Entry<TiposResponsabilidad, Boolean> entrada : obtenerRequisitosEstudiante().entrySet()) {
            if (entrada.getValue()) {
                contador++;
            }
        }
        return contador;
    }

    public static int cantidadDeRequisitosEmpleado() {
        int contador = 0;
        for (Map.Entry<ResponsabilidadesTrabajador, Boolean> entrada : obtenerRequisitosEmpleado().entrySet()) {
            if (entrada.getValue()) {
                contador++;
            }
        }
        return contador;
    }

    public static int cantidadDeRequisitosEstudiante(String s) {
        int contador = 0;

        for (Estudiante e : Secretaria.gestorEstudiantes().getGestorSolicitudes().obtenerEstudiantesPendientes()) {
            if (e.getCi().equals(s)) {
                for (Map.Entry<TiposResponsabilidad, Boolean> entrada : obtenerRequisitosEstudiante(e).entrySet()) {
                    if (entrada.getValue()) {
                        contador++;
                    }
                }
            }
        }

        return contador;
    }

    public static int cantidadDeRequisitosEmpleado(String s) {
        int contador = 0;
        for (Empleado e : GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados()
                .obtenerEstudiantesPendientes()) {
            if (e.getCi().equals(s)) {
                for (Map.Entry<ResponsabilidadesTrabajador, Boolean> entrada : obtenerRequisitosEmpleado(e)
                        .entrySet()) {
                    if (entrada.getValue()) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    public static HashMap<ResponsabilidadesTrabajador, Boolean> obtenerRequisitosEmpleado() {

        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();

        HashMap<ResponsabilidadesTrabajador, Boolean> requisitos = new HashMap<>();
        Empleado autenticado = (Empleado) Auth.usuarioAutenticado();

        requisitos.put(ResponsabilidadesTrabajador.LIBROS_BIBLIOTECA,
                gestDep.getBiblioteca().verificarRequisitos(autenticado));
        requisitos.put(ResponsabilidadesTrabajador.DEUDA, gestDep.getContabilidad().verificarRequisitos(autenticado));
        requisitos.put(ResponsabilidadesTrabajador.SALARIO_INDEBIDO,
                gestDep.getRecursosHumanos().verificarRequisitos(autenticado));
        requisitos.put(ResponsabilidadesTrabajador.CUENTA_USUARIO,
                gestDep.getSeguridadInformatica().verificarRequisitos(autenticado));

        return requisitos;
    }

    public static HashMap<ResponsabilidadesTrabajador, Boolean> obtenerRequisitosEmpleado(Empleado e) {

        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();

        HashMap<ResponsabilidadesTrabajador, Boolean> requisitos = new HashMap<>();

        requisitos.put(ResponsabilidadesTrabajador.LIBROS_BIBLIOTECA,
                gestDep.getBiblioteca().verificarRequisitos(e));
        requisitos.put(ResponsabilidadesTrabajador.DEUDA, gestDep.getContabilidad().verificarRequisitos(e));
        requisitos.put(ResponsabilidadesTrabajador.SALARIO_INDEBIDO,
                gestDep.getRecursosHumanos().verificarRequisitos(e));
        requisitos.put(ResponsabilidadesTrabajador.CUENTA_USUARIO,
                gestDep.getSeguridadInformatica().verificarRequisitos(e));

        return requisitos;
    }

    public static void mostrarRequisitosBajaEstudiantes() {

        Pricipal instancia = Pricipal.getInstancia();
        Navegacion.getInstancia().getLabel_3().setVisible(true);
        Navegacion.getInstancia().getLabel_4().setVisible(true);
        Navegacion.getInstancia().revalidate();
        Navegacion.getInstancia().repaint();
        instancia.setVista(RequisitosEstudiante.getVista(obtenerRequisitosEstudiante())
                .getPanel_RequisitosEstud());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();

    }

    public static void mostrarRequisitosEmpleados() {

        Pricipal instancia = Pricipal.getInstancia();
        if (GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados()
                .verificarEmpleadoSolicitaLicencia((Empleado) Auth.usuarioAutenticado())) {
            JOptionPane.showMessageDialog(null, "Su solicitud está siendo procesada", "Estado de Trámite",
                    JOptionPane.INFORMATION_MESSAGE);
            ControladorPrincipal.mostrarInicio();
        } else {

            Navegacion.getInstancia().getLabel_3().setVisible(true);
            Navegacion.getInstancia().getLabel_4().setVisible(true);
            Navegacion.getInstancia().revalidate();
            Navegacion.getInstancia().repaint();
            instancia.setVista(RequisitosEmpleados.getVista(obtenerRequisitosEmpleado())
                    .getPanel_RequisitosEmpleados());
            Pricipal.getInstancia().revalidate();
            Pricipal.getInstancia().repaint();

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
                // Pricipal.getInstancia().setVista(new ChatPanel());
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

    public static void mostrarTramites() {
        Pricipal instancia = Pricipal.getInstancia();

        if (Auth.usuarioAutenticado() instanceof Estudiante) {
            if (Secretaria.gestorEstudiantes().getGestorSolicitudes()
                    .verificarEstudianteSolicitaAlgo((Estudiante) Auth.usuarioAutenticado())) {
                if (cantidadDeRequisitosEstudiante() == 0 && Secretaria.gestorEstudiantes()
                        .buscarEstudiantePorCi(((Estudiante) Auth.usuarioAutenticado()).getCi()) == null) {
                    JOptionPane.showMessageDialog(null, "Su solicitud está siendo procesada", "Estado de Trámite",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    mostrarRequisitosBajaEstudiantes();
                }

            } else {
                instancia.setVista(new SolicitudesEstudiantes());
            }
        } else if (Auth.usuarioAutenticado() instanceof Empleado) {
            if (GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados()
                    .verificarEmpleadoSolicitaAlgo((Empleado) Auth.usuarioAutenticado())) {
                if (cantidadDeRequisitosEstudiante() == 0 && GestorEmpleados.gestorEmpleados()
                        .buscarEmpleadoPorCi(((Empleado) Auth.usuarioAutenticado()).getCi()) == null) {
                    JOptionPane.showMessageDialog(null, "Su solicitud está siendo procesada", "Estado de Trámite",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    mostrarRequisitosEmpleados();
                }

            } else {
                instancia.setVista(new SolicitudesEmpleados());
            }
        } else if (Auth.usuarioAutenticado() instanceof Admin) {
            ControladorAdmin.mostrarGestionLicencias();
        }

        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();
    }

    public static boolean verificarPersonaSolicitaAlgo() {

        return (Auth.usuarioAutenticado() instanceof Estudiante && Secretaria.gestorEstudiantes().getGestorSolicitudes()
                .verificarEstudianteSolicitaAlgo((Estudiante) Auth.usuarioAutenticado()))
                || (Auth.usuarioAutenticado() instanceof Empleado
                        && GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados()
                                .verificarEmpleadoSolicitaAlgo((Empleado) Auth.usuarioAutenticado()));
    }

}
