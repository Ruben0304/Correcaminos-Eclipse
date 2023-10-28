package modelos.entidades;

import utiles.Facultad;
import utiles.TipoCurso;

public class Becado extends Estudiante {
   private String idBecado;
   private int noCuarto;
   private boolean entregoCarnetBecado;
   private boolean entregoPertenencias;

   public Becado(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
   Facultad facultad, boolean licencia, boolean baja, int curso, TipoCurso tipoCurso, String carrera, int grupo,
         boolean entregoCarnet, boolean tieneDeuda, boolean tieneEstipendio, boolean tieneCuentaCerrada,
         boolean tieneLibrosDeBiblioteca, boolean tieneLibrosDocentes, String idBecado, int noCuarto,
         boolean entregoCarnetBecado, boolean entregoPertenencias) {
      super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido, facultad, licencia, baja, curso, tipoCurso, carrera,
            grupo,
            entregoCarnet, tieneDeuda, tieneEstipendio, tieneCuentaCerrada, tieneLibrosDeBiblioteca,
            tieneLibrosDocentes);
      this.idBecado = idBecado;
      this.noCuarto = noCuarto;
      this.entregoCarnetBecado = entregoCarnetBecado;
      this.entregoPertenencias = entregoPertenencias;
   }

   public String getIdBecado() {
      return idBecado;
   }

   public int getNoCuarto() {
      return noCuarto;
   }

   public boolean entregoCarnetBecado() {
      return entregoCarnetBecado;
   }

   public boolean entregoPertenencias() {
      return entregoPertenencias;
   }

}
