package controllers;

import java.util.ArrayList;

import auth.Auth;
import models.departamentos.Biblioteca;
import models.departamentos.Secretaria;
import models.gestion.GestorDepartamentos;
import models.gestion.GestorPrincipal;
import models.gestion.estudiantes.GestorEstudiantes;
import models.responsabilidades.ResponsabilidadesEstudiantes;
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

        switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
                usuariosPendientes.addAll(gestDep.getBiblioteca().getEstudiantesPendientes(listadoResponsabilidades));

                for (Estudiante usuario : usuariosPendientes) {
                    System.out.println(usuario.getNombre());
                }
                Pricipal instancia = Pricipal.getInstancia();
                instancia.setVista(new CasosPendientes(usuariosPendientes).getPanelCasosPendientes());
                Pricipal.getInstancia().revalidate();
                Pricipal.getInstancia().repaint();

                break;
            case Secretaria:
                // usuariosPendientes.addAll(secretaria.getEstudianteLicenciaPendientes());
                // SecretariaPendientes view = new SecretariaPendientes(usuarioAutenticado,
                // usuariosPendientes);
                // view.setVisible(true);
                // break;
            default:
                break;
        }

    }

}
