package principal;

import datos.clientes.Cliente;
import datos.contrato.Factura;
import datos.contrato.PeriodoFacturacion;
import java.util.HashMap;

public class GestorFacturas {
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
    public void emitirFactura(PeriodoFacturacion periodoFacturacion, Cliente cliente) {
        Factura nuevaFactura = new Factura(periodoFacturacion, cliente);
        //se anade al total de facturas
        totalFacturas.put(nuevaFactura.getCodigo(), nuevaFactura);
        //y al conjunto de facturas del cliente
        cliente.anadirFactura(nuevaFactura);
    }

    //Metodo obtenerFactura: devuelve la factura a partir de su codigo de factura
    public Factura obtenerFactura(String codFac){
        return this.totalFacturas.get(codFac);
    }
}
