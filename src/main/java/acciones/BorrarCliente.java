package acciones;

import principal.BaseDeDatos;
import principal.TelfNoExistenteException;

public class BorrarCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entradaSalida.imprimirConSalto("\nBORRAR UN CLIENTE");
            String telf = entradaSalida.pedirTelf();
            baseDeDatos.compruebaTelfExistente(telf);
            baseDeDatos.borrarCliente(telf);
            entradaSalida.imprimirConSalto("\n\tCliente con numero " + telf + " borrado con exito.\n");
        } catch (TelfNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
