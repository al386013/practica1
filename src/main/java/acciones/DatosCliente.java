package acciones;

import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class DatosCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimir("\nRECUPERAR LOS DATOS DE UN CLIENTE");
            String nif = entrada.pedirNif();
            baseDeDatos.compruebaNifExistente(nif);
            entrada.imprimir(baseDeDatos.listarDatosCliente(nif) + "\n");
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
