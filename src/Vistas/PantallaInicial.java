
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;



public class PantallaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicial frame = new PantallaInicial();
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
	public PantallaInicial() {
		setType(Type.POPUP);
		setResizable(false);
		setFont(new Font("Arial Narrow", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaInicial.class.getResource("/img/correcamino.png")));
		setTitle("CorrecaminosCujae");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 433);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setBackground(new Color(102, 204, 102));
		contentPane.setForeground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(null);
		lblNewLabel.setBackground(new Color(204, 255, 204));
		lblNewLabel.setFont(new Font("Brush Script MT", Font.PLAIN, 44));
	    lblNewLabel.setBounds(0, 0, 373, 409);
		ImageIcon ico = new ImageIcon(getClass().getResource("img/img.jpg")); 
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon((img));
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(102, 204, 102));
		txtUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtUsuario.setBounds(441, 192, 179, 25);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasea = new JTextField();
		txtContrasea.setBackground(new Color(102, 204, 102));
		txtContrasea.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtContrasea.setBounds(441, 249, 179, 25);
		contentPane.add(txtContrasea);
		txtContrasea.setColumns(10);
		
		JButton btnNewButton = new JButton("Iniciar sesi\u00F3n");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = txtUsuario.getText();
				String contraseña = txtContrasea.getText();
				
			}
		});
		btnNewButton.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		btnNewButton.setBounds(458, 301, 118, 25);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("Crear cuenta");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(458, 373, 118, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblNewLabel_1.setBounds(483, 159, 60, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(0, 0, 0));
		lblContrasea.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblContrasea.setBounds(468, 218, 124, 35);
		contentPane.add(lblContrasea);
		
		JLabel lblInicioSesin = new JLabel("Inicio  Sesi\u00F3n");
		lblInicioSesin.setForeground(new Color(0, 0, 0));
		lblInicioSesin.setBackground(new Color(255, 255, 255));
		lblInicioSesin.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		lblInicioSesin.setBounds(446, 0, 130, 43);
		contentPane.add(lblInicioSesin);
		
		JLabel lblEsNuevoa = new JLabel("\u00BFEs nuevo(a)?");
		lblEsNuevoa.setForeground(new Color(0, 0, 0));
		lblEsNuevoa.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblEsNuevoa.setBounds(468, 348, 107, 25);
		contentPane.add(lblEsNuevoa);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_2.setBounds(383, 171, 48, 43);
		ImageIcon icono = new ImageIcon(getClass().getResource("img/usuario.jpg")); 
		ImageIcon imga = new ImageIcon(icono.getImage().getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_2.setIcon((imga));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(442, 36, 134, 123);
		ImageIcon icon = new ImageIcon(getClass().getResource("img/correcamino.png")); 
		ImageIcon imgan = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_3.setIcon((imgan));
		contentPane.add(lblNewLabel_3);
		
		JLabel ErrorMessages = new JLabel("Datos err\u00F3neos, intente nuevamente");
		ErrorMessages.setForeground(new Color(204, 51, 0));
		ErrorMessages.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		ErrorMessages.setBounds(416, 274, 204, 25);
		contentPane.add(ErrorMessages);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4.setBounds(383, 225, 48, 43);
		ImageIcon iconito = new ImageIcon(getClass().getResource("img/contrasena.jpg")); 
		ImageIcon imgen = new ImageIcon(iconito.getImage().getScaledInstance(lblNewLabel_4.getWidth(), lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_4.setIcon((imgen));
		contentPane.add(lblNewLabel_4);
		
		
	}
}
