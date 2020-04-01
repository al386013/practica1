package acciones;

import principal.BaseDeDatos;

public class ListadoClientes implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        entrada.imprimir("\nRECUPERAR EL LISTADO DE TODOS LOS CLIENTES");
        entrada.imprimir(baseDeDatos.listarClientes());
    }
}
