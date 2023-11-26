package views.custom;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import views.layouts.Pricipal;

public class JImagen extends JLabel {
    private ImageIcon imga;

    public JImagen() {
        super();
        String ubi = "/javax/swing/plaf/basic/icons/JavaCup16.png";
        ImageIcon icono = new ImageIcon(Pricipal.class.getResource(ubi));
        ImageIcon imga = new ImageIcon(
                icono.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
        setIcon(imga);
        // if (rutaImagen != null) {
        // imagen = new ImageIcon(rutaImagen).getImage();
        // }

    }

    public void setImagen(String ubi) {
        ImageIcon icono = new ImageIcon(Pricipal.class.getResource(ubi));
        ImageIcon imga = new ImageIcon(
                icono.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
        repaint();

    }
}
