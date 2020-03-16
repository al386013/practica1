package principal.acciones;

import interfaces.Accion;

public class LlamadasCliente implements Accion {
    @Override
    public void ejecutaAccion() {
        System.out.println("\nLISTAR TODAS LAS LLAMADAS DE UN CLIENTE");
        String telf = pedirTelfExistente();
        System.out.println(baseDeDatos.listarLlamadasCliente(telf));
    }
}
