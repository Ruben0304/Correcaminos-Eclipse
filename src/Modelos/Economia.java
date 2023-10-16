package Modelos;

public class Economia {
	private double deudas;
	
	 public boolean seCumplenRequisitos() {
	        // Verificar si no hay deudas pendientes
	        return this.deudas == 0.0;
	    }
}
