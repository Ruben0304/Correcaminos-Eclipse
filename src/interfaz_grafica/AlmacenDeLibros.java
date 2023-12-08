package interfaz_grafica;

import java.awt.EventQueue;

import views.admin.DepartamentosModelo;
import views.modelos.DepartamentoVerificadorLibrosTableModel;

public class AlmacenDeLibros extends DepartamentosModelo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlmacenDeLibros frame = new AlmacenDeLibros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AlmacenDeLibros() {
		super("Almac�n de Libros");
		
	}

}
