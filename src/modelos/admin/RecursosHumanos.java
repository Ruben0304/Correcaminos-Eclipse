package modelos.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import datos.ObtenerEmpleadosConSalarioIndebido;
import datos.ObtenerEstudiantesConLibrosDocentesPendientes;
import interfaces.VerificadorEmpleado;
import modelos.usuarios.Docente;
import modelos.usuarios.Empleado;
import modelos.usuarios.NoDocente;
import util.TiposResponsabilidad;


public class RecursosHumanos implements VerificadorEmpleado {
	
	private HashMap<String, TiposResponsabilidad> empleadosConSalarioIndebido;
	
	public RecursosHumanos() {
		empleadosConSalarioIndebido = new HashMap<String, TiposResponsabilidad>();
		cargarInformacionEstudiantesConSalarioIndebido();
	}
	public void cargarInformacionEstudiantesConSalarioIndebido() {
		empleadosConSalarioIndebido = ObtenerEmpleadosConSalarioIndebido.cargarDesdeArchivo();
	}
	
	
	
	@Override
	public boolean verificarRequisitos(Empleado e) {
		return empleadosConSalarioIndebido.containsKey(e.getCi());
	}
	
	public void recogerSalarioIndebido(Empleado e) {
		empleadosConSalarioIndebido.remove(e.getCi());  
	}

	public void confirmarEntrega(String e) {
		empleadosConSalarioIndebido.remove(e);  
	}
	
	@Override
    public ArrayList<Empleado> getEmpleadosPendientes(ArrayList<Empleado> empleadosSolicitudesPendientes) {
    	
    	ArrayList<Empleado> nombresEmpleados = new ArrayList<>();
        
        for (Empleado e: empleadosSolicitudesPendientes) {
        	if (empleadosConSalarioIndebido.containsKey(e.getCi())) {
        		nombresEmpleados.add(e);
        	}
        }
   	
        return nombresEmpleados;
    }

   
}
