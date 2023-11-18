package util;

public class RequisitosEstudianteBecado extends RequisitosEstudiante{
    private boolean tienePertenenciasDeLaCUJAE;
    private boolean tieneCarnetDeBecado;

    public boolean isTienePertenenciasDeLaCUJAE() {
        return tienePertenenciasDeLaCUJAE;
    }
    public void setTienePertenenciasDeLaCUJAE(boolean tienePertenenciasDeLaCUJAE) {
        this.tienePertenenciasDeLaCUJAE = tienePertenenciasDeLaCUJAE;
    }
    public boolean isTieneCarnetDeBecado() {
        return tieneCarnetDeBecado;
    }
    public void setTieneCarnetDeBecado(boolean tieneCarnetDeBecado) {
        this.tieneCarnetDeBecado = tieneCarnetDeBecado;
    }
    
}
