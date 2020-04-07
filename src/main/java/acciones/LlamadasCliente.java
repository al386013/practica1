package acciones;

import principal.BaseDeDatos;
import principal.TelfNoExistenteException;

public class LlamadasCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entradaSalida.imprimirConSalto("\nLISTAR TODAS LAS LLAMADAS DE UN CLIENTE");
            String telf = entradaSalida.pedirTelf();
            baseDeDatos.compruebaTelfExistente(telf);
            entradaSalida.imprimirConSalto(baseDeDatos.listarLlamadasCliente(telf));
        } catch (TelfNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
