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

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSolicitudLicenciaEmpleado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_datos;
	private JLabel nombre_empleado;
	private JTextField textField_NombreEmpleado;
	private JLabel labelPrimer_apellido;
	private JLabel labelSegundoApellido;
	private JLabel labelCarnetID;
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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaSolicitudLicenciaEmpleado.class.getResource("/img/correcamino.png")));
		setTitle("Llenar solicitud de licencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 457);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fondo;
		fondo = new JLabel("");
		fondo.setBorder(null);
		fondo.setBackground(new Color(204, 255, 204));
		fondo.setFont(new Font("Brush Script MT", Font.PLAIN, 44));
		fondo.setBounds(10, 0, 275, 397);
		ImageIcon ico = new ImageIcon(getClass().getResource("/img/r.jpg")); 
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon((img));
		contentPane.add(fondo);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR,1);
		
		panel_datos = new JPanel();
		panel_datos.setBounds(297, 0, 357, 407);
		contentPane.add(panel_datos);
		panel_datos.setBackground(new Color (204, 255, 204));
		panel_datos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Datos del empleado", TitledBorder.LEADING, TitledBorder.TOP, new Font("Roboto Medium", Font.PLAIN, 18), new Color(0, 0, 0)));
		panel_datos.setLayout(null);
		
		nombre_empleado = new JLabel("CI:");
		nombre_empleado.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		nombre_empleado.setBounds(21, 29, 86, 14);
		panel_datos.add(nombre_empleado);
		
		textField_NombreEmpleado = new JTextField();
		textField_NombreEmpleado.setBounds(101, 29, 233, 20);
		textField_NombreEmpleado.setBorder(new LineBorder(new Color(0,0,0), 1));
		panel_datos.add(textField_NombreEmpleado);
		textField_NombreEmpleado.setColumns(10);
		
		labelPrimer_apellido = new JLabel("Nombre:");
		labelPrimer_apellido.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelPrimer_apellido.setBounds(21, 59, 116, 19);
		panel_datos.add(labelPrimer_apellido);
		
		labelSegundoApellido = new JLabel("Primer Apellido:");
		labelSegundoApellido.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelSegundoApellido.setBounds(21, 97, 127, 19);
		panel_datos.add(labelSegundoApellido);
		
		JLabel labelFacultad = new JLabel("Facultad:");
		labelFacultad.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelFacultad.setBounds(21, 165, 71, 14);
		panel_datos.add(labelFacultad);
		
		labelCarnetID = new JLabel("Segundo Apellido");
		labelCarnetID.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelCarnetID.setBounds(21, 133, 145, 14);
		panel_datos.add(labelCarnetID);
		
		JLabel labelNoTrabajador = new JLabel("No. Trabajador:");
		labelNoTrabajador.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelNoTrabajador.setBounds(21, 196, 117, 17);
		panel_datos.add(labelNoTrabajador);
		
		JLabel labelProfesion = new JLabel("Profesi\u00F3n u oficio:");
		labelProfesion.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelProfesion.setBounds(21, 229, 142, 14);
		panel_datos.add(labelProfesion);
		
		setLocationRelativeTo(null);
		
		btnEnviarSolicitud = new JButton("Enviar solicitud");
		btnEnviarSolicitud.setBackground(Color.WHITE);
		btnEnviarSolicitud.setBounds(21, 365, 127, 25);
		btnEnviarSolicitud.setBorder(new LineBorder(new Color(0,0,0), 1));
		panel_datos.add(btnEnviarSolicitud);
		btnEnviarSolicitud.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inicio i= new Inicio();
				i.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBorder(new LineBorder(new Color(0,0,0), 1));
		btnCancelar.setBounds(200, 365, 129, 25);
		panel_datos.add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		labelMotivo = new JLabel("Motivo:");
		labelMotivo.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelMotivo.setIgnoreRepaint(true);
		labelMotivo.setBounds(21, 263, 86, 14);
		panel_datos.add(labelMotivo);
		
		textField_Motivo = new JTextField();
		textField_Motivo.setBounds(84, 261, 250, 20);
		textField_Motivo.setBorder(new LineBorder(new Color(0,0,0), 1));
		panel_datos.add(textField_Motivo);
		
		JLabel lblNewLabel = new JLabel("Fecha Salida:");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel.setBounds(21, 297, 99, 14);
		panel_datos.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Regreso:");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_1.setBounds(21, 331, 116, 17);
		panel_datos.add(lblNewLabel_1);
		
		fechaSalida = new JDateChooser();
		fechaSalida.setDateFormatString("dd/MM/yyyy");
		fechaSalida.setMinSelectableDate(new Date());
		fechaSalida.setBounds(127, 294, 207, 20);
		panel_datos.add(fechaSalida);
		
		fechaRegreso = new JDateChooser();
		fechaRegreso.setDateFormatString("dd/MM/yyyy");
		fechaRegreso.setBounds(137, 331, 197, 20);
		fechaRegreso.setMinSelectableDate(calendar.getTime());
		panel_datos.add(fechaRegreso);
	}
}
