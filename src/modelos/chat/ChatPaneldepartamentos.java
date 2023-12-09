package modelos.chat;

import java.awt.Color;

import java.awt.Font;

import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

import autenticacion.Auth;
import controladores.ControladorAdmin;
import modelos.chats.AdministradorChats;
import modelos.chats.Chat;
import modelos.chats.Mensaje;
import modelos.usuarios.Admin;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ChatPaneldepartamentos extends JPanel implements ActionListener {
    private JTextArea chatArea = new JTextArea();
    private JTextField messageField = new JTextField();
    private Chat chat;
    private JLabel lblNewLabel;
    private final JLabel lblNewLabel_1 = new JLabel("");
    private final JPanel panel = new JPanel();
    private JTextField textField;
    private final JLabel label = new JLabel("");
    private final JLabel lblNewLabel_2 = new JLabel("Estudiante1");
    private final JPanel panel_1 = new JPanel();
    private final JLabel lblDepartamentos = new JLabel("Conversaciones");
    private JTextArea txtrContanctaConLos;
    private ButtonGroup rbtnGroup = new ButtonGroup();
    private JScrollPane scrollPane_1;
    private final Admin departamento = (Admin) Auth.usuarioAutenticado();
    private JTable table;

    public ChatPaneldepartamentos() {

        AdministradorChats.getAdministradorChats();

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
        lblDepartamentos.setForeground(new Color(248, 248, 255));
        lblDepartamentos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblDepartamentos.setBounds(24, 27, 150, 27);

        panel_1.add(lblDepartamentos);
        panel_1.add(getTxtrContanctaConLos());
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
        add(getScrollPane_1());
        add(getTable());
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
                    "Atiende dudas y peticiones de las personas que solicitan baja.");
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
            txtrContanctaConLos.setBounds(24, 460, 163, 74);
        }
        return txtrContanctaConLos;
    }

    private JScrollPane getScrollPane_1() {
        if (scrollPane_1 == null) {
            scrollPane_1 = new JScrollPane();
            scrollPane_1.setBounds(23, 106, 187, 370);
            scrollPane_1.setOpaque(false);
            scrollPane_1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
            scrollPane_1.setBackground(new Color(40, 42, 46));
            scrollPane_1.setAutoscrolls(true);
        }
        return scrollPane_1;
    }

    private JTable getTable() {
        if (table == null) {
            table = new JTable();
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        String nombreUsuario = table.getValueAt(selectedRow, 0).toString();
                        setChat(AdministradorChats.getAdministradorChats().buscarChat(
                                departamento.getTipoDepartamento(),
                                nombreUsuario));
                        chatArea.revalidate();
                        chatArea.repaint();

                        // DefaultTableModel modelo = (DefaultTableModel) table_2.getModel();

                        // modelo.fireTableDataChanged();

                    }

                }
            });
            table.setBounds(0, 0, 588, -121);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setRowHeight(50);
            table.setGridColor(new Color(31, 33, 36));
            table.setForeground(Color.WHITE);
            table.setBorder(null);
            table.setBackground(new Color(31, 33, 36));
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
        return table;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
