package principal.acciones;

import interfaces.Accion;
import principal.menus.MenuLlamadas;
import principal.excepciones.OpcionIncorrectaException;

public class SeleccionaOpcionLlamada implements Accion {
    @Override
    public void ejecutaAccion() {
        System.out.println("\n* * * * * * * OPCIONES DE LLAMADAS * * * * * * *\n");
        System.out.println(MenuLlamadas.getMenu());
        System.out.print("Introduce una opción: ");
        byte opcion = sc.nextByte();
        if(opcion < 0 || opcion > 4)
            throw new OpcionIncorrectaException();
        MenuLlamadas opcionLlamadas = MenuLlamadas.getOpcion(opcion);
        lanzarOpcionLlamadas(opcionLlamadas);
    }
}
