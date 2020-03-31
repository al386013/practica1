package acciones;

import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class FacturasCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nLISTAR LAS FACTURAS DE UN CLIENTE");
            System.out.print("- Introduce el NIF del cliente: ");
            String nif = sc.next();
            baseDeDatos.compruebaNifExistente(nif);
            System.out.println(baseDeDatos.listarFacturasCliente(nif));
        } catch(NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
