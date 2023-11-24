package views.admin;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ImageIcon;
import util.TipoDepartamento;
import util.Motivos;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;

import controllers.ControladorFiltrado;
import models.gestion.GestorDepartamentos;
import models.gestion.estudiantes.GestorEstudiantes;
import models.gestion.estudiantes.GestorResponsabilidadesEstudiantes;
import models.solicitudes.SolicitudBajaEstudiante;
import models.solicitudes.SolicitudLicenciaEstudiante;
import models.usuarios.Estudiante;

import javax.swing.event.ChangeEvent;
import util.Estado;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ItemEvent;

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
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblMotivo;
	private JComboBox comboBox_2;
	private JSlider slider;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTable table;
	private HashMap<String, String> map;
	private ArrayList<SolicitudBajaEstudiante> solicitudBajaEstudiantes;
	private static PanelAdministracion panelAdministracion = null;

	// public void filtrarTabla(){

	// }

	public static PanelAdministracion getPanelAdministracion(
			ArrayList<SolicitudBajaEstudiante> solicitudBajaEstudiantes) {

		return new PanelAdministracion();
	}

	private PanelAdministracion() {
		setBounds(new Rectangle(178, 0, 944, 700));
		setBackground(new Color(31, 33, 36));
		setLayout(null);
		add(getPanelFiltrados());
		add(getPanelReportes());
		add(getPanelCategorias());
		add(getScrollPaneFiltrado());
		add(getLblNewLabel());
		add(getTextField());

		// this.solicitudBajaEstudiantes = solicitudBajaEstudiantes;
		this.map = new HashMap<>();

	}

	private JPanel getPanelFiltrados() {
		if (panelFiltrados == null) {
			panelFiltrados = new JPanel();
			panelFiltrados.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
			panelFiltrados.setBounds(634, 34, 258, 250);
			panelFiltrados.setBackground(new Color(40, 42, 46));
			panelFiltrados.setLayout(null);
			panelFiltrados.add(getLblTituloFilt());
			panelFiltrados.add(getLblFac());
			panelFiltrados.add(getLblAnio());
			panelFiltrados.add(getLabelEstado());
			panelFiltrados.add(getComboBoxSeleccionarFac());
			panelFiltrados.add(getComboBox());
			panelFiltrados.add(getLblMotivo());
			panelFiltrados.add(getComboBox_2());
			panelFiltrados.add(getSlider());
			panelFiltrados.add(getLabel());
			panelFiltrados.add(getLabel_1());
			panelFiltrados.add(getLabel_2());

		}
		return panelFiltrados;
	}

	private JPanel getPanelReportes() {
		if (panelReportes == null) {
			panelReportes = new JPanel();
			panelReportes.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
			panelReportes.setBounds(634, 297, 258, 152);
			panelReportes.setBackground(new Color(40, 42, 46));
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
			panelCategorias.setBounds(634, 462, 258, 205);
			panelCategorias.setBackground(new Color(40, 42, 46));
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
			lblTituloFilt.setBounds(102, 13, 54, 28);
		}
		return lblTituloFilt;
	}

	private JLabel getLblFac() {
		if (lblFac == null) {
			lblFac = new JLabel("Facultad");
			lblFac.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			lblFac.setForeground(Color.WHITE);
			lblFac.setBounds(12, 52, 68, 28);
		}
		return lblFac;
	}

	private JLabel getLblAnio() {
		if (lblAnio == null) {
			lblAnio = new JLabel("A\u00F1o");
			lblAnio.setForeground(Color.WHITE);
			lblAnio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			lblAnio.setBounds(113, 159, 66, 53);
		}
		return lblAnio;
	}

	private JLabel getLabelEstado() {
		if (labelEstado == null) {
			labelEstado = new JLabel("Estado");
			labelEstado.setForeground(Color.WHITE);
			labelEstado.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			labelEstado.setBounds(12, 93, 56, 28);
		}
		return labelEstado;
	}

	private JComboBox getComboBoxSeleccionarFac() {
		if (comboBoxSeleccionarFac == null) {
			comboBoxSeleccionarFac = new JComboBox();
			comboBoxSeleccionarFac.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					getMap().put("facultad", comboBoxSeleccionarFac.getSelectedItem().toString());
					getTable().setModel(
							new PendientesEstudiantes(ControladorFiltrado.obtenerSolicitudesBajaEstudiantesFiltradas(getMap()), 8));
				}
			});
			comboBoxSeleccionarFac.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					// System.out.println(comboBoxSeleccionarFac.getSelectedItem().toString());

				}
			});

			comboBoxSeleccionarFac.setModel(new DefaultComboBoxModel(Facultad.values()));
			comboBoxSeleccionarFac.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBoxSeleccionarFac.setMaximumRowCount(9);
			comboBoxSeleccionarFac.setForeground(Color.BLACK);
			comboBoxSeleccionarFac.setBackground(new Color(245, 255, 250));
			comboBoxSeleccionarFac.setToolTipText("");
			comboBoxSeleccionarFac.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
			// comboBoxSeleccionarFac.setModel(new DefaultComboBoxModel(Facultad.values()));
			// comboBoxSeleccionarFac.setSelectedIndex(9);
			comboBoxSeleccionarFac.setBounds(92, 55, 154, 25);
		}
		return comboBoxSeleccionarFac;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBackground(new Color(224, 255, 255));
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getMap().put("estado", comboBox.getSelectedItem().toString());
					getTable().setModel(
							new PendientesEstudiantes(ControladorFiltrado.obtenerSolicitudesBajaEstudiantesFiltradas(getMap()), 8));
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(Estado.values()));
			comboBox.setBounds(92, 97, 154, 25);
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
			comboBoxReportes.setBounds(12, 59, 234, 27);
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
			chckbxGenerarPdf.setBackground(new Color(40, 42, 46));
			chckbxGenerarPdf.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
			chckbxGenerarPdf.setBounds(12, 95, 113, 42);
		}
		return chckbxGenerarPdf;
	}

	private JRadioButton getRdbtnEstudiante() {
		if (rdbtnEstudiante == null) {
			rdbtnEstudiante = new JRadioButton("Estudiante");
			rdbtnEstudiante.setForeground(Color.WHITE);
			rdbtnEstudiante.setBackground(new Color(40, 42, 46));
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
			rdbtnEmpleado.setBackground(new Color(40, 42, 46));
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
			rdbtnBaja.setBackground(new Color(40, 42, 46));
			rdbtnBaja.setBounds(21, 168, 73, 25);
		}
		return rdbtnBaja;
	}

	private JRadioButton getRdbtnLicencia() {
		if (rdbtnLicencia == null) {
			rdbtnLicencia = new JRadioButton("Licencia");
			rdbtnLicencia.setForeground(Color.WHITE);
			rdbtnLicencia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			rdbtnLicencia.setBackground(new Color(40, 42, 46));
			rdbtnLicencia.setBounds(125, 168, 127, 25);
		}
		return rdbtnLicencia;
	}

	private JScrollPane getScrollPaneFiltrado() {
		if (scrollPaneFiltrado == null) {
			scrollPaneFiltrado = new JScrollPane();
			scrollPaneFiltrado.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
			scrollPaneFiltrado.setOpaque(false);
			scrollPaneFiltrado.setBackground(new Color(40, 42, 46));
			scrollPaneFiltrado.setBounds(0, 100, 590, 574);
			scrollPaneFiltrado.setAutoscrolls(true);
			scrollPaneFiltrado.getViewport().setBackground(new Color(40, 42, 46));
			scrollPaneFiltrado.setViewportView(getTable());
		}
		return scrollPaneFiltrado;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel();
			lblNewLabel.setBounds(58, -43, 446, 196);
			ImageIcon ico = new ImageIcon("C:\\Users\\herna\\OneDrive\\Escritorio\\Nueva carpeta\\b.png");
			ImageIcon img = new ImageIcon(
					ico.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
							Image.SCALE_SMOOTH));
			lblNewLabel.setIcon(img);
		}
		return lblNewLabel;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addKeyListener(new KeyListener() {
				// private String buscar = textField.getText();

				@Override
				public void keyTyped(KeyEvent e) {
				}

				@Override
				public void keyPressed(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {

					getMap().put("buscar", textField.getText());
					getTable().setModel(
							new PendientesEstudiantes(
									ControladorFiltrado.obtenerSolicitudesBajaEstudiantesFiltradas(getMap()), 8));

				}
			});

			textField.setBorder(null);
			textField.setBackground(new Color(249, 249, 249));

			textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
			textField.setBounds(120, 44, 285, 22);
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLblMotivo() {
		if (lblMotivo == null) {
			lblMotivo = new JLabel("Motivo");
			lblMotivo.setForeground(Color.WHITE);
			lblMotivo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			lblMotivo.setBounds(12, 134, 68, 28);
		}
		return lblMotivo;
	}

	private JComboBox getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.setModel(new DefaultComboBoxModel(Motivos.values()));
			comboBox_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					map.put("motivo", comboBox_2.getSelectedItem().toString());
					getTable().setModel(
							new PendientesEstudiantes(
									ControladorFiltrado.obtenerSolicitudesBajaEstudiantesFiltradas(getMap()), 8));
				}
			});
			
			comboBox_2.setToolTipText("");
			comboBox_2.setMaximumRowCount(9);
			comboBox_2.setForeground(Color.BLACK);
			comboBox_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
			comboBox_2.setBackground(new Color(255, 245, 238));
			comboBox_2.setBounds(92, 137, 154, 25);
		}
		return comboBox_2;
	}

	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.setMinimum(2015);
			slider.setMaximum(2023);
			slider.setValue(2023);
			slider.setMajorTickSpacing(10);
			slider.setMinorTickSpacing(1);
			slider.setPaintLabels(true);
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {

					getLabel_2().setText("= " + Integer.toString(slider.getValue()));

					getMap().put("anio", Integer.toString(slider.getValue()));

					getTable().setModel(
							new PendientesEstudiantes(
									ControladorFiltrado.obtenerSolicitudesBajaEstudiantesFiltradas(getMap()), 8));

				}
			});

			slider.setMinorTickSpacing(1);

			slider.setBackground(new Color(40, 42, 46));
			slider.setBounds(22, 196, 224, 26);
		}
		return slider;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("2023");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			label.setBounds(212, 204, 56, 46);
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("2015");
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			label_1.setBounds(24, 204, 56, 46);
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("= 2015");
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			label_2.setBounds(112, 196, 56, 66);
		}
		return label_2;
	}

	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setBorder(null);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// scrollPane.setViewportView(table);

			table.setModel(new PendientesEstudiantes(
					ControladorFiltrado.obtenerSolicitudesBajaEstudiantesFiltradas(getMap()), 8));

			table.setBounds(112, 33, 587, 476);
			table.setBackground(new Color(31, 33, 36));
			table.setRowHeight(50);
			table.setGridColor(new Color(31, 33, 36));
			table.setForeground(Color.WHITE);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);

			// table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			// table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			// table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			// table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		}
		return table;
	}

	public HashMap<String, String> getMap() {
		if (this.map == null) {
			this.map = new HashMap<>();

		}
		return this.map;
	}
}
