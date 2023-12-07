package interfaz_grafica;

import java.awt.EventQueue;

import interfaz_grafica.modelos_tablas.DepartamentoVerificadorLibrosTableModel;

public class AlmacenDeLibros extends DepartamentosModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlmacenDeLibros frame = new AlmacenDeLibros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AlmacenDeLibros() {
		super("Almacén de Libros");
		this.tableModel = new DepartamentoVerificadorLibrosTableModel();
		this.table.setModel(tableModel);
	}

}
