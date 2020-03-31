/*package acciones;

import acciones.Accion;
import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class ContratarTarifaTardes implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nCONTRATAR TARIFA POR HORAS");
            System.out.print("- Introduce el NIF del cliente: ");
            String nif = sc.next();
            baseDeDatos.compruebaNifExistente(nif);
            baseDeDatos.contratarTarifaTardes(nif);
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}*/
