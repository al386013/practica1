package acciones;

import principal.BaseDeDatos;
import principal.TelfNoExistenteException;

public class LlamadasCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nLISTAR TODAS LAS LLAMADAS DE UN CLIENTE");
            System.out.print("- Introduce el telefono del cliente: ");
            String telf = sc.next();
            baseDeDatos.compruebaTelfExistente(telf);
            System.out.println(baseDeDatos.listarLlamadasCliente(telf));
        } catch (TelfNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
