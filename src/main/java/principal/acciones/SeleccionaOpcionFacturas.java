package principal.acciones;

import interfaces.Accion;
import menus.MenuFacturas;
import principal.BaseDeDatos;
import principal.excepciones.OpcionIncorrectaException;

public class SeleccionaOpcionFacturas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        System.out.println("\n* * * * * * * OPCIONES DE FACTURAS * * * * * * *\n");
        System.out.println(MenuFacturas.getMenu());
        System.out.print("Introduce una opción: ");
        byte opcion = sc.nextByte();
        /*if(opcion < 0 || opcion > 5)
            throw new OpcionIncorrectaException();*/
        if (opcion < 0 || opcion > 5)
            System.out.println("\n-------------> Opcion incorrecta <-------------");
        else {
            MenuFacturas opcionFacturas = MenuFacturas.getOpcion(opcion);
            opcionFacturas.ejecutaOpcion(baseDeDatos);
        }
    }
}
