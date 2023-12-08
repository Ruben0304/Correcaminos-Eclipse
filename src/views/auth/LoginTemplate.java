package views.auth;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;




import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import controllers.ControladorLogin;
import controllers.ControladorPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginTemplate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos de la clase
	 private JPanel pPrincipal, pIzquierda;
	 private ImageIcon iCerrar, iMinimizar, iFondo, iUsuario, iClave, iDimAux;
	 private JButton bEntrar,bCerrar;
	 private JTextField tNombreUsuario;
	 private JPasswordField tClaveUsuario;
	 private JLabel lEslogan, lTituloLogin, lFondo, lMantenerSesion, lUsuario, lClave;
	 private JCheckBox checkMantenerSesion;
	 private JTextField textField;
	 private JPasswordField passwordField;
	 private JPanel panel;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTemplate frame = new LoginTemplate();
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
	public LoginTemplate() {
		
		FlatRobotoFont.install();
		FlatLaf.registerCustomDefaultsSource("app.themes");
		UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		FlatMacDarkLaf.setup();
		
		UIManager.put( "Component.innerFocusWidth", 1 );
		UIManager.put( "Button.innerFocusWidth", 1 );
		
		crearImagenes();
		this.crearJPanels();
	    this.crearJTextFields();
	    this.crearJButtons();
	    this.crearJCheckBoxes();
	    this.crearJLabels();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	    setSize(400, 500);
	    setLocationRelativeTo(this);
	    setUndecorated(true);
	    
	    
	}
	
	private void crearImagenes() {
	    iCerrar = new ImageIcon(LoginTemplate.class.getResource("/img/cerrar_login_blanco.png"));
	    // iMinimizar = new ImageIcon(LoginTemplate.class.getResource("/img/minimizar.png"));
	    iFondo = new ImageIcon(LoginTemplate.class.getResource("/img/login.jpg"));
	    iUsuario = new ImageIcon(LoginTemplate.class.getResource("/img/user.png"));
	    iClave = new ImageIcon(LoginTemplate.class.getResource("/img/password1.png"));
	}
	
	public void crearJPanels() {
		
		pPrincipal = new JPanel();
		pPrincipal.setLocation(0, 0);
		pPrincipal.setSize(400, 500);
		pPrincipal.setLayout(null);
		//pDerecha.setBackground(Color.WHITE);
		getContentPane().add(pPrincipal);
		
		panel = new JPanel();
	    TitledBorder titulo = new TitledBorder(null, "Ingresar Datos", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE);
		titulo.setTitleFont( new Font(FlatRobotoFont.FAMILY,Font.PLAIN,16));
	    panel.setBorder(titulo);
		panel.setBounds(24, 91, 351, 345);
		pPrincipal.add(panel);
		panel.setLayout(null);
		
	}
	
	public void crearJButtons() {
		//Bot�n CERRAR
		iDimAux = new ImageIcon(
					iCerrar.getImage()
			        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
			    );
		bCerrar = new JButton();
		bCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon image = new ImageIcon(LoginTemplate.class.getResource("/img/cerrar_login_rojo.png"));
				iDimAux = new ImageIcon(
						image.getImage()
				        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
				    );
				bCerrar.setIcon(iDimAux);
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				iDimAux = new ImageIcon(
						iCerrar.getImage()
				        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
				    );
				bCerrar.setIcon(iDimAux);
			}
		});
		bCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		bCerrar.setLocation(350, 10);
		bCerrar.setSize(45, 30);
		bCerrar.setFocusable(false);
		bCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bCerrar.setIcon(new ImageIcon(LoginTemplate.class.getResource("/img/cerrar_login_blanco.png")));
		bCerrar.setContentAreaFilled(false);
		pPrincipal.add(bCerrar);	
		
		bEntrar = new JButton("Entrar");
		bEntrar.setBounds(66, 209, 234, 37);
		panel.add(bEntrar);
		bEntrar.setBackground(new Color(72, 189, 133));
		bEntrar.setForeground(Color.BLACK);
		bEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bEntrar.setContentAreaFilled(true);
		
	
		bEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] passwordChars = tClaveUsuario.getPassword();
				String contrasena = new String(passwordChars);
				String user = tNombreUsuario.getText();

				if (ControladorLogin.intentarAutenticar(user, contrasena, checkMantenerSesion.isSelected())) {
					ControladorPrincipal.mostrarInicio();
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	public void crearJLabels() {
		// Label TituloLogin
		lTituloLogin = new JLabel("Correcaminos");
		lTituloLogin.setBounds(100, 16, 185, 24);
		lTituloLogin.setFont(new Font(FlatRobotoFont.FAMILY_SEMIBOLD,Font.PLAIN,22));
		pPrincipal.add(lTituloLogin);
					
		iDimAux = new ImageIcon(
				iUsuario.getImage()
		        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
		    );
		lUsuario = new JLabel();
		lUsuario.setBounds(21, 64, 46, 38);
		lUsuario.setIcon(iDimAux);
		panel.add(lUsuario);
		
		iDimAux = new ImageIcon(
				iClave.getImage()
		        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
		    );
		lClave = new JLabel();
		lClave.setBounds(21, 141, 46, 40);
		lClave.setIcon(iDimAux);
		panel.add(lClave);
		
	
	}
	
	public void crearJTextFields() {
		tClaveUsuario = new JPasswordField();
		tClaveUsuario.setBounds(66, 141, 234, 40);
		tClaveUsuario.putClientProperty(FlatClientProperties.STYLE,"" +
				"showRevealButton:true");
		tClaveUsuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Introduzca su contrase�a");
		panel.add(tClaveUsuario);
		
		tNombreUsuario = new JTextField();
		tNombreUsuario.setBounds(66, 64, 234, 40);
		panel.add(tNombreUsuario);
		tNombreUsuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Introduzca su nombre de usuario");
		tNombreUsuario.putClientProperty(FlatClientProperties.STYLE,"" +
				"showClearButton:true");
	}
	
	public void crearJCheckBoxes() {
		
		checkMantenerSesion = new JCheckBox("Mantener sesi�n iniciada");
		checkMantenerSesion.setBounds(66, 260, 175, 25);
		panel.add(checkMantenerSesion);
	}
}
