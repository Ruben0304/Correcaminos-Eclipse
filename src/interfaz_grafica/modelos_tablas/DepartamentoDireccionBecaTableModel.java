package interfaz_grafica.modelos_tablas;

import javax.swing.table.DefaultTableModel;

public class DepartamentoDireccionBecaTableModel extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;
	
	public DepartamentoDireccionBecaTableModel(){
		String[] columnNames = {
				"Carnet de Identidad","Nombre", "Apellidos", "Pertenencias"};
		this.setColumnIdentifiers(columnNames);
	}
}
