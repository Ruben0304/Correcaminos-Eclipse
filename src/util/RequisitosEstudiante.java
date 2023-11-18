package util;

public class RequisitosEstudiante {
    protected boolean tieneLibrosPrestados;
    protected boolean tieneEstipendio;
    protected boolean tieneDeuda;
    protected boolean tieneLibrosDocentes;
    protected boolean tieneCarnetDeEstudiante;
    protected boolean tieneCuentaUsuarioAbierta;

    
    public boolean isTieneLibrosPrestados() {
        return tieneLibrosPrestados;
    }
    public void setTieneLibrosPrestados(boolean tieneLibrosPrestados) {
        this.tieneLibrosPrestados = tieneLibrosPrestados;
    }
    public boolean isTieneEstipendio() {
        return tieneEstipendio;
    }
    public void setTieneEstipendio(boolean tieneEstipendio) {
        this.tieneEstipendio = tieneEstipendio;
    }
    public boolean isTieneDeuda() {
        return tieneDeuda;
    }
    public void setTieneDeuda(boolean tieneDeuda) {
        this.tieneDeuda = tieneDeuda;
    }
    public boolean isTieneLibrosDocentes() {
        return tieneLibrosDocentes;
    }
    public void setTieneLibrosDocentes(boolean tieneLibrosDocentes) {
        this.tieneLibrosDocentes = tieneLibrosDocentes;
    }
    public boolean isTieneCarnetDeEstudiante() {
        return tieneCarnetDeEstudiante;
    }
    public void setTieneCarnetDeEstudiante(boolean tieneCarnetDeEstudiante) {
        this.tieneCarnetDeEstudiante = tieneCarnetDeEstudiante;
    }
    public boolean isTieneCuentaUsuarioAbierta() {
        return tieneCuentaUsuarioAbierta;
    }
    public void setTieneCuentaUsuarioAbierta(boolean tieneCuentaUsuarioAbierta) {
        this.tieneCuentaUsuarioAbierta = tieneCuentaUsuarioAbierta;
    }

    
}
