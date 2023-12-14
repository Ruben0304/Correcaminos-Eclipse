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
		
		Estudiante estudiante = new Estudiante("02010161846","Adrian","Suar","Martinez",Facultad.Ing_Informatica,2,TipoCurso.DIURNO,"Ingenieria Informatica",23);
		
		assertTrue(s.getGestorSolicitudes().verificarEstudianteSolicitaAlgo(estudiante));
				
		
	}
	
	@Test
	public void testVerificarEstudianteSolicitaAlgoCP2() {
		
		Becado estudiante = new Becado("01010561846","Itzan","Escamilla","Gonzalez",Facultad.Ing_Informatica,1,TipoCurso.DIURNO,"Ingenieria Informatica",11, "12949", 305);
		
		assertFalse(s.getGestorSolicitudes().verificarEstudianteSolicitaAlgo(estudiante));
		
	}
		
	@Test
	public void testCrearSolicitudBaja() {
		
		Estudiante estudiante = new Estudiante("01010561846","Itzan","Escamilla","Gonzalez",Facultad.Ing_Informatica,1,TipoCurso.DIURNO,"Ingenieria Informatica",11);
	
		s.getGestorSolicitudes().crearSolicitudBaja(MotivoBaja.Enfermedad, estudiante);
		
		assertTrue(s.getGestorSolicitudes().getSolicitudes().containsKey(estudiante));		
	}

}
