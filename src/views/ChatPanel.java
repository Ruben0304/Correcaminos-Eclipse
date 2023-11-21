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
import javax.swing.JSlider;

public class ChatPanel extends JPanel implements ActionListener {
    private JTextArea chatArea = new JTextArea();
    private JTextField messageField = new JTextField();
    private JButton sendButton = new JButton("Enviar");
    private final JSlider slider = new JSlider();

    public ChatPanel() {
        // Configurar el panel
        setLayout(new BorderLayout());
        setBounds(178, 0, 944, 700);
        chatArea.setFont(new Font("Segoe UI", Font.PLAIN, 17));

        // Configurar el �rea de chat
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);
        
        scrollPane.setRowHeaderView(slider);

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
            messageField.setText("");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChatPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
