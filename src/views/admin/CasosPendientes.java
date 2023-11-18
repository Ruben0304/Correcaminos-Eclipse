package views.admin;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import models.usuarios.Estudiante;
import models.usuarios.Persona;
import views.components.Navegacion;

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
			panel_2.add(getLblCasosPendientes());
			panel_2.add(getTable());
			panel_2.add(getBtnNewButton());
		}
		return panel_2;
	}

	private JLabel getLblCasosPendientes() {
		if (lblCasosPendientes == null) {
			lblCasosPendientes = new JLabel("Casos pendientes");
			lblCasosPendientes.setForeground(Color.WHITE);
			lblCasosPendientes.setFont(new Font("Segoe UI Semibold", Font.BOLD, 40));
			lblCasosPendientes.setBounds(357, 55, 333, 54);
		}
		return lblCasosPendientes;
	}



	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			// table.setFillsViewportHeight(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// scrollPane.setViewportView(table);
			table.setModel(new PendientesEstudiantes(usuariosPendientes));
			table.setBounds(112, 33, 587, 476);

		}
		return table;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Confirmar entrega");
			btnNewButton.setBounds(826, 593, 97, 25);

			public void actionPerformed(ActionEvent e) {

                int selectedRow = table_2.getSelectedRow();
                if (selectedRow != -1) {
                    String carnet = table_2.getValueAt(selectedRow, 0).toString();
                    Biblioteca.quitarLibrosPrestados(
                            ((Estudiante) GestorPrincipal.buscarPersonaEnLista(carnet, usuariosPendientes)));

                    ControladorAdmin.mostrarGestionLicencias();
                    dispose();
                    // DefaultTableModel modelo = (DefaultTableModel) table_2.getModel();

                    // modelo.fireTableDataChanged();

                }

            }
		}
		return btnNewButton;
	}
}
