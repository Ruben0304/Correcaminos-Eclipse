package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;

public class VentanaSolicitudLicenciaEmpleado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelBase;
	private JPanel panel_datos;
	private JLabel nombre_empleado;
	private JTextField textField_NombreEmpleado;
	private JLabel labelPrimer_apellido;
	private JTextField textField_PrimerApellido;
	private JLabel labelSegundoApellido;
	private JTextField textField_SegundoApellido;
	private JLabel labelCarnetID;
	private JTextField textField_Carnet;
	private JComboBox comboBox_Facultades;
	private JSpinner spinner_NoTrabajador;
	private JComboBox comboBox_Profesiones;
	private JButton btnEnviarSolicitud;
	private JButton btnCancelar;
	private JLabel labelMotivo;
	private JTextField textField_Motivo;
	private JPanel panel_foto;
	private JLabel labelFoto;
	private JDateChooser fechaSalida;
	private JDateChooser fechaRegreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSolicitudLicenciaEmpleado frame = new VentanaSolicitudLicenciaEmpleado();
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
	public VentanaSolicitudLicenciaEmpleado() {
		setTitle("Llenar solicitud de licencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 457);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelBase = new JPanel();
		panelBase.setBackground(Color.WHITE);
		panelBase.setBounds(0, 0, 684, 418);
		contentPane.add(panelBase);
		panelBase.setLayout(null);
		
		panel_datos = new JPanel();
		panel_datos.setBounds(299, 0, 357, 407);
		panelBase.add(panel_datos);
		panel_datos.setBackground(new Color (204, 255, 204));
		panel_datos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Datos del empleado", TitledBorder.LEADING, TitledBorder.TOP, new Font("Roboto Medium", Font.PLAIN, 18), new Color(0, 0, 0)));
		panel_datos.setLayout(null);
		
		nombre_empleado = new JLabel("Nombre:");
		nombre_empleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombre_empleado.setBounds(21, 30, 86, 14);
		panel_datos.add(nombre_empleado);
		
		textField_NombreEmpleado = new JTextField();
		textField_NombreEmpleado.setBounds(101, 29, 202, 20);
		textField_NombreEmpleado.setBorder(new LineBorder(new Color(0,0,0), 1));
		panel_datos.add(textField_NombreEmpleado);
		textField_NombreEmpleado.setColumns(10);
		
		labelPrimer_apellido = new JLabel("Primer Apellido:");
		labelPrimer_apellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPrimer_apellido.setBounds(21, 60, 116, 19);
		panel_datos.add(labelPrimer_apellido);
		
		textField_PrimerApellido = new JTextField();
		textField_PrimerApellido.setBounds(142, 61, 161, 20);
		textField_PrimerApellido.setBorder(new LineBorder(new Color(0,0,0), 1));
		panel_datos.add(textField_PrimerApellido);
		
		labelSegundoApellido = new JLabel("Segundo Apellido:");
		labelSegundoApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelSegundoApellido.setBounds(21, 98, 127, 19);
		panel_datos.add(labelSegundoApellido);
		
		textField_SegundoApellido = new JTextField();
		textField_SegundoApellido.setBounds(152, 97, 151, 20);
		textField_SegundoApellido.setBorder(new LineBorder(new Color(0,0,0), 1));
		panel_datos.add(textField_SegundoApellido);
		textField_SegundoApellido.setColumns(10);
		
		JLabel labelFacultad = new JLabel("Facultad:");
		labelFacultad.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelFacultad.setBounds(21, 165, 71, 14);
		panel_datos.add(labelFacultad);
		
		labelCarnetID = new JLabel("Carnet de Identidad:");
		labelCarnetID.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCarnetID.setBounds(21, 134, 145, 14);
		panel_datos.add(labelCarnetID);
		
		textField_Carnet = new JTextField();
		textField_Carnet.setBounds(176, 133, 127, 20);
	    textField_Carnet.setBorder(new LineBorder(new Color(0,0,0), 1));
		panel_datos.add(textField_Carnet);
		
		comboBox_Facultades = new JComboBox();
		comboBox_Facultades.setBackground(Color.WHITE);
		comboBox_Facultades.setModel(new DefaultComboBoxModel(new String[] {"<Facultad>","Inform�tica", "Autom�tica", "Mec�nica", "Telecomunicaciones","Qu�mica","Civil","Arquitectura","Industrial","El�ctrica"}));
		comboBox_Facultades.setBounds(101, 164, 202, 20);
		panel_datos.add(comboBox_Facultades);
		
		spinner_NoTrabajador = new JSpinner();
		spinner_NoTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_NoTrabajador.setBorder(new LineBorder(new Color(0,0,0), 1));
		spinner_NoTrabajador.setModel(new SpinnerNumberModel(1, 1, 100000, 1));
		spinner_NoTrabajador.setBounds(142, 194, 161, 20);
		panel_datos.add(spinner_NoTrabajador);
		
		JLabel labelNoTrabajador = new JLabel("No. Trabajador:");
		labelNoTrabajador.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelNoTrabajador.setBounds(21, 196, 117, 17);
		panel_datos.add(labelNoTrabajador);
		
		JLabel labelProfesion = new JLabel("Profesi\u00F3n u oficio:");
		labelProfesion.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelProfesion.setBounds(21, 229, 142, 14);
		panel_datos.add(labelProfesion);
		
		comboBox_Profesiones = new JComboBox();
		comboBox_Profesiones.setBackground(Color.WHITE);
		comboBox_Profesiones.setModel(new DefaultComboBoxModel(new String[] {"<Profesiones>","Docente", "Investigador", "T�cnico", "Dirigente","Obrero","Servicio","Administrador"}));
		comboBox_Profesiones.setBounds(152, 228, 151, 20);
		panel_datos.add(comboBox_Profesiones);
		
		btnEnviarSolicitud = new JButton("Enviar solicitud");
		btnEnviarSolicitud.setBackground(Color.WHITE);
		btnEnviarSolicitud.setBounds(21, 365, 127, 25);
		btnEnviarSolicitud.setBorder(new LineBorder(new Color(0,0,0), 1));
		panel_datos.add(btnEnviarSolicitud);
		btnEnviarSolicitud.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBorder(new LineBorder(new Color(0,0,0), 1));
		btnCancelar.setBounds(174, 365, 129, 25);
		panel_datos.add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		labelMotivo = new JLabel("Motivo:");
		labelMotivo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelMotivo.setIgnoreRepaint(true);
		labelMotivo.setBounds(21, 263, 86, 14);
		panel_datos.add(labelMotivo);
		
		textField_Motivo = new JTextField();
		textField_Motivo.setBounds(84, 261, 219, 20);
		textField_Motivo.setBorder(new LineBorder(new Color(0,0,0), 1));
		panel_datos.add(textField_Motivo);
		
		JLabel lblNewLabel = new JLabel("Fecha Salida:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 297, 99, 14);
		panel_datos.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Regreso:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(21, 331, 116, 17);
		panel_datos.add(lblNewLabel_1);
		
		panel_foto = new JPanel();
		panel_foto.setBounds(0, 0, 299, 418);
		panelBase.add(panel_foto);
		panel_foto.setLayout(null);
		
		labelFoto = new JLabel("");
		ImageIcon image = new ImageIcon("C:/Users/Marcel/Correcaminos-Eclipse/img/IMG-20231017-WA0040.jpg");
		ImageIcon ico = new ImageIcon(image.getImage().getScaledInstance(299, 418, Image.SCALE_AREA_AVERAGING));
		labelFoto.setBounds(0, 0, 299, 418);
		labelFoto.setIcon(ico);
		panel_foto.add(labelFoto);
		
		fechaSalida = new JDateChooser();
		fechaSalida.setDateFormatString("dd/MM/yyyy");
		fechaSalida.setMinSelectableDate(new Date());
		fechaSalida.setBounds(127, 294, 176, 20);
		panel_datos.add(fechaSalida);
		
		fechaRegreso = new JDateChooser();
		fechaRegreso.setDateFormatString("dd/MM/yyyy");
		fechaRegreso.setBounds(137, 331, 166, 20);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR,1);
		fechaRegreso.setMinSelectableDate(calendar.getTime());
		panel_datos.add(fechaRegreso);
	}
}