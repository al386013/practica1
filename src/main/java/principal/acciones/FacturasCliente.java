package principal.acciones;

import interfaces.Accion;

public class FacturasCliente implements Accion {
    @Override
    public void ejecutaAccion() {
        System.out.println("\nLISTAR LAS FACTURAS DE UN CLIENTE");
        String nif = pedirNifExistente();
        System.out.println(baseDeDatos.listarFacturasCliente(nif));
    }
}
