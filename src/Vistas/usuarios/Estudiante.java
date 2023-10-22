package vistas.usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.border.MatteBorder;

import vistas.Inicio;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;


public class Estudiante extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	

	/**
	 * Create the frame.
	 */
	public Estudiante() {
		setResizable(false);
		setTitle("Datos Estudiante");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Estudiante.class.getResource("/img/correcamino.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Registre sus datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(299, 11, 428, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel foto;
		foto = new JLabel("");
		foto.setBorder(null);
		foto.setBackground(new Color(204, 255, 204));
		foto.setFont(new Font("Brush Script MT", Font.PLAIN, 44));
		foto.setBounds(10, 11, 279, 432);
		ImageIcon ico = new ImageIcon(getClass().getResource("/img/est.jpg")); 
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH));
		foto.setIcon((img));
		contentPane.add(foto);
		
		JLabel lblNewLabel = new JLabel("Ci");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel.setBounds(24, 17, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_1.setBounds(24, 39, 55, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u00C1rea o Facultad");
		lblNewLabel_3.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_3.setBounds(24, 66, 86, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Carrera");
		lblNewLabel_4.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_4.setBounds(24, 94, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de curso");
		lblNewLabel_5.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_5.setBounds(24, 119, 86, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Curso");
		lblNewLabel_6.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_6.setBounds(24, 148, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Grupo");
		lblNewLabel_8.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_8.setBounds(24, 175, 46, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tipo de estudiante");
		lblNewLabel_9.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_9.setBounds(25, 202, 98, 14);
		panel.add(lblNewLabel_9);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Colores.BLANCO);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSalir = new JMenuItem("Salir de la aplicaci\u00F3n");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JMenuItem mntmInicio = new JMenuItem("Cancelar y volver a Inicio");
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inicio inicio = new Inicio();
				inicio.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmInicio);
		mnNewMenu.add(mntmSalir);
		
		JMenu mnNewMenu_3 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmAcercaDeLa = new JMenuItem("Acerca de la app");
		mnNewMenu_3.add(mntmAcercaDeLa);
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/imagenes/img.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
				
			}
		};
		
		final JLabel errorMessage = new JLabel("Existen campos vac\u00EDos");
		errorMessage.setVisible(false);
		errorMessage.setForeground(new Color(204, 0, 0));
		errorMessage.setBounds(158, 405, 168, 14);
		panel.add(errorMessage);
		
		JButton btnEnviarSolicitud = new JButton("Solicitar Baja");
		btnEnviarSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = textField.getText();
				
				String motivo = textField_5.getText();
				
				if(nombre==null|| nombre.isEmpty() || motivo.isEmpty()||motivo==null)
					errorMessage.setVisible(true);
				else{
					Baja b=new Baja();
					b.setVisible(true);
					dispose();
					
				}
					
			}
		});
		btnEnviarSolicitud.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEnviarSolicitud.setBackground(SystemColor.inactiveCaptionBorder);
		btnEnviarSolicitud.setBounds(88, 373, 121, 31);
		panel.add(btnEnviarSolicitud);
		
		JButton btnCancelar = new JButton("Solicitar licencia");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = textField.getText();
				
				String motivo = textField_5.getText();
				
				if(nombre==null|| nombre.isEmpty()  || motivo.isEmpty()||motivo==null)
					errorMessage.setVisible(true);
				else{
					
				}
				
			}
		});
		btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCancelar.setBounds(244, 373, 121, 31);
		panel.add(btnCancelar);
		
		JLabel label = new JLabel("Motivo:");
		label.setIgnoreRepaint(true);
		label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		label.setBounds(24, 244, 86, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(__WBP_NO_TYPE_BINDING.NEGRO, 1));
		textField.setBounds(87, 242, 309, 20);
		panel.add(textField);
		
		JLabel lblFechaSalidalicencia = new JLabel("Fecha Salida (licencia) :");
		lblFechaSalidalicencia.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblFechaSalidalicencia.setBounds(24, 291, 173, 14);
		panel.add(lblFechaSalidalicencia);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(209, 285, 187, 20);
		panel.add(dateChooser);
		
		JLabel lblFechaRegresolicencia = new JLabel("Fecha Regreso (licencia) :");
		lblFechaRegresolicencia.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblFechaRegresolicencia.setBounds(24, 325, 187, 17);
		panel.add(lblFechaRegresolicencia);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBounds(209, 322, 187, 20);
		panel.add(dateChooser_1);
		
		setLocationRelativeTo(null);
		
		
	}

	private void getColorFondo() {
		// TODO Auto-generated method stub
		
	}
}
