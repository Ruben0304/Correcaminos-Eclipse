package views.usuarios;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import views.Pricipal;

public class RequisitosEstudiante {

	private JPanel panel_RequisitosEstud;
	private JLabel lblTitulo;
	private JLabel lblBiblioteca;
	private JLabel lblEntregadoTodosLos;
	private JLabel lblNewLabel;
	private JLabel lblDeudasPendientesSaldadas;
	private JLabel label_4;
	private JLabel lblEconomia;
	private JLabel lblDadoDeBaja;
	private JLabel label_5;
	private JLabel lblEntregadoDelCarnet;
	private JLabel label_6;
	private JLabel lblSecretaria;
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
	private static RequisitosEstudiante instance = null;

	private boolean tieneLibrosPrestados;
	private boolean tieneEstipendio;
	private boolean tieneDeuda;
	private boolean tieneLibrosDocentes;
	private boolean tieneCarnetDeEstudiante;
	private boolean tieneCuentaUsuarioAbierta;
	private boolean tienePertenenciasDeLaCUJAE;
	private boolean tieneCarnetDeBecado;

	private RequisitosEstudiante(boolean tieneLibrosPrestados, boolean tieneEstipendio,
			boolean tieneDeuda,
			boolean tieneLibrosDocentes, boolean tieneCarnetDeEstudiante, boolean tieneCuentaUsuarioAbierta,
			boolean tienePertenenciasDeLaCUJAE, boolean tieneCarnetDeBecado) {

		this.tieneLibrosPrestados = tieneLibrosPrestados;
		this.tieneEstipendio = tieneEstipendio;
		this.tieneDeuda = tieneDeuda;
		this.tieneLibrosDocentes = tieneLibrosDocentes;
		this.tieneCarnetDeEstudiante = tieneCarnetDeEstudiante;
		this.tieneCuentaUsuarioAbierta = tieneCuentaUsuarioAbierta;
		this.tienePertenenciasDeLaCUJAE = tienePertenenciasDeLaCUJAE;
		this.tieneCarnetDeBecado = tieneCarnetDeBecado;
		this.panel_RequisitosEstud = getPanel_RequisitosEstudBecado();
	}

	private RequisitosEstudiante(boolean tieneLibrosPrestados, boolean tieneEstipendio,
			boolean tieneDeuda,
			boolean tieneLibrosDocentes, boolean tieneCarnetDeEstudiante, boolean tieneCuentaUsuarioAbierta) {

		this.tieneLibrosPrestados = tieneLibrosPrestados;
		this.tieneEstipendio = tieneEstipendio;
		this.tieneDeuda = tieneDeuda;
		this.tieneLibrosDocentes = tieneLibrosDocentes;
		this.tieneCarnetDeEstudiante = tieneCarnetDeEstudiante;
		this.tieneCuentaUsuarioAbierta = tieneCuentaUsuarioAbierta;
		this.panel_RequisitosEstud = getPanel_RequisitosEstud();
	}

	// becado
	public static RequisitosEstudiante getVista(boolean tieneLibrosPrestados, boolean tieneEstipendio,
			boolean tieneDeuda,
			boolean tieneLibrosDocentes, boolean tieneCarnetDeEstudiante, boolean tieneCuentaUsuarioAbierta,
			boolean tienePertenenciasDeLaCUJAE, boolean tieneCarnetDeBecado) {

		return new RequisitosEstudiante(tieneLibrosPrestados, tieneEstipendio,
				tieneDeuda,
				tieneLibrosDocentes, tieneCarnetDeEstudiante, tieneCuentaUsuarioAbierta,
				tienePertenenciasDeLaCUJAE, tieneCarnetDeBecado);
	}

	// no becado

	public static RequisitosEstudiante getVista(boolean tieneLibrosPrestados, boolean tieneEstipendio,
			boolean tieneDeuda,
			boolean tieneLibrosDocentes, boolean tieneCarnetDeEstudiante, boolean tieneCuentaUsuarioAbierta) {

		return new RequisitosEstudiante(tieneLibrosPrestados, tieneEstipendio,
				tieneDeuda,
				tieneLibrosDocentes, tieneCarnetDeEstudiante, tieneCuentaUsuarioAbierta);
	}

	// Becado

