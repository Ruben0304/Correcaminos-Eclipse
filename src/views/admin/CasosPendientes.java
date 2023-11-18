package views.admin;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
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
    
    public CasosPendientes (ArrayList<Estudiante> usuariosPendientes) {
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
			table.setFillsViewportHeight(true);
			table.setForeground(Color.WHITE);
			table.setBorder(new LineBorder(new Color(255, 255, 255), 9, true));

			
			Object[][] data = new Object[usuariosPendientes.size() + 1][3];
			int i = 1;
			data[0][0] = "Carnet";
			data[0][1] = "Nombre";
			data[0][2] = "Apellidos";
			for (Persona p : usuariosPendientes) {

				data[i][0] = p.getCi();
				data[i][1] = p.getNombre();
				data[i][2] = p.getApellidos();
				i++;
			}

			table.setModel(new DefaultTableModel(
					new Object[][] {
							{ null, null, null },
					},
					new String[] {
							"Carnet", "Nombre", "Apellidos"
					}));
			table.setBounds(112, 33, 587, 476);

		}
		return table;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.setBounds(826, 593, 97, 25);
		}
		return btnNewButton;
	}
}
