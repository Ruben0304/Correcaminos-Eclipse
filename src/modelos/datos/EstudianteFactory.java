package modelos.datos;
import java.util.ArrayList;

import controlador.*;
import modelos.*;
import modelos.entidades.Becado;
import modelos.entidades.Estudiante;
import utiles.Facultad;
import utiles.TipoCurso;

public class EstudianteFactory {
	 public static ArrayList<Estudiante> inicializarEstudiantes() {
		 ArrayList<Estudiante> estudiantes = new ArrayList<>();

	        
	        Estudiante estudiante1 = new Estudiante("1111111", "estudiante1", "contrasena1", "Juan", "Prez",
	                Facultad.Ing_Civil, "Ingeniera Civil", 3, TipoCurso.DIURNO, 1);
	        estudiantes.add(estudiante1);

	        Estudiante estudiante2 = new Estudiante("2222222", "estudiante2", "contrasena2", "Marna", "Gonznlez",
	                Facultad.Ing_Quimica, "Ingenierna Qunmica", 4, TipoCurso.ENCUENTRO, 2);
	        estudiantes.add(estudiante2);

	        Estudiante estudiante3 = new Estudiante("3333333", "estudiante3", "contrasena3", "Pedro", "Rodrnguez",
	                Facultad.Ing_Electrica, "Ingenierna Elnctrica", 2, TipoCurso.DIURNO, 1);
	        estudiantes.add(estudiante3);

	        Estudiante estudiante4 = new Estudiante("4444444", "estudiante4", "contrasena4", "Laura", "Garcna",
	                Facultad.Ing_Automatica_y_Biomedica, "Ingenierna Automntica y Biomndica", 3, TipoCurso.DIURNO, 2);
	        estudiantes.add(estudiante4);

	        Estudiante estudiante5 = new Estudiante("5555555", "estudiante5", "contrasena5", "Carlos", "Martnnez",
	                Facultad.Ing_Mecanica, "Ingenierna Mecnnica", 2, TipoCurso.ENCUENTRO, 3);
	        estudiantes.add(estudiante5);

	        // Crear instancias de Becado
	        Becado becado1 = new Becado("6666666", "becado1", "contrasena6", "Ana", "Lnpez",
	                Facultad.Arquitectura, "Arquitectura", 4, TipoCurso.DIURNO, 1, "BEC001", 101);
	        estudiantes.add(becado1);

	        Becado becado2 = new Becado("7777777", "becado2", "contrasena7", "David", "Hernnndez",
	                Facultad.Ing_Informatica, "Ingenierna Informntica", 5, TipoCurso.ENCUENTRO, 2, "BEC002", 202);
	        estudiantes.add(becado2);

	        Becado becado3 = new Becado("8888888", "becado3", "contrasena8", "Sofna", "Gnmez",
	                Facultad.Ing_Industrial, "Ingenierna Industrial", 3, TipoCurso.DIURNO, 3, "BEC003", 303);
	        estudiantes.add(becado3);

	        

	        return estudiantes;
	    }
}
