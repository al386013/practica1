package acciones;

import interfaces.Accion;
import menus.MenuCambiarTarifa;
import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class SeleccionaOpcionCambiarTarifa implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException {
        System.out.println("\nCONTRATAR UNA TARIFA ESPECIAL");

        /*System.out.print("- Introduce el NIF del cliente: ");
        String nif = sc.next();
        baseDeDatos.compruebaNifExistente(nif);*/

        System.out.println(MenuCambiarTarifa.getMenu());
        System.out.print("Introduce la tarifa a contratar: ");
        byte opcion = sc.nextByte();
        if (opcion < 0 || opcion > 2)
            throw new OpcionIncorrectaException(2);
        else {
            MenuCambiarTarifa opcionCambiarTarifa = MenuCambiarTarifa.getOpcion(opcion);
            opcionCambiarTarifa.ejecutaOpcion(baseDeDatos);
        }
        System.out.println("\n\t--> Tarifa especial contratada.\n");
    }
}
