package views.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import auth.Auth;
import controllers.ControladorPrincipal;
import models.gestion.estudiantes.Secretaria;
import models.usuarios.Estudiante;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import util.MotivoLicencia;
import util.MotivoBaja;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class SolicitudesEmpleados extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JPanel panelBaja;
	private JPanel panelLicencia;
	private JLabel lblMotivosLicencia;
	private JComboBox<String> cbMotivosLicencia;
	private JButton btnSolicitarLicencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitudesEmpleados frame = new SolicitudesEmpleados();
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
	public SolicitudesEmpleados() {
		
		
		
		
		setLayout(null);
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 944, 700);
		this.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		panelBaja = new JPanel();
		panelBaja.setBounds(509, 236, 407, 387);
		panelPrincipal.add(panelBaja);
		panelBaja.setBorder(new TitledBorder(null, "Solicitud de Baja", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelBaja.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(MotivoBaja.values()));
		comboBox.setBounds(159, 83, 201, 36);
		panelBaja.add(comboBox);
		
		JLabel label = new JLabel("Motivo :");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label.setBounds(43, 85, 90, 23);
		panelBaja.add(label);
		
		JButton btnSolicitarBaja = new JButton("Solicitar Baja");
		btnSolicitarBaja.setForeground(Color.WHITE);
		btnSolicitarBaja.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnSolicitarBaja.setBackground(new Color(72, 189, 133));
		btnSolicitarBaja.setBounds(106, 283, 223, 54);
		panelBaja.add(btnSolicitarBaja);
		
		panelLicencia = new JPanel();
		panelLicencia.setBorder(new TitledBorder(null, "Solicitud de Licencia", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelLicencia.setBounds(23, 236, 423, 387);
		panelLicencia.setLayout(null);
		panelPrincipal.add(panelLicencia);
		
		lblMotivosLicencia = new JLabel("Motivo :");
		lblMotivosLicencia.setBounds(53, 88, 90, 23);
		lblMotivosLicencia.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		panelLicencia.add(lblMotivosLicencia);
		
		cbMotivosLicencia = new JComboBox<String>();
		cbMotivosLicencia.setModel(new DefaultComboBoxModel(MotivoLicencia.values()));
		cbMotivosLicencia.setBounds(169, 86, 201, 36);
		panelLicencia.add(cbMotivosLicencia);
		
		btnSolicitarLicencia = new JButton("Solicitar Licencia");
		btnSolicitarLicencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Secretaria.gestorEstudiantes().getGestorSolicitudes().crearSolicitudLiciencia((MotivoLicencia)cbMotivosLicencia.getSelectedItem(), (Estudiante) Auth.usuarioAutenticado());
				ControladorPrincipal.mostrarRequisitosBajaEstudiantes();
			}
		});
		btnSolicitarLicencia.setBounds(88, 288, 223, 54);
		btnSolicitarLicencia.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnSolicitarLicencia.setForeground(new Color(255, 255, 255));
		btnSolicitarLicencia.setBackground(new Color(72, 189, 133));
		panelLicencia.add(btnSolicitarLicencia);
		
		JDateChooser dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dateChooser.setForeground(new Color(255, 255, 255));
		dateChooser.setBounds(169, 144, 201, 36);
		panelLicencia.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dateChooser_1.setForeground(new Color(255, 255, 255));
		dateChooser_1.setBounds(169, 217, 201, 36);
		panelLicencia.add(dateChooser_1);
		
		JLabel lblFechaSalida = new JLabel("Salida:");
		lblFechaSalida.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblFechaSalida.setBounds(53, 144, 90, 36);
		panelLicencia.add(lblFechaSalida);
		
		JLabel lblRegreso = new JLabel("Regreso :");
		lblRegreso.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblRegreso.setBounds(40, 217, 103, 36);
		panelLicencia.add(lblRegreso);
		
		JLabel lblTrmites = new JLabel("Tr\u00E1mites");
		lblTrmites.setForeground(Color.WHITE);
		lblTrmites.setFont(new Font("Segoe UI Semibold", Font.BOLD, 55));
		lblTrmites.setBounds(330, 87, 352, 67);
		panelPrincipal.add(lblTrmites);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SolicitudesEmpleados.class.getResource("/img/Accountc.png")));
		label_2.setBounds(706, 24, 51, 37);
		panelPrincipal.add(label_2);
		
		JLabel label_3 = new JLabel("Hola, Ruben");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		label_3.setBounds(756, 24, 176, 30);
		panelPrincipal.add(label_3);
		
		setBounds(178, 0, 944, 700);
		
	}
}
