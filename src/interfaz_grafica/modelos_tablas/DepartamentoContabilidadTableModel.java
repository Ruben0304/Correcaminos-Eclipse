package interfaz_grafica.modelos_tablas;

import javax.swing.table.DefaultTableModel;

public class DepartamentoContabilidadTableModel extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;
	
	public DepartamentoContabilidadTableModel(){
		String[] columnNames = {
				"No.Trabajador","Carnet de Identidad","Nombre", "Apellidos", "Deuda"};
		this.setColumnIdentifiers(columnNames);
	}
}