	public JPanel getPanel_RequisitosEstudBecado() {
		if (panel_RequisitosEstud == null) {
			panel_RequisitosEstud = new JPanel();
			panel_RequisitosEstud.setBounds(178, 0, 944, 700);
			panel_RequisitosEstud.setLayout(null);
			panel_RequisitosEstud.setBackground(new Color(31, 33, 36));
			panel_RequisitosEstud.add(getLblTitulo());
			panel_RequisitosEstud.add(getLblBiblioteca());
			panel_RequisitosEstud.add(getLblEntregadoTodosLos());
			panel_RequisitosEstud.add(getLblNewLabel());
			panel_RequisitosEstud.add(getLabel_3_1());
			panel_RequisitosEstud.add(getLabel_4());
			panel_RequisitosEstud.add(getLblEconomia());
			panel_RequisitosEstud.add(getLabel_3_2());
			panel_RequisitosEstud.add(getLabel_5());
			panel_RequisitosEstud.add(getLabel_3_3());
			panel_RequisitosEstud.add(getLabel_6());
			panel_RequisitosEstud.add(getLblSecretaria());
			panel_RequisitosEstud.add(getLblSeguridadInformatica());
			panel_RequisitosEstud.add(getLabel_7_1());
			panel_RequisitosEstud.add(getLabel_8());
			panel_RequisitosEstud.add(getLblAlmacenDeLibros());
			panel_RequisitosEstud.add(getLabel_7());
			panel_RequisitosEstud.add(getLblEntregadoTodosLos_1());
			panel_RequisitosEstud.add(getLblGestionDeBeca());
			panel_RequisitosEstud.add(getLabel_11());
			panel_RequisitosEstud.add(getLblEntregadoCarnetDe());
			panel_RequisitosEstud.add(getLblEntregadasPertenencias());
			panel_RequisitosEstud.add(getLabel_15());

		}
		return panel_RequisitosEstud;
	}

	// No becado

