package acciones;

import interfaces.Accion;
import menus.MenuCambiarTarifa;
import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class SeleccionaOpcionCambiarTarifa implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nCONTRATAR UNA TARIFA ESPECIAL");

            //tres lineas anadidas (y el try catch)
            System.out.print("- Introduce el NIF del cliente: ");
            String nif = sc.next();
            baseDeDatos.compruebaNifExistente(nif);

            System.out.println("\n" + MenuCambiarTarifa.getMenu());
            byte opcion = pedirOpcion();
            MenuCambiarTarifa opcionCambiarTarifa = MenuCambiarTarifa.getOpcion(opcion);
            baseDeDatos.contratarTarifaEspecial(opcionCambiarTarifa, nif); //linea nueva
            //opcionCambiarTarifa.ejecutaOpcion(baseDeDatos);

            System.out.println("\n\t--> Tarifa especial contratada.\n");
        } catch (NifNoExistenteException | OpcionIncorrectaException e) {
            e.printStackTrace();
        }
    }

    private byte pedirOpcion() throws OpcionIncorrectaException {
        System.out.print("Introduce la tarifa a contratar: ");
        byte opcion = sc.nextByte();
        if (opcion < 0 || opcion > 2)
            throw new OpcionIncorrectaException(2);
        return opcion;
    }
}
