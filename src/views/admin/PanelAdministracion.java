package views.admin;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;

import util.Facultad;

import java.awt.Cursor;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ImageIcon;
import util.TipoDepartamento;

public class PanelAdministracion extends JPanel {
	private JPanel panelFiltrados;
	private JPanel panelReportes;
	private JPanel panelCategorias;
	private JLabel lblTituloFilt;
	private JLabel lblFac;
	private JLabel lblAnio;
	private JLabel labelEstado;
	private JComboBox comboBoxSeleccionarFac;
	private JComboBox comboBox;
	private JLabel lblTituloReportes;
	private JComboBox comboBoxReportes;
	private JLabel lblTituloCategorias;
	private JCheckBox chckbxGenerarPdf;
	private JRadioButton rdbtnEstudiante;
	private JLabel lblTipoDePersona;
	private JRadioButton rdbtnEmpleado;
	private JLabel lblTramite;
	private JRadioButton rdbtnBaja;
	private JRadioButton rdbtnLicencia;
	private JScrollPane scrollPaneFiltrado;
	private JComboBox comboBox_1;
	private JTable table;
	private JLabel lblNewLabel;

	
	public PanelAdministracion() {
		setBounds(new Rectangle(178, 0, 944, 700));
		setBackground(new Color(31, 33, 36));
		setLayout(null);
		add(getPanelFiltrados());
		add(getPanelReportes());
		add(getPanelCategorias());
		add(getScrollPaneFiltrado());
		add(getLblNewLabel());

	}
	private JPanel getPanelFiltrados() {
		if (panelFiltrados == null) {
			panelFiltrados = new JPanel();
			panelFiltrados.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
			panelFiltrados.setBounds(634, 32, 258, 237);
			panelFiltrados.setBackground(new Color(26, 30, 40));
			panelFiltrados.setLayout(null);
			panelFiltrados.add(getLblTituloFilt());
			panelFiltrados.add(getLblFac());
			panelFiltrados.add(getLblAnio());
			panelFiltrados.add(getLabelEstado());
			panelFiltrados.add(getComboBoxSeleccionarFac());
			panelFiltrados.add(getComboBox());
			panelFiltrados.add(getComboBox_1());
			
		}
		return panelFiltrados;
	}
	private JPanel getPanelReportes() {
		if (panelReportes == null) {
			panelReportes = new JPanel();
			panelReportes.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
			panelReportes.setBounds(634, 280, 258, 154);
			panelReportes.setBackground(new Color(26, 30, 40));
			panelReportes.setLayout(null);
			panelReportes.add(getLblTituloReportes());
			panelReportes.add(getComboBoxReportes());
			panelReportes.add(getChckbxGenerarPdf());
		}
		return panelReportes;
	}
	private JPanel getPanelCategorias() {
		if (panelCategorias == null) {
			panelCategorias = new JPanel();
			panelCategorias.setBorder(new LineBorder(new Color(105, 105, 105), 1, true));
			panelCategorias.setBounds(634, 445, 258, 229);
			panelCategorias.setBackground(new Color(26, 30, 40));
			panelCategorias.setLayout(null);
			panelCategorias.add(getLblTituloCategorias());
			panelCategorias.add(getRdbtnEstudiante());
			panelCategorias.add(getLblTipoDePersona());
			panelCategorias.add(getRdbtnEmpleado());
			panelCategorias.add(getLblTramite());
			panelCategorias.add(getRdbtnBaja());
			panelCategorias.add(getRdbtnLicencia());
		}
		return panelCategorias;
	}
	private JLabel getLblTituloFilt() {
		if (lblTituloFilt == null) {
			lblTituloFilt = new JLabel("Filtrar");
			lblTituloFilt.setForeground(Color.WHITE);
			lblTituloFilt.setFont(new Font("Segoe UI Semibold", Font.BOLD, 19));
			lblTituloFilt.setBounds(102, 13, 54, 41);
		}
		return lblTituloFilt;
	}
	private JLabel getLblFac() {
		if (lblFac == null) {
			lblFac = new JLabel("Facultad");
			lblFac.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			lblFac.setForeground(Color.WHITE);
			lblFac.setBounds(12, 68, 68, 28);
		}
		return lblFac;
	}
	private JLabel getLblAnio() {
		if (lblAnio == null) {
			lblAnio = new JLabel("A\u00F1o");
			lblAnio.setForeground(Color.WHITE);
			lblAnio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			lblAnio.setBounds(12, 126, 56, 28);
		}
		return lblAnio;
	}
	private JLabel getLabelEstado() {
		if (labelEstado == null) {
			labelEstado = new JLabel("Estado");
			labelEstado.setForeground(Color.WHITE);
			labelEstado.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			labelEstado.setBounds(12, 188, 56, 28);
		}
		return labelEstado;
	}
	private JComboBox getComboBoxSeleccionarFac() {
		if (comboBoxSeleccionarFac == null) {
			comboBoxSeleccionarFac = new JComboBox();
			comboBoxSeleccionarFac.setModel(new DefaultComboBoxModel(TipoDepartamento.values()));
			comboBoxSeleccionarFac.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBoxSeleccionarFac.setMaximumRowCount(9);
			comboBoxSeleccionarFac.setForeground(Color.BLACK);
			comboBoxSeleccionarFac.setBackground(Color.WHITE);
			comboBoxSeleccionarFac.setToolTipText("");
			comboBoxSeleccionarFac.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
//			comboBoxSeleccionarFac.setModel(new DefaultComboBoxModel(Facultad.values()));
//			comboBoxSeleccionarFac.setSelectedIndex(9);
			comboBoxSeleccionarFac.setBounds(92, 72, 154, 25);
		}
		return comboBoxSeleccionarFac;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(92, 193, 154, 25);
		}
		return comboBox;
	}
	private JLabel getLblTituloReportes() {
		if (lblTituloReportes == null) {
			lblTituloReportes = new JLabel("Reportes");
			lblTituloReportes.setForeground(Color.WHITE);
			lblTituloReportes.setFont(new Font("Segoe UI Semibold", Font.BOLD, 19));
			lblTituloReportes.setBounds(89, 13, 76, 41);
		}
		return lblTituloReportes;
	}
	private JComboBox getComboBoxReportes() {
		if (comboBoxReportes == null) {
			comboBoxReportes = new JComboBox();
			comboBoxReportes.setBackground(Color.WHITE);
			comboBoxReportes.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			comboBoxReportes.setBounds(12, 67, 234, 25);
		}
		return comboBoxReportes;
	}
	private JLabel getLblTituloCategorias() {
		if (lblTituloCategorias == null) {
			lblTituloCategorias = new JLabel("Categoria");
			lblTituloCategorias.setForeground(Color.WHITE);
			lblTituloCategorias.setFont(new Font("Segoe UI Semibold", Font.BOLD, 19));
			lblTituloCategorias.setBounds(85, 11, 102, 41);
		}
		return lblTituloCategorias;
	}
	private JCheckBox getChckbxGenerarPdf() {
		if (chckbxGenerarPdf == null) {
			chckbxGenerarPdf = new JCheckBox("Generar PDF");
			chckbxGenerarPdf.setForeground(Color.WHITE);
			chckbxGenerarPdf.setBackground(new Color(31, 33, 36));
			chckbxGenerarPdf.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
			chckbxGenerarPdf.setBounds(12, 120, 113, 25);
		}
		return chckbxGenerarPdf;
	}
	private JRadioButton getRdbtnEstudiante() {
		if (rdbtnEstudiante == null) {
			rdbtnEstudiante = new JRadioButton("Estudiante");
			rdbtnEstudiante.setForeground(Color.WHITE);
			rdbtnEstudiante.setBackground(new Color(31, 33, 36));
			rdbtnEstudiante.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			rdbtnEstudiante.setBounds(23, 85, 102, 25);
		}
		return rdbtnEstudiante;
	}
	private JLabel getLblTipoDePersona() {
		if (lblTipoDePersona == null) {
			lblTipoDePersona = new JLabel("Tipo de persona");
			lblTipoDePersona.setForeground(Color.WHITE);
			lblTipoDePersona.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			lblTipoDePersona.setBounds(23, 50, 123, 28);
		}
		return lblTipoDePersona;
	}
	private JRadioButton getRdbtnEmpleado() {
		if (rdbtnEmpleado == null) {
			rdbtnEmpleado = new JRadioButton("Empleado");
			rdbtnEmpleado.setForeground(Color.WHITE);
			rdbtnEmpleado.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			rdbtnEmpleado.setBackground(new Color(31, 33, 36));
			rdbtnEmpleado.setBounds(125, 85, 127, 25);
		}
		return rdbtnEmpleado;
	}
	private JLabel getLblTramite() {
		if (lblTramite == null) {
			lblTramite = new JLabel("Tr\u00E1mite");
			lblTramite.setForeground(Color.WHITE);
			lblTramite.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			lblTramite.setBounds(23, 136, 123, 28);
		}
		return lblTramite;
	}
	private JRadioButton getRdbtnBaja() {
		if (rdbtnBaja == null) {
			rdbtnBaja = new JRadioButton("Baja");
			rdbtnBaja.setForeground(Color.WHITE);
			rdbtnBaja.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			rdbtnBaja.setBackground(new Color(31, 33, 36));
			rdbtnBaja.setBounds(21, 168, 73, 25);
		}
		return rdbtnBaja;
	}
	private JRadioButton getRdbtnLicencia() {
		if (rdbtnLicencia == null) {
			rdbtnLicencia = new JRadioButton("Licencia");
			rdbtnLicencia.setForeground(Color.WHITE);
			rdbtnLicencia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			rdbtnLicencia.setBackground(new Color(31, 33, 36));
			rdbtnLicencia.setBounds(125, 168, 127, 25);
		}
		return rdbtnLicencia;
	}
	private JScrollPane getScrollPaneFiltrado() {
		if (scrollPaneFiltrado == null) {
			scrollPaneFiltrado = new JScrollPane();
			scrollPaneFiltrado.setBackground(new Color(31, 33, 36));
			scrollPaneFiltrado.setBounds(0, 100, 590, 574);
			scrollPaneFiltrado.setAutoscrolls(true);
			scrollPaneFiltrado.setViewportView(getTable());
		}
		return scrollPaneFiltrado;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(92, 131, 154, 25);
		}
		return comboBox_1;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setVisible(false);
			table.setVerifyInputWhenFocusTarget(false);
			table.setUpdateSelectionOnSort(false);
			table.setEditingRow(3);
			table.setEditingColumn(4);
			table.setAutoCreateRowSorter(true);
			table.setFillsViewportHeight(true);
			table.setColumnSelectionAllowed(true);
			table.setCellSelectionEnabled(true);
		}
		return table;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel();
			lblNewLabel.setBounds(36, -44, 504, 196);
            ImageIcon ico = new ImageIcon("C:\\Users\\herna\\OneDrive\\Escritorio\\Nueva carpeta\\b.png");
            ImageIcon img = new ImageIcon(
                    ico.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
            lblNewLabel.setIcon(img);
		}
		return lblNewLabel;
	}
}
