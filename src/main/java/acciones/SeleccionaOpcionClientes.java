package acciones;

import interfaces.Accion;
import menus.MenuClientes;
import principal.BaseDeDatos;

public class SeleccionaOpcionClientes implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException {
        System.out.println("\n* * * * * * * OPCIONES DE CLIENTES * * * * * * *\n");
        System.out.println(MenuClientes.getMenu());
        System.out.print("Introduce una opción: ");
        byte opcion = sc.nextByte();
        if(opcion < 0 || opcion > 7)
            throw new OpcionIncorrectaException(7);
        else {
            MenuClientes opcionClientes = MenuClientes.getOpcion(opcion);
            opcionClientes.ejecutaOpcion(baseDeDatos);
        }
    }
}
