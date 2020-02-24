package datos.clientes;

import datos.contrato.Factura;
import datos.contrato.Tarifa;
import datos.llamadas.Llamada;

import java.util.*;


//preguntar si los constructores son public

public abstract class Cliente {
    private String nombre;
    private String NIF;
    private Direccion direccion;
    private String email;
    private String fechaDeAlta;
    private Tarifa tarifa;
    private HashMap<int, Factura> facturas; //La clave corresponde al codigo de factura

    public Cliente(final String nombre, final String NIF, final Direccion direccion, final String email){
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        //Preguntar si las siguentes sentencias corresponde a la fecha actual del sistema:
        Calendar fechaActual = Calendar.getInstance();
        this.fechaDeAlta = fechaActual.toString();
        this.tarifa = new Tarifa(); //Preguntar si es necesario instanciar
        this.facturas = new HashMap<int, Factura>();
    }

    //Metodo que realiza una llamada, debemos guardar todos los minutos que lleva
    public Llamada efectuarLlamada(){
        //El cliente introduce el telefono destino y la duracion????
        //Se que esto habrá que cambiarlo pero es por tener algo:
        Llamada efectuada = new Llamada("692245585", 2);
        return efectuada;
    }

}