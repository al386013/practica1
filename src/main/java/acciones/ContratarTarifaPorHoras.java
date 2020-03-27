package acciones;

import interfaces.Accion;
import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class ContratarTarifaPorHoras implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nCONTRATAR TARIFA POR HORAS");
            System.out.print("- Introduce el NIF del cliente: ");
            String nif = sc.next();
            baseDeDatos.compruebaNifExistente(nif);
            baseDeDatos.contratarTarifaPorHoras(nif);
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
