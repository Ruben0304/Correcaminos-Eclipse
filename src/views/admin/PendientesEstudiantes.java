package views.admin;

import javax.swing.table.DefaultTableModel;
import util.Facultad;
import models.usuarios.Estudiante;
import java.util.Vector;




public class PendientesEstudiantes extends DefaultTableModel {
	
	

		private static final long serialVersionUID = 1L;

		public PendientesEstudiantes(){
			String[] columnNames = {
					"Nombre", "Primer Apellido", "Segundo Apellido", "Facultad"};
			this.setColumnIdentifiers(columnNames);
		}
		
		public PendientesEstudiantes(Estudiante [] estudiantes){
			String[] columnNames = {
					"Nombre", "Primer Apellido", "Segundo Apellido", "Facultad"};
			this.setColumnIdentifiers(columnNames);
			for (int i = 0; i < estudiantes.length; i++) {
				Object[] newRow = new Object[]{estudiantes[i].getNombre(), estudiantes[i].getPrimer_apellido(), estudiantes[i].getSegundo_apellido(), estudiantes[i].getFacultad()};
				addRow(newRow);
			}
		}
		
		public void adicionar(String Nombre, String PrimerApellido ,String SegundoApellido, Facultad Facultad){
			Object[] newRow = new Object[]{Nombre, PrimerApellido, SegundoApellido, Facultad};
			addRow(newRow);
		}
		
		public void eliminar(int pos){
			removeRow(pos);
		}

		@SuppressWarnings("unchecked")
		public void modificar(int pos,String Nombre, String PrimerApellido ,String SegundoApellido, Facultad Facultad){
			Object[] newRow = new Object[]{Nombre, PrimerApellido, SegundoApellido, Facultad};
			
			setValueAt(Nombre, pos, 0);
			setValueAt(PrimerApellido, pos, 1);
			setValueAt(SegundoApellido, pos, 2);
			setValueAt(Facultad, pos, 3);
					
		}
	}
