package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SolicitudBajaEmpleado {
	
	
	private JPanel panel;
	private JLabel lblCarnetDeIdentidad;
	private JLabel lblNombre;
	private JLabel lblPrimerApellido;
	private JLabel lblSegundoApellido;
	private JLabel lblNotrabajador;
	private JLabel lblMotivoDeSolicitud;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblExistenCamposVacos;
	private JLabel lblDatosPersonalesEmpleados;
	private static SolicitudBajaEmpleado instance = null;
	private JLabel lblNewLabel;

	
	
	public static SolicitudBajaEmpleado getVista() {
        if (instance == null) {
            instance = new SolicitudBajaEmpleado();
        }
        return instance;
    }
	
	  public JPanel getPanel() {
			if (panel == null) {
				panel = new JPanel();
				panel.setBackground(new Color(31, 33, 36));
				panel.setBounds(70, 0, 1052, 700);
				panel.setLayout(null);
				panel.add(getLblCarnetDeIdentidad());
				panel.add(getLblNombre());
				panel.add(getLblPrimerApellido());
				panel.add(getLblSegundoApellido());
				panel.add(getLblNotrabajador());
				panel.add(getLblMotivoDeSolicitud());
				panel.add(getTextField());
				panel.add(getBtnNewButton() );
				panel.add(getBtnNewButton_1());
				panel.add(getLblExistenCamposVacos());
				panel.add(getLblDatosPersonalesEmpleados());
			}
			return panel;
		}
	
			
	private JLabel getLblCarnetDeIdentidad() {
		if (lblCarnetDeIdentidad == null) {
			lblCarnetDeIdentidad = new JLabel("Carnet de Identidad:");
			lblCarnetDeIdentidad.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			lblCarnetDeIdentidad.setForeground(Color.WHITE);
			lblCarnetDeIdentidad.setBounds(50, 55, 290, 23);
		}
		return lblCarnetDeIdentidad;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setBounds(50, 104, 289, 30);
		}
		return lblNombre;
	}
	private JLabel getLblPrimerApellido() {
		if (lblPrimerApellido == null) {
			lblPrimerApellido = new JLabel("Primer Apellido:");
			lblPrimerApellido.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			lblPrimerApellido.setForeground(Color.WHITE);
			lblPrimerApellido.setBounds(51, 163, 289, 23);
		}
		return lblPrimerApellido;
	}
	private JLabel getLblSegundoApellido() {
		if (lblSegundoApellido == null) {
			lblSegundoApellido = new JLabel("Segundo Apellido:");
			lblSegundoApellido.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			lblSegundoApellido.setForeground(Color.WHITE);
			lblSegundoApellido.setBounds(50, 213, 290, 41);
		}
		return lblSegundoApellido;
	}
	private JLabel getLblNotrabajador() {
		if (lblNotrabajador == null) {
			lblNotrabajador = new JLabel("No.Trabajador");
			lblNotrabajador.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			lblNotrabajador.setForeground(Color.WHITE);
			lblNotrabajador.setBounds(50, 265, 289, 30);
		}
		return lblNotrabajador;
	}
	private JLabel getLblMotivoDeSolicitud() {
		if (lblMotivoDeSolicitud == null) {
			lblMotivoDeSolicitud = new JLabel("Motivo de solicitud de baja:");
			lblMotivoDeSolicitud.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			lblMotivoDeSolicitud.setForeground(Color.WHITE);
			lblMotivoDeSolicitud.setBounds(50, 319, 290, 30);
		}
		return lblMotivoDeSolicitud;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(316, 319, 296, 27);
			textField.setColumns(10);
		}
		return textField;
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Solicitar Baja");
			btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			btnNewButton.setEnabled(false);
			btnNewButton.setBackground(new Color(42, 100, 56));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textField!=null && !textField.getText().isEmpty())
						btnNewButton.setEnabled(true);
					else
						lblExistenCamposVacos.setVisible(true);
					
						
				}
			});
			btnNewButton.setBounds(75, 427, 170, 41);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Cancelar");
			btnNewButton_1.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			btnNewButton_1.setBounds(442, 427, 170, 41);
			btnNewButton_1.setBackground(new Color(42, 100, 56));
		}
		return btnNewButton_1;
	}
	private JLabel getLblExistenCamposVacos() {
		if (lblExistenCamposVacos == null) {
			lblExistenCamposVacos = new JLabel("Existen campos vac\u00EDos");
			lblExistenCamposVacos.setVisible(false);
			lblExistenCamposVacos.setForeground(new Color(220, 20, 60));
			lblExistenCamposVacos.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			lblExistenCamposVacos.setBounds(240, 486, 290, 30);
		}
		return lblExistenCamposVacos;
	}
	
	private JLabel getLblDatosPersonalesEmpleados() {
		if (lblDatosPersonalesEmpleados == null) {
			lblDatosPersonalesEmpleados = new JLabel("Datos Personales Empleados");
			lblDatosPersonalesEmpleados.setForeground(Color.WHITE);
			lblDatosPersonalesEmpleados.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblDatosPersonalesEmpleados.setBounds(215, 36, 344, 23);
		}
		return lblDatosPersonalesEmpleados;
	}

	

}
