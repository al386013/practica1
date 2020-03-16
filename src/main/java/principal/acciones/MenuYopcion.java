package principal.acciones;

import interfaces.Accion;
import principal.menus.MenuPrincipal;

public class MenuYopcion implements Accion {
    @Override
    public void ejecutaAccion() {
        while (opcionMenu != MenuPrincipal.SALIR_GUARDAR) {
            System.out.println("\n* * * * * * * OPCIONES DISPONIBLES * * * * * * *\n");
            System.out.println(MenuPrincipal.getMenu());
            System.out.print("Introduce una opción: ");
            byte opcion = sc.nextByte();
            if(opcion < 0 || opcion > 4) System.out.println("\n-------------> Opcion incorrecta <-------------");
            else {
                opcionMenu = MenuPrincipal.getOpcion(opcion); //es un atributo global para toda la clase
                lanzarOpcionPrincipal();
            }
        }
    }
}
