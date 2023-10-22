package modelos.entidades;

import utiles.Facultad;
import utiles.TipoCurso;

public class Becado extends Estudiante {
   private String idBecado;
   private int noCuarto;
   private boolean tieneCarnet;
   private boolean tienePertenencias;

   public Becado(String nombreUsuario, String contrasena, String ci, String nombre, String apellidos, Facultad facultad,
         boolean licencia, boolean baja, int curso, TipoCurso tipoCurso, String especialidad, int grupo,
         boolean tieneDeuda, boolean tieneEstipendio, boolean tieneCuentaCerrada, boolean tieneLibrosDeBiblioteca,
         boolean tieneLibrosDocentes, String idBecado, int noCuarto, boolean tieneCarnet, boolean tienePertenencias) {
      super(nombreUsuario, contrasena, ci, nombre, apellidos, facultad, licencia, baja, curso, tipoCurso, especialidad,
            grupo, tieneDeuda, tieneEstipendio, tieneCuentaCerrada, tieneLibrosDeBiblioteca, tieneLibrosDocentes);
      this.idBecado = idBecado;
      this.noCuarto = noCuarto;
      this.tieneCarnet = tieneCarnet;
      this.tienePertenencias = tienePertenencias;
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