	public JPanel getPanel_RequisitosEstud() {
		if (panel_RequisitosEstud == null) {
			panel_RequisitosEstud = new JPanel();
			panel_RequisitosEstud.setBounds(178, 0, 944, 700);
			panel_RequisitosEstud.setLayout(null);
			panel_RequisitosEstud.setBackground(new Color(31, 33, 36));
			panel_RequisitosEstud.add(getLblTitulo());
			panel_RequisitosEstud.add(getLblBiblioteca());
			panel_RequisitosEstud.add(getLblEntregadoTodosLos());
			panel_RequisitosEstud.add(getLblNewLabel());
			panel_RequisitosEstud.add(getLabel_3_1());
			panel_RequisitosEstud.add(getLabel_4());
			panel_RequisitosEstud.add(getLblEconomia());
			panel_RequisitosEstud.add(getLabel_3_2());
			panel_RequisitosEstud.add(getLabel_5());
			panel_RequisitosEstud.add(getLabel_3_3());
			panel_RequisitosEstud.add(getLabel_6());
			panel_RequisitosEstud.add(getLblSecretaria());
			panel_RequisitosEstud.add(getLblSeguridadInformatica());
			panel_RequisitosEstud.add(getLabel_7_1());
			panel_RequisitosEstud.add(getLabel_8());
			panel_RequisitosEstud.add(getLblAlmacenDeLibros());
			panel_RequisitosEstud.add(getLabel_7());
			panel_RequisitosEstud.add(getLblEntregadoTodosLos_1());

		}
		return panel_RequisitosEstud;
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
					Pricipal.class.getResource("/img/" + (tieneLibrosPrestados ? "Canceel.png" : "Checkmarkkk.png"))));
			lblNewLabel.setBounds(52, 221, 42, 35);
		}
		return lblNewLabel;
	}

	private JLabel getLabel_3_1() {
		if (lblDeudasPendientesSaldadas == null) {
			lblDeudasPendientesSaldadas = new JLabel("Deudas saldadas");
			lblDeudasPendientesSaldadas.setForeground(Color.WHITE);
			lblDeudasPendientesSaldadas.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			lblDeudasPendientesSaldadas.setBounds(89, 360, 144, 35);
		}
		return lblDeudasPendientesSaldadas;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon(
					Pricipal.class.getResource("/img/" + (tieneDeuda ? "Canceel.png" : "Checkmarkkk.png"))));
			label_4.setBounds(50, 368, 23, 21);
		}
		return label_4;
	}

	private JLabel getLblEconomia() {
		if (lblEconomia == null) {
			lblEconomia = new JLabel("Economia");
			lblEconomia.setForeground(Color.WHITE);
			lblEconomia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
			lblEconomia.setBounds(52, 307, 127, 54);
		}
		return lblEconomia;
	}

	private JLabel getLabel_3_2() {
		if (lblDadoDeBaja == null) {
			lblDadoDeBaja = new JLabel("Dado de baja en el estipendio");
			lblDadoDeBaja.setForeground(Color.WHITE);
			lblDadoDeBaja.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			lblDadoDeBaja.setBounds(89, 385, 332, 54);
		}
		return lblDadoDeBaja;
	}

	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon(
					Pricipal.class.getResource("/img/" + (tieneEstipendio ? "Canceel.png" : "Checkmarkkk.png"))));
			label_5.setBounds(52, 404, 20, 20);
		}
		return label_5;
	}

	private JLabel getLabel_3_3() {
		if (lblEntregadoDelCarnet == null) {
			lblEntregadoDelCarnet = new JLabel("Entregado el carnet de la CUJAE");
			lblEntregadoDelCarnet.setForeground(Color.WHITE);
			lblEntregadoDelCarnet.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			lblEntregadoDelCarnet.setBounds(89, 536, 322, 54);
		}
		return lblEntregadoDelCarnet;
	}

	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("");
			label_6.setIcon(new ImageIcon(Pricipal.class
					.getResource("/img/" + (tieneCarnetDeEstudiante ? "Canceel.png" : "Checkmarkkk.png"))));
			label_6.setBounds(52, 548, 31, 35);
		}
		return label_6;
	}

	private JLabel getLblSecretaria() {
		if (lblSecretaria == null) {
			lblSecretaria = new JLabel("Secretaria");
			lblSecretaria.setForeground(Color.WHITE);
			lblSecretaria.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
			lblSecretaria.setBounds(50, 485, 181, 54);
		}
		return lblSecretaria;
	}

	private JLabel getLblSeguridadInformatica() {
		if (lblSeguridadInformatica == null) {
			lblSeguridadInformatica = new JLabel("Seguridad Informatica");
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
					.getResource("/img/" + (tieneCuentaUsuarioAbierta ? "Canceel.png" : "Checkmarkkk.png"))));
			label_8.setBounds(478, 221, 31, 35);
		}
		return label_8;
	}

	private JLabel getLblAlmacenDeLibros() {
		if (lblAlmacenDeLibros == null) {
			lblAlmacenDeLibros = new JLabel("Almacen de libros");
			lblAlmacenDeLibros.setForeground(Color.WHITE);
			lblAlmacenDeLibros.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
			lblAlmacenDeLibros.setBounds(478, 307, 225, 54);
		}
		return lblAlmacenDeLibros;
	}

	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("");
			label_7.setIcon(new ImageIcon(
					Pricipal.class.getResource("/img/" + (tieneLibrosDocentes ? "Canceel.png" : "Checkmarkkk.png"))));
			label_7.setBounds(478, 361, 42, 35);
		}
		return label_7;
	}

	private JLabel getLblEntregadoTodosLos_1() {
		if (lblEntregadoTodosLos_1 == null) {
			lblEntregadoTodosLos_1 = new JLabel("Entregado todos los libros docentes");
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
					Pricipal.class.getResource("/img/" + (tieneCarnetDeBecado ? "Canceel.png" : "Checkmarkkk.png"))));
			label_11.setBounds(478, 546, 20, 20);
		}
		return label_11;
	}

	private JLabel getLblEntregadoCarnetDe() {
		if (lblEntregadoCarnetDe == null) {
			lblEntregadoCarnetDe = new JLabel("Entregado carnet de becado");
			lblEntregadoCarnetDe.setForeground(Color.WHITE);
			lblEntregadoCarnetDe.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			lblEntregadoCarnetDe.setBounds(515, 538, 285, 35);
		}
		return lblEntregadoCarnetDe;
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

	private JLabel getLabel_15() {
		if (label_15 == null) {
			label_15 = new JLabel("");
			label_15.setIcon(new ImageIcon(Pricipal.class
					.getResource("/img/" + (tienePertenenciasDeLaCUJAE ? "Canceel.png" : "Checkmarkkk.png"))));
			label_15.setBounds(478, 578, 42, 35);
		}
		return label_15;
	}
}
