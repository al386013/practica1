package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.NifRepetidoException;
import modelo.principal.TelfRepetidoException;
import modelo.datos.clientes.Direccion;
import vista.InterrogaVista;
import vista.InterrogaVistaClientes;

public class DarAltaCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            InterrogaVistaClientes vistaClientes = vista.getVistaClientes();
            String opcionTipoCliente = vistaClientes.getTipoCliente();
            String nombre = vistaClientes.getNombre();
            String apellidos = null;
            if (opcionTipoCliente.equals("particular")) apellidos = vistaClientes.getApellido();

            String nif = vistaClientes.getNifAnadir();
            baseDeDatos.compruebaNifNoExistente(nif);
            String telf = vistaClientes.getTelfAnadir();
            baseDeDatos.compruebaTelfNoExistente(telf);
            String cp = vistaClientes.getCP();
            String provincia = vistaClientes.getProvincia();
            String poblacion = vistaClientes.getPoblacion();
            Direccion direccion = new Direccion(cp, provincia, poblacion);
            String email = vistaClientes.getEmail();

            if (opcionTipoCliente.equals("particular"))
                baseDeDatos.anadirParticular(nombre, apellidos, telf, nif, direccion, email);
            else baseDeDatos.anadirEmpresa(nombre, telf, nif, direccion, email);

            entradaSalida.imprimirConSalto("\n\tCreado cliente " + nombre + " con NIF " + nif + " y telefono " + telf + ".\n");
        } catch (NifRepetidoException | TelfRepetidoException e) {
            e.printStackTrace();
        }
    }
}
