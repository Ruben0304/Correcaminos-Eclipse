package interfaz_grafica.modelos_tablas;

import javax.swing.table.DefaultTableModel;

public class DepartamentoRHTableModel extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;
	
	public DepartamentoRHTableModel(){
		String[] columnNames = {
				"No.Trabajador","Carnet de Identidad","Nombre", "Apellidos"};
		this.setColumnIdentifiers(columnNames);
	}
}
