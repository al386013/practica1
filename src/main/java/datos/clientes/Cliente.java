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
    private HashMap<Integer, Factura> facturas; //La clave corresponde al codigo de factura

    public Cliente(final String nombre, final String NIF, final Direccion direccion, final String email){
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        //Preguntar si las siguentes sentencias corresponde a la fecha actual del sistema:
        Calendar fechaActual = Calendar.getInstance();
        this.fechaDeAlta = fechaActual.toString();
        this.tarifa = new Tarifa(); //Preguntar si es necesario instanciar
        this.facturas = new HashMap<Integer, Factura>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public String getEmail() {
        return email;
    }

    public String getFechaDeAlta() {
        return fechaDeAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public HashMap<Integer, Factura> getFacturas() {
        return facturas;
    }
}