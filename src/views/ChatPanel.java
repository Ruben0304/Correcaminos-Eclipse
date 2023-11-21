package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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

public class ChatPanel extends JPanel implements ActionListener {
    private JTextArea chatArea = new JTextArea();
    private JTextField messageField = new JTextField();
    private JButton sendButton = new JButton("Enviar");
    private Chat chat;
    private Usuario usuario;

    public ChatPanel(Usuario usuario, TipoDepartamento departamento) {
        // Configurar el panel
        AdministradorChats.getAdministradorChats();

        this.chat = AdministradorChats.getAdministradorChats().buscarChat(departamento, usuario.getNombreUsuario());

        setLayout(new BorderLayout());
        setBounds(178, 0, 944, 700);
        chatArea.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        if (chat != null) {
            for (Mensaje mensaje : chat.getMensajes()) {
                chatArea.append(" " + mensaje.getNombreUsuario() + " \n");
                chatArea.append(mensaje.getContenido() + "\n\n");
            }

        }
        // Configurar el �rea de chat
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // Configurar el campo de texto y el bot�n de enviar
        JPanel messagePanel = new JPanel(new GridBagLayout());
        messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        GridBagConstraints gbcMessage = new GridBagConstraints();
        gbcMessage.gridx = 0;
        gbcMessage.gridy = 0;
        gbcMessage.weightx = 1.0;
        gbcMessage.fill = GridBagConstraints.HORIZONTAL;
        gbcMessage.insets = new Insets(0, 0, 0, 5);
        messagePanel.add(messageField, gbcMessage);
        GridBagConstraints gbcSend = new GridBagConstraints();
        gbcSend.gridx = 1;
        gbcSend.gridy = 0;
        gbcSend.weightx = 0.0;
        gbcSend.fill = GridBagConstraints.NONE;
        messagePanel.add(sendButton, gbcSend);
        add(messagePanel, BorderLayout.SOUTH);

        // Agregar un listener al bot�n de enviar
        sendButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            String nombre = Auth.hayUsuarioAutenticado() ? Auth.usuarioAutenticado().getNombreUsuario() : "Biblioteca";
            String message = messageField.getText();

            // L�gica para enviar el mensaje
            // ...
            // Limpiar el campo de texto despu�s de enviar el mensaje
            chatArea.append(" " + nombre + " \n");
            chatArea.append(message + "\n\n");
            Mensaje m = new Mensaje(usuario.getNombreUsuario(), messageField.getText());
            System.out.println(m.getNombreUsuario());
            System.out.println(m.getContenido());
            chat.agregarMensaje(m);
            messageField.setText("");
        }
    }


}
