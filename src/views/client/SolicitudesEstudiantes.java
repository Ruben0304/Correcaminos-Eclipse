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

public class SolicitudesEstudiantes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JComboBox<String> cbMotivosBaja;
	private JLabel lblMotivoBajas;
	private JPanel panelBaja;
	private JPanel panelLicencia;
	private JLabel lblMotivosLicencia;
	private JComboBox<String> cbMotivosLicencia;
	private JButton btnSolicitarLicencia;
	private JButton btnCancelarLicencia;
	private JButton btnSolicitarBaja;
	private JButton btnCancelarBaja;

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
		
		FlatLaf.registerCustomDefaultsSource("app.themes");
		FlatMacDarkLaf.setup();
		UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,14));
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 450, 350);
		this.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		panelBaja = new JPanel();
		panelBaja.setBorder(new TitledBorder(null, "Solicitud de Baja", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelBaja.setBounds(53, 172, 328, 130);
		panelBaja.setLayout(null);
		panelPrincipal.add(panelBaja);
		
		
		lblMotivoBajas = new JLabel("Motivo :");
		lblMotivoBajas.setBounds(10, 47, 46, 14);
		lblMotivoBajas.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		panelBaja.add(lblMotivoBajas);
		
		cbMotivosBaja = new JComboBox<String>();
		cbMotivosBaja.setModel(new DefaultComboBoxModel(MotivoBaja.values()));
		cbMotivosBaja.setBounds(66, 44, 226, 23);
		
		panelBaja.add(cbMotivosBaja);
		
		btnSolicitarBaja = new JButton("Solicitar Baja");
		btnSolicitarBaja.setFont(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
		btnSolicitarBaja.setForeground(Color.BLACK);
		btnSolicitarBaja.setBounds(10, 96, 150, 23);
		btnSolicitarBaja.setBackground(new Color(72, 189, 133));
		panelBaja.add(btnSolicitarBaja);
	
		btnCancelarBaja = new JButton("Cancelar");
		btnCancelarBaja.setBounds(168, 96, 150, 23);
		btnCancelarBaja.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		btnCancelarBaja.setForeground(Color.BLACK);
		btnCancelarBaja.setBackground(new Color(212, 72, 72));
		panelBaja.add(btnCancelarBaja);
		
		panelLicencia = new JPanel();
		panelLicencia.setBorder(new TitledBorder(null, "Solicitud de Licencia", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelLicencia.setBounds(53, 24, 328, 130);
		panelLicencia.setLayout(null);
		panelPrincipal.add(panelLicencia);
		
		lblMotivosLicencia = new JLabel("Motivo :");
		lblMotivosLicencia.setBounds(10, 47, 59, 14);
		lblMotivosLicencia.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		panelLicencia.add(lblMotivosLicencia);
		
		cbMotivosLicencia = new JComboBox<String>();
		cbMotivosLicencia.setModel(new DefaultComboBoxModel(MotivoLicencia.values()));
		cbMotivosLicencia.setBounds(66, 44, 226, 23);
		panelLicencia.add(cbMotivosLicencia);
		
		btnSolicitarLicencia = new JButton("Solicitar Licencia");
		btnSolicitarLicencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Secretaria.gestorEstudiantes().getGestorSolicitudes().crearSolicitudLiciencia((MotivoLicencia)cbMotivosLicencia.getSelectedItem(), (Estudiante) Auth.usuarioAutenticado());
				ControladorPrincipal.mostrarRequisitosBajaEstudiantes();
			}
		});
		btnSolicitarLicencia.setBounds(10, 96, 150, 23);
		btnSolicitarLicencia.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		btnSolicitarLicencia.setForeground(Color.BLACK);
		btnSolicitarLicencia.setBackground(new Color(72, 189, 133));
		panelLicencia.add(btnSolicitarLicencia);
		
		btnCancelarLicencia = new JButton("Cancelar");
		btnCancelarLicencia.setBounds(168, 96, 150, 23);
		btnCancelarLicencia.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		btnCancelarLicencia.setForeground(Color.BLACK);
		btnCancelarLicencia.setBackground(new Color(212, 72, 72));
		panelLicencia.add(btnCancelarLicencia);
		
		setBounds(0, 0, 450, 350);
	    this.setLayout(null);
		
	}
}
