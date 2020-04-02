package acciones;

import principal.BaseDeDatos;
import principal.TelfNoExistenteException;

public class BorrarCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimirConSalto("\nBORRAR UN CLIENTE");
            String telf = entrada.pedirTelf();
            baseDeDatos.compruebaTelfExistente(telf);
            baseDeDatos.borrarCliente(telf);
            entrada.imprimirConSalto("\n\tCliente con numero " + telf + " borrado con exito.\n");
        } catch (TelfNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
