package acciones;

import menus.MenuPrincipal;
import principal.BaseDeDatos;
import java.io.Serializable;

public class SeleccionaOpcionPrincipal implements Accion, Serializable {
    static transient MenuPrincipal opcionMenu = null;
    static BaseDeDatos baseDeDatos;

    //constructores
    public SeleccionaOpcionPrincipal() {
        super();
    }

    public SeleccionaOpcionPrincipal(BaseDeDatos baseDeDatos) {
        SeleccionaOpcionPrincipal.baseDeDatos = baseDeDatos;
    }

    @Override
    public void ejecutaAccion(BaseDeDatos bbdd) {
        do {
            entrada.imprimirConSalto("\n* * * * * * * OPCIONES DISPONIBLES * * * * * * *\n");
            entrada.imprimirConSalto(MenuPrincipal.getMenu());
            try {
                byte opcion = pedirOpcion();
                opcionMenu = MenuPrincipal.getOpcion(opcion);
                opcionMenu.ejecutaOpcion(SeleccionaOpcionPrincipal.baseDeDatos);
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
