package acciones;

import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class FacturasCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entradaSalida.imprimirConSalto("\nLISTAR LAS FACTURAS DE UN CLIENTE");
            String nif = entradaSalida.pedirNif();
            baseDeDatos.compruebaNifExistente(nif);
            entradaSalida.imprimirConSalto(baseDeDatos.listarFacturasCliente(nif));
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
