package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




import com.toedter.calendar.JDateChooser;

public class TramitesEmpleados {
	
	private JPanel panel;
	private JLabel lblDatosPersonalesEmpleado;
	private JLabel lblNombre;
	private JLabel lblPrimerApellido;
	private JLabel lblSegundoApellido;
	private JLabel lblCarnetDeIdentidad;
	private JLabel lblNotrabajador;
	private JLabel lblMotivoDeSolicitud;
	private JLabel lblFechaDeSalida;
	private JLabel lblFechaDeEntrada;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	 private static TramitesEmpleados instance = null;
	

	public TramitesEmpleados() {}
	
	 public static TramitesEmpleados getVista() {
	        if (instance == null) {
	            instance = new TramitesEmpleados();
	        }
	        return instance;
	    }

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(221, 11, 639, 521);
			panel.setLayout(null);
			panel.add(getLblDatosPersonalesEmpleado());
			panel.add(getLblNombre());
			panel.add(getLblPrimerApellido());
			panel.add(getLblSegundoApellido());
			panel.add(getLblCarnetDeIdentidad());
			panel.add(getLblNotrabajador());
			panel.add(getLblMotivoDeSolicitud());
			panel.add(getLblFechaDeSalida());
			panel.add(getLblFechaDeEntrada());
			panel.add(getTextField());
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
			panel.add(getBtnNewButton_2());
			panel.add(getDateChooser());
			panel.add(getDateChooser_1());
		}
		return panel;
	}
	private JLabel getLblDatosPersonalesEmpleado() {
		if (lblDatosPersonalesEmpleado == null) {
			lblDatosPersonalesEmpleado = new JLabel("Datos Personales Empleado");
			lblDatosPersonalesEmpleado.setForeground(Color.WHITE);
			lblDatosPersonalesEmpleado.setFont(new Font("Arial Narrow", Font.BOLD, 20));
			lblDatosPersonalesEmpleado.setBounds(229, 31, 220, 25);
		}
		return lblDatosPersonalesEmpleado;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			lblNombre.setBounds(58, 72, 154, 25);
		}
		return lblNombre;
	}
	private JLabel getLblPrimerApellido() {
		if (lblPrimerApellido == null) {
			lblPrimerApellido = new JLabel("Primer apellido:");
			lblPrimerApellido.setForeground(Color.WHITE);
			lblPrimerApellido.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			lblPrimerApellido.setBounds(58, 108, 145, 25);
		}
		return lblPrimerApellido;
	}
	private JLabel getLblSegundoApellido() {
		if (lblSegundoApellido == null) {
			lblSegundoApellido = new JLabel("Segundo apellido:");
			lblSegundoApellido.setForeground(Color.WHITE);
			lblSegundoApellido.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			lblSegundoApellido.setBounds(58, 144, 154, 35);
		}
		return lblSegundoApellido;
	}
	private JLabel getLblCarnetDeIdentidad() {
		if (lblCarnetDeIdentidad == null) {
			lblCarnetDeIdentidad = new JLabel("Carnet de identidad:");
			lblCarnetDeIdentidad.setForeground(Color.WHITE);
			lblCarnetDeIdentidad.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			lblCarnetDeIdentidad.setBounds(57, 190, 189, 25);
		}
		return lblCarnetDeIdentidad;
	}
	private JLabel getLblNotrabajador() {
		if (lblNotrabajador == null) {
			lblNotrabajador = new JLabel("No.trabajador:");
			lblNotrabajador.setForeground(Color.WHITE);
			lblNotrabajador.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			lblNotrabajador.setBounds(58, 226, 154, 28);
		}
		return lblNotrabajador;
	}
	private JLabel getLblMotivoDeSolicitud() {
		if (lblMotivoDeSolicitud == null) {
			lblMotivoDeSolicitud = new JLabel("Motivo de solicitud:");
			lblMotivoDeSolicitud.setForeground(Color.WHITE);
			lblMotivoDeSolicitud.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			lblMotivoDeSolicitud.setBounds(58, 265, 171, 25);
		}
		return lblMotivoDeSolicitud;
	}
	private JLabel getLblFechaDeSalida() {
		if (lblFechaDeSalida == null) {
			lblFechaDeSalida = new JLabel("Fecha de salida (Licencia):");
			lblFechaDeSalida.setForeground(Color.WHITE);
			lblFechaDeSalida.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			lblFechaDeSalida.setBounds(58, 309, 220, 25);
		}
		return lblFechaDeSalida;
	}
	private JLabel getLblFechaDeEntrada() {
		if (lblFechaDeEntrada == null) {
			lblFechaDeEntrada = new JLabel("Fecha de entrada (Licencia):");
			lblFechaDeEntrada.setForeground(Color.WHITE);
			lblFechaDeEntrada.setFont(new Font("Arial Narrow", Font.BOLD, 18));
			lblFechaDeEntrada.setBounds(58, 352, 220, 25);
		}
		return lblFechaDeEntrada;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Solicitar Baja");
			btnNewButton.setEnabled(false);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnNewButton.setBackground(new Color(42, 100, 56));
			btnNewButton.setBounds(57, 402, 205, 41);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!(textField.getText().isEmpty()) && textField.getText() !=null){
						btnNewButton.setEnabled(true);
					    btnNewButton_1.setEnabled(true);}
					else{
						btnNewButton.setEnabled(false);
				        btnNewButton_1.setEnabled(false);}
					
				}
			});
			
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Solicitar Licencia");
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!(textField.getText().isEmpty()) && textField.getText() !=null){
						btnNewButton.setEnabled(true);
					    btnNewButton_1.setEnabled(true);}
					else{
						btnNewButton.setEnabled(false);
				        btnNewButton_1.setEnabled(false);}
				}
			});
			btnNewButton_1.setEnabled(false);
			btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnNewButton_1.setBounds(424, 402, 205, 41);
			btnNewButton_1.setBackground(new Color(42, 100, 56));
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Cancelar");
			btnNewButton_2.setForeground(Color.WHITE);
			btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnNewButton_2.setBounds(281, 470, 145, 41);
			btnNewButton_2.setBackground(new Color(42, 100, 56));
		}
		return btnNewButton_2;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser("dd/MM/yyyy","##/##/####",'_'); 
			dateChooser.setBounds(251, 314, 101, 20);
		}
		return dateChooser;
	}
	private JDateChooser getDateChooser_1() {
		if (dateChooser_1 == null) {
			dateChooser_1 = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
			dateChooser_1.setBounds(261, 357, 91, 20);
		}
		return dateChooser_1;
	}
	
	
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!(textField.getText().isEmpty()) && textField.getText() !=null){
						btnNewButton.setEnabled(true);
					    btnNewButton_1.setEnabled(true);}
					else{
						btnNewButton.setEnabled(false);
				        btnNewButton_1.setEnabled(false);}
					
				}
			});
			textField.setBounds(215, 270, 375, 20);
			textField.setColumns(10);
		}
		return textField;
	}
}

	

	
	

	
	  


