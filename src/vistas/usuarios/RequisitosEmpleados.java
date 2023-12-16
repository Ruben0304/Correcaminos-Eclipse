package vistas.usuarios;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import autenticacion.Auth;
import controladores.ControladorPrincipal;
import modelos.gestion.GestorDepartamentos;
import modelos.usuarios.Becado;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;
import util.ResponsabilidadesTrabajador;
import util.TiposResponsabilidad;
import vistas.template.Pricipal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RequisitosEmpleados extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel panel_RequisitosEmpl;
	private JLabel lblTitulo;
	private JLabel lblBiblioteca;
	private JLabel lblEntregadoTodosLos;
	private JLabel lblNewLabel;
	private JLabel label_4;
	private JLabel lblEconomia;
	private JLabel lblDadoDeBaja;
	private JLabel label_5;
	private JLabel lblEntregadoDelCarnet;
	private JLabel label_6;
	private JLabel lblSeguridadInformatica;
	private JLabel lblCerradaCuentaUsuario;
	private JLabel label_8;
	private JLabel lblAlmacenDeLibros;
	private JLabel label_7;
	private JLabel lblEntregadoTodosLos_1;
	private JLabel lblGestionDeBeca;
	private JLabel label_11;
	private JLabel lblEntregadoCarnetDe;
	private JLabel lblEntregadasPertenencias;
	private JLabel label_15;
	private HashMap<ResponsabilidadesTrabajador, Boolean> requisitos;
	private JLabel lblVerRestante;
	private JLabel lblVerRestantes;
	private JButton button;

	private RequisitosEmpleados(HashMap<ResponsabilidadesTrabajador, Boolean> requisitos) {

		this.requisitos = requisitos;
		this.panel_RequisitosEmpl = getPanel_RequisitosEmpleados();
	}

	public static RequisitosEmpleados getVista(HashMap<ResponsabilidadesTrabajador, Boolean> requisitos) {

		return new RequisitosEmpleados(requisitos);
	}

	public JPanel getPanel_RequisitosEmpleados() {
		if (panel_RequisitosEmpl == null) {
			panel_RequisitosEmpl = new JPanel();
			panel_RequisitosEmpl.setBounds(178, 0, 944, 700);
			panel_RequisitosEmpl.setLayout(null);
			panel_RequisitosEmpl.add(getLblTitulo());
			panel_RequisitosEmpl.add(getLblBiblioteca());
			panel_RequisitosEmpl.add(getLblEntregadoTodosLos());
			panel_RequisitosEmpl.add(getLblNewLabel());
			panel_RequisitosEmpl.add(getLblEconomia());
			panel_RequisitosEmpl.add(getLabel_3_2());
			panel_RequisitosEmpl.add(getLabel_5());
			panel_RequisitosEmpl.add(getLabel_3_3());
			panel_RequisitosEmpl.add(getLabel_6());
			panel_RequisitosEmpl.add(getLblSeguridadInformatica());
			panel_RequisitosEmpl.add(getLabel_7_1());
			panel_RequisitosEmpl.add(getLabel_8());
			panel_RequisitosEmpl.add(getLblAlmacenDeLibros());
			panel_RequisitosEmpl.add(getLabel_7());
			panel_RequisitosEmpl.add(getLblEntregadoTodosLos_1());
			panel_RequisitosEmpl.add(getButton());
			if (requisitos.get(ResponsabilidadesTrabajador.DEUDA)) {
				panel_RequisitosEmpl.add(getLblVerRestante());
			}
			
			if (requisitos.get(ResponsabilidadesTrabajador.LIBROS_BIBLIOTECA)) {
				panel_RequisitosEmpl.add(getLabel_1());
			}
			

		}
		return panel_RequisitosEmpl;
	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Requisitos");
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 40));
			lblTitulo.setBounds(295, 65, 225, 54);

		}
		return lblTitulo;
	}

	private JLabel getLblBiblioteca() {
		if (lblBiblioteca == null) {
			lblBiblioteca = new JLabel("Biblioteca");
			lblBiblioteca.setForeground(Color.WHITE);
			lblBiblioteca.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
			lblBiblioteca.setBounds(52, 167, 181, 54);
		}
		return lblBiblioteca;
	}

	private JLabel getLblEntregadoTodosLos() {
		if (lblEntregadoTodosLos == null) {
			lblEntregadoTodosLos = new JLabel("Entregado todos los libros prestados");
			lblEntregadoTodosLos.setForeground(Color.WHITE);
			lblEntregadoTodosLos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			lblEntregadoTodosLos.setBounds(89, 209, 322, 54);
		}
		return lblEntregadoTodosLos;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(
					Pricipal.class.getResource(
							"/img/" + (requisitos.get(ResponsabilidadesTrabajador.LIBROS_BIBLIOTECA) ? "Canceel.png"
									: "Checkmarkkk.png"))));
			lblNewLabel.setBounds(52, 221, 42, 35);
		}
		return lblNewLabel;
	}

	// private JLabel getLabel_4() {
	// if (label_4 == null) {
	// label_4 = new JLabel("");
	// label_4.setIcon(new ImageIcon(
	// Pricipal.class
	// .getResource("/img/" + (requisitos.get(ResponsabilidadesTrabajador.DEUDA) ?
	// "Canceel.png" : "Checkmarkkk.png"))));
	// label_4.setBounds(50, 368, 23, 21);
	// }
	// return label_4;
	// }

	private JLabel getLblEconomia() {
		if (lblEconomia == null) {
			lblEconomia = new JLabel("Contabilidad");
			lblEconomia.setForeground(Color.WHITE);
			lblEconomia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
			lblEconomia.setBounds(52, 307, 238, 54);
		}
		return lblEconomia;
	}

	private JLabel getLabel_3_2() {
		if (lblDadoDeBaja == null) {
			lblDadoDeBaja = new JLabel("Deuda saldada");
			lblDadoDeBaja.setForeground(Color.WHITE);
			lblDadoDeBaja.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			lblDadoDeBaja.setBounds(89, 361, 332, 54);
		}
		return lblDadoDeBaja;
	}

	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon(
					Pricipal.class.getResource(
							"/img/" + (requisitos.get(ResponsabilidadesTrabajador.DEUDA) ? "Canceel.png"
									: "Checkmarkkk.png"))));
			label_5.setBounds(52, 376, 20, 20);
		}
		return label_5;
	}

	private JLabel getLabel_3_3() {
		if (lblEntregadoDelCarnet == null) {
			lblEntregadoDelCarnet = new JLabel("Entregado el carnet de la CUJAE");
			lblEntregadoDelCarnet.setForeground(Color.WHITE);
			lblEntregadoDelCarnet.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			lblEntregadoDelCarnet.setBounds(515, 400, 322, 54);
		}
		return lblEntregadoDelCarnet;
	}

	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("");
			label_6.setIcon(new ImageIcon(Pricipal.class
					.getResource(
							"/img/Canceel.png")));
			label_6.setBounds(478, 412, 31, 35);
		}
		return label_6;
	}

	private JLabel getLblSeguridadInformatica() {
		if (lblSeguridadInformatica == null) {
			lblSeguridadInformatica = new JLabel("Seguridad Informática");
			lblSeguridadInformatica.setForeground(Color.WHITE);
			lblSeguridadInformatica.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
			lblSeguridadInformatica.setBounds(478, 167, 310, 54);
		}
		return lblSeguridadInformatica;
	}

	private JLabel getLabel_7_1() {
		if (lblCerradaCuentaUsuario == null) {
			lblCerradaCuentaUsuario = new JLabel("Cerrada cuenta de usuario de la CUJAE");
			lblCerradaCuentaUsuario.setForeground(Color.WHITE);
			lblCerradaCuentaUsuario.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			lblCerradaCuentaUsuario.setBounds(515, 209, 405, 54);
		}
		return lblCerradaCuentaUsuario;
	}

	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("");
			label_8.setIcon(new ImageIcon(Pricipal.class
					.getResource(
							"/img/" + (requisitos.get(ResponsabilidadesTrabajador.CUENTA_USUARIO) ? "Canceel.png"
									: "Checkmarkkk.png"))));
			label_8.setBounds(478, 221, 31, 35);
		}
		return label_8;
	}

	private JLabel getLblAlmacenDeLibros() {
		if (lblAlmacenDeLibros == null) {
			lblAlmacenDeLibros = new JLabel("Recursos Humanos");
			lblAlmacenDeLibros.setForeground(Color.WHITE);
			lblAlmacenDeLibros.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
			lblAlmacenDeLibros.setBounds(478, 307, 271, 54);
		}
		return lblAlmacenDeLibros;
	}

	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("");
			label_7.setIcon(new ImageIcon(
					Pricipal.class.getResource(
							"/img/" + (requisitos.get(ResponsabilidadesTrabajador.SALARIO_INDEBIDO) ? "Canceel.png"
									: "Checkmarkkk.png"))));
			label_7.setBounds(478, 361, 42, 35);
		}
		return label_7;
	}

	private JLabel getLblEntregadoTodosLos_1() {
		if (lblEntregadoTodosLos_1 == null) {
			lblEntregadoTodosLos_1 = new JLabel("No posee salario indebido\r\n");
			lblEntregadoTodosLos_1.setForeground(Color.WHITE);
			lblEntregadoTodosLos_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			lblEntregadoTodosLos_1.setBounds(515, 349, 322, 54);
		}
		return lblEntregadoTodosLos_1;
	}

	private JLabel getLblGestionDeBeca() {
		if (lblGestionDeBeca == null) {
			lblGestionDeBeca = new JLabel("Gestion de beca");
			lblGestionDeBeca.setForeground(Color.WHITE);
			lblGestionDeBeca.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
			lblGestionDeBeca.setBounds(478, 485, 199, 54);
		}
		return lblGestionDeBeca;
	}

	private JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel("");
			label_11.setIcon(new ImageIcon(
					Pricipal.class.getResource("/img/"
							+ (requisitos.get(TiposResponsabilidad.PERTENENCIAS_BECA) ? "Canceel.png"
									: "Checkmarkkk.png"))));
			label_11.setBounds(478, 546, 20, 20);
		}
		return label_11;
	}

	private JLabel getLblEntregadasPertenencias() {
		if (lblEntregadasPertenencias == null) {
			lblEntregadasPertenencias = new JLabel("Entregadas pertenencias");
			lblEntregadasPertenencias.setForeground(Color.WHITE);
			lblEntregadasPertenencias.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			lblEntregadasPertenencias.setBounds(515, 566, 322, 54);
		}
		return lblEntregadasPertenencias;
	}

	private JLabel getLblVerRestante() {
		if (lblVerRestante == null) {
			lblVerRestante = new JLabel("Ver Restante");
			lblVerRestante.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {

					JOptionPane.showMessageDialog(null,
							GestorDepartamentos.gestorDepartamentos().getContabilidad().obtenerDeudaEmpleado(
									((Estudiante) Auth.usuarioAutenticado()).getCi()),
							"Deudas Pendientes",
							JOptionPane.INFORMATION_MESSAGE);

				}
			});
			lblVerRestante.setForeground(new Color(152, 251, 152));
			lblVerRestante.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
			lblVerRestante.setBounds(99, 411, 225, 35);
		}
		return lblVerRestante;
	}
   
	private JLabel getLabel_1() {
		if (lblVerRestantes == null) {
			lblVerRestantes = new JLabel("Ver Restantes");
			lblVerRestantes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					for (String s : GestorDepartamentos.gestorDepartamentos().getBiblioteca()
							.obtenerDeudas(((Empleado) Auth.usuarioAutenticado()).getCi())) {
						JOptionPane.showMessageDialog(null, s, "Deudas Pendientes",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			lblVerRestantes.setForeground(new Color(152, 251, 152));
			lblVerRestantes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
			lblVerRestantes.setBounds(99, 259, 225, 35);
		}
		return lblVerRestantes;
	}
	public JButton getButton() {
		if (button == null) {
			button = new JButton("Solicitar cancelación de trámite");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ControladorPrincipal.solicitarCancelacion();
				}
			});
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			button.setBackground(new Color(221, 78, 94));
			button.setBounds(295, 589, 332, 54);
		}
		return button;
	}
}
