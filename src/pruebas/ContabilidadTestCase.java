package pruebas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import modelos.gestion.GestorDepartamentos;

public class ContabilidadTestCase {
	
	static GestorDepartamentos departamentos;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		departamentos = GestorDepartamentos.gestorDepartamentos();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		departamentos = null;
	}

	@Test
	public void testCargarInformacionEmpleadosConDeudas() {
		assertFalse(departamentos.getContabilidad().getEmpleadosDeudas().isEmpty());
	}

	@Test
	public void testSaldarDeuda() {
		
		Double real = departamentos.getContabilidad().saldarDeuda("94070561846");
		
		Double esperado = 235.00;
		
		assertEquals(esperado,real);
		
	}

}
