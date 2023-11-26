package views.old;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
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

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSolicitudBajaEmpleado extends JFrame {

	private JPanel contentPane;
	private JPanel panel_datos;
	private JTextField textField_NombreEmpleado;
	private JButton btnEnviarSolicitud;
	private JButton btnCancelar;
	private JLabel labelCarnetID;
	private JLabel labelSegundoApellido;
	private JLabel labelPrimer_apellido;
	private JLabel nombre_empleado;
	private JPanel panel_foto;
	private JLabel labelFoto;
	private JLabel labelMotivo;
	private JTextField textField_Motivo;

	
	/**
	 * Create the frame.
	 */
	public VentanaSolicitudBajaEmpleado() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaSolicitudBajaEmpleado.class.getResource("/img/correcamino.png")));
		setTitle("Llenar solicitud de baja");
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
		fondo.setBounds(10, 13, 278, 370);
		ImageIcon ico = new ImageIcon(getClass().getResource("/img/r.jpg")); 
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon((img));
		contentPane.add(fondo);
		
		panel_datos = new JPanel();
		panel_datos.setBounds(300, 13, 357, 405);
		contentPane.add(panel_datos);
		panel_datos.setBackground(new Color (204, 255, 204));
		panel_datos.setBorder(new TitledBorder(new LineBorder(Colores.NEGRO, 2), "Datos del empleado", TitledBorder.LEADING, TitledBorder.TOP, new Font("Roboto Medium", Font.PLAIN, 18), Colores.NEGRO));
		panel_datos.setLayout(null);
		
		nombre_empleado = new JLabel("Carnet de Identidad:");
		nombre_empleado.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		nombre_empleado.setBounds(21, 29, 116, 14);
		panel_datos.add(nombre_empleado);
		
		textField_NombreEmpleado = new JTextField();
		textField_NombreEmpleado.setBounds(151, 29, 177, 19);
		textField_NombreEmpleado.setBorder(new LineBorder(Colores.NEGRO, 1));
		panel_datos.add(textField_NombreEmpleado);
		textField_NombreEmpleado.setColumns(10);
		
		labelPrimer_apellido = new JLabel("Nombre:");
		labelPrimer_apellido.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelPrimer_apellido.setBounds(21, 65, 161, 19);
		panel_datos.add(labelPrimer_apellido);
		
		labelSegundoApellido = new JLabel("Primer Apellidos:");
		labelSegundoApellido.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelSegundoApellido.setBounds(21, 101, 177, 19);
		panel_datos.add(labelSegundoApellido);
		
		JLabel labelFacultad = new JLabel("Facultad:");
		labelFacultad.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelFacultad.setBounds(21, 169, 71, 14);
		panel_datos.add(labelFacultad);
		
		labelCarnetID = new JLabel("Segundo Apellido:");
		labelCarnetID.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelCarnetID.setBounds(21, 137, 177, 14);
		panel_datos.add(labelCarnetID);
		
		JLabel labelNoTrabajador = new JLabel("No. Trabajador:");
		labelNoTrabajador.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelNoTrabajador.setBounds(21, 200, 117, 17);
		panel_datos.add(labelNoTrabajador);
		
		JLabel labelProfesion = new JLabel("Profesi\u00F3n u oficio:");
		labelProfesion.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelProfesion.setBounds(21, 233, 142, 14);
		panel_datos.add(labelProfesion);
		
		btnEnviarSolicitud = new JButton("Enviar solicitud");
		btnEnviarSolicitud.setBackground(Colores.BLANCO);
		btnEnviarSolicitud.setBounds(21, 329, 127, 25);
		btnEnviarSolicitud.setBorder(new LineBorder(Colores.NEGRO, 1));
		panel_datos.add(btnEnviarSolicitud);
		btnEnviarSolicitud.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inicios i= new Inicios();
				i.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBackground(Colores.BLANCO);
		btnCancelar.setBorder(new LineBorder(Colores.NEGRO, 1));
		btnCancelar.setBounds(199, 329, 129, 25);
		panel_datos.add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		labelMotivo = new JLabel("Motivo:");
		labelMotivo.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		labelMotivo.setIgnoreRepaint(true);
		labelMotivo.setBounds(21, 267, 86, 14);
		panel_datos.add(labelMotivo);
		
		textField_Motivo = new JTextField();
		textField_Motivo.setBounds(84, 265, 244, 20);
		textField_Motivo.setBorder(new LineBorder(Colores.NEGRO, 1));
		panel_datos.add(textField_Motivo);
		textField_Motivo.setColumns(10);
		
		
		setLocationRelativeTo(null);
		

	}
}