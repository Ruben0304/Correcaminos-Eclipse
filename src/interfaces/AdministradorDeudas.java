package interfaces;

import java.util.Set;

public interface AdministradorDeudas {
 Set<String> obtenerDeudas(String carnet);
 void recogerDeudas(String carnet, Set<String> deudas);
}
