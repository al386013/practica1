package controlador.acciones;

import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;

public class ListadoClientes implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        entradaSalida.imprimirConSalto("\nRECUPERAR EL LISTADO DE TODOS LOS CLIENTES");
        entradaSalida.imprimirConSalto(baseDeDatos.listarClientes());
    }
}
