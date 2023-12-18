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

import util.Estado;
import util.TipoDepartamento;
import util.TiposResponsabilidad;
import util.modelos.ChatModel;

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
import controladores.ControladorAdmin;
import modelos.chats.AdministradorChats;
import modelos.chats.Chat;
import modelos.chats.Mensaje;
import modelos.gestion.empleados.GestorEmpleados;
import modelos.gestion.estudiantes.Secretaria;
import modelos.usuarios.Becado;
import modelos.usuarios.Admin;
import modelos.usuarios.Persona;
import raven.toast.Notifications;

import javax.swing.JTable;

public class ChatPanelDepartamentos extends JPanel implements ActionListener {
    private JTextArea chatArea = new JTextArea();
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel("");
    private final JLabel lblNewLabel_2 = new JLabel("Seleccione Persona");
    private final JPanel panel_1 = new JPanel();
    private final JLabel lblDepartamentos = new JLabel("Personas");
    private JTextArea txtrContanctaConLos;

    private final AdministradorChats chats = AdministradorChats.getInstancia();
    private Persona persona;
    private Chat chat = new Chat();
    private final TipoDepartamento departamento = ((Admin) Auth.usuarioAutenticado()).getTipoDepartamento();
    private JTextField textField;
    private JLabel label_1;
    private JScrollPane scrollPane_1;
    private JTable table;

    // private final Persona persona = (Persona) Auth.usuarioAutenticado();

    public ChatPanelDepartamentos() {

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
        lblDepartamentos.setForeground(new Color(248, 248, 255));
        lblDepartamentos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblDepartamentos.setBounds(51, 27, 123, 27);

        panel_1.add(lblDepartamentos);
        panel_1.add(getTxtrContanctaConLos());
        panel_1.add(getScrollPane_1());
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
                    "Para dar soporte a personas con solicitudes y deudas pendientes.");
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
                        chatArea.append(departamento.toString() + ": \n");
                        chatArea.append("  " + getTextField_1().getText() + "\n\n");
                        Mensaje m = new Mensaje(getTextField_1().getText(), departamento.toString());

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

    public void cargarMensajes() {
        chatArea.setText("");
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

    public JScrollPane getScrollPane_1() {
        if (scrollPane_1 == null) {
            scrollPane_1 = new JScrollPane();
            scrollPane_1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                }
            });
            scrollPane_1.setBounds(12, 67, 186, 355);
            scrollPane_1.setViewportView(getTable());
        }
        return scrollPane_1;
    }

    public JTable getTable() {
        if (table == null) {
            table = new JTable();
            table.setModel(new ChatModel(chats.getChats().get(departamento)));
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {

                    if (table.getSelectedRow() != -1) {
                       for (Map.Entry<Persona,Chat> personas : chats.getChats().get(departamento).entrySet()) {
                        Persona p = personas.getKey();
                        if (p.getCi().equals(table.getValueAt(table.getSelectedRow(), 0).toString())) {
                            persona = p;
                            cargarMensajes();
                        }
                        
                       }
                    }
                }
            });
        }
        return table;
    }
}
