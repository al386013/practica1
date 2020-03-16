package principal.acciones;

import interfaces.Accion;

public class DatosCliente implements Accion {
    @Override
    public void ejecutaAccion() {
        System.out.println("\nRECUPERAR LOS DATOS DE UN CLIENTE");
        String nif = pedirNifExistente();
        System.out.println(baseDeDatos.listarDatosCliente(nif) + "\n");
    }
}
