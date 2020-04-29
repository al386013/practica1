package modelo.principal;

import modelo.datos.contrato.Factura;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GestorFacturas implements Serializable {
    private Map<Integer, Factura> totalFacturas; //Clave: codigo de factura

    public GestorFacturas() {
        super();
        totalFacturas = new HashMap<Integer, Factura>();
    }

    //Metodo listarDatosFactura: recupera los modelo.principal.datos de la factura a partir de su codigo
    public String listarDatosFactura(int cod) throws IllegalArgumentException {
        Factura factura = totalFacturas.get(cod);
        if (factura == null) throw new IllegalArgumentException("La factura de codigo " + cod + " no existe. ");
        return "<html>" + factura.toString() + "</html>";
    }

    //Metodo emitirFactura: anade una factura a totalFacturas
    public void emitirFactura(Factura factura, Set<Factura> facturasCliente) {
        //la nueva factura se anade al total de facturas
        totalFacturas.put(factura.getCodigo(), factura);
        //y al conjunto de facturas del cliente
        facturasCliente.add(factura);
    }
}