package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaz_grafica.modelos_tablas.DepartamentoSegInformaticaTableModel;
import views.admin.DepartamentosModelo;

public class SeguridadInformatica extends DepartamentosModelo {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeguridadInformatica frame = new SeguridadInformatica();
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
	public SeguridadInformatica() {
		super("Seguridad Inform�tica");
		lNombreDepartamento.setLocation(10, 6);
		lNombreDepartamento.setSize(185, 25);
		panelNombreDept.setSize(600, 35);
		menuBar.setLocation(0, 35);
		this.tableModel = new DepartamentoSegInformaticaTableModel();
		this.table.setModel(tableModel);
	}

}
