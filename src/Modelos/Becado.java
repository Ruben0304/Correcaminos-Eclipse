package Modelos;

import Variables.Facultad;
import Variables.TipoCurso;

public class Becado extends Estudiante {
   private String idBecado;
   private int noCuarto;
   private boolean tieneCarnet;
   private boolean tienePertenencias;

   public Becado(String ci, String nombreUsuario, String contraseña, String nombre, String apellidos, Facultad facultad,
         String especialidad, int curso, TipoCurso tipoCurso, int grupo, String idBecado, int noCuarto) {
      super(ci, nombreUsuario, contraseña, nombre, apellidos, facultad, especialidad, curso, tipoCurso, grupo);
      this.idBecado = idBecado;
      this.noCuarto = noCuarto;
   }

   public boolean tieneCarnet() {
      return tieneCarnet;
   }

   public boolean tienePertenencias() {
      return tienePertenencias;
   }

   public void setTieneCarnet(boolean tieneCarnet) {
      this.tieneCarnet = tieneCarnet;
   }

   public void setTienePertenencias(boolean tienePertenencias) {
      this.tienePertenencias = tienePertenencias;
   }

}
