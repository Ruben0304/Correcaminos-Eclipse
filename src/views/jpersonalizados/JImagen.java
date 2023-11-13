package views.jpersonalizados;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import views.prueba;

public class JImagen extends JLabel{
     private ImageIcon imga;

    public JImagen(String ubi) {
        super();
        ImageIcon icono = new ImageIcon(prueba.class.getResource(ubi));
        ImageIcon imga = new ImageIcon(icono.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
        setIcon(imga);
        // if (rutaImagen != null) {
        //     imagen = new ImageIcon(rutaImagen).getImage();
        // }
        
    }
}
