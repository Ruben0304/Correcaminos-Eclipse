package vistas.template;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.SwingConstants;

import autenticacion.Auth;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import controladores.ControladorLogin;
import controladores.ControladorPrincipal;
import vistas.componentes.Navegacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sesiones extends JDialog {
	private ButtonGroup buttonGroup;
	private JRadioButton rdbtnEconomia;
	private JRadioButton rdbtnContabilidad;
	private JRadioButton rdbtnSecretaria;
	private JRadioButton rdbtnRecusosHumanos;
	private JRadioButton rdbtnBiblioteca;
	private JRadioButton rdbtnAlmacenDeLibros;
	private JRadioButton rdbtnDirBecas;
	private JRadioButton rdbtnSeguridadInformtica;
	private JRadioButton rdbtnEstudiante;
	private JRadioButton rdbtnEmpleado;

	/**
	 * Create the dialog.
	 */
	public Sesiones() {
		setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		setTitle("Cambiar sesión");
		setBounds(100, 100, 292, 448);
		getContentPane().setLayout(null);
		getContentPane().add(getRdbtnEconomia());
		getContentPane().add(getRdbtnContabilidad());
		getContentPane().add(getRdbtnSecretaria());
		getContentPane().add(getRdbtnRecusosHumanos());
		getContentPane().add(getRdbtnBiblioteca());
		getContentPane().add(getRdbtnAlmacenDeLibros());
		getContentPane().add(getRdbtnDirBecas());
		getContentPane().add(getRdbtnSeguridadInformtica());
		getContentPane().add(getRdbtnEstudiante());
		getContentPane().add(getRdbtnEmpleado());
		
		getButtonGroup();
		
		FlatLaf.registerCustomDefaultsSource("app.themes");
		FlatMacDarkLaf.setup();

	}

	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(getRdbtnEconomia());
			buttonGroup.add(getRdbtnContabilidad());
			buttonGroup.add(getRdbtnSecretaria());
			buttonGroup.add(getRdbtnRecusosHumanos());
			buttonGroup.add(getRdbtnBiblioteca());
			buttonGroup.add(getRdbtnAlmacenDeLibros());
			buttonGroup.add(getRdbtnDirBecas());
			buttonGroup.add(getRdbtnSeguridadInformtica());
			buttonGroup.add(getRdbtnEstudiante());
			buttonGroup.add(getRdbtnEmpleado());
			
		}
		return buttonGroup;
	}

	private JRadioButton getRdbtnEconomia() {
		if (rdbtnEconomia == null) {
			rdbtnEconomia = new JRadioButton("Economía");
			rdbtnEconomia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
			rdbtnEconomia.setBounds(35, 83, 123, 25);
			rdbtnEconomia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorLogin.intentarAutenticar("Economia", "economia", true);
					Navegacion.reiniciar();
					ControladorPrincipal.mostrarInicio();
					
				}
			});
		}
		return rdbtnEconomia;
	}
	public JRadioButton getRdbtnContabilidad() {
		if (rdbtnContabilidad == null) {
			rdbtnContabilidad = new JRadioButton("Contabilidad");
			rdbtnContabilidad.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
			rdbtnContabilidad.setBounds(35, 122, 197, 25);
			rdbtnContabilidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorLogin.intentarAutenticar("Contabilidad", "contabilidad", true);
					Navegacion.reiniciar();
					ControladorPrincipal.mostrarInicio();
					
				}
			});
		}
		return rdbtnContabilidad;
	}
	public JRadioButton getRdbtnSecretaria() {
		if (rdbtnSecretaria == null) {
			rdbtnSecretaria = new JRadioButton("Secretaría");
			rdbtnSecretaria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorLogin.intentarAutenticar("Secretaria", "secretaria", true);
					Navegacion.reiniciar();
					ControladorPrincipal.mostrarInicio();
					
				}
			});
			rdbtnSecretaria.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
			rdbtnSecretaria.setBounds(35, 9, 197, 25);
		}
		return rdbtnSecretaria;
	}
	public JRadioButton getRdbtnRecusosHumanos() {
		if (rdbtnRecusosHumanos == null) {
			rdbtnRecusosHumanos = new JRadioButton("Recusos Humanos");
			rdbtnRecusosHumanos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
			rdbtnRecusosHumanos.setBounds(35, 45, 197, 25);
			rdbtnRecusosHumanos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorLogin.intentarAutenticar("RecursosHumanos", "recursoshumanos", true);
					Navegacion.reiniciar();
					ControladorPrincipal.mostrarInicio();
					
				}
			});
		}
		return rdbtnRecusosHumanos;
	}
	public JRadioButton getRdbtnBiblioteca() {
		if (rdbtnBiblioteca == null) {
			rdbtnBiblioteca = new JRadioButton("Biblioteca");
			rdbtnBiblioteca.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
			rdbtnBiblioteca.setBounds(35, 161, 197, 25);
			rdbtnBiblioteca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorLogin.intentarAutenticar("Biblioteca", "biblioteca", true);
					Navegacion.reiniciar();
					ControladorPrincipal.mostrarInicio();
					
				}
			});
		}
		return rdbtnBiblioteca;
	}
	public JRadioButton getRdbtnAlmacenDeLibros() {
		if (rdbtnAlmacenDeLibros == null) {
			rdbtnAlmacenDeLibros = new JRadioButton("Almacén de libros");
			rdbtnAlmacenDeLibros.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
			rdbtnAlmacenDeLibros.setBounds(35, 201, 197, 25);
			rdbtnAlmacenDeLibros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorLogin.intentarAutenticar("AlmacenLibros", "almacenlibros", true);
					Navegacion.reiniciar();
					ControladorPrincipal.mostrarInicio();
					
				}
			});
		}
		return rdbtnAlmacenDeLibros;
	}
	public JRadioButton getRdbtnDirBecas() {
		if (rdbtnDirBecas == null) {
			rdbtnDirBecas = new JRadioButton("Dirección Becas");
			rdbtnDirBecas.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
			rdbtnDirBecas.setBounds(35, 238, 197, 25);
			rdbtnDirBecas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorLogin.intentarAutenticar("DireccionBecas", "direccionbecas", true);
					Navegacion.reiniciar();
					ControladorPrincipal.mostrarInicio();
					
				}
			});
		}
		return rdbtnDirBecas;
	}
	public JRadioButton getRdbtnSeguridadInformtica() {
		if (rdbtnSeguridadInformtica == null) {
			rdbtnSeguridadInformtica = new JRadioButton("Seguridad Informática");
			rdbtnSeguridadInformtica.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
			rdbtnSeguridadInformtica.setBounds(35, 278, 197, 25);
			rdbtnSeguridadInformtica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorLogin.intentarAutenticar("SeguridadInformatica", "seguridadinformatica", true);
					Navegacion.reiniciar();
					ControladorPrincipal.mostrarInicio();
					
				}
			});
		}
		return rdbtnSeguridadInformtica;
	}
	public JRadioButton getRdbtnEstudiante() {
		if (rdbtnEstudiante == null) {
			rdbtnEstudiante = new JRadioButton("Estudiante1");
			rdbtnEstudiante.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
			rdbtnEstudiante.setBounds(35, 354, 197, 25);
			rdbtnEstudiante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorLogin.intentarAutenticar("estudiante1", "prueba", true);
					Navegacion.reiniciar();
					ControladorPrincipal.mostrarInicio();
					
				}
			});
		}
		return rdbtnEstudiante;
	}
	public JRadioButton getRdbtnEmpleado() {
		if (rdbtnEmpleado == null) {
			rdbtnEmpleado = new JRadioButton("Empleado1");
			rdbtnEmpleado.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
			rdbtnEmpleado.setBounds(35, 317, 197, 25);
			rdbtnEmpleado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorLogin.intentarAutenticar("empleado1", "prueba", true);
					Navegacion.reiniciar();
					ControladorPrincipal.mostrarInicio();
					
				}
			});
		}
		return rdbtnEmpleado;
	}
}
