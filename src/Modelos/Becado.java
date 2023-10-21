package Modelos;

import Variables.Facultad;
import Variables.TipoCurso;

public class Becado extends Estudiante {
   private String idBecado;
   private int noCuarto;
   
   public Becado(String ci, String nombreUsuario, String contraseña, String nombre, String apellidos, Facultad facultad,
         String especialidad, int curso, TipoCurso tipoCurso, int grupo, String idBecado, int noCuarto) {
      super(ci, nombreUsuario, contraseña, nombre, apellidos, facultad, especialidad, curso, tipoCurso, grupo);
      this.idBecado = idBecado;
      this.noCuarto = noCuarto;
   }
   
   public void solicitarBaja() {
	}

	public void solicitarLicencia() {
	}
   
}
