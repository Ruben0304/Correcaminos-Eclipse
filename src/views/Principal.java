package views;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controllers.ControladorLogin;

import java.awt.Color;
import java.awt.Component;



import java.awt.Font;


import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;







public class Principal{
    private JLabel lblCorrecaminosCujae;
	private JTextArea txtrnecesitasSolicitarUna;
	private JLabel lblQueSomos;
	private JPanel panel_lateral;
	private JLabel lblEntrar;
	private JLabel label_6;
    private JLabel label_3;
	private JLabel lblInicio;
    private static Principal instance = null;

    
    private Principal() {}

    
    
    public static Principal getVista() {
        if (instance == null) {
            instance = new Principal();
        }
        return instance;
    }


    private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("");
			label_6.setIcon(new ImageIcon(prueba.class.getResource("/img/Accountc.png")));
			label_6.setBounds(879, 37, 40, 37);
		}
		return label_6;
	}

    private JLabel getLblCorrecaminosCujae() {
		if (lblCorrecaminosCujae == null) {
			lblCorrecaminosCujae = new JLabel("Correcaminos");
			lblCorrecaminosCujae.setBounds(364, 117, 352, 67);
			lblCorrecaminosCujae.setForeground(Color.WHITE);
			lblCorrecaminosCujae.setFont(new Font("Segoe UI Semibold", Font.BOLD, 50));
		}
		return lblCorrecaminosCujae;
	}

	private JTextArea getTxtrnecesitasSolicitarUna() {
		if (txtrnecesitasSolicitarUna == null) {
			txtrnecesitasSolicitarUna = new JTextArea();
			txtrnecesitasSolicitarUna.setBounds(106, 349, 734, 292);
			txtrnecesitasSolicitarUna.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
			txtrnecesitasSolicitarUna.setLineWrap(true);
			txtrnecesitasSolicitarUna.setForeground(new Color(255, 255, 255));
			txtrnecesitasSolicitarUna.setBackground(new Color(31, 33, 36));
			// new Color()
			txtrnecesitasSolicitarUna.setText(
					"\r\n. Correcamino: una app para gestionar bajas y licencias universitarias.\r\n\r\n.\u00BFNecesitas una baja o una licencia? Correcamino te ayuda a solicitarlas y a conocer los requisitos.\r\n\r\n.Correcamino te permite enviar tu solicitud electr\u00F3nicamente, recibir notificaciones, descargar documentos y contactar con el personal.\r\n\r\n.Correcamino es segura, r\u00E1pida y f\u00E1cil de usar. Desc\u00E1rgala y disfruta de sus ventajas.");
		}
		return txtrnecesitasSolicitarUna;
	}

	private JLabel getLblQueSomos() {
		if (lblQueSomos == null) {
			lblQueSomos = new JLabel("Qu\u00E9 somos ?");
			lblQueSomos.setBounds(122, 269, 481, 67);
			lblQueSomos.setForeground(Color.WHITE);
			lblQueSomos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		}
		return lblQueSomos;
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
			panel_lateral.add(getLblCorrecaminosCujae());
			panel_lateral.add(getTxtrnecesitasSolicitarUna());
			panel_lateral.add(getLblQueSomos());
			panel_lateral.add(getLblEntrar());
			panel_lateral.add(getLabel_6());
		}
		return panel_lateral;
	}

	private JLabel getLblEntrar() {
		if (lblEntrar == null) {
			lblEntrar = new JLabel("Entrar");
			lblEntrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ControladorLogin.mostrarLogin2();
                  
				}
			});
			lblEntrar.setForeground(Color.WHITE);
			lblEntrar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
			lblEntrar.setBounds(921, 37, 89, 30);
		}
		return lblEntrar;
	}

    private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
			label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label_3.setBounds(123, 46, 33, 28);
			label_3.setIcon(new ImageIcon(prueba.class.getResource("/img/Back Arrow.png")));
		}
		return label_3;
	}

	private JLabel getLblInicio() {
		if (lblInicio == null) {
			lblInicio = new JLabel("Inicio");
			lblInicio.setBounds(162, 44, 89, 30);
			lblInicio.setForeground(new Color(255, 255, 255));
			lblInicio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		}
		return lblInicio;
	}
}
