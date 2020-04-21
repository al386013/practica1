package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.NifNoExistenteException;

public class DatosCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entradaSalida.imprimirConSalto("\nRECUPERAR LOS DATOS DE UN CLIENTE");
            String nif = entradaSalida.pedirNif();
            baseDeDatos.compruebaNifExistente(nif);
            entradaSalida.imprimirConSalto(baseDeDatos.listarDatosCliente(nif) + "\n");
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
