package views.client;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SolicitudLicenciaEmpleadoJP extends JPanel {
	private JTextField textField;
	private JButton button;

	/**
	 * Create the panel.
	 */
	public SolicitudLicenciaEmpleadoJP() {
		setBounds(178, 0, 944, 700);
		setBackground(new Color(31, 33, 36));
		setLayout(null);
		
		JLabel label = new JLabel("Datos Personales");
		label.setBounds(149, 41, 235, 41);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		add(label);
		
		JLabel label_1 = new JLabel("Fecha de Regreso(Licencia):");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_1.setBounds(153, 498, 287, 30);
		add(label_1);
		
		JLabel label_2 = new JLabel("Fecha de Salida(Licencia):");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_2.setBounds(153, 441, 276, 30);
		add(label_2);
		
		button = new JButton("Solicitar Licencia");
		button.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		button.setEnabled(false);
		button.setBorder(new LineBorder(null, 1, true));
		button.setBackground(Color.WHITE);
		button.setBounds(352, 573, 186, 68);
		add(button);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField.getText().isEmpty()) && textField.getText() != null)
					button.setEnabled(true);
			}
		});
		textField.setColumns(10);
		textField.setBounds(246, 356, 591, 30);
		add(textField);
		
		JLabel label_3 = new JLabel("Motivo:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_3.setBounds(153, 356, 81, 30);
		add(label_3);
		
		JLabel label_4 = new JLabel("Carrera:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_4.setBounds(148, 211, 93, 30);
		add(label_4);
		
		JLabel label_5 = new JLabel("NASCAR");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_5.setBounds(243, 211, 93, 30);
		add(label_5);
		
		JLabel label_6 = new JLabel("Facultad:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_6.setBounds(137, 155, 99, 30);
		add(label_6);
		
		JLabel label_7 = new JLabel("Informatica");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_7.setBounds(241, 155, 172, 30);
		add(label_7);
		
		JLabel label_8 = new JLabel("DNI:");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_8.setBounds(179, 99, 48, 30);
		add(label_8);
		
		JLabel label_9 = new JLabel("03081268111");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_9.setBounds(239, 99, 172, 30);
		add(label_9);
		
		JLabel label_10 = new JLabel("Grupo:");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_10.setBounds(149, 272, 93, 30);
		add(label_10);
		
		JLabel label_11 = new JLabel("Curso:");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_11.setBounds(567, 99, 93, 30);
		add(label_11);
		
		JLabel label_12 = new JLabel("Nose");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_12.setBounds(653, 99, 93, 30);
		add(label_12);
		
		JLabel label_13 = new JLabel("Tocate");
		label_13.setToolTipText("");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_13.setBounds(235, 272, 93, 30);
		add(label_13);
		
		JLabel label_14 = new JLabel("No Trabajador:");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_14.setBounds(567, 165, 186, 30);
		add(label_14);
		
		JLabel label_15 = new JLabel("Profecion y Oficio");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_15.setBounds(567, 229, 200, 30);
		add(label_15);
		
		JLabel label_16 = new JLabel("Becado");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_16.setBounds(788, 229, 156, 30);
		add(label_16);
		
		JLabel label_17 = new JLabel("Encuentro");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_17.setBounds(774, 165, 156, 30);
		add(label_17);
		
		JLabel label_18 = new JLabel("Nombre:");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_18.setBounds(445, 44, 93, 30);
		add(label_18);
		
		JLabel label_19 = new JLabel("Roy Hernandez");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		label_19.setBounds(557, 44, 375, 30);
		add(label_19);
	}

}
