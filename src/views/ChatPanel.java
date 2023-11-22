package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import auth.Auth;
import models.chats.AdministradorChats;
import models.chats.Chat;
import models.chats.Mensaje;
import models.usuarios.Admin;
import models.usuarios.Usuario;
import util.TipoDepartamento;

import javax.swing.JSlider;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.SystemColor;

public class ChatPanel extends JPanel implements ActionListener {
    private JTextArea chatArea = new JTextArea();
    private JTextField messageField = new JTextField();
    private Chat chat;
    private TipoDepartamento departamento = TipoDepartamento.Biblioteca;
    private JLabel lblNewLabel;
    private final JLabel lblNewLabel_1 = new JLabel("");
    private final JPanel panel = new JPanel();
    private JTextField textField;
    private final JLabel label = new JLabel("");
    private final JLabel lblNewLabel_2 = new JLabel("Biblioteca");
    private final JLabel label_2 = new JLabel("Biblioteca");
    private final JLabel lblSecretaria = new JLabel("Secretaria");
    private final JLabel lblEconomia = new JLabel("Economia");
    private final JLabel lblSinformatica = new JLabel("S.Informatica");
    private final JRadioButton radioButtonSecretaria = new JRadioButton("");
    private final JRadioButton radioButtonEconomia = new JRadioButton("");
    private final JRadioButton radioButtonSInformatica = new JRadioButton("");
    private final JPanel panel_1 = new JPanel();
    private final JLabel lblDepartamentos = new JLabel("Departamentos");
    private JTextArea txtrContanctaConLos;
    private ButtonGroup rbtnGroup = new ButtonGroup();
    private JRadioButton radioButtonBiblioteca = new JRadioButton("");

