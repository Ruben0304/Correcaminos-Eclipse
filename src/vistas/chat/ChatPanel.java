package vistas.chat;

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

import util.TipoDepartamento;
import util.TiposResponsabilidad;

import javax.swing.JSlider;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

import java.awt.SystemColor;

import javax.swing.border.MatteBorder;

import com.formdev.flatlaf.FlatClientProperties;

import autenticacion.Auth;
import modelos.chats.AdministradorChats;
import modelos.chats.Chat;
import modelos.chats.Mensaje;
import modelos.usuarios.Becado;
import modelos.usuarios.Persona;

public class ChatPanel extends JPanel implements ActionListener {
    private JTextArea chatArea = new JTextArea();
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel("");
    private final JLabel lblNewLabel_2 = new JLabel("Seleccione Entidad");
    private final JLabel label_2 = new JLabel("Biblioteca");
    private final JLabel lblSecretaria = new JLabel("Secretaría");
    private final JLabel lblEconomia = new JLabel("Economía");
    private final JLabel lblSinformatica = new JLabel("S.Informática");
    private final JRadioButton radioButtonSecretaria = new JRadioButton("");
    private final JRadioButton radioButtonEconomia = new JRadioButton("");
    private final JRadioButton radioButtonSInformatica = new JRadioButton("");
    private final JPanel panel_1 = new JPanel();
    private final JLabel lblDepartamentos = new JLabel("Departamentos");
    private JTextArea txtrContanctaConLos;
    private ButtonGroup rbtnGroup = new ButtonGroup();
    private JRadioButton radioButtonBiblioteca = new JRadioButton("");
    private final AdministradorChats chats = AdministradorChats.getInstancia();
    private final Persona persona = (Persona) Auth.usuarioAutenticado();
    private Chat chat = new Chat();
    private TipoDepartamento departamento;
    private JTextField textField;
    private JLabel label_1;
    private JRadioButton radioButton;
    private JLabel lblAlibros;
    private JRadioButton radioButton_1;
    private JLabel lblDbecas;

    // private final Persona persona = (Persona) Auth.usuarioAutenticado();

