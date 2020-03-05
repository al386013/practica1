package principal;

import datos.clientes.Cliente;
import datos.contrato.Factura;

import java.io.Serializable;
import java.util.HashMap;

public class GestorFacturas implements Serializable {
    //ATRIBUTOS
    private HashMap<Integer, Factura> totalFacturas; //Clave: codigo de factura

    //CONSTRUCTORES
    public GestorFacturas() {
        totalFacturas = new HashMap<Integer, Factura>();
    }

    //METODOS

    //Metodo listarDatosFactura: recupera los datos de la factura a partir de su codigo
    public String listarDatosFactura(int cod) {
        Factura factura = totalFacturas.get(cod);
        if (factura == null) return null;
        else return factura.toString();
    }

    //Metodo emitirFactura: anade una factura a totalFacturas
    public void emitirFactura(Factura factura, Cliente cliente) {
        //se anade al total de facturas
        totalFacturas.put(factura.getCodigo(), factura);
        //y al conjunto de facturas del cliente
        cliente.anadirFactura(factura);
    }
}
