package Vistas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;


public class CrearCuenta extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	/**
	 * @wbp.nonvisual location=-32,229
	 */
	private final Choice choice = new Choice();
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCuenta frame = new CrearCuenta();
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
	public CrearCuenta() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearCuenta.class.getResource("/img/correcamino.png")));
		setTitle("Crear cuenta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel lblCreaTuCuenta = new JLabel("Crea tu cuenta en CorrecaminosCujae");
		lblCreaTuCuenta.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblCreaTuCuenta.setBounds(339, 13, 289, 44);
		contentPane.add(lblCreaTuCuenta);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Reg\u00EDstrese como usuario de la app", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(339, 56, 296, 315);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 40, 120, 14);
		panel.add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Contrase\u00F1a");
		lblApellidos.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblApellidos.setBounds(10, 91, 107, 14);
		panel.add(lblApellidos);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(204, 255, 204));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(85, 81, 194, 24);
		panel.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(204, 255, 204));
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_1.setColumns(10);
		textField_1.setBounds(129, 34, 150, 20);
		panel.add(textField_1);
		
		JLabel fondo;
		fondo = new JLabel("");
		fondo.setBorder(null);
		fondo.setBackground(new Color(204, 255, 204));
		fondo.setFont(new Font("Brush Script MT", Font.PLAIN, 44));
		fondo.setBounds(10, 48, 319, 323);
		ImageIcon ico = new ImageIcon(getClass().getResource("/img/r.jpg")); 
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon((img));
		contentPane.add(fondo);
		
		final JLabel errorMessage = new JLabel("Por favor, aseg\u00FArese de no dejar campos vac\u00EDos");
		errorMessage.setVisible(false);
		errorMessage.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		errorMessage.setForeground(new Color(204, 0, 51));
		errorMessage.setBounds(17, 285, 269, 14);
		panel.add(errorMessage);
		
		JButton btnNewButton = new JButton("Crear cuenta");
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String email=textField_1.getText();
				
				String contrase�a=passwordField.getText();
				String verificar=passwordField.getText();
				
				if(email==null || email.isEmpty() || contrase�a.isEmpty()||contrase�a==null ||verificar.isEmpty()||verificar==null)
					errorMessage.setVisible(true);
				else{
					Inicio inicio = new Inicio();
					inicio.setVisible(true);
					dispose();
				}
				
				
			}
		});
		btnNewButton.setBounds(95, 244, 107, 30);
		panel.add(btnNewButton);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarContrasea.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblConfirmarContrasea.setBounds(10, 145, 137, 14);
		panel.add(lblConfirmarContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		passwordField_1.setBackground(new Color(204, 255, 204));
		passwordField_1.setBounds(146, 135, 133, 24);
		panel.add(passwordField_1);
		
		JLabel lblSeleccioneTipoDe = new JLabel("Seleccione tipo de usuario");
		lblSeleccioneTipoDe.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblSeleccioneTipoDe.setBounds(10, 191, 172, 24);
		panel.add(lblSeleccioneTipoDe);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(null);
		comboBox.setBackground(new Color(204, 255, 204));
		comboBox.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Estudiante", "Empleado", "Administrador"}));
		comboBox.setBounds(183, 194, 96, 20);
		panel.add(comboBox);
		
		
		
		JButton btnLogin = new JButton("Volver al Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaInicial p= new PantallaInicial();
				p.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBackground(new Color(204, 255, 204));
		btnLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLogin.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		btnLogin.setBounds(10, 13, 104, 32);
		contentPane.add(btnLogin);
	}
}
