package principal;

import datos.clientes.Cliente;
import datos.contrato.Factura;
import datos.llamadas.Llamada;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;

public class GestorFacturas {
    //ATRIBUTOS
    private HashMap<Integer, Factura> totalFacturas; //Clave corresponde al codigo de factura

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
}
