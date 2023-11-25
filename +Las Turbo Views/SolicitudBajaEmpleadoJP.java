package views;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SolicitudBajaEmpleadoJP extends JPanel {
	private JTextField textField;
	private JButton button;

	/**
	 * Create the panel.
	 */
	public SolicitudBajaEmpleadoJP() {
		setBounds(178, 0, 944, 700);
		setBackground(new Color(31, 33, 36));
		setLayout(null);
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setBounds(149, 33, 235, 41);
		lblDatosPersonales.setForeground(Color.WHITE);
		lblDatosPersonales.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		add(lblDatosPersonales);
		
		JLabel label = new JLabel("Nombre:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label.setBounds(445, 41, 93, 30);
		add(label);
		
		JLabel label_1 = new JLabel("Roy Hernandez");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_1.setBounds(557, 41, 375, 30);
		add(label_1);
		
		JLabel label_2 = new JLabel("DNI:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_2.setBounds(171, 114, 48, 30);
		add(label_2);
		
		JLabel label_3 = new JLabel("03081268111");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_3.setBounds(231, 114, 172, 30);
		add(label_3);
		
		JLabel label_4 = new JLabel("Grupo:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_4.setBounds(557, 104, 93, 30);
		add(label_4);
		
		JLabel label_5 = new JLabel("No Trabajador:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_5.setBounds(557, 226, 186, 30);
		add(label_5);
		
		JLabel label_6 = new JLabel("Encuentro");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_6.setBounds(739, 226, 156, 30);
		add(label_6);
		
		JLabel label_7 = new JLabel("Facultad:");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_7.setBounds(129, 170, 99, 30);
		add(label_7);
		
		JLabel label_8 = new JLabel("Informatica");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_8.setBounds(233, 170, 172, 30);
		add(label_8);
		
		JLabel label_9 = new JLabel("Curso:");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_9.setBounds(557, 160, 93, 30);
		add(label_9);
		
		JLabel label_10 = new JLabel("Nose");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_10.setBounds(643, 160, 93, 30);
		add(label_10);
		
		JLabel lblProfecionYOficio = new JLabel("Profecion y Oficio:");
		lblProfecionYOficio.setForeground(Color.WHITE);
		lblProfecionYOficio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		lblProfecionYOficio.setBounds(557, 283, 200, 30);
		add(lblProfecionYOficio);
		
		JLabel label_12 = new JLabel("Becado");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_12.setBounds(755, 283, 156, 30);
		add(label_12);
		
		JLabel label_13 = new JLabel("Carrera:");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_13.setBounds(140, 226, 93, 30);
		add(label_13);
		
		JLabel label_14 = new JLabel("NASCAR");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_14.setBounds(235, 226, 93, 30);
		add(label_14);
		
		JLabel label_15 = new JLabel("Motivo:");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_15.setBounds(129, 393, 81, 30);
		add(label_15);
		
		button = new JButton("Solicitar Baja");
		button.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		button.setEnabled(false);
		button.setBorder(new LineBorder(null, 1, true));
		button.setBackground(Color.WHITE);
		button.setBounds(374, 568, 164, 68);
		add(button);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField.getText().isEmpty()) && textField.getText() != null)
					button.setEnabled(true);
			}
		});
		textField.setColumns(10);
		textField.setBounds(222, 393, 591, 30);
		add(textField);
		
		
		
		
	}
}
