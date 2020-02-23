package datos.clientes;

import datos.contrato.Factura;
import datos.contrato.Tarifa;
import datos.llamadas.Llamada;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//preguntar si los constructores son public


public abstract class Cliente {
    String nombre;
    String NIF;
    Direccion direccion;
    String email;
    String fechaDeAlta;
    Tarifa tarifa;
    Set<Factura> facturas;

    public Cliente(final String nombre, final String NIF, final Direccion direccion, final String email){
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        //Preguntar si las siguentes sentencias corresponde a la fecha actual del sistema:
        Calendar fechaActual = Calendar.getInstance();
        this.fechaDeAlta = fechaActual.toString();
        this.tarifa = new Tarifa(); //Preguntar si es necesario instanciar
        this.facturas = new HashSet<Factura>();

    }

    public Llamada efectuarLlamada(){
        //El cliente introduce el telefono destino y la duracion????
        //Se que esto habrá que cambiarlo pero es por tener algo:
        Llamada efectuada = new Llamada("692245585", 2);
        return efectuada;
    }



}
