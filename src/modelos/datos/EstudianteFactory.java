package modelos.datos;

import java.util.ArrayList;

import modelos.entidades.Becado;
import modelos.entidades.Estudiante;
import utiles.Facultad;
import utiles.TipoCurso;

public class EstudianteFactory {
        public static ArrayList<Estudiante> inicializarEstudiantes() {
                ArrayList<Estudiante> estudiantes = new ArrayList<>();

                estudiantes.add(new Estudiante("estudiante1", "0b14d501a594442a01c6859541bcb3e8164d183d32937b851835442f69d5c94e", "01234567891", "Juan", "Perez","Perez",
                                Facultad.Ing_Informatica, false, false, 1, TipoCurso.DIURNO, "Ingenieria Informatica",
                                1, false,false, false, false, false, false));

                estudiantes.add(new Becado("estudiante2", "6cf615d5bcaac778352a8f1f3360d23f02f34ec182e259897fd6ce485d7870d4", "12345678902", "Maria", "Gonzalez","Perez",
                                Facultad.Ing_Informatica, true, false, 2, TipoCurso.ENCUENTRO, "Ingenieria Informatica",
                                2,false, true, true, true, true, true,
                                "Becado234", 23, true, true));

                estudiantes.add(new Estudiante("estudiante3", "5906ac361a137e2d286465cd6588ebb5ac3f5ae955001100bc41577c3d751764", "23456789013", "Pedro", "Lopez","Perez",
                                Facultad.Ing_Informatica, false, false, 3, TipoCurso.DIURNO, "Ingenieria Informatica",
                                3,false, false, true, false, true, true));

                estudiantes.add(new Becado("estudiante4", "b97873a40f73abedd8d685a7cd5e5f85e4a9cfb83eac26886640a0813850122b", "34567890124", "Sofia", "Fernandez","Fernandez",
                                Facultad.Ing_Informatica, true, false, 4, TipoCurso.ENCUENTRO, "Ingenieria Informatica",
                                4,false, false, true, true, false, false,
                                "Becado456", 45, true, false));

                estudiantes.add(new Estudiante("estudiante5", "8b2c86ea9cf2ea4eb517fd1e06b74f399e7fec0fef92e3b482a6cf2e2b092023", "45678901235", "Laura", "Martinez","Fernandez",
                                Facultad.Ing_Informatica, false, false, 5, TipoCurso.DIURNO, "Ingenieria Informatica",
                                5,false, true, false, true, false, true));

                estudiantes.add(new Becado("estudiante6", "598a1a400c1dfdf36974e69d7e1bc98593f2e15015eed8e9b7e47a83b31693d5", "56789012346", "Carlos", "Sanchez","Fernandez",
                                Facultad.Ing_Informatica, true, false, 6, TipoCurso.ENCUENTRO, "Ingenieria Informatica",
                                6,false, false, false, true, false, true,
                                "Becado678", 67, false, true));

                estudiantes.add(new Estudiante("estudiante7", "5860836e8f13fc9837539a597d4086bfc0299e54ad92148d54538b5c3feefb7c", "67890123457", "Isabel", "Gomez","Fernandez",
                                Facultad.Ing_Informatica, false, false, 1, TipoCurso.DIURNO, "Ingenieria Informatica",
                                1,false, false, true, false, true, true));

                estudiantes.add(new Becado("estudiante8", "57f3ebab63f156fd8f776ba645a55d96360a15eeffc8b0e4afe4c05fa88219aa", "78901234568", "Manuel", "Torres","Fernandez",
                                Facultad.Ing_Informatica, true, false, 2, TipoCurso.ENCUENTRO, "Ingenieria Informatica",
                                2,false, true, false, true, true, false,
                                "Becado789", 78, true, true));

                estudiantes.add(new Estudiante("estudiante9", "9323dd6786ebcbf3ac87357cc78ba1abfda6cf5e55cd01097b90d4a286cac90e", "89012345679", "Ana", "Lopez","Fernandez",
                                Facultad.Ing_Informatica, false, false, 3, TipoCurso.DIURNO, "Ingenieria Informatica",
                                3,false, false, true, false, true, true));

                estudiantes.add(new Becado("estudiante10", "aa4a9ea03fcac15b5fc63c949ac34e7b0fd17906716ac3b8e58c599cdc5a52f0", "90123456780", "Luis", "Fernandez","Fernandez",
                                Facultad.Ing_Informatica, true, false, 4, TipoCurso.ENCUENTRO, "Ingenieria Informatica",
                                4,false, false, false, true, true, true,
                                "Becado890", 89, true, true));

                estudiantes.add(new Estudiante("estudiante11", "53d453b0c08b6b38ae91515dc88d25fbecdd1d6001f022419629df844f8ba433", "09876543211", "Marta", "Martinez","Fernandez",
                                Facultad.Ing_Informatica, false, false, 5, TipoCurso.DIURNO, "Ingenieria Informatica",
                                5,false, true, true, false, false, false));

                estudiantes.add(new Becado("estudiante12", "b3d17ebbe4f2b75d27b6309cfaae1487b667301a73951e7d523a039cd2dfe110", "98765432102", "David", "Sanchez","Fernandez",
                                Facultad.Ing_Informatica, true, false, 6, TipoCurso.ENCUENTRO, "Ingenieria Informatica",
                                6,false, true, true, false, true, false,
                                "Becado098", 90, false, true));

                estudiantes.add(new Estudiante("estudiante13", "48caafb68583936afd0d78a7bfd7046d2492fad94f3c485915f74bb60128620d", "87654321013", "Clara", "Gomez","Fernandez",
                                Facultad.Ing_Informatica, false, false, 1, TipoCurso.DIURNO, "Ingenieria Informatica",
                                1,false, false, false, true, false, true));

                estudiantes.add(new Becado("estudiante14", "c6863e1db9b396ed31a36988639513a1c73a065fab83681f4b77adb648fac3d6", "76543210124", "Eduardo", "Torres","Fernandez",
                                Facultad.Ing_Informatica, true, false, 2, TipoCurso.ENCUENTRO, "Ingenieria Informatica",
                                2,false, true, true, false, false, false,
                                "Becado765", 100, true, false));

                estudiantes.add(new Estudiante("estudiante15", "c63c2d34ebe84032ad47b87af194fedd17dacf8222b2ea7f4ebfee3dd6db2dfb", "65432101235", "Maria", "Lopez","Fernandez",
                                Facultad.Ing_Informatica, false, false, 3, TipoCurso.DIURNO, "Ingenieria Informatica",
                                3,false, false, true, false, true, true));

                return estudiantes;
        }
}
