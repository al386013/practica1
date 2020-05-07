package modelo.principal;

import modelo.datos.clientes.Cliente;
import modelo.datos.contrato.tarifas.Tarifa;
import modelo.datos.llamadas.Llamada;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GestorClientes implements Serializable {
    Map<String, Cliente> clientes; //clave: nif
    Map<String, String> telfNif;   //clave: telf - relaciona el telf con el nif del cliente

    public GestorClientes() {
        super();
        clientes = new HashMap<String, Cliente>();
        telfNif = new HashMap<String, String>();
    }

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
    public void anadirCliente(Cliente cliente) {
        clientes.put(cliente.getNIF(), cliente);
        telfNif.put(cliente.getTelf(), cliente.getNIF());
    }

    //Metodo borrarCliente: lo elimina de clientes a partir de su telefono
    public void borrarCliente(String telf) { //al borrarlo no se borran sus facturas de totalFacturas
        String nif = telfNif.get(telf);
        clientes.remove(nif); //se borra de clientes
        telfNif.remove(telf); //y del telfNif
    }

    public void contratarTarifaEspecial(Tarifa tarifa, Cliente cliente) {
        cliente.setTarifa(tarifa);
    }

    //Metodo listarDatosCliente, recupera todos los modelo.principal.datos de un cliente a partir del NIF
    public String listarDatosCliente(String NIF) {
        return clientes.get(NIF).toString();
    }

    //Método darDeAltaLlamada: crea y anade una llamada al conjunto de llamadas de un cliente
    public void darDeAltaLlamada(String telfOrigen, Llamada llamada) {
        clientes.get(telfNif.get(telfOrigen)).anadirLlamada(llamada);
    }
}