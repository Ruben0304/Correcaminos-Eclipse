package Modelos;
import java.util.ArrayList;
import Variables.Materiales;

public class Biblioteca {
	 private ArrayList<Materiales> materialesPrestados;
	 
	 public boolean seCumplenRequisitos() {
	        // Verificar si se han devuelto todos los materiales prestados
	        return this.materialesPrestados.isEmpty();
	    }
}
