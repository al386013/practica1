package acciones;

import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class FacturasCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimirConSalto("\nLISTAR LAS FACTURAS DE UN CLIENTE");
            String nif = entrada.pedirNif();
            baseDeDatos.compruebaNifExistente(nif);
            entrada.imprimirConSalto(baseDeDatos.listarFacturasCliente(nif));
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
