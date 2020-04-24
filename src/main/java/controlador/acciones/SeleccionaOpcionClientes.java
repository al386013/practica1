/*package controlador.acciones;

import controlador.menus.MenuClientes;
import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;

public class SeleccionaOpcionClientes implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws OpcionIncorrectaException {
        entradaSalida.imprimirConSalto("\n* * * * * * * OPCIONES DE CLIENTES * * * * * * *\n");
        entradaSalida.imprimirConSalto(MenuClientes.getMenu());
        byte opcion = entradaSalida.pedirOpcion();
        if (opcion < 0 || opcion > 7)
            throw new OpcionIncorrectaException(7);
        else {
            MenuClientes opcionClientes = MenuClientes.getOpcion(opcion);
            opcionClientes.ejecutaOpcion(baseDeDatos);
        }
    }
}*/
