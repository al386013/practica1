package principal.acciones;

import interfaces.Accion;
import principal.menus.MenuClientes;
import principal.excepciones.OpcionIncorrectaException;

public class SeleccionaOpcionClientes implements Accion {
    @Override
    public void ejecutaAccion() {
        System.out.println("\n* * * * * * * OPCIONES DE CLIENTES * * * * * * *\n");
        System.out.println(MenuClientes.getMenu());
        System.out.print("Introduce una opción: ");
        byte opcion = sc.nextByte();
        if(opcion < 0 || opcion > 7)
            throw new OpcionIncorrectaException();
        MenuClientes opcionClientes = MenuClientes.getOpcion(opcion);
        lanzarOpcionClientes(opcionClientes);
    }
}
