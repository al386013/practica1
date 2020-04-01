package acciones;

import menus.MenuLlamadas;
import principal.BaseDeDatos;

public class SeleccionaOpcionLlamada implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException {
        entrada.imprimir("\n* * * * * * * OPCIONES DE LLAMADAS * * * * * * *\n");
        entrada.imprimir(MenuLlamadas.getMenu());
        byte opcion = entrada.pedirOpcion();
        if(opcion < 0 || opcion > 4)
            throw new OpcionIncorrectaException(4);
        else {
            MenuLlamadas opcionLlamadas = MenuLlamadas.getOpcion(opcion);
            opcionLlamadas.ejecutaOpcion(baseDeDatos);
        }
    }
}
