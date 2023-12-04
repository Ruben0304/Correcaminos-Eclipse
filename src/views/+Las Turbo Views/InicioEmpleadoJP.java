package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InicioEmpleadoJP extends JPanel {

	/**
	 * Create the panel.
	 */
	public InicioEmpleadoJP() {
		setBounds(178, 0, 944, 700);
		setBackground(new Color(31, 33, 36));
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(57, 22, 33, 28);
		add(label);
		label.setIcon(new ImageIcon(Pricipal.class.getResource("/img/Back Arrow.png")));
		
		JLabel label_1 = new JLabel("Inicio");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_1.setBounds(96, 20, 89, 30);
		add(label_1);
		
		JLabel label_2 = new JLabel("Correcaminos");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 50));
		label_2.setBounds(299, 62, 352, 67);
		add(label_2);
		
		JLabel lblQuEs = new JLabel("\u00BF Como Solicitar Baja ?");
		lblQuEs.setForeground(Color.WHITE);
		lblQuEs.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		lblQuEs.setBounds(96, 250, 481, 67);
		add(lblQuEs);
		
		JTextArea txtrSuMotivoY = new JTextArea();
		txtrSuMotivoY.setText("\r\n Su motivo y datos personales.\r\n\r\nEntrega de todos los materiales en las respectivas entidades: biblioteca, seguridad inform\u00E1tica, recursos humanos y contabilidad");
		txtrSuMotivoY.setLineWrap(true);
		txtrSuMotivoY.setForeground(Color.WHITE);
		txtrSuMotivoY.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		txtrSuMotivoY.setBackground(new Color(31, 33, 36));
		txtrSuMotivoY.setBounds(96, 325, 734, 118);
		add(txtrSuMotivoY);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(813, 13, 40, 37);
		add(label_4);
		label_4.setIcon(new ImageIcon(Pricipal.class.getResource("/img/account.png")));
		
		JLabel label_5 = new JLabel("Entrar");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		label_5.setBounds(855, 13, 89, 30);
		add(label_5);
		
		JLabel lblEstuadiantes = new JLabel("Bienvenido Empleado");
		lblEstuadiantes.setForeground(Color.WHITE);
		lblEstuadiantes.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		lblEstuadiantes.setBounds(336, 129, 241, 30);
		add(lblEstuadiantes);
		
		JLabel lblSolicitarLicencia = new JLabel("\u00BF Como Solicitar Licencia ?");
		lblSolicitarLicencia.setForeground(Color.WHITE);
		lblSolicitarLicencia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		lblSolicitarLicencia.setBounds(96, 446, 481, 67);
		add(lblSolicitarLicencia);
		
		JTextArea txtrEntregaDeTodos = new JTextArea();
		txtrEntregaDeTodos.setText("Entrega de todos los materiales en las respectivas entidades: biblioteca, seguridad inform\u00E1tica, recursos humanos y contabilidad");
		txtrEntregaDeTodos.setLineWrap(true);
		txtrEntregaDeTodos.setForeground(Color.WHITE);
		txtrEntregaDeTodos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		txtrEntregaDeTodos.setBackground(new Color(31, 33, 36));
		txtrEntregaDeTodos.setBounds(96, 526, 734, 98);
		add(txtrEntregaDeTodos);
		
		JLabel lblCorrecaminoEsUna = new JLabel("Correcamino es una app para gestionar bajas y licencias universitarias");
		lblCorrecaminoEsUna.setForeground(Color.WHITE);
		lblCorrecaminoEsUna.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		lblCorrecaminoEsUna.setBounds(111, 181, 724, 30);
		add(lblCorrecaminoEsUna);
	}

}
