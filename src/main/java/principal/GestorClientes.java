package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.clientes.Empresa;
import datos.clientes.Particular;
import datos.contrato.Factura;
import datos.llamadas.Llamada;

import java.util.HashMap;

public class GestorClientes {
    //ATRIBUTOS
    private HashMap<String, Cliente> clientes; //clave: nif
    private HashMap<String, String> telfNif;   //clave: telf; relaciona el telf con el nif del cliente

    //CONSTRUCTORES
    public GestorClientes() {
        clientes = new HashMap<String, Cliente>();
    }

    //METODOS

    //Metodo devuelveCliente: si un cliente no existe devuelve null
    public Cliente devuelveCliente(String NIF) {
        return clientes.get(NIF);
    }

    //Metodo existeCliente: devuelve true si existe el cliente en la base de datos
    public boolean existeCliente(String NIF) {
        return clientes.get(NIF) != null;
    }

    //Metodo anadirParticular, llama al constructor de Cliente, lo crea, se anade a la cartera y lo devuelve.
    //Devuelve null si ya existe el cliente y no lo modifica
    public Cliente anadirParticular(String nombre, String apellidos, String telefono, String NIF, Direccion direccion, String email) {
        //Comprobar que no existe el cliente:
        if (existeCliente(NIF)) return null;
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
        if (existeCliente(NIF)) return null;
        else {
            Cliente nuevo = new Empresa(nombre, telefono, NIF, direccion, email);
            clientes.put(NIF, nuevo);
            return nuevo;
        }
    }

    //Metodo borrarCliente: lo elimina de clientes a partir de su telefono
    public void borrarCliente(String telf) { //al borrarlo no se forran sus facturas de totalFacturas
        String nif = telfNif.get(telf);
        clientes.remove(nif); //se borra de clientes
        telfNif.remove(telf); //y del telfNif
    }

    //Metodo cambioTarifa: cambia la tarifa de un cliente dado su nif
    public void cambioTarifa(float nuevaTarifa, String NIF) {
        clientes.get(NIF).cambiarTarifa(nuevaTarifa);
    }

    //Metodo listarDatosCliente, recupera todos los datos de un cliente a partir del NIF
    public String listarDatosCliente(String NIF) {
       return clientes.get(NIF).toString();
    }

    //Metodo listarClientes, lista todos los clientes
    public String listarClientes() {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : clientes.values()) {
            sb.append(listarDatosCliente(cliente.getNIF()));
            sb.append("\n");
        }
        return sb.toString();
    }

    //Método darDeAltaLlamada: crea y anade una llamada al conjunto de llamadas de un cliente
    public void darDeAltaLlamada(String nif, String telfDestino, String fecha, String hora, int duracion) {
        Llamada llamada = new Llamada(telfDestino, fecha, hora, duracion);
        clientes.get(nif).anadirLlamada(llamada);
    }

    //Metodo listarLlamadasCliente: lista todas las llamadas de un cliente
    public String listarLlamadasCliente(String nif) {
        StringBuilder sb = new StringBuilder();
        for(Llamada llamada : clientes.get(nif).getLlamadas())
            sb.append(llamada.toString());
        return sb.toString();
    }

    //Metodo listarFacturasCliente: recupera todas las facturas de un cliente a partir de su nif
    public String listarFacturasCliente(String nif) {
        StringBuilder sb = new StringBuilder();
        for (Factura factura : clientes.get(nif).getFacturas())
            sb.append(factura.toString());
        return sb.toString();
    }


}
