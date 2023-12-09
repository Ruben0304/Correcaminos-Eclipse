package vistas.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorAdmin;
import modelos.admin.Biblioteca;
import modelos.gestion.Correcaminos;
import modelos.usuarios.Estudiante;
import modelos.usuarios.Persona;
import vistas.componentes.Navegacion;

public class CasosPendientes {

	private JPanel panel_2;
	private JLabel lblCasosPendientes;
	private JTable table;
	private JButton btnNewButton;
	private ArrayList<Estudiante> usuariosPendientes;

	public CasosPendientes(ArrayList<Estudiante> usuariosPendientes) {
		this.usuariosPendientes = usuariosPendientes;
	}

	public JPanel getPanelCasosPendientes() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(71, 0, 1051, 700);
			panel_2.setBackground(new Color(31, 33, 36));
			panel_2.setLayout(null);
			
			panel_2.add(getTable());
			panel_2.add(getBtnNewButton());
		}
		return panel_2;
	}

	

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			// table.setFillsViewportHeight(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			table.setBounds(112, 33, 587, 476);

		}
		return table;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Confirmar entrega");
			btnNewButton.setBounds(826, 593, 97, 25);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int selectedRow = getTable().getSelectedRow();
					if (selectedRow != -1) {
						String carnet = getTable().getValueAt(selectedRow, 0).toString();
						ControladorAdmin.confirmarEntrega(carnet);
						
						// DefaultTableModel modelo = (DefaultTableModel) table_2.getModel();

						// modelo.fireTableDataChanged();

					}

				}
			});
		}
		return btnNewButton;
	}
}
