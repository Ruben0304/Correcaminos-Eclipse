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


public class Estudiante extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_5;

	

	/**
	 * Create the frame.
	 */
	public Estudiante() {
		setResizable(false);
		setTitle("Datos Estudiante");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Estudiante.class.getResource("/img/correcamino.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Registre sus datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(299, 11, 347, 375);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel foto;
		foto = new JLabel("");
		foto.setBorder(null);
		foto.setBackground(new Color(204, 255, 204));
		foto.setFont(new Font("Brush Script MT", Font.PLAIN, 44));
		foto.setBounds(10, 11, 279, 367);
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
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_2.setBounds(24, 64, 114, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u00C1rea o Facultad");
		lblNewLabel_3.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_3.setBounds(24, 89, 86, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Carrera");
		lblNewLabel_4.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_4.setBounds(24, 117, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de curso");
		lblNewLabel_5.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_5.setBounds(24, 142, 86, 14);
		panel.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBackground(new Color(204, 255, 204));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField.setBounds(80, 17, 239, 14);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Curso");
		lblNewLabel_6.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_6.setBounds(24, 171, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("A\u00F1o");
		lblNewLabel_7.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_7.setBounds(24, 196, 46, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Grupo");
		lblNewLabel_8.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_8.setBounds(24, 221, 46, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tipo de estudiante");
		lblNewLabel_9.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_9.setBounds(24, 258, 98, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblCausaDeLa = new JLabel("Motivo de solicitud");
		lblCausaDeLa.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblCausaDeLa.setBounds(24, 286, 114, 14);
		panel.add(lblCausaDeLa);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(204, 255, 204));
		textField_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_5.setBounds(142, 283, 177, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
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
		errorMessage.setBounds(125, 350, 168, 14);
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
		btnEnviarSolicitud.setBounds(35, 318, 121, 31);
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
		btnCancelar.setBounds(191, 318, 121, 31);
		panel.add(btnCancelar);
		
		setLocationRelativeTo(null);
		
		
	}

	private void getColorFondo() {
		// TODO Auto-generated method stub
		
	}
}
