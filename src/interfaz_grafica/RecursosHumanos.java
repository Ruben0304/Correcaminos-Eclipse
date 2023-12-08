package interfaz_grafica;

import java.awt.EventQueue;
import interfaz_grafica.modelos_tablas.DepartamentoRHTableModel;

public class RecursosHumanos extends DepartamentosModel {

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
					RecursosHumanos frame = new RecursosHumanos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RecursosHumanos() {
		super("Recursos Humanos");
		this.tableModel = new DepartamentoRHTableModel();
		this.table.setModel(tableModel);
		this.mnReportes.setVisible(true);
	}
}
