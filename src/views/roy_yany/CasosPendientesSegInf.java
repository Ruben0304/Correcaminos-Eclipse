package views.roy_yany;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class CasosPendientesSegInf extends JPanel {
	
	private JPanel panel;
	private JLabel lblCasosPendientesPor;
	private JLabel lblBiblioteca;
	private JLabel lblTipoDePersona;
	private JRadioButton rdbtnEstudiante;
	private JRadioButton rdbtnEmpleado;
	private JButton btnConfirmarRequisitos;
	private JTable table;
	
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;
	private JLabel lblFiltrarPor;
	private JLabel lblFacultad;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public CasosPendientesSegInf() {
		setBounds(178,0,944,700);
		setBackground(new Color(31,33,36));
		setLayout(null);
		add(getPanel());
		add(getLblCasosPendientesPor());
		add(getLblBiblioteca());
		add(getLblTipoDePersona());
		add(getRdbtnEstudiante());
		add(getRdbtnEmpleado());
		add(getBtnConfirmarRequisitos());
		add(getLblFiltrarPor());
		add(getLblFacultad());
		add(getComboBox());
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new LineBorder(Color.WHITE));
			panel.setBounds(29, 82, 719, 528);
			panel.setBackground(new Color(31,33,36));
			panel.setLayout(null);
			panel.add(getTable());
			
			panel.add(getScrollPane_1());
			panel.add(getScrollPane());
		

		}
		return panel;
	}
	private JLabel getLblCasosPendientesPor() {
		if (lblCasosPendientesPor == null) {
			lblCasosPendientesPor = new JLabel("Casos pendientes por verificaci\u00F3n de requisitos");
			lblCasosPendientesPor.setForeground(Color.WHITE);
			lblCasosPendientesPor.setFont(new Font("Arial Narrow", Font.BOLD, 22));
			lblCasosPendientesPor.setBounds(133, 30, 486, 41);
		}
		return lblCasosPendientesPor;
	}
	private JLabel getLblBiblioteca() {
		if (lblBiblioteca == null) {
			lblBiblioteca = new JLabel("Seguridad Inform\u00E1tica");
			lblBiblioteca.setForeground(Color.WHITE);
			lblBiblioteca.setFont(new Font("Arial Narrow", Font.BOLD, 16));
			lblBiblioteca.setBounds(769, 11, 165, 41);
		}
		return lblBiblioteca;
	}
	private JLabel getLblTipoDePersona() {
		if (lblTipoDePersona == null) {
			lblTipoDePersona = new JLabel("Tipo de persona");
			lblTipoDePersona.setForeground(Color.WHITE);
			lblTipoDePersona.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			lblTipoDePersona.setBounds(779, 169, 143, 31);
		}
		return lblTipoDePersona;
	}
	private JRadioButton getRdbtnEstudiante() {
		if (rdbtnEstudiante == null) {
			rdbtnEstudiante = new JRadioButton("Estudiante");
			rdbtnEstudiante.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			rdbtnEstudiante.setForeground(Color.WHITE);
			rdbtnEstudiante.setBounds(796, 207, 109, 23);
			rdbtnEstudiante.setBackground(new Color(31,33,36));
		}
		return rdbtnEstudiante;
	}
	private JRadioButton getRdbtnEmpleado() {
		if (rdbtnEmpleado == null) {
			rdbtnEmpleado = new JRadioButton("Empleado");
			rdbtnEmpleado.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			rdbtnEmpleado.setForeground(Color.WHITE);
			rdbtnEmpleado.setBounds(796, 243, 109, 23);
			rdbtnEmpleado.setBackground(new Color(31,33,36));
		}
		return rdbtnEmpleado;
	}
	private JButton getBtnConfirmarRequisitos() {
		if (btnConfirmarRequisitos == null) {
			btnConfirmarRequisitos = new JButton("Confirmar requisitos");
			btnConfirmarRequisitos.setBackground(new Color(51, 153, 51));
			btnConfirmarRequisitos.setForeground(Color.WHITE);
			btnConfirmarRequisitos.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			btnConfirmarRequisitos.setBounds(619, 635, 191, 31);
		}
		return btnConfirmarRequisitos;
	}


	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setForeground(Color.WHITE);
			table.setBackground(new Color(31,33,36));
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"Nombre", "Apellidos", "Facultad", "Tipo de persona", "Deuda"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(149);
			table.getColumnModel().getColumn(1).setPreferredWidth(187);
			table.getColumnModel().getColumn(2).setPreferredWidth(148);
			table.getColumnModel().getColumn(3).setPreferredWidth(118);
			table.setFont(new Font("Arial Narrow", Font.BOLD, 16));
			table.setBounds(10, 11, 663, 483);
		}
		return table;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 499, 698, 18);
		}
		return scrollPane_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(683, 11, 25, 483);
		}
		return scrollPane;
	}
	private JLabel getLblFiltrarPor() {
		if (lblFiltrarPor == null) {
			lblFiltrarPor = new JLabel("Filtrar por\r\n");
			lblFiltrarPor.setForeground(Color.WHITE);
			lblFiltrarPor.setFont(new Font("Arial Narrow", Font.BOLD, 22));
			lblFiltrarPor.setBounds(769, 131, 143, 31);
		}
		return lblFiltrarPor;
	}
	private JLabel getLblFacultad() {
		if (lblFacultad == null) {
			lblFacultad = new JLabel("Facultad (Estudiante)\r\n");
			lblFacultad.setForeground(Color.WHITE);
			lblFacultad.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			lblFacultad.setBounds(769, 288, 165, 31);
		}
		return lblFacultad;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Arquitectura", "Ing_Civil", "Ing_Electrica", "Ing_Industrial", "Ing_Informatica", "Ing_Quimica", "Ing_Mecanica", "Ing_Automatica_y_Biomedica", "Ing_en_Telecomunicaciones_y_Electronica"}));
			comboBox.setBounds(769, 330, 165, 20);
		}
		return comboBox;
	}

}
