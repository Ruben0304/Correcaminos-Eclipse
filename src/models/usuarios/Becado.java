package models.usuarios;

import java.util.ArrayList;

import utiles.Facultad;
import utiles.TipoCurso;
import utiles.TiposResponsabilidad;

public class Becado extends Estudiante {
   private String idBecado;
   private int noCuarto;

   public Becado(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido,
         String segundo_apellido,
         Facultad facultad, int curso, TipoCurso tipoCurso, String carrera, int grupo, String idBecado, int noCuarto,
         ArrayList<TiposResponsabilidad> responsabilidades) {
      super(nombreUsuario, contrasena, ci, nombre, primer_apellido, segundo_apellido, facultad, curso, tipoCurso,
            carrera,
            grupo,responsabilidades);
      this.idBecado = idBecado;
      this.noCuarto = noCuarto;

   }

   public String getIdBecado() {
      return idBecado;
   }

   public int getNoCuarto() {
      return noCuarto;
   }

}
