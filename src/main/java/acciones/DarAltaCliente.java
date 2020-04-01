package acciones;

import datos.clientes.Direccion;
import principal.*;

public class DarAltaCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimir("\nDAR DE ALTA UN NUEVO CLIENTE");
            entrada.imprimir("--> Introduce 'e' para empresa o 'p' para particular: ");
            String letra = sc.next();
            while (!letra.equals("e") && !letra.equals("p")) {
                entrada.imprimir("* Parametro incorrecto. Vuelve a intentarlo: ");
                letra = sc.next();
            }

            String nombre = entrada.pedirNombre();
            
            String apellidos = null;
            if (letra.equals("p")) {
                apellidos = entrada.pedirApellidos();
            }

            String nif = entrada.pedirNif();
            String telf = entrada.pedirTelf("- Introduce el telefono del cliente: ");
            baseDeDatos.compruebaTelfNoExistente(telf);
            String cp = entrada.pedirCP();
            String provincia = entrada.pedirProvincia();
            String poblacion = entrada.pedirPoblacion();
            Direccion direccion = new Direccion(cp, provincia, poblacion);
            String email = entrada.pedirEmail();

            if (letra.equals("p"))
                baseDeDatos.anadirParticular(nombre, apellidos, telf, nif, direccion, email);
            else baseDeDatos.anadirEmpresa(nombre, telf, nif, direccion, email);

            entrada.imprimir("\n\tCreado cliente " + nombre + " con NIF " + nif + " y telefono " + telf + ".\n");
        } catch (NifRepetidoException | TelfRepetidoException e) {
            e.printStackTrace();
        }
    }
}
