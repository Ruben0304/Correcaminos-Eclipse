package controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import auth.Auth;
import models.departamentos.Biblioteca;
import models.departamentos.Economia;
import models.gestion.GestorDepartamentos;
import models.gestion.Correcaminos;
import models.gestion.empleados.GestorEmpleados;
import models.gestion.estudiantes.Secretaria;

import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Admin;
import models.usuarios.Becado;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.Persona;

import util.BooleanosEstudianteBaja;
import util.BooleanosEstudianteBecadoBaja;
import util.Colores;
import util.ResponsabilidadesTrabajador;
import util.TiposResponsabilidad;
import views.Inicio;
import views.Reportes;
import views.TramitesEmpleados;
import views.admin.DepartamentosModelo;
import views.auth.CuentaJP;
import views.chat.ChatPanel;

import views.client.InicioEmpleadoJP;
import views.client.InicioEstudianteJP;
import views.client.RequisitosEmpleados;
import views.client.RequisitosEstudiante;
import views.client.SolicitudesEmpleados;
import views.client.SolicitudesEstudiantes;

import views.layouts.Pricipal;

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
            instancia.setVista(Inicio.getVista().getPanel_lateral());
        }

        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();

    }

    public static void mostrarRequisitosBajaEstudiantes() {

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
        
        Pricipal instancia = Pricipal.getInstancia();

        instancia.setVista(RequisitosEstudiante.getVista(requisitos)
                .getPanel_RequisitosEstud());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();

    }
    
    public static void mostrarRequisitosEmpleados() {

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
        
        Pricipal instancia = Pricipal.getInstancia();

        instancia.setVista(RequisitosEmpleados.getVista(requisitos)
                .getPanel_RequisitosEmpleados());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();

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
        if (Auth.usuarioAutenticado() instanceof Estudiante) {
            if (Secretaria.gestorEstudiantes().getGestorSolicitudes()
                    .verificarEstudianteSolicitaAlgo((Estudiante) Auth.usuarioAutenticado())) {
                mostrarRequisitosBajaEstudiantes();
                ;
            } else {
                instancia.setVista(new SolicitudesEstudiantes());
            }
        } else if (Auth.usuarioAutenticado() instanceof Empleado) {
            if (GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados()
                    .verificarEmpleadoSolicitaAlgo((Empleado) Auth.usuarioAutenticado())) {
                // mostrarRequisitosBajaEmpleado();
            }
            instancia.setVista(new SolicitudesEmpleados());
        } else if (Auth.usuarioAutenticado() instanceof Admin) {
            instancia.setVista(new DepartamentosModelo());
        }

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
