package vistas.componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import autenticacion.Auth;
import modelos.usuarios.Admin;
import modelos.usuarios.Persona;


public class LabelUsuario {

    public static JPanel usuario() {
        JPanel panel = new JPanel();
        panel.setBounds(630, 13, 331, 37);
        panel.setLayout(null);

        JLabel label_4 = new JLabel("Hola, " + (Auth.usuarioAutenticado() instanceof Persona ? ((Persona)Auth.usuarioAutenticado()).getNombre() : Auth.getNombreUsuario()));
        label_4.setBounds(60, 0, 259, 30);
        panel.add(label_4);
        label_4.setForeground(Color.WHITE);
        label_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));

        JLabel label_3 = new JLabel("");
        label_3.setBounds(12, 0, 39, 37);
        panel.add(label_3);
        label_3.setIcon(new ImageIcon(LabelUsuario.class.getResource("/img/Accountc.png")));
        return panel;
    }
}
