package modelos.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import datos.ObtenerEmpleadosConDeudas;
import datos.ObtenerEstudiantesConEstipendio;
import interfaces.VerificadorEmpleado;
import modelos.usuarios.Empleado;

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
	public boolean verificarRequisitos(String e) {
		return empleadosDeudas.containsKey(e);
	}
	
	public void saldarDeuda(String e) {
		empleadosDeudas.remove(e);
	}
	
	@Override
    public ArrayList<Empleado> getEmpleadosPendientes(ArrayList<Empleado> empleadosSolicitudesPendientes) {
    	
    	ArrayList<Empleado> nombresEmpleados = new ArrayList<>();
        
        for (Empleado e: empleadosSolicitudesPendientes) {
        	if (empleadosDeudas.containsKey(e.getCi())) {
        		nombresEmpleados.add(e);
        	}
        }
   	
        return nombresEmpleados;
    }
	
	public double obtenerDeudaEmpleado(String e) {
		return empleadosDeudas.get(e).doubleValue();
	}
}
