package acciones;

import interfaces.Accion;
import menus.MenuCambiarTarifa;
import menus.MenuFacturas;
import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class SeleccionaOpcionCambiarTarifa implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException
        try {
            System.out.println("\nCONTRATAR UNA TARIFA ESPECIAL");
            System.out.print("- Introduce el NIF del cliente: ");
            String nif = sc.next();
            baseDeDatos.compruebaNifExistente(nif);
            System.out.println(MenuFacturas.getMenu());
            System.out.print("\n\t- Introduce la tarifa a contratar: ");
            byte opcion = sc.next();
            if(opcion < 0 || opcion > 2)
                throw new OpcionIncorrectaException(2);
            else {
                MenuCambiarTarifa opcionCambiarTarifa = MenuCambiarTarifa.getOpcion(opcion);
                opcionCambiarTarifa.ejecutaOpcion(baseDeDatos);
            }
            baseDeDatos.contratarTarifaEspecial(opcion, nif);
            System.out.println("\n\tTarifa especial contratada.\n");
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
