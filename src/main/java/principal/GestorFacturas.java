package principal;

import datos.clientes.Cliente;
import datos.contrato.Factura;
import java.util.Calendar;
import java.util.HashMap;

public class GestorFacturas {
    private HashMap<Integer, Factura> totalFacturas; //por codigo de factura

    public GestorFacturas() {
        totalFacturas = new HashMap<Integer, Factura>();
    }

    //Metodo emitirFactura, anade una factura a totalFacturas
    public void emitirFactura(GestorClientes gestorClientes, String nif) {
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        Calendar fechaActual = Calendar.getInstance();
        Factura nuevaFactura = new Factura(codFac, cliente.getTarifa(), fechaActual.toString(), 30, cliente);
        cliente.anadirFactura(codFac, nuevaFactura);
        //cliente.clearLlamadasPeriodoFact();
        totalFacturas.put(codFac++, nuevaFactura);
    }

    //Metodo recDatosFactura, recupera los datos de la factura de un cliente a partir de su codigo
    public String recDatosFactura(int cod) {
        Factura factura = totalFacturas.get(cod);
        if (factura == null) return null;
        else return factura.toString();
    }

    //Metodo listarFacturasCliente, recupera todas las facturas de un cliente a partir de su nif
    public String listarFacturasCliente(GestorClientes gestorClientes, String nif) {
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        StringBuilder sb = new StringBuilder();
        for (Factura factura : cliente.getFacturas())
            sb.append(recDatosFactura(factura.getCodigo()));
        return sb.toString();
    }
}
