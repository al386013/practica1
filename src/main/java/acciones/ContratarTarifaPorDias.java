package acciones;

import interfaces.Accion;
import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class ContratarTarifaPorDias implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nCONTRATAR TARIFA POR DIAS");
            System.out.print("- Introduce el NIF del cliente: ");
            String nif = sc.next();
            baseDeDatos.compruebaNifExistente(nif);
            baseDeDatos.contratarTarifaPorDias(nif);
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}