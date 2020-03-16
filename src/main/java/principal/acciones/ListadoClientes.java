package principal.acciones;

import interfaces.Accion;

public class ListadoClientes implements Accion {
    @Override
    public void ejecutaAccion() {
        System.out.println("\nRECUPERAR EL LISTADO DE TODOS LOS CLIENTES");
        System.out.println(baseDeDatos.listarClientes());
    }
}
