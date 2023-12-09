package vistas.usuarios;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import util.MotivoLicencia;
import util.MotivoBaja;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import autenticacion.Auth;
import controladores.ControladorPrincipal;
import modelos.gestion.empleados.GestorEmpleados;
import modelos.gestion.estudiantes.Secretaria;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;

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
	private JDateChooser fechaSalida ;
	private JDateChooser fechaRegreso ;
	private JComboBox<String> cbMotivosBaja;

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
		
		cbMotivosBaja = new JComboBox<String>();
		cbMotivosBaja.setModel(new DefaultComboBoxModel(MotivoBaja.values()));
		cbMotivosBaja.setBounds(159, 83, 201, 36);
		panelBaja.add(cbMotivosBaja);
		
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
		btnSolicitarLicencia.setBounds(88, 288, 223, 54);
		btnSolicitarLicencia.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnSolicitarLicencia.setForeground(new Color(255, 255, 255));
		btnSolicitarLicencia.setBackground(new Color(72, 189, 133));
		panelLicencia.add(btnSolicitarLicencia);
		
		fechaSalida = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		fechaSalida.setForeground(new Color(255, 255, 255));
		fechaSalida.setBounds(169, 144, 201, 36);
		panelLicencia.add(fechaSalida);
		
		fechaRegreso = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		fechaRegreso.setForeground(new Color(255, 255, 255));
		fechaRegreso.setBounds(169, 217, 201, 36);
		panelLicencia.add(fechaRegreso);
		
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
	
		
		setBounds(178, 0, 944, 700);
		




		
		
		
		
		
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

		btnSolicitarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados().crearSolicitudBaja((MotivoBaja)cbMotivosBaja.getSelectedItem(), (Empleado) Auth.usuarioAutenticado());
				ControladorPrincipal.mostrarRequisitosEmpleados();
			}
		});
	}
}
