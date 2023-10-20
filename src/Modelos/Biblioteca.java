package Modelos;
import java.util.ArrayList;
import Variables.Materiales;

public class Biblioteca {
	 private ArrayList<Materiales> materialesPrestados;
	 
	 public boolean seCumplenRequisitos() {
	        return this.materialesPrestados.isEmpty();
	    }
}
