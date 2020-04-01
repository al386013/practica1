package acciones;

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
            entrada.imprimir("\n* * * * * * * OPCIONES DISPONIBLES * * * * * * *\n");
            entrada.imprimir(MenuPrincipal.getMenu());
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
        byte opcion = entrada.pedirOpcion();
        if (opcion < 0 || opcion > 4)
            throw new OpcionIncorrectaException(4);
        return opcion;
    }
}
