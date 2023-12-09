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

public class SolicitudesEstudiantes extends JPanel {
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
	private JButton btnSolicitarBaja;
	private JComboBox<String> cbMotivosBaja; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitudesEstudiantes frame = new SolicitudesEstudiantes();
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
	public SolicitudesEstudiantes() {
		
		
		
		
		setLayout(null);
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 944, 700);
		this.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		panelBaja = new JPanel();
		panelBaja.setBounds(509, 257, 407, 366);
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
		
		cbMotivosBaja = new JComboBox<String>();
		cbMotivosBaja.setModel(new DefaultComboBoxModel(MotivoBaja.values()));
		cbMotivosBaja.setBounds(66, 44, 226, 23);
		
		panelBaja.add(cbMotivosBaja);
		
		btnSolicitarBaja = new JButton("Solicitar Baja");
		btnSolicitarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Secretaria.gestorEstudiantes().getGestorSolicitudes().crearSolicitudBaja((MotivoBaja)cbMotivosBaja.getSelectedItem(), (Estudiante) Auth.usuarioAutenticado());
				ControladorPrincipal.mostrarRequisitosBajaEstudiantes();
			}
		});
		btnSolicitarBaja.setFont(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
		btnSolicitarBaja.setForeground(Color.BLACK);
		btnSolicitarBaja.setBounds(10, 96, 150, 23);
		btnSolicitarBaja.setBackground(new Color(72, 189, 133));
		btnSolicitarBaja.setBounds(107, 225, 223, 54);
		panelBaja.add(btnSolicitarBaja);
		
		panelLicencia = new JPanel();
		panelLicencia.setBorder(new TitledBorder(null, "Solicitud de Licencia", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelLicencia.setBounds(23, 257, 423, 366);
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
		btnSolicitarLicencia.setBounds(89, 227, 223, 54);
		btnSolicitarLicencia.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnSolicitarLicencia.setForeground(new Color(255, 255, 255));
		btnSolicitarLicencia.setBackground(new Color(72, 189, 133));
		panelLicencia.add(btnSolicitarLicencia);
		
		JLabel lblTrmites = new JLabel("Tr\u00E1mites");
		lblTrmites.setForeground(Color.WHITE);
		lblTrmites.setFont(new Font("Segoe UI Semibold", Font.BOLD, 55));
		lblTrmites.setBounds(330, 87, 352, 67);
		panelPrincipal.add(lblTrmites);
		
	
		
		setBounds(178, 0, 944, 700);
		
	}
}
