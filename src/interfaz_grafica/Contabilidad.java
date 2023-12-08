package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaz_grafica.modelos_tablas.DepartamentoContabilidadTableModel;
import views.admin.DepartamentosModelo;

public class Contabilidad extends DepartamentosModelo {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contabilidad frame = new Contabilidad();
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
	public Contabilidad() {
		super("Contabilidad");
		this.tableModel = new DepartamentoContabilidadTableModel();
		this.table.setModel(tableModel);
	}

}
