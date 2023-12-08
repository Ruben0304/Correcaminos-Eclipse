package views.client;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;

public class InicioEstudianteJP extends JPanel{

	/**
	 * Create the panel.
	 */
	public InicioEstudianteJP() {
		setBounds(178, 0, 944, 700);
		
		setLayout(null);
		
		JLabel label_2 = new JLabel("Correcaminos");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 55));
		label_2.setBounds(280, 102, 352, 67);
		add(label_2);
		
		JLabel lblQuEs = new JLabel("\u00BF Como Solicitar Baja ?");
		lblQuEs.setForeground(Color.WHITE);
		lblQuEs.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		lblQuEs.setBounds(96, 250, 481, 67);
		add(lblQuEs);
		
		JTextArea txtrSuMotivoY = new JTextArea();
		txtrSuMotivoY.setEditable(false);
		txtrSuMotivoY.setText(" Su motivo y datos personales.\r\n\r\nEntrega de todos los materiales en las respectivas entidades: almac\u00E9n de libros, econom\u00EDa, seguridad inform\u00E1tica, secretar\u00EDa y direcci\u00F3n de becas en caso de estar becado.");
		txtrSuMotivoY.setLineWrap(true);
		txtrSuMotivoY.setBackground(new Color(30, 30, 30));
		txtrSuMotivoY.setForeground(Color.WHITE);
		txtrSuMotivoY.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		
		txtrSuMotivoY.setBounds(96, 317, 734, 126);
		add(txtrSuMotivoY);
		
		JLabel lblSolicitarLicencia = new JLabel("\u00BF Como Solicitar Licencia ?");
		lblSolicitarLicencia.setForeground(Color.WHITE);
		lblSolicitarLicencia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		lblSolicitarLicencia.setBounds(96, 446, 481, 67);
		add(lblSolicitarLicencia);
		
		JTextArea txtrEntregaDeTodos = new JTextArea();
		txtrEntregaDeTodos.setEditable(false);
		txtrEntregaDeTodos.setText("Entrega de todos los materiales en las respectivas entidades: almac\u00E9n de libros, econom\u00EDa, seguridad inform\u00E1tica, secretar\u00EDa y direcci\u00F3n de becas en caso de estar becado.");
		txtrEntregaDeTodos.setLineWrap(true);
		txtrEntregaDeTodos.setForeground(Color.WHITE);
		txtrEntregaDeTodos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		txtrEntregaDeTodos.setBackground(new Color(30, 30, 30));
		txtrEntregaDeTodos.setBounds(96, 514, 734, 110);
		add(txtrEntregaDeTodos);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(InicioEstudianteJP.class.getResource("/img/Accountc.png")));
		label_3.setBounds(706, 13, 51, 37);
		add(label_3);
		
		JLabel label_4 = new JLabel("Hola, Ruben");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		label_4.setBounds(756, 13, 176, 30);
		add(label_4);
	}
}
