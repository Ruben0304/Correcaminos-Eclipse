package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import views.admin.DepartamentosModelo;
import views.modelos.DepartamentoVerificadorLibrosTableModel;

public class Biblioteca extends DepartamentosModelo {

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
					Biblioteca frame = new Biblioteca();
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
	public Biblioteca() {
		super("Biblioteca");
		this.tableModel = new DepartamentoVerificadorLibrosTableModel();
		this.table.setModel(tableModel);
	}

}
