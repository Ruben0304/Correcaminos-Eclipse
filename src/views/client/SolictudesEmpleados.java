package views.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.toedter.calendar.JDateChooser;

import auth.Auth;
import controllers.ControladorPrincipal;
import models.gestion.empleados.GestorEmpleados;
import models.gestion.estudiantes.Secretaria;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;

import javax.swing.DefaultComboBoxModel;
import util.MotivoBaja;
import util.MotivoLicencia;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;;;
public class SolictudesEmpleados extends JPanel {

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
	private JButton btnSolicitarBaja;
	private JButton btnCancelarLicencia;
	private JButton btnSolicitarLicencia;
	private JButton btnCancelarBaja;
	private JDateChooser fechaSalida, fechaRegreso;
	private JLabel lblFechaDeSalida;
	private JLabel lblFechaDeRegreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolictudesEmpleados frame = new SolictudesEmpleados();
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
	public SolictudesEmpleados() {
		
		FlatLaf.registerCustomDefaultsSource("app.themes");
		FlatMacDarkLaf.setup();
		UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,14));
			
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 434, 461);
		this.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		panelBaja = new JPanel();
		panelBaja.setBorder(new TitledBorder(null, "Solicitud de Licencia", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelBaja.setBounds(42, 185, 345, 200);
		panelBaja.setLayout(null);
		panelPrincipal.add(panelBaja);
		
		
		lblMotivoBajas = new JLabel("Motivo :");
		lblMotivoBajas.setBounds(10, 37, 46, 14);
		lblMotivoBajas.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		panelBaja.add(lblMotivoBajas);
		
		cbMotivosBaja = new JComboBox<String>();
		cbMotivosBaja.setModel(new DefaultComboBoxModel(MotivoBaja.values()));
		cbMotivosBaja.setBounds(59, 34, 259, 23);
		
		panelBaja.add(cbMotivosBaja);
		
		btnSolicitarLicencia = new JButton("Solicitar Licencia");
		btnSolicitarLicencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Calendar fs = fechaSalida.getCalendar();
				Calendar fr = fechaRegreso.getCalendar();
				
				if (fs != null && fr != null) {
					GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados().crearSolicitudLicencia((MotivoLicencia)cbMotivosLicencia.getSelectedItem(), (Empleado) Auth.usuarioAutenticado(),fs,fr);
					JOptionPane.showMessageDialog(null, "Su solicitud está siendo procesada", "Estado de Trámite", JOptionPane.INFORMATION_MESSAGE);
					ControladorPrincipal.mostrarInicio();
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha de salida y una de regreso", "Fechas Vacías", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSolicitarLicencia.setFont(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
		btnSolicitarLicencia.setForeground(Color.BLACK);
		btnSolicitarLicencia.setBounds(10, 166, 150, 23);
		btnSolicitarLicencia.setBackground(new Color(72, 189, 133));
		panelBaja.add(btnSolicitarLicencia);
	
		btnCancelarBaja = new JButton("Cancelar");
		btnCancelarBaja.setBounds(185, 166, 150, 23);
		btnCancelarBaja.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		btnCancelarBaja.setForeground(Color.BLACK);
		btnCancelarBaja.setBackground(new Color(212, 72, 72));
		panelBaja.add(btnCancelarBaja);
		
		lblFechaDeSalida = new JLabel("Fecha de Salida :");
		lblFechaDeSalida.setBounds(10, 82, 130, 14);
		lblFechaDeSalida.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		panelBaja.add(lblFechaDeSalida);
		
		lblFechaDeRegreso = new JLabel("Fecha de Regreso :");
		lblFechaDeRegreso.setBounds(10, 123, 130, 17);
		lblFechaDeRegreso.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		panelBaja.add(lblFechaDeRegreso);
		

		fechaSalida = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		fechaSalida.setBounds(140, 76, 178, 27);
		
		fechaRegreso = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		fechaRegreso.setBounds(140, 117, 178, 27);
		fechaRegreso.setEnabled(false);
		
		// Crea un objeto Calendar y establece la fecha actual
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        // Suma 7 d�as a la fecha actual
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        
        // Establece la fecha resultante como la fecha m�nima seleccionable
		fechaSalida.setMinSelectableDate(calendar.getTime());
		
		fechaSalida.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
		    @Override
		    public void propertyChange(PropertyChangeEvent evt) {
		    	
		    	System.out.println(evt.getPropertyName());
		    	if ("date".equals(evt.getPropertyName())){
		    		
		    		Date d = (Date) evt.getNewValue();
		    		Calendar c = Calendar.getInstance();
		    		c.setTime(d);
			    	
		    		fechaRegreso.setEnabled(true);
			    	c.add(Calendar.DAY_OF_MONTH, 3);
			    	fechaRegreso.setMinSelectableDate(c.getTime());
			    	
			    	c.add(Calendar.DAY_OF_MONTH, 90);
			    	fechaRegreso.setMaxSelectableDate(c.getTime());
		    	}
		    	
		    }
		});
		
		
		for (Component c : fechaSalida.getComponents()) {
		    ((JComponent) c).setBackground(new Color(227, 226, 226));
		}
		for (Component c : fechaRegreso.getComponents()) {
		    ((JComponent) c).setBackground(new Color(227, 226, 226));
		}
		
		
		panelBaja.add(fechaRegreso);
		panelBaja.add(fechaSalida);
		
		panelLicencia = new JPanel();
		panelLicencia.setBorder(new TitledBorder(null, "Solicitud de Baja", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelLicencia.setBounds(40, 20, 345, 110);
		panelLicencia.setLayout(null);
		panelPrincipal.add(panelLicencia);
		
		lblMotivosLicencia = new JLabel("Motivo :");
		lblMotivosLicencia.setBounds(10, 31, 59, 14);
		lblMotivosLicencia.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		panelLicencia.add(lblMotivosLicencia);
		
		cbMotivosLicencia = new JComboBox<String>();
		cbMotivosLicencia.setModel(new DefaultComboBoxModel(MotivoLicencia.values()));
		cbMotivosLicencia.setBounds(59, 28, 259, 23);
		panelLicencia.add(cbMotivosLicencia);
		
		btnSolicitarBaja = new JButton("Solicitar Baja");
		btnSolicitarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados().crearSolicitudBaja((MotivoBaja)cbMotivosBaja.getSelectedItem(), (Empleado) Auth.usuarioAutenticado());
				ControladorPrincipal.mostrarRequisitosEmpleados();
			}
		});
		btnSolicitarBaja.setBounds(15, 76, 150, 23);
		btnSolicitarBaja.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		btnSolicitarBaja.setForeground(Color.BLACK);
		btnSolicitarBaja.setBackground(new Color(72, 189, 133));
		panelLicencia.add(btnSolicitarBaja);
		
		btnCancelarLicencia = new JButton("Cancelar");
		btnCancelarLicencia.setBounds(185, 76, 150, 23);
		btnCancelarLicencia.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		btnCancelarLicencia.setForeground(Color.BLACK);
		btnCancelarLicencia.setBackground(new Color(212, 72, 72));
		panelLicencia.add(btnCancelarLicencia);
		
		setBounds(0, 0, 434, 461);
		this.setLayout(null);
	}
}
