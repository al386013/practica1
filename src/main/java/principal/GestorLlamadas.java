package principal;

import datos.llamadas.Llamada;

import java.util.HashMap;

public class GestorLlamadas {
    HashMap<String, Llamada> llamadas; //La clave es el NIF del cliente


    public GestorLlamadas(){
        this.llamadas = new HashMap<String, Llamada>();
    }

    public void efectuarLlamada(String nifCliente, String telefonoDestino, int duracion){
        //Comprobar que el nifCliente corresponde con uno existe en Clientes:
        //AQUI TENGO UNA CRISIS EXISTENCIAL:
        //Tengo que comprobar que nifCliente existe en GestorClientes.clientes y no Se como hacerlo (no puedo acceder a los metodos de la otra clase)

        //Una vez comprobado que si puedo efectuar la llamada:
        Llamada nuevaLlamada = new Llamada(telefonoDestino, duracion);
        this.llamadas.put(nifCliente, nuevaLlamada);
    }

    public String listarLlamadas(String nifCliente){
        String llamadas = "";
        StringBuilder sb =
        return llamadas;
    }
}
