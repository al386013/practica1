package acciones;

import principal.BaseDeDatos;

public class ListadoClientes implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        entrada.imprimirConSalto("\nRECUPERAR EL LISTADO DE TODOS LOS CLIENTES");
        entrada.imprimirConSalto(baseDeDatos.listarClientes());
    }
}
