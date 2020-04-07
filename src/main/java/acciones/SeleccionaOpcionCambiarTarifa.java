package acciones;

import menus.MenuCambiarTarifa;
import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class SeleccionaOpcionCambiarTarifa implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entradaSalida.imprimirConSalto("\nCONTRATAR UNA TARIFA ESPECIAL");
            String nif = entradaSalida.pedirNif();
            baseDeDatos.compruebaNifExistente(nif);
            entradaSalida.imprimirConSalto("\n" + MenuCambiarTarifa.getMenu());
            byte opcion = pedirOpcion();
            MenuCambiarTarifa opcionCambiarTarifa = MenuCambiarTarifa.getOpcion(opcion);
            baseDeDatos.contratarTarifaEspecial(opcionCambiarTarifa, nif);
            entradaSalida.imprimirConSalto("\n\t--> Tarifa especial contratada.\n");
        } catch (OpcionIncorrectaException | NifNoExistenteException e) {
            e.printStackTrace();
        }
    }

    private byte pedirOpcion() throws OpcionIncorrectaException {
        byte opcion = entradaSalida.pedirOpcion();
        if (opcion < 0 || opcion > 1)
            throw new OpcionIncorrectaException(1);
        return opcion;
    }
}
