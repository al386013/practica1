package principal;

import datos.clientes.Cliente;
import datos.contrato.Factura;

import java.util.Calendar;

public class BaseDeDatos {
    //ATRIBUTOS
    private GestorClientes gestorClientes;
    private GestorFacturas gestorFacturas;


    //CONSTRUCTOR:
    public BaseDeDatos(){
        this.gestorClientes = new GestorClientes();
        this.gestorFacturas = new GestorFacturas();
    }


    //METODOS

    //Metodo emitirFactura,
    public void emitirFactura(String nif) {

    }


    //Metodo listarFacturasCliente, recupera todas las facturas de un cliente a partir de su nif
    //MODIFICADO Y CREO QUE ESTA BIEN
    public String listarFacturasCliente(String nif) {
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        StringBuilder sb = new StringBuilder();
        for (Factura factura : cliente.getFacturas())
            sb.append(factura.toString());
        return sb.toString();
    }
}
