package acciones;

import interfaces.Accion;
import menus.MenuPrincipal;
import principal.BaseDeDatos;
import java.io.Serializable;
import java.util.Scanner;

public class SeleccionaOpcionPrincipal implements Accion, Serializable {
    private transient Scanner sc = new Scanner(System.in);
    static transient MenuPrincipal opcionMenu = null;
    static BaseDeDatos baseDeDatos;

    //constructor por defecto
    public SeleccionaOpcionPrincipal() {}

    public SeleccionaOpcionPrincipal(BaseDeDatos baseDeDatos) {
        SeleccionaOpcionPrincipal.baseDeDatos = baseDeDatos;
    }

    @Override
    public void ejecutaAccion(BaseDeDatos bbdd) {
        do {
            System.out.println("\n* * * * * * * OPCIONES DISPONIBLES * * * * * * *\n");
            System.out.println(MenuPrincipal.getMenu());
            try {
                byte opcion = pedirOpcion();
                opcionMenu = MenuPrincipal.getOpcion(opcion);
                opcionMenu.ejecutaOpcion(SeleccionaOpcionPrincipal.baseDeDatos);
                sc.reset(); //No se si es necesario
            } catch (OpcionIncorrectaException e) {
                e.printStackTrace();
            }
        } while (opcionMenu != MenuPrincipal.SALIR_GUARDAR);
    }

    private byte pedirOpcion() throws OpcionIncorrectaException {
        System.out.print("Introduce una opción: ");
        byte opcion = sc.nextByte();
        if (opcion < 0 || opcion > 4)
            throw new OpcionIncorrectaException(4);
        return opcion;
    }
}
