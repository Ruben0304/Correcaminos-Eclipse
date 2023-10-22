package main;
import java.util.ArrayList;

import variables.Facultad;
import variables.TipoCurso;
import controladores.*;
import modelos.*;

public class Factory {
	 public static ArrayList<Estudiante> inicializarEstudiantes() {
		 ArrayList<Estudiante> estudiantes = new ArrayList<>();

	        
	        Estudiante estudiante1 = new Estudiante("1111111", "estudiante1", "contraseña1", "Juan", "Pérez",
	                Facultad.Ing_Civil, "Ingeniería Civil", 3, TipoCurso.DIURNO, 1);
	        estudiantes.add(estudiante1);

	        Estudiante estudiante2 = new Estudiante("2222222", "estudiante2", "contraseña2", "María", "González",
	                Facultad.Ing_Quimica, "Ingeniería Química", 4, TipoCurso.ENCUENTRO, 2);
	        estudiantes.add(estudiante2);

	        Estudiante estudiante3 = new Estudiante("3333333", "estudiante3", "contraseña3", "Pedro", "Rodríguez",
	                Facultad.Ing_Electrica, "Ingeniería Eléctrica", 2, TipoCurso.DIURNO, 1);
	        estudiantes.add(estudiante3);

	        Estudiante estudiante4 = new Estudiante("4444444", "estudiante4", "contraseña4", "Laura", "García",
	                Facultad.Ing_Automatica_y_Biomedica, "Ingeniería Automática y Biomédica", 3, TipoCurso.DIURNO, 2);
	        estudiantes.add(estudiante4);

	        Estudiante estudiante5 = new Estudiante("5555555", "estudiante5", "contraseña5", "Carlos", "Martínez",
	                Facultad.Ing_Mecanica, "Ingeniería Mecánica", 2, TipoCurso.ENCUENTRO, 3);
	        estudiantes.add(estudiante5);

	        // Crear instancias de Becado
	        Becado becado1 = new Becado("6666666", "becado1", "contraseña6", "Ana", "López",
	                Facultad.Arquitectura, "Arquitectura", 4, TipoCurso.DIURNO, 1, "BEC001", 101);
	        estudiantes.add(becado1);

	        Becado becado2 = new Becado("7777777", "becado2", "contraseña7", "David", "Hernández",
	                Facultad.Ing_Informatica, "Ingeniería Informática", 5, TipoCurso.ENCUENTRO, 2, "BEC002", 202);
	        estudiantes.add(becado2);

	        Becado becado3 = new Becado("8888888", "becado3", "contraseña8", "Sofía", "Gómez",
	                Facultad.Ing_Industrial, "Ingeniería Industrial", 3, TipoCurso.DIURNO, 3, "BEC003", 303);
	        estudiantes.add(becado3);

	        

	        return estudiantes;
	    }
}
