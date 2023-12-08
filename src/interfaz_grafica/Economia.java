package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import interfaz_grafica.modelos_tablas.DepartamentoEconomiaTableModel;
import views.admin.DepartamentosModelo;

public class Economia extends DepartamentosModelo {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Economia frame = new Economia();
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
	public Economia() {
		super("Econom�a");
		this.tableModel = new DepartamentoEconomiaTableModel();
		this.table.setModel(tableModel);
		
	}

}
