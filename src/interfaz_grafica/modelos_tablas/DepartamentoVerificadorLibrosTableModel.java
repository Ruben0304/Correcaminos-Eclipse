package interfaz_grafica.modelos_tablas;

import javax.swing.table.DefaultTableModel;

public class DepartamentoVerificadorLibrosTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	
	public DepartamentoVerificadorLibrosTableModel(){
		String[] columnNames = {
				"Carnet de Identidad","Nombre", "Apellidos", "Libros Pendientes"};
		this.setColumnIdentifiers(columnNames);
	}
}
