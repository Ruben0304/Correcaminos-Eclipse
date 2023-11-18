package views;

//import javax.swing.ImageIcon;

import javafx.scene.layout.Region;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//import controllers.ControladorLogin;
//import controllers.ControladorPruebas;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaSolicitudLicenciaEmpleado{
	private JPanel panel_lateral;
    private JLabel label_3;
	private JLabel lblInicio;
    private static VentanaSolicitudLicenciaEmpleado instance = null;
    private JTextField textFieldMotivo;
    private JLabel lblExistenCamposVacios;
    private JButton btnSolicitarBaja;
    private JLabel lblNombre;
    private JLabel label;
    private JLabel lblFacultad;
    private JLabel lblCarrera;
    private JLabel lblGrupo;
    private JLabel lblCurso;
    private JLabel lblTipoDeCurso;
    private JLabel lblTipoDeEstudiante;
    private JLabel lblGetFacultad;
    private JLabel lblRoyHernandez;
    private JLabel label_2;
    private JLabel lblGetCarrera;
    private JLabel lblGetGroup;
    private JLabel lblGetCurso;
    private JLabel lblGetTipoDeCurso;
    private JLabel lblGetTipoDeEstudiante;

    
    private VentanaSolicitudLicenciaEmpleado() {}
    
    public static VentanaSolicitudLicenciaEmpleado getVista() {
        if (instance == null) {
            instance = new VentanaSolicitudLicenciaEmpleado();
        }
        return instance;
    }

	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel getPanel_lateral() {
		if (panel_lateral == null) {
			panel_lateral = new JPanel();
			panel_lateral.setAlignmentX(Component.LEFT_ALIGNMENT);
			panel_lateral.setBackground(new Color(31, 33, 36));
			panel_lateral.setBounds(70, 0, 1052, 700);
			panel_lateral.setLayout(null);
			panel_lateral.add(getLabel_3());
			panel_lateral.add(getLblInicio());
			
			textFieldMotivo = new JTextField();
			textFieldMotivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!(textFieldMotivo.getText().isEmpty()) && textFieldMotivo.getText() != null){
						btnSolicitarBaja.setEnabled(true);
					}
				}
			});
			textFieldMotivo.setBounds(217, 356, 591, 30);
			panel_lateral.add(textFieldMotivo);
			textFieldMotivo.setColumns(10);
			
			JLabel lblMotivo = new JLabel("Motivo:");
			lblMotivo.setForeground(Color.WHITE);
			lblMotivo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblMotivo.setBounds(124, 356, 81, 30);
			panel_lateral.add(lblMotivo);
			
			JLabel lblFechaDeSalida = new JLabel("Fecha de Salida(Licencia):");
			lblFechaDeSalida.setForeground(Color.WHITE);
			lblFechaDeSalida.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblFechaDeSalida.setBounds(123, 431, 276, 30);
			panel_lateral.add(lblFechaDeSalida);
			
			lblExistenCamposVacios = new JLabel("Existen campos vacios !");
			lblExistenCamposVacios.setVisible(false);
			lblExistenCamposVacios.setForeground(Color.RED);
			lblExistenCamposVacios.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblExistenCamposVacios.setBounds(364, 657, 257, 30);
			panel_lateral.add(lblExistenCamposVacios);
			
			lblNombre = new JLabel("DNI:");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblNombre.setBounds(165, 122, 48, 30);
			panel_lateral.add(lblNombre);
			
			label = new JLabel("Nombre:");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			label.setBounds(553, 44, 93, 30);
			panel_lateral.add(label);
			
			lblFacultad = new JLabel("Facultad:");
			lblFacultad.setForeground(Color.WHITE);
			lblFacultad.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblFacultad.setBounds(123, 178, 99, 30);
			panel_lateral.add(lblFacultad);
			
			lblCarrera = new JLabel("Carrera:");
			lblCarrera.setForeground(Color.WHITE);
			lblCarrera.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblCarrera.setBounds(134, 234, 93, 30);
			panel_lateral.add(lblCarrera);
			
			lblGrupo = new JLabel("Grupo:");
			lblGrupo.setForeground(Color.WHITE);
			lblGrupo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblGrupo.setBounds(418, 122, 93, 30);
			panel_lateral.add(lblGrupo);
			
			lblCurso = new JLabel("Curso:");
			lblCurso.setForeground(Color.WHITE);
			lblCurso.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblCurso.setBounds(418, 178, 93, 30);
			panel_lateral.add(lblCurso);
			
			lblTipoDeCurso = new JLabel("No Trabajador:");
			lblTipoDeCurso.setForeground(Color.WHITE);
			lblTipoDeCurso.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblTipoDeCurso.setBounds(665, 122, 186, 30);
			panel_lateral.add(lblTipoDeCurso);
			
			lblTipoDeEstudiante = new JLabel("Profecion y Oficio");
			lblTipoDeEstudiante.setForeground(Color.WHITE);
			lblTipoDeEstudiante.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblTipoDeEstudiante.setBounds(651, 178, 200, 30);
			panel_lateral.add(lblTipoDeEstudiante);
			
			//Carga los datos del Backend
			
			lblGetFacultad = new JLabel("Informatica");
			lblGetFacultad.setForeground(Color.WHITE);
			lblGetFacultad.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblGetFacultad.setBounds(227, 178, 172, 30);
			panel_lateral.add(lblGetFacultad);
			
			lblRoyHernandez = new JLabel("Roy Hernandez");
			lblRoyHernandez.setForeground(Color.WHITE);
			lblRoyHernandez.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblRoyHernandez.setBounds(665, 44, 375, 30);
			panel_lateral.add(lblRoyHernandez);
			
			label_2 = new JLabel("03081268111");
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			label_2.setBounds(225, 122, 172, 30);
			panel_lateral.add(label_2);
			
			lblGetCarrera = new JLabel("NASCAR");
			lblGetCarrera.setForeground(Color.WHITE);
			lblGetCarrera.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblGetCarrera.setBounds(229, 234, 93, 30);
			panel_lateral.add(lblGetCarrera);
			
			lblGetGroup = new JLabel("Tocate");
			lblGetGroup.setToolTipText("");
			lblGetGroup.setForeground(Color.WHITE);
			lblGetGroup.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblGetGroup.setBounds(504, 122, 93, 30);
			panel_lateral.add(lblGetGroup);
			
			lblGetCurso = new JLabel("Nose");
			lblGetCurso.setForeground(Color.WHITE);
			lblGetCurso.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblGetCurso.setBounds(504, 178, 93, 30);
			panel_lateral.add(lblGetCurso);
			
			lblGetTipoDeCurso = new JLabel("Encuentro");
			lblGetTipoDeCurso.setForeground(Color.WHITE);
			lblGetTipoDeCurso.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblGetTipoDeCurso.setBounds(872, 122, 156, 30);
			panel_lateral.add(lblGetTipoDeCurso);
			
			lblGetTipoDeEstudiante = new JLabel("Becado");
			lblGetTipoDeEstudiante.setForeground(Color.WHITE);
			lblGetTipoDeEstudiante.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblGetTipoDeEstudiante.setBounds(872, 178, 156, 30);
			panel_lateral.add(lblGetTipoDeEstudiante);
			
			btnSolicitarBaja = new JButton("Solicitar Licencia");
			btnSolicitarBaja.setEnabled(false);
			btnSolicitarBaja.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			btnSolicitarBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnSolicitarBaja.setBorder(new LineBorder(null, 1, true));
			btnSolicitarBaja.setBackground(Color.WHITE);
			btnSolicitarBaja.setBounds(396, 576, 186, 68);
			panel_lateral.add(btnSolicitarBaja);
			
			JLabel lblFechaDeRegresplicencia = new JLabel("Fecha de Regreso(Licencia):");
			lblFechaDeRegresplicencia.setForeground(Color.WHITE);
			lblFechaDeRegresplicencia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
			lblFechaDeRegresplicencia.setBounds(123, 488, 287, 30);
			panel_lateral.add(lblFechaDeRegresplicencia);
			
		}
		return panel_lateral;
	}

    private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
			label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label_3.setBounds(123, 46, 33, 28);
//			label_3.setIcon(new ImageIcon(Pricipal.class.getResource("/img/Back Arrow.png")));
		}
		return label_3;
	}

	private JLabel getLblInicio() {
		if (lblInicio == null) {
			lblInicio = new JLabel("Datos Personales");
			lblInicio.setBounds(162, 32, 237, 55);
			lblInicio.setForeground(new Color(255, 255, 255));
			lblInicio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		}
		return lblInicio;
	}
}
