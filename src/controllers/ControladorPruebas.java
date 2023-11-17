package controllers;

import views.Inicio;
import views.Pricipal;
import views.SolicitudBajaEmpleado;
import views.auth.Entrar;
import views.usuarios.RequisitosEstudiante;

public class ControladorPruebas {
    public static void mostrarLogin (){
        Pricipal instancia = Pricipal.getInstancia();
        instancia.setVista(Entrar.getVista().getPanel());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();
    }

     public static void mostrarRequisitosEstudiantes (){
        Pricipal instancia = Pricipal.getInstancia();
        instancia.setVista(RequisitosEstudiante.getVista().getPanel_RequisitosEstud());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();
    }

    public static void mostrarInicio (){
        Pricipal instancia = Pricipal.getInstancia();
        instancia.setVista(Inicio.getVista().getPanel_lateral());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();
    }
    
    public static void mostrarBajaEmpleados (){
        Pricipal instancia = Pricipal.getInstancia();
        instancia.setVista(SolicitudBajaEmpleado.getVista().getPanel());
        Pricipal.getInstancia().revalidate();
        Pricipal.getInstancia().repaint();
    }
}
