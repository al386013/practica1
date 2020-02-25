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

    //Metodo recDatosFactura, recupera los datos de la factura de un cliente a partir de su codigo
    public String recDatosFactura(int cod) {
        Factura factura = totalFacturas.get(cod);
        if (factura == null) return null;
        else return factura.toString();
    }

    //Metodo efectuarLlamada, da de alta una llamada
    public void efectuarLlamada(GestorClientes gc, String nif, String telfDestino, String fecha, String hora, int duracion) {
//        Cliente cliente = gc.devuelveCliente(nif);
//        Llamada llamada = new Llamada(telfDestino, fecha, hora, duracion);
//        //cliente.anadirLlamadaPeriodoFact(llamada);
//        LinkedList<Llamada> listaLlamadas = llamadas.get(nif);
//        if(listaLlamadas == null) {
//            listaLlamadas = new LinkedList<Llamada>();
//            listaLlamadas.add(llamada);
//            llamadas.put(nif, listaLlamadas);
//        }
//        else listaLlamadas.add(llamada);
    }


}
