/*package controlador.acciones;

import controlador.menus.MenuLlamadas;
import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;

public class SeleccionaOpcionLlamada implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws OpcionIncorrectaException {
        entradaSalida.imprimirConSalto("\n* * * * * * * OPCIONES DE LLAMADAS * * * * * * *\n");
        entradaSalida.imprimirConSalto(MenuLlamadas.getMenu());
        byte opcion = entradaSalida.pedirOpcion();
        if (opcion < 0 || opcion > 4)
            throw new OpcionIncorrectaException(4);
        else {
            MenuLlamadas opcionLlamadas = MenuLlamadas.getOpcion(opcion);
            opcionLlamadas.ejecutaOpcion(baseDeDatos);
        }
    }
}*/
