package interfaz_grafica.modelos_tablas;

import javax.swing.table.DefaultTableModel;

public class DepartamentoEconomiaTableModel extends DefaultTableModel {
	
private static final long serialVersionUID = 1L;
	
	public DepartamentoEconomiaTableModel(){
		String[] columnNames = {
				"Año Escolar","Carnet de Identidad","Nombre", "Apellidos"};
		this.setColumnIdentifiers(columnNames);
	}
}
