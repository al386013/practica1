package principal;

import datos.clientes.Cliente;
import datos.llamadas.Llamada;
import java.util.HashMap;
import java.util.LinkedList;

public class GestorLlamadas {
    HashMap<String, LinkedList<Llamada>> llamadas; //La clave es el NIF del cliente

    public GestorLlamadas() {
        llamadas = new HashMap<String, LinkedList<Llamada>>();
    }

    //Metodo efectuarLlamada, da de alta una llamada
    public void efectuarLlamada(GestorClientes gc, String nif, String telfDestino, String fecha, String hora, int duracion) {
        Cliente cliente = gc.devuelveCliente(nif);
        Llamada llamada = new Llamada(telfDestino, fecha, hora, duracion);
        cliente.anadirLlamadaPeriodoFact(llamada);
        LinkedList<Llamada> listaLlamadas = llamadas.get(nif);
        if(listaLlamadas == null) {
            listaLlamadas = new LinkedList<Llamada>();
            listaLlamadas.add(llamada);
            llamadas.put(nif, listaLlamadas);
        }
        else listaLlamadas.add(llamada);
    }

    //Metodo listarLlamadas: lista todas las llamadas de un cliente; devuelve null si todavia no ha hecho llamadas
    public String listarLlamadas(String nif) {
        LinkedList<Llamada> listaLlamadas = llamadas.get(nif);
        if (listaLlamadas == null) return null;
        else {
            StringBuilder sb = new StringBuilder();
            for (Llamada llamada : listaLlamadas)
                sb.append(llamada.toString());
            return sb.toString();
        }
    }
}
