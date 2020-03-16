package principal.acciones;

import interfaces.Accion;

public class BorrarCliente implements Accion {
    @Override
    public void ejecutaAccion() {
        System.out.println("\nBORRAR UN CLIENTE");
        String telf = pedirTelfExistente();
        baseDeDatos.borrarCliente(telf);
        System.out.println("\n\tCliente con numero " + telf + " borrado con exito.\n");
    }
}
