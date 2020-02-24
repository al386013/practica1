package principal;

import datos.llamadas.Llamada;

import java.util.HashMap;

public class GestorLlamadas {
    HashMap<String, Llamada> llamadas; //La clave es el numero de telefono del cliente


    public GestorLlamadas(){
        this.llamadas = new HashMap<String, Llamada>();
    }

    public void efectuarLlamada(String telefonoCliente, String telefonoDestino, int duracion){
        //Comprobar que el telefono existe:
        Llamada nueva = new Llamada(telefonoDestino, duracion);
        llamadas.put(telefonoCliente, nueva);
    }

    public String listarLlamadas(){
        return null;
    }
}
