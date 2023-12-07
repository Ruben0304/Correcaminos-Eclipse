package interfaz_grafica.modelos_tablas;

import javax.swing.table.DefaultTableModel;

public class DepartamentoSegInformaticaTableModel extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;
	
	public DepartamentoSegInformaticaTableModel(){
		String[] columnNames = {
				"Carnet de Identidad","Nombre", "Apellidos", "Nombre Usuario"};
		this.setColumnIdentifiers(columnNames);
	}
}