    public ChatPanel(HashMap<TiposResponsabilidad, Boolean> requisitos) {

        // this.mensajes = ControladorChats.obtenerMensajes(admin, persona);
        // this.departamento = admin;

        setBounds(178, 0, 944, 700);

        chatArea.setBackground(new Color(105, 105, 105));

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
        rbtnGroup.add(getRadioButton_1());
        rbtnGroup.add(getRadioButton());
        radioButtonBiblioteca.setEnabled(requisitos.get(TiposResponsabilidad.LIBROS_BIBLIOTECA));
        radioButtonSInformatica.setEnabled(requisitos.get(TiposResponsabilidad.CUENTA_USUARIO));
        radioButtonEconomia.setEnabled(requisitos.get(TiposResponsabilidad.ESTIPENDIO));
        getRadioButton_1().setEnabled(
                Auth.usuarioAutenticado() instanceof Becado && requisitos.get(TiposResponsabilidad.PERTENENCIAS_BECA));
        getRadioButton().setEnabled(requisitos.get(TiposResponsabilidad.LIBROS_DOCENTES));
        // if (!mensajes.isEmpty()) {
        // for (Mensaje mensaje : mensajes) {
        // chatArea.append(mensaje.getNombreUsuario() + ": \n");
        // chatArea.append(" " + mensaje.getContenido() + "\n\n");
        // }

        // }
        setLayout(null);

        JPanel messagePanel = new JPanel();

        messagePanel.setBounds(0, 593, 944, 107);
        messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        messagePanel.setLayout(null);
        add(messagePanel);
        messagePanel.add(getTextField_1());
        messagePanel.add(getLabel_1());
        panel_1.setBounds(12, 58, 210, 522);
        add(panel_1);
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(new Color(105, 105, 105)));
        panel_1.setBackground(new Color(40, 42, 46));
        label_2.setBounds(54, 137, 120, 27);
        panel_1.add(label_2);
        label_2.setForeground(new Color(248, 248, 255));
        label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblSecretaria.setBounds(54, 177, 120, 27);
        panel_1.add(lblSecretaria);
        lblSecretaria.setForeground(new Color(248, 248, 255));
        lblSecretaria.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblEconomia.setBounds(54, 217, 120, 27);
        panel_1.add(lblEconomia);
        lblEconomia.setForeground(new Color(248, 248, 255));
        lblEconomia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblSinformatica.setBounds(54, 257, 120, 27);
        panel_1.add(lblSinformatica);
        lblSinformatica.setForeground(new Color(248, 248, 255));
        lblSinformatica.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        radioButtonBiblioteca.setBounds(24, 139, 25, 25);
        radioButtonBiblioteca.setBackground(new Color(40, 42, 46));
        radioButtonBiblioteca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                departamento = TipoDepartamento.Biblioteca;
                lblNewLabel_2.setText("Biblioteca");
                cargarMensajes();
            }
        });
        panel_1.add(radioButtonBiblioteca);

        radioButtonSecretaria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                departamento = TipoDepartamento.Secretaria;
                lblNewLabel_2.setText("Secretaría");
                cargarMensajes();
            }
        });

        radioButtonSecretaria.setBounds(24, 179, 25, 25);
        panel_1.add(radioButtonSecretaria);
        radioButtonSecretaria.setBackground(new Color(40, 42, 46));
        radioButtonEconomia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                departamento = TipoDepartamento.Economia;
                lblNewLabel_2.setText("Economía");
                cargarMensajes();
            }
        });
        radioButtonEconomia.setBounds(24, 219, 25, 25);
        panel_1.add(radioButtonEconomia);
        radioButtonEconomia.setBackground(new Color(40, 42, 46));
        radioButtonSInformatica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                departamento = TipoDepartamento.SeguridadInformatica;
                lblNewLabel_2.setText("Seguridad Informática");
                cargarMensajes();
            }
        });
        radioButtonSInformatica.setBounds(24, 258, 28, 27);
        panel_1.add(radioButtonSInformatica);
        radioButtonSInformatica.setBackground(new Color(40, 42, 46));
        lblDepartamentos.setForeground(new Color(248, 248, 255));
        lblDepartamentos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblDepartamentos.setBounds(24, 27, 150, 27);

        panel_1.add(lblDepartamentos);
        panel_1.add(getTxtrContanctaConLos());
        panel_1.add(radioButtonBiblioteca);
        panel_1.add(getRadioButton());
        panel_1.add(getLblAlibros());
        panel_1.add(getRadioButton_1());
        panel_1.add(getLblDbecas());
        // Configurar el �rea de chat
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBorder(null);
        scrollPane.setBounds(317, 149, 525, 408);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
        panel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.setBackground(new Color(40, 42, 46));
        panel.setBounds(252, 58, 616, 522);

        add(panel);
        panel.setLayout(null);
        label.setBounds(25, 13, 50, 50);

        panel.add(label);
        lblNewLabel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 250, 0)));
        lblNewLabel_2.setForeground(new Color(248, 248, 255));
        lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
        lblNewLabel_2.setBounds(52, 25, 435, 50);

        panel.add(lblNewLabel_2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private JTextArea getTxtrContanctaConLos() {
        if (txtrContanctaConLos == null) {
            txtrContanctaConLos = new JTextArea();
            txtrContanctaConLos.setLineWrap(true);
            txtrContanctaConLos.setWrapStyleWord(true);
            txtrContanctaConLos.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            txtrContanctaConLos.setText(
                    "Contacta con los distintos departamentos para definir horarios de visita o aclarar cualquier duda.");
            txtrContanctaConLos.setVerifyInputWhenFocusTarget(false);
            txtrContanctaConLos.setRequestFocusEnabled(false);
            txtrContanctaConLos.setMargin(new Insets(5, 10, 2, 2));
            txtrContanctaConLos.setForeground(Color.WHITE);
            txtrContanctaConLos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
            txtrContanctaConLos.setFocusable(false);
            txtrContanctaConLos.setEditable(false);
            txtrContanctaConLos.setBorder(null);
            txtrContanctaConLos.setBackground(new Color(40, 42, 46));
            txtrContanctaConLos.setBounds(24, 435, 174, 74);
        }
        return txtrContanctaConLos;
    }

    public JTextField getTextField_1() {
        if (textField == null) {
            textField = new JTextField();
            textField.setForeground(new Color(0, 0, 0));
            textField.setBackground(new Color(255, 255, 255));
            textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            textField.setBounds(350, 27, 349, 40);
            textField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Escriba el mensaje...");
            textField.putClientProperty(FlatClientProperties.STYLE, "" +
                    "showClearButton:true");
        }
        return textField;
    }

    public JLabel getLabel_1() {
        if (label_1 == null) {
            label_1 = new JLabel("");
            label_1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    if (!getTextField_1().getText().isEmpty()) {
                        chatArea.append(persona.getNombre() + ": \n");
                        chatArea.append("  " + getTextField_1().getText() + "\n\n");
                        Mensaje m = new Mensaje(getTextField_1().getText(), persona.getNombre());

                        chat.getChat().add(m);

                        if (chats.getChats().get(departamento) == null) {
                            HashMap<Persona, Chat> map = new HashMap<Persona, Chat>();
                            map.put(persona, chat);
                            chats.getChats().put(departamento, map);
                        } else {
                            HashMap<Persona, Chat> map = chats.getChats().get(departamento);
                            map.put(persona, chat);
                            chats.getChats().put(departamento, map);
                        }

                    }

                }
            });
            label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label_1.setIcon(new ImageIcon(ChatPanel.class.getResource("/img/Send Letter.png")));
            label_1.setBounds(711, 27, 46, 35);
        }
        return label_1;
    }

    public JRadioButton getRadioButton() {
        if (radioButton == null) {
            radioButton = new JRadioButton("");
            radioButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    departamento = TipoDepartamento.AlmacenLibrosDocentes;
                    lblNewLabel_2.setText("Almacén de Libros");
                    cargarMensajes();
                }
            });
            radioButton.setBackground(new Color(40, 42, 46));
            radioButton.setBounds(24, 298, 28, 27);
        }
        return radioButton;
    }

    public JLabel getLblAlibros() {
        if (lblAlibros == null) {
            lblAlibros = new JLabel("A.Libros");
            lblAlibros.setForeground(new Color(248, 248, 255));
            lblAlibros.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
            lblAlibros.setBounds(54, 297, 120, 27);
        }
        return lblAlibros;
    }

    public JRadioButton getRadioButton_1() {
        if (radioButton_1 == null) {
            radioButton_1 = new JRadioButton("");
            radioButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    departamento = TipoDepartamento.DireccionBecas;
                    lblNewLabel_2.setText("Dirección Becas");
                    cargarMensajes();
                }
            });
            radioButton_1.setBackground(new Color(40, 42, 46));
            radioButton_1.setBounds(24, 339, 28, 27);
        }
        return radioButton_1;
    }

    public JLabel getLblDbecas() {
        if (lblDbecas == null) {
            lblDbecas = new JLabel("D.Becas");
            lblDbecas.setForeground(new Color(248, 248, 255));
            lblDbecas.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
            lblDbecas.setBounds(54, 338, 120, 27);
        }
        return lblDbecas;
    }

    public void cargarMensajes() {
        chatArea.setText("");
        chat = new Chat();
        if (chats.getChats().get(departamento) != null) {

            if (chats.obtenerChat(departamento, persona) != null) {
                chat = chats.obtenerChat(departamento, persona);
                for (Mensaje mensaje : chats.obtenerChat(departamento,
                        persona).getChat()) {
                    chatArea.append(mensaje.getAutor() + ": \n");
                    chatArea.append("  " + mensaje.getMensaje() + "\n\n");

                }
            }
        }
    }
}
