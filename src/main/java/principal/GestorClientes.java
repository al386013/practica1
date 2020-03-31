package principal;

import datos.clientes.Cliente;
import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaDomingosGratis;
import datos.contrato.tarifas.TarifaTardesReducida;
import datos.llamadas.Llamada;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GestorClientes implements Serializable {

    //ATRIBUTOS
    Map<String, Cliente> clientes; //clave: nif
    Map<String, String> telfNif;   //clave: telf - relaciona el telf con el nif del cliente

    //CONSTRUCTOR
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

    /*
    //Metodo contratarTarifaPorDias: contrata la tarifa por dias de un cliente dado su nif
    public void contratarTarifaDomingos(String NIF) {
        Cliente cliente = clientes.get(NIF);
        Tarifa tarifa = cliente.getTarifa();
        tarifa = new TarifaDomingosGratis(tarifa, 0.00f);
        cliente.setTarifa(tarifa);
    }

    //Metodo contratarTarifaPorHoras: contrata la tarifa por horas de un cliente dado su nif
    public void contratarTarifaTardes(String NIF) {
        Cliente cliente = clientes.get(NIF);
        Tarifa tarifa = cliente.getTarifa();
        tarifa = new TarifaTardesReducida(tarifa, 0.03f);
        cliente.setTarifa(tarifa);
    } */

    public void contratarTarifaEspecial(Tarifa tarifa, String nif) {
        Cliente cliente = clientes.get(nif);
        cliente.setTarifa(tarifa);
    }

    //Metodo listarDatosCliente, recupera todos los datos de un cliente a partir del NIF
    public String listarDatosCliente(String NIF) {
        return clientes.get(NIF).toString();
    }

    //Método darDeAltaLlamada: crea y anade una llamada al conjunto de llamadas de un cliente
    public void darDeAltaLlamada(String telfOrigen, Llamada llamada) {
        clientes.get(telfNif.get(telfOrigen)).anadirLlamada(llamada);
    }
}