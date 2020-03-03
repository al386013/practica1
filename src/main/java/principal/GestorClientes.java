package principal;

import datos.clientes.Cliente;
import datos.contrato.Factura;
import datos.llamadas.Llamada;

import java.util.HashMap;

public class GestorClientes {
    //ATRIBUTOS
    private HashMap<String, Cliente> clientes; //clave: nif
    private HashMap<String, String> telfNif;   //clave: telf - relaciona el telf con el nif del cliente

    //CONSTRUCTORES
    public GestorClientes() {
        clientes = new HashMap<String, Cliente>();
        telfNif = new HashMap<String, String>();
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

    //Metodo existeTelf: devuelve true si existe el telefono del cliente en la base de datos
    public boolean existeTelf(String telf) {
        return telfNif.get(telf) != null;
    }

    //Metodo anadirCliente, llama al constructor de Cliente, lo crea, se anade a la base de datos
    public void anadirParticular(Cliente cliente) {
        clientes.put(cliente.getNIF(), cliente);
        telfNif.put(cliente.getTelf(), cliente.getNIF());
    }

    //Metodo borrarCliente: lo elimina de clientes a partir de su telefono
    public void borrarCliente(String telf) { //al borrarlo no se borran sus facturas de totalFacturas
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
    public void darDeAltaLlamada(String telfOrigen, Llamada llamada) {
        clientes.get(telfNif.get(telfOrigen)).anadirLlamada(llamada);
    }

    //Metodo listarLlamadasCliente: lista todas las llamadas de un cliente a partir de su telefono
    public String listarLlamadasCliente(String telf) {
        StringBuilder sb = new StringBuilder();
        for (Llamada llamada : clientes.get(telfNif.get(telf)).getLlamadas()) {
            sb.append(llamada.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    //Metodo listarFacturasCliente: recupera todas las facturas de un cliente a partir de su nif
    public String listarFacturasCliente(String nif) {
        StringBuilder sb = new StringBuilder();
        for (Factura factura : clientes.get(nif).getFacturas()) {
            sb.append(factura.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
