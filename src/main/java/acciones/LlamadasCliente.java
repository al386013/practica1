package acciones;

import principal.BaseDeDatos;
import principal.TelfNoExistenteException;

public class LlamadasCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimirConSalto("\nLISTAR TODAS LAS LLAMADAS DE UN CLIENTE");
            String telf = entrada.pedirTelf();
            baseDeDatos.compruebaTelfExistente(telf);
            entrada.imprimirConSalto(baseDeDatos.listarLlamadasCliente(telf));
        } catch (TelfNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
