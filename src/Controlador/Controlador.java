package Controlador;
import Modelos.Biblioteca;
import Modelos.Economia;

public class Controlador {
	private Biblioteca biblioteca;
    private Economia economia;
   
    public Controlador() {
        this.biblioteca = new Biblioteca();
        this.economia = new Economia();
        
    }

    public boolean verificarRequisitos() {
        boolean requisitosCumplidos = false;

        
        if (biblioteca.seCumplenRequisitos() && economia.seCumplenRequisitos()) {
            requisitosCumplidos = true;
        }

        return requisitosCumplidos;
    }
}
