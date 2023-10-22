package modelos.datos;
import java.util.ArrayList;
import java.util.Random;

import controlador.*;
import modelos.*;
import modelos.entidades.Becado;
import modelos.entidades.Estudiante;
import utiles.Facultad;
import utiles.TipoCurso;

public class EstudianteFactory {
	 public static ArrayList<Estudiante> inicializarEstudiantes() {
		 ArrayList<Estudiante> estudiantes = new ArrayList<>();

	        
		 estudiantes.add(new Estudiante("estudiante1", "password1", "01234567891", "Juan", "Pérez",
                Facultad.Ing_Informatica, false, false, 1, TipoCurso.DIURNO, "Ingeniería Informática", 1, false, false, false, false, false));

        estudiantes.add(new Becado("estudiante2", "password2", "12345678902", "Maria", "González",
                Facultad.Ing_Informatica, true, false, 2, TipoCurso.ENCUENTRO, "Medicina General", 2, true, true, true, true, true,
                "Becado234", 23, true, true));

        estudiantes.add(new Estudiante("estudiante3", "password3", "23456789013", "Pedro", "López",
                Facultad.Ing_Informatica, false, false, 3, TipoCurso.DIURNO, "Ingeniería Eléctrica", 3, false, true, false, true, true));

        estudiantes.add(new Becado("estudiante4", "password4", "34567890124", "Sofía", "Fernández",
                Facultad.Ing_Informatica, true, false, 4, TipoCurso.ENCUENTRO, "Química Orgánica", 4, false, true, true, false, false,
                "Becado456", 45, true, false));

        estudiantes.add(new Estudiante("estudiante5", "password5", "45678901235", "Laura", "Martínez",
                Facultad.Ing_Informatica, false, false, 5, TipoCurso.DIURNO, "Ingeniería Mecánica", 5, true, false, true, false, true));

        estudiantes.add(new Becado("estudiante6", "password6", "56789012346", "Carlos", "Sánchez",
                Facultad.Ing_Informatica, true, false, 6, TipoCurso.ENCUENTRO, "Ingeniería Civil", 6, false, false, true, false, true,
                "Becado678", 67, false, true));

        estudiantes.add(new Estudiante("estudiante7", "password7", "67890123457", "Isabel", "Gómez",
                Facultad.Ing_Informatica, false, false, 1, TipoCurso.DIURNO, "Ingeniería Informática", 1, false, true, false, true, true));

        estudiantes.add(new Becado("estudiante8", "password8", "78901234568", "Manuel", "Torres",
                Facultad.Ing_Informatica, true, false, 2, TipoCurso.ENCUENTRO, "Ingeniería Eléctrica", 2, true, false, true, true, false,
                "Becado789", 78, true, true));

        estudiantes.add(new Estudiante("estudiante9", "password9", "89012345679", "Ana", "López",
                Facultad.Ing_Informatica, false, false, 3, TipoCurso.DIURNO, "Química Orgánica", 3, false, true, false, true, true));

        estudiantes.add(new Becado("estudiante10", "password10", "90123456780", "Luis", "Fernández",
                Facultad.Ing_Informatica, true, false, 4, TipoCurso.ENCUENTRO, "Medicina General", 4, false, false, true, true, true,
                "Becado890", 89, true, true));

        estudiantes.add(new Estudiante("estudiante11", "password11", "09876543211", "Marta", "Martínez",
                Facultad.Ing_Informatica, false, false, 5, TipoCurso.DIURNO, "Ingeniería Mecánica", 5, true, true, false, false, false));

        estudiantes.add(new Becado("estudiante12", "password12", "98765432102", "David", "Sánchez",
                Facultad.Ing_Informatica, true, false, 6, TipoCurso.ENCUENTRO, "Química Orgánica", 6, true, true, false, true, false,
                "Becado098", 90, false, true));

        estudiantes.add(new Estudiante("estudiante13", "password13", "87654321013", "Clara", "Gómez",
                Facultad.Ing_Informatica, false, false, 1, TipoCurso.DIURNO, "Ingeniería Informática", 1, false, false, true, false, true));

        estudiantes.add(new Becado("estudiante14", "password14", "76543210124", "Eduardo", "Torres",
                Facultad.Ing_Informatica, true, false, 2, TipoCurso.ENCUENTRO, "Ingeniería Eléctrica", 2, true, true, false, false, false,
                "Becado765", 100, true, false));

        estudiantes.add(new Estudiante("estudiante15", "password15", "65432101235", "María", "López",
                Facultad.Ing_Informatica, false, false, 3, TipoCurso.DIURNO, "Ingeniería Civil", 3, false, true, false, true, true));

	        

	        return estudiantes;
	    }
}
