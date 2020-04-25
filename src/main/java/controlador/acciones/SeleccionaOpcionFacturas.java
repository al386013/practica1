/*package controlador.acciones;

import controlador.menus.MenuFacturas;
import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;

public class SeleccionaOpcionFacturas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws OpcionIncorrectaException {
        entradaSalida.imprimirConSalto("\n* * * * * * * OPCIONES DE FACTURAS * * * * * * *\n");
        entradaSalida.imprimirConSalto(MenuFacturas.getMenu());
        byte opcion = entradaSalida.pedirOpcion();
        if (opcion < 0 || opcion > 5)
            throw new OpcionIncorrectaException(5);
        else {
            MenuFacturas opcionFacturas = MenuFacturas.getOpcion(opcion);
            opcionFacturas.ejecutaOpcion(baseDeDatos);
        }
    }
}*/
