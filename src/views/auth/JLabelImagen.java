package views.auth;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel; 

public class JLabelImagen extends JLabel {   
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image imagen; 
 
   
    public JLabelImagen(String rutaImagen) { 
    	super();       
    	if (rutaImagen != null) { 
    		imagen = new ImageIcon(rutaImagen).getImage();     
    		}    
    	} 
 
    
    @Override   
    public void paint(Graphics g) { 
    	g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this);        
    	super.paint(g);    
} 
 
    public void setImagen(String rutaImagen) {   
    	if (rutaImagen != null) {           
    		imagen = new ImageIcon(rutaImagen).getImage(); 
    		repaint();         
    		}    
    	}
    } 
