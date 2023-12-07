package interfaz_grafica.modelos_tablas;

import javax.swing.table.DefaultTableModel;

public class SecretariaTableModel extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;
	
	public SecretariaTableModel(){
		String[] columnNames = {
				"Año Escolar","Carnet de Identidad","Nombre", "Apellidos","Requisitos"};
		this.setColumnIdentifiers(columnNames);
	}
}
