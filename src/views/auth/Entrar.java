package views.auth;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controllers.ControladorLogin;
import controllers.ControladorPrincipal;
import models.usuarios.Usuario;
import views.layouts.Pricipal;

import java.awt.Color;




import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Entrar {
    private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel label_3;
	private JLabel lblContrasea;
	private JPasswordField textField_1;
	private JButton button;
	private JCheckBox checkBox;
    private static Entrar instance = null;

    private Entrar() {}

    
    
    public static Entrar getVista() {
        if (instance == null) {
            instance = new Entrar();
        }
        return instance;
    }

    public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(31, 33, 36));
			panel.setBounds(70, 0, 1052, 700);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getTextField());
			panel.add(getLabel_3());
			panel.add(getLblContrasea());
			panel.add(getTextField_1());
			panel.add(getButton());
			panel.add(getCheckBox());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Pricipal.class.getResource("/img/User.png")));
			lblNewLabel.setBounds(446, 59, 107, 137);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setSelectionColor(new Color(143, 188, 143));
			textField.setForeground(Color.WHITE);
			textField.setColumns(10);
			textField.setBorder(new LineBorder(new Color(240, 255, 240), 1, true));
			textField.setBackground(new Color(40, 42, 46));
			textField.setBounds(343, 287, 332, 48);
		}
		return textField;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Usuario");
			label_3.setForeground(Color.WHITE);
			label_3.setFont(new Font("Arial Narrow", Font.BOLD, 24));
			label_3.setBounds(460, 239, 93, 48);
		}
		return label_3;
	}
	private JLabel getLblContrasea() {
		if (lblContrasea == null) {
			lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setForeground(Color.WHITE);
			lblContrasea.setFont(new Font("Arial Narrow", Font.BOLD, 24));
			lblContrasea.setBounds(446, 371, 135, 48);
		}
		return lblContrasea;
	}
	private JPasswordField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JPasswordField();
			textField_1.setSelectionColor(new Color(143, 188, 143));
			textField_1.setForeground(Color.WHITE);
			textField_1.setColumns(10);
			textField_1.setBorder(new LineBorder(new Color(240, 255, 240), 1, true));
			textField_1.setBackground(new Color(40, 42, 46));
			textField_1.setBounds(343, 420, 332, 48);
		}
		return textField_1;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Iniciar sesi\u00F3n");
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
			button.setBorder(null);
			button.setBackground(new Color(42, 100, 56));
			button.setBounds(422, 571, 182, 48);
			button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] passwordChars = getTextField_1().getPassword();
				String contrasena = new String(passwordChars);
				String user = getTextField().getText();

				if (ControladorLogin.intentarAutenticar(user, contrasena, getCheckBox().isSelected())) {
					ControladorPrincipal.mostrarInicio();
				} else {
					JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		}
		return button;
	}
	private JCheckBox getCheckBox() {
		if (checkBox == null) {
			checkBox = new JCheckBox("Mantener sesion");
			checkBox.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
			checkBox.setForeground(new Color(255, 255, 255));
			checkBox.setBackground(new Color(31, 33, 36));
			checkBox.setBounds(446, 513, 135, 24);
		}
		return checkBox;
	}
}
