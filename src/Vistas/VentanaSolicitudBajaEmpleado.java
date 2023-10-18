package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

public class VentanaSolicitudBajaEmpleado extends JFrame {

	private JPanel contentPane;
	private JPanel panel_datos;
	private JTextField textField_NombreEmpleado;
	private JTextField textField_PrimerApellido;
	private JTextField textField_SegundoApellido;
	private JTextField textField_Carnet;
	private JPanel panelBase;
	private JButton btnEnviarSolicitud;
	private JButton btnCancelar;
	private JComboBox comboBox_Profesiones;
	private JSpinner spinner_NoTrabajador;
	private JComboBox comboBox_Facultades;
	private JLabel labelCarnetID;
	private JLabel labelSegundoApellido;
	private JLabel labelPrimer_apellido;
	private JLabel nombre_empleado;
	private JPanel panel_foto;
	private JLabel labelFoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSolicitudBajaEmpleado frame = new VentanaSolicitudBajaEmpleado();
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
	public VentanaSolicitudBajaEmpleado() {
		setTitle("Llenar solicitud de baja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 457);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelBase = new JPanel();
		panelBase.setBackground(Color.WHITE);
		panelBase.setBounds(0, 0, 656, 418);
		contentPane.add(panelBase);
		panelBase.setLayout(null);
		
		panel_datos = new JPanel();
		panel_datos.setBounds(299, 11, 347, 384);
		panelBase.add(panel_datos);
		panel_datos.setBackground(Color.WHITE);
		panel_datos.setBorder(new TitledBorder(null, "Datos del empleado", TitledBorder.LEADING, TitledBorder.TOP,new Font("Roboto Medium", Font.PLAIN, 16), Color.BLACK));
		panel_datos.setLayout(null);
		
		nombre_empleado = new JLabel("Nombre:");
		nombre_empleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombre_empleado.setBounds(21, 30, 86, 14);
		panel_datos.add(nombre_empleado);
		
		textField_NombreEmpleado = new JTextField();
		textField_NombreEmpleado.setBounds(101, 29, 176, 20);
		panel_datos.add(textField_NombreEmpleado);
		textField_NombreEmpleado.setColumns(10);
		
		labelPrimer_apellido = new JLabel("Primer Apellido:");
		labelPrimer_apellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPrimer_apellido.setBounds(21, 66, 116, 19);
		panel_datos.add(labelPrimer_apellido);
		
		textField_PrimerApellido = new JTextField();
		textField_PrimerApellido.setBounds(131, 65, 146, 20);
		panel_datos.add(textField_PrimerApellido);
		textField_PrimerApellido.setColumns(10);
		
		labelSegundoApellido = new JLabel("Segundo Apellido:");
		labelSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelSegundoApellido.setBounds(21, 102, 127, 19);
		panel_datos.add(labelSegundoApellido);
		
		textField_SegundoApellido = new JTextField();
		textField_SegundoApellido.setBounds(142, 101, 135, 20);
		panel_datos.add(textField_SegundoApellido);
		textField_SegundoApellido.setColumns(10);
		
		JLabel labelFacultad = new JLabel("Facultad:");
		labelFacultad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelFacultad.setBounds(21, 169, 71, 14);
		panel_datos.add(labelFacultad);
		
		labelCarnetID = new JLabel("Carnet de Identidad:");
		labelCarnetID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCarnetID.setBounds(21, 138, 145, 14);
		panel_datos.add(labelCarnetID);
		
		textField_Carnet = new JTextField();
		textField_Carnet.setBounds(152, 137, 125, 20);
		panel_datos.add(textField_Carnet);
		textField_Carnet.setColumns(10);
		
		comboBox_Facultades = new JComboBox();
		comboBox_Facultades.setBounds(87, 168, 190, 20);
		panel_datos.add(comboBox_Facultades);
		
		spinner_NoTrabajador = new JSpinner();
		spinner_NoTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_NoTrabajador.setModel(new SpinnerNumberModel(1, 1, 100000, 1));
		spinner_NoTrabajador.setBounds(131, 198, 146, 20);
		panel_datos.add(spinner_NoTrabajador);
		
		JLabel labelNoTrabajador = new JLabel("No. Trabajador:");
		labelNoTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNoTrabajador.setBounds(21, 200, 117, 17);
		panel_datos.add(labelNoTrabajador);
		
		JLabel labelProfesion = new JLabel("Profesi\u00F3n u oficio:");
		labelProfesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelProfesion.setBounds(21, 233, 142, 14);
		panel_datos.add(labelProfesion);
		
		comboBox_Profesiones = new JComboBox();
		comboBox_Profesiones.setBounds(141, 232, 136, 20);
		panel_datos.add(comboBox_Profesiones);
		
		btnEnviarSolicitud = new JButton("Enviar solicitud");
		btnEnviarSolicitud.setBounds(21, 303, 143, 25);
		panel_datos.add(btnEnviarSolicitud);
		btnEnviarSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(174, 303, 143, 25);
		panel_datos.add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		panel_foto = new JPanel();
		panel_foto.setBounds(0, 0, 299, 418);
		panelBase.add(panel_foto);
		panel_foto.setLayout(null);
		
		labelFoto = new JLabel("");
		ImageIcon image = new ImageIcon(getClass().getResource("img/IMG-20231017-WA0040.jpg"));
		labelFoto.setBounds(0, 0, 299, 418);
		labelFoto.setIcon(image);
		panel_foto.add(labelFoto);
	}
}
