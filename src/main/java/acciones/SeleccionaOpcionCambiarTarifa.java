package acciones;

import menus.MenuCambiarTarifa;
import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class SeleccionaOpcionCambiarTarifa implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimir("\nCONTRATAR UNA TARIFA ESPECIAL");

            //tres lineas anadidas (y el try catch)

            String nif = entrada.pedirNif();
            baseDeDatos.compruebaNifExistente(nif);

            entrada.imprimir("\n" + MenuCambiarTarifa.getMenu());
            byte opcion = pedirOpcion();
            MenuCambiarTarifa opcionCambiarTarifa = MenuCambiarTarifa.getOpcion(opcion);
            baseDeDatos.contratarTarifaEspecial(opcionCambiarTarifa, nif); //linea nueva
            //opcionCambiarTarifa.ejecutaOpcion(baseDeDatos);

            entrada.imprimir("\n\t--> Tarifa especial contratada.\n");
        } catch (OpcionIncorrectaException | NifNoExistenteException e) {
            e.printStackTrace();
        }
    }

    private byte pedirOpcion() throws OpcionIncorrectaException {
        byte opcion = entrada.pedirOpcion();
        if (opcion < 0 || opcion > 1)
            throw new OpcionIncorrectaException(1);
        return opcion;
    }
}
