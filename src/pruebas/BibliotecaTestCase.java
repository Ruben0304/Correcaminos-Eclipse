package pruebas;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import modelos.gestion.GestorDepartamentos;
import modelos.usuarios.Estudiante;
import util.Facultad;
import util.TipoCurso;

public class BibliotecaTestCase {

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
	public void testRecogerDeudas() {
		
		Set<String> esperado = new HashSet<>();
		esperado.add("Ciencias");
		
		Set<String> remover = new HashSet<>();
		esperado.add("Historia de Cuba");
		
		departamentos.getBiblioteca().recogerDeudas("01010161846",remover);
		
		Set<String> real = departamentos.getBiblioteca().getPersonasConLibrosBiblioteca().get("01010161846");
		
		assertEquals(esperado,real);
	}


	@Test
	public void testGetEstudiantesPendientesCP1() {
		
		Estudiante estudiante = new Estudiante("01234567891","Juan","Perez","Perez",Facultad.Ing_Informatica,1,TipoCurso.DIURNO,"Ingenieria Informatica",11);
		
		ArrayList<Estudiante> estSolicitudPendientes = new ArrayList<Estudiante>();
		estSolicitudPendientes.add(estudiante);
		
		ArrayList<Estudiante> estudiantePendiente = departamentos.getBiblioteca().getEstudiantesPendientes(estSolicitudPendientes);
		
		assertFalse(estudiantePendiente.isEmpty());
	}
	
	@Test
	public void testGetEstudiantesPendientesCP2() {
		
		ArrayList<Estudiante> estSolicitudPendientes = new ArrayList<Estudiante>();
		
		ArrayList<Estudiante> estudiantePendiente = departamentos.getBiblioteca().getEstudiantesPendientes(estSolicitudPendientes);
		
		assertTrue(estudiantePendiente.isEmpty());
	}


}
