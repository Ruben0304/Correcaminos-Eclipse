package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaz_grafica.modelos_tablas.DepartamentoDireccionBecaTableModel;
import views.admin.DepartamentosModelo;

public class DireccionDeBecas extends DepartamentosModelo {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DireccionDeBecas frame = new DireccionDeBecas();
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
	public DireccionDeBecas() {
		super("Direcci�n de Becas");
		this.tableModel = new DepartamentoDireccionBecaTableModel();
		this.table.setModel(tableModel);
	}

}
