package pruebas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import modelos.gestion.GestorDepartamentos;
import modelos.usuarios.Estudiante;
import util.Facultad;
import util.TipoCurso;

public class AlmacenDeLibrosTestCase {
	
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
	public void testVerificarRequisitosCP1() {
		Estudiante estudiante1 = new Estudiante("02010161846","Adrian","Suar","Martinez",Facultad.Ing_Informática,2,TipoCurso.DIURNO,"Ingenieria Informática",23);
		
		assertTrue(departamentos.getAlmacenDeLibros().verificarRequisitos(estudiante1));
	}
	
	@Test
	public void testVerificarRequisitosCP2() {
		Estudiante estudiante2 = new Estudiante("02020561846","Carmen","Villalobos","Garcia",Facultad.Ing_Informática,1,TipoCurso.DIURNO,"Ingenieria Informática",13);
		
		assertFalse(departamentos.getAlmacenDeLibros().verificarRequisitos(estudiante2));
	}
	
}
