package acciones;

import interfaces.Accion;
import principal.BaseDeDatos;
import principal.TelfNoExistenteException;

public class BorrarCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nBORRAR UN CLIENTE");
            System.out.print("- Introduce el telefono del cliente: ");
            String telf = sc.next();
            baseDeDatos.compruebaTelfExistente(telf);
            baseDeDatos.borrarCliente(telf);
            System.out.println("\n\tCliente con numero " + telf + " borrado con exito.\n");
        } catch (TelfNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
