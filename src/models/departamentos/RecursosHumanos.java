package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import interfaces.VerificadorEmpleado;
import models.usuarios.Docente;
import models.usuarios.Empleado;
import models.usuarios.NoDocente;
import util.TiposResponsabilidad;



public class RecursosHumanos implements VerificadorEmpleado {
	
	private HashMap<Empleado, TiposResponsabilidad> empleadosConSalarioIndebido;
	
	public boolean tieneSalarioIndebido(Empleado e) {
		return empleadosConSalarioIndebido.containsKey(e);
	}
	
	@Override
	public boolean verificarRequisitos(Empleado e) {
		return tieneSalarioIndebido(e);
	}
	
	public void recogerSalarioIndebido(Empleado e) {
		empleadosConSalarioIndebido.remove(e);  
	}
	
	@Override
	public ArrayList<Empleado> getEmpleadosPendientes() {
        
		ArrayList<Empleado> nombresEmpleados = new ArrayList<>();
           
    	Set<Empleado> empleadosPendientes = empleadosConSalarioIndebido.keySet();
        
        for (Empleado e: empleadosPendientes) {
        	nombresEmpleados.add(e);
        }
   	
        return nombresEmpleados;
    }

   
}
