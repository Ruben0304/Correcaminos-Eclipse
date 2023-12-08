package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import data.ObtenerEmpleadosConDeudas;
import data.ObtenerEstudiantesConEstipendio;
import interfaces.VerificadorEmpleado;
import models.usuarios.Empleado;

public class Contabilidad implements VerificadorEmpleado {
	
	private HashMap<String, Double> empleadosDeudas;
	
	public Contabilidad() {
		empleadosDeudas = new HashMap<String, Double>();
		cargarInformacionEmpleadosConDeudas();
	}
	public void cargarInformacionEmpleadosConDeudas() {
		empleadosDeudas = ObtenerEmpleadosConDeudas.cargarDesdeArchivo();
	}
	
	@Override
	public boolean verificarRequisitos(Empleado e) {
		return empleadosDeudas.containsKey(e.getCi());
	}
	
	public void saldarDeuda(Empleado e) {
		empleadosDeudas.remove(e.getCi());
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
	
	public double obtenerDeudaEmpleado(Empleado e) {
		return empleadosDeudas.get(e).doubleValue();
	}
}
