package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import interfaces.VerificadorEmpleado;
import models.usuarios.Empleado;

public class Contabilidad implements VerificadorEmpleado {
	
	private HashMap<Empleado, Double> empleadosDeudas;
	
	@Override
	public boolean verificarRequisitos(Empleado e) {
		return empleadosDeudas.containsKey(e);
	}
	
	public void saldarDeuda(Empleado e, double deuda) {
		Double d = empleadosDeudas.get(e);
		
		if (deuda == d.doubleValue()) {
			empleadosDeudas.remove(e);
		}
		else {
			d = d.valueOf(d.doubleValue() - deuda);
			empleadosDeudas.put(e, d);
		}
	}
	
	@Override
	public ArrayList<Empleado> getEmpleadosPendientes() {
        
		ArrayList<Empleado> nombresEmpleados = new ArrayList<>();
           
    	Set<Empleado> empleadosPendientes = empleadosDeudas.keySet();
        
        for (Empleado e: empleadosPendientes) {
        	nombresEmpleados.add(e);
        }
   	
        return nombresEmpleados;
    }

}