    public ChatPanel(Usuario usuario) {
        // Configurar el panel
        AdministradorChats.getAdministradorChats();

        this.chat = AdministradorChats.getAdministradorChats().buscarChat(departamento, usuario.getNombreUsuario());
        setBounds(178, 0, 944, 700);
        setBackground(new Color(31, 33, 36));
        chatArea.setWrapStyleWord(true);
        chatArea.setLineWrap(true);
        chatArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        chatArea.setBorder(null);
        chatArea.setMargin(new Insets(5, 10, 2, 2));
        chatArea.setFocusable(false);
        chatArea.setBackground(new Color(40, 42, 46));
        chatArea.setVerifyInputWhenFocusTarget(false);
        chatArea.setRequestFocusEnabled(false);
        chatArea.setForeground(Color.WHITE);
        chatArea.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        rbtnGroup = new ButtonGroup();
        rbtnGroup.add(radioButtonEconomia);
        rbtnGroup.add(radioButtonSInformatica);
        rbtnGroup.add(radioButtonSecretaria);
        rbtnGroup.add(radioButtonBiblioteca);
        if (chat != null) {
            for (Mensaje mensaje : chat.getMensajes()) {
                chatArea.append(mensaje.getNombreUsuario() + ": \n");
                chatArea.append("  " + mensaje.getContenido() + "\n\n");
            }

        }
        setLayout(null);

        // Configurar el campo de texto y el bot�n de enviar
        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(new Color(31, 33, 36));
        messagePanel.setBounds(0, 593, 944, 107);
        messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        messagePanel.setLayout(null);
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String nombre = Auth.hayUsuarioAutenticado() ? Auth.usuarioAutenticado().getNombreUsuario()
                        : "Biblioteca";
                String message = getTextField().getText();

                // L�gica para enviar el mensaje
                // ...
                // Limpiar el campo de texto despu�s de enviar el mensaje
                chatArea.append(nombre + " : \n");
                chatArea.append("  " + message + "\n\n");
                Mensaje m = new Mensaje(nombre, message);
                System.out.println(m.getNombreUsuario());
                System.out.println(m.getContenido());
                chat.agregarMensaje(m);
                getTextField().setText("");

            }
        });
        lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblNewLabel_1.setIcon(
                new ImageIcon("C:\\Users\\herna\\OneDrive\\Escritorio\\Nueva carpeta\\Send Letter - copia.png"));
        lblNewLabel_1.setBounds(683, 25, 40, 50);

        messagePanel.add(lblNewLabel_1);
        messagePanel.add(getLblNewLabel());
        add(messagePanel);
        messageField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        messageField.setBounds(230, 71, 441, -41);
        messagePanel.add(messageField);
        messagePanel.add(getTextField());
        panel_1.setBounds(12, 33, 210, 547);
        add(panel_1);
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(new Color(105, 105, 105)));
        panel_1.setBackground(new Color(40, 42, 46));
        label_2.setBounds(54, 119, 120, 27);
        panel_1.add(label_2);
        label_2.setForeground(new Color(248, 248, 255));
        label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblSecretaria.setBounds(54, 184, 120, 27);
        panel_1.add(lblSecretaria);
        lblSecretaria.setForeground(new Color(248, 248, 255));
        lblSecretaria.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblEconomia.setBounds(54, 252, 120, 27);
        panel_1.add(lblEconomia);
        lblEconomia.setForeground(new Color(248, 248, 255));
        lblEconomia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblSinformatica.setBounds(54, 315, 120, 27);
        panel_1.add(lblSinformatica);
        lblSinformatica.setForeground(new Color(248, 248, 255));
        lblSinformatica.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        radioButtonBiblioteca.setBounds(24, 121, 25, 25);
        radioButtonBiblioteca.setBackground(new Color(40, 42, 46));
        radioButtonBiblioteca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        panel_1.add(radioButtonBiblioteca);

        radioButtonSecretaria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        radioButtonSecretaria.setBounds(24, 186, 25, 25);
        panel_1.add(radioButtonSecretaria);
        radioButtonSecretaria.setBackground(new Color(40, 42, 46));
        radioButtonEconomia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        radioButtonEconomia.setBounds(24, 254, 25, 25);
        panel_1.add(radioButtonEconomia);
        radioButtonEconomia.setBackground(new Color(40, 42, 46));
        radioButtonSInformatica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        radioButtonSInformatica.setBounds(24, 320, 25, 25);
        panel_1.add(radioButtonSInformatica);
        radioButtonSInformatica.setBackground(new Color(40, 42, 46));
        lblDepartamentos.setForeground(new Color(248, 248, 255));
        lblDepartamentos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblDepartamentos.setBounds(24, 27, 150, 27);

        panel_1.add(lblDepartamentos);
        panel_1.add(getTxtrContanctaConLos());
        panel_1.add(radioButtonBiblioteca);
        // Configurar el �rea de chat
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBorder(null);
        scrollPane.setBounds(317, 124, 525, 433);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
        panel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.setBackground(new Color(40, 42, 46));
        panel.setBounds(252, 33, 616, 547);

        add(panel);
        panel.setLayout(null);
        label.setBounds(25, 13, 50, 50);
        label.setIcon(new ImageIcon("C:\\Users\\herna\\OneDrive\\Escritorio\\Nueva carpeta\\Circled vB.png"));

        panel.add(label);
        lblNewLabel_2.setForeground(new Color(248, 248, 255));
        lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblNewLabel_2.setBounds(87, 23, 120, 27);

        panel.add(lblNewLabel_2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
            lblNewLabel = new JLabel();
            lblNewLabel.setBounds(195, -66, 607, 233);
            ImageIcon ico = new ImageIcon("C:\\Users\\herna\\OneDrive\\Escritorio\\Nueva carpeta\\chatc.png");
            ImageIcon img = new ImageIcon(
                    ico.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
                            Image.SCALE_SMOOTH));
            lblNewLabel.setIcon(img);
        }
        return lblNewLabel;
    }

    private JTextField getTextField() {
        if (textField == null) {
            textField = new JTextField();
            textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
            textField.setBorder(null);
            textField.setBounds(276, 32, 395, 35);
            textField.setColumns(10);
        }
        return textField;
    }

    private JTextArea getTxtrContanctaConLos() {
        if (txtrContanctaConLos == null) {
            txtrContanctaConLos = new JTextArea();
            txtrContanctaConLos.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            txtrContanctaConLos.setText(
                    "Contancta con los distintos departamentos para definir horarios de visita o aclarar cualquier duda.");
            txtrContanctaConLos.setWrapStyleWord(true);
            txtrContanctaConLos.setVerifyInputWhenFocusTarget(false);
            txtrContanctaConLos.setRequestFocusEnabled(false);
            txtrContanctaConLos.setMargin(new Insets(5, 10, 2, 2));
            txtrContanctaConLos.setLineWrap(true);
            txtrContanctaConLos.setForeground(Color.WHITE);
            txtrContanctaConLos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
            txtrContanctaConLos.setFocusable(false);
            txtrContanctaConLos.setEditable(false);
            txtrContanctaConLos.setBorder(null);
            txtrContanctaConLos.setBackground(new Color(40, 42, 46));
            txtrContanctaConLos.setBounds(35, 460, 163, 74);
        }
        return txtrContanctaConLos;
    }
    // private JRadioButton getRadioButtonBiblioteca() {
    // if (radioButtonBiblioteca == null) {
    // radioButtonBiblioteca = new JRadioButton("");
    // radioButtonBiblioteca.setBackground(new Color(40, 42, 46));
    // radioButtonBiblioteca.setBounds(24, 121, 25, 25);
    // }
    // return radioButtonBiblioteca;
    // }
}
