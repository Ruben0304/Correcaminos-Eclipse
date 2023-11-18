package controllers;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

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
import views.EstudianteTableModel;
import views.Pricipal;
import views.admin.CasosPendientes;
import views.old.SecretariaPendientes;

public class ControladorAdmin {
	private DefaultTableModel tableModel; 
	private JTable table;
	
	
	
    public static void mostrarGestionLicencias() {
        ArrayList<Persona> usuariosPendientes = new ArrayList<>();
        Usuario usuarioAutenticado = Auth.usuarioAutenticado();
        GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();
        ArrayList<ResponsabilidadesEstudiantes> listadoResponsabilidades = GestorEstudiantes.gestorEstudiantes()
                .getGestorResponsabilidadesEstudiantes().getResponsabilidadesEstudiantesPendientes();
                
        switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
                usuariosPendientes.addAll(gestDep.getBiblioteca().getEstudiantesPendientes(listadoResponsabilidades));
                CasosPendientes biblioteca = new CasosPendientes(usuarioAutenticado, usuariosPendientes);
                biblioteca.setVisible(true);
                cargarTablaConEstudiantesPendientes(usuariosPendientes);
                break;
            case Secretaria:
                // usuariosPendientes.addAll(secretaria.getEstudianteLicenciaPendientes());
                // SecretariaPendientes view = new SecretariaPendientes(usuarioAutenticado, usuariosPendientes);
                // view.setVisible(true);
                // break;
            default:
                break;
                
              
        }
        
      

    }
    public void cargarTablaConEstudiantesPendientes(ArrayList<Estudiante> estudiantes){		
    	Estudiante[] valores = new Estudiante[estudiantes.size()];
		int i = 0;
		for (Estudiante c : estudiantes){
			valores[i] = c;	
			i++;
		}
		tableModel = new EstudianteTableModel(valores);
		table.setModel(tableModel);		
	}
    
    private JTable getTable() {
		if (table == null) {
			table = new JTable();
    		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setBounds(879, 37, 40, 37);
					}
		return table;
	}
    
}
