package vistas.template;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import raven.toast.Notifications;
import raven.toast.ToastClientProperties;

import javax.management.Notification;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import autenticacion.Auth;
import util.TipoDepartamento;
import vistas.admin.PanelAdministracion;
import vistas.autenticacion.CuentaJP;
import vistas.componentes.LabelUsuario;
import vistas.componentes.Navegacion;
import vistas.usuarios.RequisitosEstudiante;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Pricipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea chatArea = new JTextArea();
	private JTextField messageField = new JTextField();
	private JButton sendButton = new JButton("Enviar");

	private static Pricipal instance = null;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {

	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */

	public static Pricipal getInstancia() {
		if (instance == null) {
			instance = new Pricipal();
		}
		return instance;
	}

	public void setVista(JPanel panel) {

		contentPane.removeAll();
		contentPane.add(Navegacion.getInstancia());
		if (!(panel instanceof PanelAdministracion || panel instanceof CuentaJP)) {
			panel.add(LabelUsuario.usuario());
		}
		
		contentPane.add(new ChatFrame());

		repaint();
		revalidate();

	}

	public Pricipal() {
		setTitle("Correcaminos");
		UIManager.put(ToastClientProperties.TOAST_INFO_ICON, new FlatSVGIcon("raven/toast/error.svg"));
		Notifications.getInstance().setJFrame(this);
		setResizable(false);

		setIconImage(Toolkit.getDefaultToolkit().getImage(Pricipal.class.getResource("/img/spotillo2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 744);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(31, 33, 36));
			panel_1.setBounds(225, 0, 897, 697);
		}
		return panel_1;
	}

	public JPanel ChatPanel() {
		// Configurar el panel
		JPanel panel = new JPanel();
		getContentPane().setLayout(new BorderLayout());
		setPreferredSize(new Dimension(400, 300));

		// Configurar el �rea de chat
		chatArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(chatArea);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		// Configurar el campo de texto y el bot�n de enviar
		JPanel messagePanel = new JPanel(new GridBagLayout());
		messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 0, 5);
		messagePanel.add(messageField, gbc);
		gbc.gridx++;
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		messagePanel.add(sendButton, gbc);
		getContentPane().add(messagePanel, BorderLayout.SOUTH);

		// Agregar un listener al bot�n de enviar
		sendButton.addActionListener(this);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sendButton) {
			String message = messageField.getText();
			if (!message.isEmpty()) {
				chatArea.append("Yo: " + message + "\n");
				messageField.setText("");
			}
		}
	}

}
