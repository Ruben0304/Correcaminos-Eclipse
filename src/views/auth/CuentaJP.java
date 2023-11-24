package views.auth;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import auth.Auth;
import models.usuarios.Admin;
import models.usuarios.Persona;
import views.Pricipal;

public class CuentaJP extends JPanel {
	private JLabel label_4;

	/**
	 * Create the panel.
	 */
	public CuentaJP() {
		setBounds(178, 0, 944, 700);
		setBackground(new Color(31, 33, 36));
		setLayout(null);

		JLabel label = new JLabel("Cuenta");
		label.setBounds(379, 42, 135, 41);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 34));
		add(label);

		JLabel label_1 = new JLabel("Usuario:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 32));
		label_1.setBounds(131, 213, 120, 30);
		add(label_1);

		JLabel label_2 = new JLabel(Auth.usuarioAutenticado().getNombreUsuario());
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 32));
		label_2.setBounds(273, 207, 375, 43);
		add(label_2);

		JLabel label_5 = new JLabel("");
		label_5.setBounds(510, 32, 46, 68);
		add(label_5);
		label_5.setIcon(new ImageIcon(Pricipal.class.getResource("/img/account.png")));

		JLabel label_6 = new JLabel("Rol:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 27));
		label_6.setBounds(200, 312, 51, 30);
		add(label_6);

		JLabel label_7 = new JLabel(Auth.usuarioAutenticado() instanceof Persona ? "Estudiante" : "Departamento");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Segoe UI Semibold", Font.BOLD, 27));
		label_7.setBounds(273, 312, 197, 30);
		add(label_7);

		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setForeground(Color.WHITE);
		btnCerrarSesin.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		btnCerrarSesin.setBorder(new LineBorder(null, 0));
		btnCerrarSesin.setBackground(new Color(42, 100, 56));
		btnCerrarSesin.setBounds(311, 542, 280, 68);
		add(btnCerrarSesin);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\+Roy+\\Apps\\Eclipse\\Views\\src\\img\\profile.png"));
		label_3.setBounds(796, 41, 107, 100);
		add(label_3);
		add(getLabel_4());
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("");

			label_4.setIcon(new ImageIcon(CuentaJP.class.getResource("/img/User.png")));
			
			label_4.setBounds(646, 140, 328, 269);
		}
		return label_4;
	}
}
