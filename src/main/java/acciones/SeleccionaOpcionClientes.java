package acciones;

import menus.MenuClientes;
import principal.BaseDeDatos;

public class SeleccionaOpcionClientes implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException {
        entrada.imprimir("\n* * * * * * * OPCIONES DE CLIENTES * * * * * * *\n");
        entrada.imprimir(MenuClientes.getMenu());
        byte opcion = entrada.pedirOpcion();
        if(opcion < 0 || opcion > 7)
            throw new OpcionIncorrectaException(7);
        else {
            MenuClientes opcionClientes = MenuClientes.getOpcion(opcion);
            opcionClientes.ejecutaOpcion(baseDeDatos);
        }
    }
}
