package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaz_grafica.modelos_tablas.SecretariaTableModel;;

public class Secretaria extends DepartamentosModel {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Secretaria frame = new Secretaria();
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
	public Secretaria() {
		super("Secretaría");
		this.tableModel = new SecretariaTableModel();
		this.table.setModel(tableModel);
		this.mnReportes.setVisible(true);
	}
}
