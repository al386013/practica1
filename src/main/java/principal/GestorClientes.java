package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.clientes.Empresa;
import datos.clientes.Particular;
import java.util.HashMap;

public class GestorClientes {
    private HashMap<String, Cliente> clientes;

    public GestorClientes() {
        clientes = new HashMap<String, Cliente>();
    }

    //Metodo devuelveCliente: si no existe devuelve null
    public Cliente devuelveCliente(String NIF) {
        return clientes.get(NIF);
    }

    //Metodo existeCliente: devuelve si existe el cliente en la base de datos
    public boolean existeCliente(String NIF) {
        return clientes.get(NIF) != null;
    }

    //Metodo anadirParticular, llama al constructor de Cliente, lo crea, se anade a la cartera y lo devuelve.
    //Devuelve null si ya existe el cliente y no lo modifica
    public Cliente anadirParticular(String nombre,String apellidos, String telefono, String NIF, Direccion direccion, String email) {
        //Comprobar que no existe el cliente:
        if (clientes.containsKey(NIF)) return null;
        else {
            Cliente nuevo = new Particular(nombre, apellidos, telefono, NIF, direccion, email);
            clientes.put(NIF, nuevo);
            return nuevo;
        }
    }

    //Metodo anadirEmpresa, llama al constructor de Cliente, lo crea, se anade a la cartera y lo devuelve.
    //Devuelve null si ya existe el cliente y no lo modifica
    public Cliente anadirEmpresa(String nombre, String telefono, String NIF, Direccion direccion, String email) {
        //Comprobar que no existe el cliente:
        if (clientes.containsKey(NIF)) return null;
        else {
            Cliente nuevo = new Empresa(nombre, telefono, NIF, direccion, email);
            clientes.put(NIF, nuevo);
            return nuevo;
        }
    }

    //Metodo borrarCliente: lo elimina de clientes a partir de su nif
    public void borrarCliente(String NIF) {
        Cliente cliente = clientes.get(NIF);
        clientes.remove(NIF);
    }

    //Metodo cambioTarifa: cambia la tarifa de un cliente dado su nif
    public void cambioTarifa(Double nuevaTarifa, String NIF) {
        Cliente cliente = devuelveCliente(NIF);
        cliente.cambiarTarifa(nuevaTarifa);
    }

    //Metodo recDatosCliente, recupera todos los datos de un cliente a partir del NIF
    public String recDatosCliente(String NIF) {
       return clientes.get(NIF).toString();
    }

    //Metodo listarClientes, lista todos los clientes
    public String listarClientes() {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : clientes.values()) {
            sb.append(recDatosCliente(cliente.getNIF()));
            sb.append("\n");
        }
        return sb.toString();
    }
}
