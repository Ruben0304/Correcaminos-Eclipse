package views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;


public class CuentaJP extends JPanel {

	/**
	 * Create the panel.
	 */
	public CuentaJP() {
		setBounds(178, 0, 944, 700);
		setBackground(new Color(31, 33, 36));
		setLayout(null);
		
		JLabel label = new JLabel("Cuenta");
		label.setBounds(149, 41, 98, 41);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		add(label);
		
		JLabel label_1 = new JLabel("Usuario:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 32));
		label_1.setBounds(125, 221, 120, 30);
		add(label_1);
		
		JLabel label_2 = new JLabel("Roy Hernandez");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 32));
		label_2.setBounds(261, 215, 375, 43);
		add(label_2);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(264, 51, 46, 30);
		add(label_5);
		label_5.setIcon(new ImageIcon(Principal.class.getResource("/img/account.png")));
		
		JLabel label_6 = new JLabel("Rol:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 27));
		label_6.setBounds(125, 285, 120, 30);
		add(label_6);
		
		JLabel label_7 = new JLabel("Estudiante");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Segoe UI Semibold", Font.BOLD, 27));
		label_7.setBounds(267, 285, 375, 30);
		add(label_7);
		
		JCheckBox chckbxB = new JCheckBox("Ha Solicitado Licencia");
		chckbxB.setForeground(Color.WHITE);
		chckbxB.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		chckbxB.setBackground(new Color(31, 33, 36));
		chckbxB.setBounds(125, 352, 282, 25);
		add(chckbxB);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setForeground(new Color(31, 33, 36));
		btnCerrarSesin.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		btnCerrarSesin.setBorder(new LineBorder(null, 0));
		btnCerrarSesin.setBackground(Color.WHITE);
		btnCerrarSesin.setBounds(311, 542, 280, 68);
		add(btnCerrarSesin);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\+Roy+\\Apps\\Eclipse\\Views\\src\\img\\profile.png"));
		label_3.setBounds(796, 41, 107, 100);
		add(label_3);
	}
}
