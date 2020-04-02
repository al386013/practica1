package acciones;

import datos.clientes.Direccion;
import menus.MenuTipoCliente;
import principal.*;

public class DarAltaCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException {
        try {
            entrada.imprimir("\nDAR DE ALTA UN NUEVO CLIENTE");
            entrada.imprimir("\nOpciones para tipo de cliente: \n");
            entrada.imprimir(MenuTipoCliente.getMenu());
            byte opcion = entrada.pedirOpcion();
            if (opcion < 0 || opcion > 1) throw new OpcionIncorrectaException(1);
            MenuTipoCliente opcionTipoCliente = MenuTipoCliente.getOpcion(opcion);

            String nombre = entrada.pedirNombre();
            String apellidos = null;
            if (opcionTipoCliente == MenuTipoCliente.PARTICULAR) apellidos = entrada.pedirApellidos();

            String nif = entrada.pedirNif();
            baseDeDatos.compruebaNifNoExistente(nif);
            String telf = entrada.pedirTelf();
            baseDeDatos.compruebaTelfNoExistente(telf);
            String cp = entrada.pedirCP();
            String provincia = entrada.pedirProvincia();
            String poblacion = entrada.pedirPoblacion();
            Direccion direccion = new Direccion(cp, provincia, poblacion);
            String email = entrada.pedirEmail();

            if (opcionTipoCliente == MenuTipoCliente.PARTICULAR)
                baseDeDatos.anadirParticular(nombre, apellidos, telf, nif, direccion, email);
            else baseDeDatos.anadirEmpresa(nombre, telf, nif, direccion, email);

            entrada.imprimir("\n\tCreado cliente " + nombre + " con NIF " + nif + " y telefono " + telf + ".\n");
        } catch (NifRepetidoException | TelfRepetidoException e) {
            e.printStackTrace();
        }
    }
}
