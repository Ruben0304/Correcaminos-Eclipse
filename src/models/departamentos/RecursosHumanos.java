package models.departamentos;

import java.util.ArrayList;

import models.interfaces.VerificadorEmpleado;
import models.responsabilidades.ResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import util.ResponsabilidadesTrabajador;
import util.TiposResponsabilidad;



public class RecursosHumanos implements VerificadorEmpleado {

	public boolean tieneSalarioIndebido(ResponsabilidadesEmpleados r) {
		return r.getResponsabilidades().contains(ResponsabilidadesTrabajador.SALARIO_INDEBIDO);
	}
	@Override
	public boolean verificarRequisitos(ResponsabilidadesEmpleados responsabilidadesTrabajador) {
		return tieneSalarioIndebido(responsabilidadesTrabajador);
	}
	
	public void recogerSalarioIndebido(Empleado e, ArrayList<ResponsabilidadesEmpleados> responsabilidades) {
		boolean encontrado = false;
        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEmpleado().equals(e);
            if (encontrado) {
                responsabilidades.get(i).getResponsabilidades().remove(ResponsabilidadesTrabajador.SALARIO_INDEBIDO);
            }

        }
        
	}
	
	@Override
	public ArrayList<Empleado> getEmpleadosPendientes(ArrayList<ResponsabilidadesEmpleados> responsabilidades) {
        
		ArrayList<Empleado> es = new ArrayList<>();
        
		for (ResponsabilidadesEmpleados r : responsabilidades) {
            if (verificarRequisitos(r)) {
                es.add(r.getEmpleado());
            }
        }
        return es;
    }

   
}
