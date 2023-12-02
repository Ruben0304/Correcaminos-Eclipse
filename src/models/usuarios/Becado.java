package models.usuarios;



import util.Facultad;
import util.TipoCurso;


public class Becado extends Estudiante {
   private String idBecado;
   private int noCuarto;

   public Becado( String ci, String nombre, String primer_apellido,
         String segundo_apellido,
         Facultad facultad, int curso, TipoCurso tipoCurso, String carrera, int grupo, String idBecado, int noCuarto) {
      super(ci, nombre, primer_apellido, segundo_apellido, facultad, curso, tipoCurso,
            carrera,
            grupo);
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
