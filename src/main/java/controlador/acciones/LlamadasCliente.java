package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.TelfNoExistenteException;

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
