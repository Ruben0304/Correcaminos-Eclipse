package pruebas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import modelos.gestion.estudiantes.Secretaria;
import modelos.usuarios.Becado;
import modelos.usuarios.Estudiante;
import util.Facultad;
import util.MotivoBaja;
import util.TipoCurso;

public class GestorSolicitudesEstudianteTestCase {
	
	static Secretaria s;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		s = Secretaria.gestorEstudiantes();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		s = null;
	}

	@Test
	public void testVerificarEstudianteSolicitaAlgoCP1() {
		
		Estudiante estudiante = new Estudiante("02010161846","Adrián","Suar","Martínez",Facultad.Ing_Informática,2,TipoCurso.DIURNO,"Ingeniería Informática",23);
		
		assertTrue(s.getGestorSolicitudes().verificarEstudianteSolicitaAlgo(estudiante));
				
		
	}
	
	@Test
	public void testVerificarEstudianteSolicitaAlgoCP2() {
		
		Becado estudiante2 = new Becado("01010561111","Itzan","Escamilla","González",Facultad.Ing_Informática,1,TipoCurso.DIURNO,"Ingeniería Informática",11, "12949", 305);
		
		assertFalse(s.getGestorSolicitudes().verificarEstudianteSolicitaAlgo(estudiante2));
		
	}
		
	@Test
	public void testCrearSolicitudBaja() {
		
		Estudiante estudiante = new Estudiante("01010561846","Itzan","Escamilla","González",Facultad.Ing_Informática,1,TipoCurso.DIURNO,"Ingeniería Informática",11);
	
		s.getGestorSolicitudes().crearSolicitudBaja(MotivoBaja.Enfermedad, estudiante);
		
		assertTrue(s.getGestorSolicitudes().getSolicitudes().containsKey(estudiante));		
	}

}
