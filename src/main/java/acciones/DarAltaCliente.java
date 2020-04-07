package acciones;

import datos.clientes.Direccion;
import menus.MenuTipoCliente;
import principal.*;

public class DarAltaCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException {
        try {
            entradaSalida.imprimirConSalto("\nDAR DE ALTA UN NUEVO CLIENTE");
            entradaSalida.imprimirConSalto("\nOpciones para tipo de cliente: ");
            entradaSalida.imprimirConSalto(MenuTipoCliente.getMenu());
            byte opcion = entradaSalida.pedirOpcion();
            if (opcion < 0 || opcion > 1) throw new OpcionIncorrectaException(1);
            MenuTipoCliente opcionTipoCliente = MenuTipoCliente.getOpcion(opcion);

            String nombre = entradaSalida.pedirNombre();
            String apellidos = null;
            if (opcionTipoCliente == MenuTipoCliente.PARTICULAR) apellidos = entradaSalida.pedirApellidos();

            String nif = entradaSalida.pedirNif();
            baseDeDatos.compruebaNifNoExistente(nif);
            String telf = entradaSalida.pedirTelf();
            baseDeDatos.compruebaTelfNoExistente(telf);
            String cp = entradaSalida.pedirCP();
            String provincia = entradaSalida.pedirProvincia();
            String poblacion = entradaSalida.pedirPoblacion();
            Direccion direccion = new Direccion(cp, provincia, poblacion);
            String email = entradaSalida.pedirEmail();

            if (opcionTipoCliente == MenuTipoCliente.PARTICULAR)
                baseDeDatos.anadirParticular(nombre, apellidos, telf, nif, direccion, email);
            else baseDeDatos.anadirEmpresa(nombre, telf, nif, direccion, email);

            entradaSalida.imprimirConSalto("\n\tCreado cliente " + nombre + " con NIF " + nif + " y telefono " + telf + ".\n");
        } catch (NifRepetidoException | TelfRepetidoException e) {
            e.printStackTrace();
        }
    }
}
