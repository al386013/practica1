package acciones;

import menus.MenuFacturas;
import principal.BaseDeDatos;

public class SeleccionaOpcionFacturas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException {
        entrada.imprimirConSalto("\n* * * * * * * OPCIONES DE FACTURAS * * * * * * *\n");
        entrada.imprimirConSalto(MenuFacturas.getMenu());
        byte opcion = entrada.pedirOpcion();
        if (opcion < 0 || opcion > 5)
            throw new OpcionIncorrectaException(5);
        else {
            MenuFacturas opcionFacturas = MenuFacturas.getOpcion(opcion);
            opcionFacturas.ejecutaOpcion(baseDeDatos);
        }
    }
}
