package principal.acciones;

import interfaces.Accion;
import menus.MenuPrincipal;
import principal.BaseDeDatos;
import principal.excepciones.OpcionIncorrectaException;

import java.util.Scanner;

public class SeleccionaOpcionPrincipal implements Accion {
    public static BaseDeDatos baseDeDatos;
    private transient Scanner sc = new Scanner(System.in);
    public static transient MenuPrincipal opcionMenu = null;

    public SeleccionaOpcionPrincipal(BaseDeDatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException {
        do{
            System.out.println("\n* * * * * * * OPCIONES DISPONIBLES * * * * * * *\n");
            System.out.println(MenuPrincipal.getMenu());
            System.out.print("Introduce una opción: ");
            byte opcion = sc.nextByte();
            if (opcion < 0 || opcion > 4) System.out.println("\n-------------> Opcion incorrecta <-------------");
            else {
                opcionMenu = MenuPrincipal.getOpcion(opcion);
                opcionMenu.ejecutaOpcion(baseDeDatos);
                sc.reset();
            }
    } while (opcionMenu != MenuPrincipal.SALIR_GUARDAR);
    }
}
