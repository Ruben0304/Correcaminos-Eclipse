package vistas.admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import autenticacion.Auth;
import controladores.ControladorAdmin;
import modelos.gestion.empleados.GestorEmpleados;
import modelos.gestion.estudiantes.Secretaria;
import modelos.usuarios.Admin;
import modelos.usuarios.Persona;
import raven.toast.Notifications;
import util.Estado;
import util.TipoDepartamento;
import util.modelos.DepartamentoVerificadorLibrosTableModel;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;

import javax.swing.JMenu;

public class DepartamentosModelo extends JPanel {

	private static final long serialVersionUID = 1L;

	protected JPanel panelContenedor;
	protected JPanel panelNombreDept;
	protected JTable table;
	protected TableModel tableModel;
	protected JLabel lNombreDepartamento;
	protected JLabel lblCasosPendientes;
	protected JScrollPane scrollPane;
	protected JButton btnConfirmarEntrega;
	protected ImageIcon iDimAux, iMinimizar, iCerrar;
	private JButton button;
	private JButton btnLeyenda;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() {
	 * public void run() {
	 * try {
	 * DepartamentosModel frame = new DepartamentosModel("Econom�a");
	 * frame.setVisible(true);
	 * } catch (Exception e) {
	 * e.printStackTrace();
	 * }
	 * }
	 * });
	 * }
	 */

	/**
	 * Create the panel.
	 */
	public DepartamentosModelo(TableModel modelo) {

		FlatLaf.registerCustomDefaultsSource("app.themes");
		FlatMacDarkLaf.setup();
		crearImagenes();

		panelContenedor = new JPanel();
		panelContenedor.setBounds(0, 0, 944, 700);
		;
		add(panelContenedor);
		panelContenedor.setLayout(null);

		panelNombreDept = new JPanel();
		panelNombreDept.setBounds(28, 0, 572, 43);
		panelContenedor.add(panelNombreDept);
		panelNombreDept.setLayout(null);

		lNombreDepartamento = new JLabel(Auth.getNombreUsuario());
		lNombreDepartamento.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lNombreDepartamento.setBounds(0, 8, 271, 35);
		panelNombreDept.add(lNombreDepartamento);

		iDimAux = new ImageIcon(
				iCerrar.getImage()
				.getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING));

		iDimAux = new ImageIcon(
				iMinimizar.getImage()
				.getScaledInstance(21, 21, Image.SCALE_AREA_AVERAGING));

		lblCasosPendientes = new JLabel("Listado de Casos Pendientes");
		lblCasosPendientes.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblCasosPendientes.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 255, 0)));
		lblCasosPendientes.setBounds(28, 77, 840, 30);
		panelContenedor.add(lblCasosPendientes);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 111, 840, 424);
		panelContenedor.add(scrollPane);

		table = new JTable();
		this.table.setModel(modelo);
		table.isCellEditable(40, 8);
		table.setFont(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		table.setFocusable(false);
		scrollPane.setViewportView(table);

		btnConfirmarEntrega = new JButton("Confirmar entrega");
		btnConfirmarEntrega.setBounds(673, 609, 210, 43);
		btnConfirmarEntrega.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnConfirmarEntrega.setBackground(new Color(102, 153, 255));
		btnConfirmarEntrega.setForeground(Color.WHITE);
		btnConfirmarEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() != -1) {
					if (table.getColumnName(0).equals("Deudas")) {
						Set<String> seleccion = new HashSet<>();
						for (int i : table.getSelectedRows()) {
							seleccion.add((String) table.getValueAt(i, 0));
						}

						ControladorAdmin.entregarDeuda(seleccion, table.getValueAt(0, 1).toString());
					} else {

						ControladorAdmin.confirmarEntrega(table.getValueAt(table.getSelectedRow(), 0).toString());

					}

					// DefaultTableModel modelo = (DefaultTableModel) table_2.getModel();

					// modelo.fireTableDataChanged();

				}

			}
		});
		panelContenedor.add(btnConfirmarEntrega);

		button = new JButton("Confirmar cancelación");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int selectedRow1 = table.getSelectedRow();
				String cancelado = null;
				if (selectedRow1 != -1) {
					if(((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.Secretaria))
						 cancelado = table.getValueAt(selectedRow1,8 ).toString();
					else if(((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.RecursosHumanos))
						 cancelado = table.getValueAt(selectedRow1,6 ).toString();
				
					if(cancelado.equals("Sí")){
						button.setEnabled(true);
						int respuesta = JOptionPane.showConfirmDialog(null,
								"¿Estás seguro que desea ejecutar esta acción?",
								"Confirmación",
								JOptionPane.YES_NO_OPTION);
						if (respuesta == 0) {
							int selectedRow = table.getSelectedRow();
							if (selectedRow != -1) {
								if(((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.Secretaria)){
									String carnet = table.getValueAt(selectedRow, 0).toString();
									Secretaria.gestorEstudiantes().getGestorSolicitudes().cambiarEstadoSolicitud(carnet,
											Estado.CANCELADO);
									Notifications.getInstance().show(Notifications.Type.SUCCESS,"Trámite cancelado correctamente");
									ControladorAdmin.mostrarGestionLicencias();
								}
								else if(((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.RecursosHumanos)){
									String carnetE = table.getValueAt(selectedRow, 0).toString();
									GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados().cambiarEstadoSolicitud(carnetE,
											Estado.CANCELADO);
									Notifications.getInstance().show(Notifications.Type.SUCCESS,"Trámite cancelado correctamente");
									ControladorAdmin.mostrarGestionLicencias();
								}
							}
						}

					}else {
						button.setEnabled(false);
						Notifications.getInstance().show(Notifications.Type.SUCCESS,"No ha solicitado cancelación");
						ControladorAdmin.mostrarGestionLicencias();

					}

				}
			}
		});
		button.setForeground(Color.WHITE);
		if(((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.Secretaria) || ((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.RecursosHumanos))
			button.setVisible(true);
		else
			button.setVisible(false);

		button.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		button.setBackground(new Color(102, 153, 255));
		button.setBounds(416, 609, 219, 43);
		panelContenedor.add(button);
		panelContenedor.add(getBtnLeyenda());



		if (((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.AlmacenLibrosDocentes)
				|| ((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.Biblioteca)
				|| ((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.Contabilidad)
				|| ((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.DireccionBecas)) {

			JButton btnVerDeudas = new JButton(
					table.getColumnName(0).equals("Deudas") ? "Ver Casos Pendientes" : "Ver Deudas");
			btnVerDeudas.setForeground(Color.WHITE);
			btnVerDeudas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			btnVerDeudas.setBackground(new Color(143, 188, 143));
			btnVerDeudas.setBounds(450, 609, 196, 43);
			btnVerDeudas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getColumnName(0).equals("Deudas")) {
						ControladorAdmin.mostrarGestionLicencias();
					} else {
						int selectedRow = table.getSelectedRow();
						if (selectedRow != -1) {
							String carnet = table.getValueAt(selectedRow, 0).toString();
							ControladorAdmin.verDeudas(carnet);

							// DefaultTableModel modelo = (DefaultTableModel) table_2.getModel();

							// modelo.fireTableDataChanged();

						}
					}
				}
			});

			panelContenedor.add(btnVerDeudas);
		}
		setBounds(178, 0, 944, 700);
		this.setLayout(null);
	}

	private void crearImagenes() {
		iCerrar = new ImageIcon("./src/img/cerrar_sin_relleno.png");
		iMinimizar = new ImageIcon("./src/img/min_blanco.png");
	}
	private JButton getBtnLeyenda() {

		if (btnLeyenda == null) {
			btnLeyenda = new JButton("Leyenda");
			btnLeyenda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if(((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.Secretaria)){
						JTextArea textArea = new JTextArea("B-Biblioteca\nAL-Almacén de libros\nE-Economía\nDB-dirección de becas\nSI-Seguridad Informática\nSC-Solicita Cancelación\nA-Aprobado\nP-Pendiente");
						textArea.setEditable(false);
						JScrollPane s = new JScrollPane (textArea);
						s.setPreferredSize(new Dimension(200,100));
						JOptionPane.showMessageDialog(null, s,"Leyenda",JOptionPane.PLAIN_MESSAGE);}
					else if(((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.RecursosHumanos))
					{
						JTextArea textArea = new JTextArea("B-Biblioteca\nC-Contabilidad\nSI-Seguridad Informática\nSC-Solicita Cancelación\nA-Aprobado\nP-Pendiente");
						textArea.setEditable(false);
						JScrollPane s = new JScrollPane (textArea);
						s.setPreferredSize(new Dimension(200,100));
						JOptionPane.showMessageDialog(null, s,"Leyenda",JOptionPane.PLAIN_MESSAGE);}



				}
			});
			if(((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.Secretaria) || ((Admin) Auth.usuarioAutenticado()).getTipoDepartamento().equals(TipoDepartamento.RecursosHumanos))
				btnLeyenda.setVisible(true);
			else
				btnLeyenda.setVisible(false);

			btnLeyenda.setForeground(Color.WHITE);
			btnLeyenda.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			btnLeyenda.setEnabled(true);
			btnLeyenda.setBackground(new Color(72, 189, 133));
			btnLeyenda.setBounds(28, 558, 196, 43);

		}

		return btnLeyenda;
	}
	
	
		
	
}

