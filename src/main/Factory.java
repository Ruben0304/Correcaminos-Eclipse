package main;
import java.util.ArrayList;

import variables.Facultad;
import variables.TipoCurso;
import controladores.*;
import modelos.*;

public class Factory {
	 public static ArrayList<Estudiante> inicializarEstudiantes() {
		 ArrayList<Estudiante> estudiantes = new ArrayList<>();

	        
	        Estudiante estudiante1 = new Estudiante("1111111", "estudiante1", "contrase�a1", "Juan", "P�rez",
	                Facultad.Ing_Civil, "Ingenier�a Civil", 3, TipoCurso.DIURNO, 1);
	        estudiantes.add(estudiante1);

	        Estudiante estudiante2 = new Estudiante("2222222", "estudiante2", "contrase�a2", "Mar�a", "Gonz�lez",
	                Facultad.Ing_Quimica, "Ingenier�a Qu�mica", 4, TipoCurso.ENCUENTRO, 2);
	        estudiantes.add(estudiante2);

	        Estudiante estudiante3 = new Estudiante("3333333", "estudiante3", "contrase�a3", "Pedro", "Rodr�guez",
	                Facultad.Ing_Electrica, "Ingenier�a El�ctrica", 2, TipoCurso.DIURNO, 1);
	        estudiantes.add(estudiante3);

	        Estudiante estudiante4 = new Estudiante("4444444", "estudiante4", "contrase�a4", "Laura", "Garc�a",
	                Facultad.Ing_Automatica_y_Biomedica, "Ingenier�a Autom�tica y Biom�dica", 3, TipoCurso.DIURNO, 2);
	        estudiantes.add(estudiante4);

	        Estudiante estudiante5 = new Estudiante("5555555", "estudiante5", "contrase�a5", "Carlos", "Mart�nez",
	                Facultad.Ing_Mecanica, "Ingenier�a Mec�nica", 2, TipoCurso.ENCUENTRO, 3);
	        estudiantes.add(estudiante5);

	        // Crear instancias de Becado
	        Becado becado1 = new Becado("6666666", "becado1", "contrase�a6", "Ana", "L�pez",
	                Facultad.Arquitectura, "Arquitectura", 4, TipoCurso.DIURNO, 1, "BEC001", 101);
	        estudiantes.add(becado1);

	        Becado becado2 = new Becado("7777777", "becado2", "contrase�a7", "David", "Hern�ndez",
	                Facultad.Ing_Informatica, "Ingenier�a Inform�tica", 5, TipoCurso.ENCUENTRO, 2, "BEC002", 202);
	        estudiantes.add(becado2);

	        Becado becado3 = new Becado("8888888", "becado3", "contrase�a8", "Sof�a", "G�mez",
	                Facultad.Ing_Industrial, "Ingenier�a Industrial", 3, TipoCurso.DIURNO, 3, "BEC003", 303);
	        estudiantes.add(becado3);

	        

	        return estudiantes;
	    }
}
