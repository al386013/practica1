package principal;

import datos.clientes.Cliente;
import datos.contrato.Factura;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

public class GestorFacturas {
    private static int codFac = 0;
    private HashMap<String, Factura> totalFacturas; //por codigo de factura

    //Metodo emitirFactura, devuelve null si no existe el cliente
    public Factura emitirFactura(String nifCliente){
        if(!clientes.containsKey(nifCliente)) return null;
        else {
            Calendar fechaActual = Calendar.getInstance();
            Factura nuevaFactura = new Factura(codFac++, clientes.get(nifCliente).getTarifa(),fechaActual.getTime().toString(),30);
            return nuevaFactura;
        }
    }

    //recuperar los datos de la factura de un cliente a partir de su codigo
    public String recDatosFactura(String cod) {
        Factura factura = totalFacturas.get(cod);
        if(factura == null) return null;
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("NIF del cliente: " + factura.getNifCliente() + ", ");
            sb.append("Código: " + factura.getCodigo() + ", ");
            sb.append("Tarifa: " + factura.getTarifa().getTarifa() + "€/min, ");
            sb.append("Fecha de emisión: " + factura.getFecha_emision() + ", ");
            sb.append("Período de facturación: " + factura.getPeriodo_fact() + "días, ");
            sb.append("Importe: " + factura.getImporte() + "€, ");
            return sb.toString();
        }
    }

    //recuperar todas las facturas de un cliente a partir de u nif
    public String listarFacturasCliente(String nif) {

        Iterator<Cliente> iter = clientes.values().iterator();
        StringBuilder sb = new StringBuilder();
        while(iter.hasNext()) {
            Cliente cliente = iter.next();
            sb.append(recDatosCliente(cliente.getNIF()));
        }
        return sb.toString();
    }
}
