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
    private Set<Factura> facturas;

    private HashMap<String, Cliente> clientes;

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

    public String listarClientes() {
        Iterator<Cliente> iter = clientes.values().iterator();
        StringBuilder sb = new StringBuilder();
        while(iter.hasNext()) {
            Cliente cliente = iter.next();
            sb.append("Nombre: " + cliente.nombre + ", ");
            sb.append("NIF: " + cliente.NIF + ", ");
            sb.append("Direccion: " + cliente.direccion + ", ");
            sb.append("Email: " + cliente.email + ", ");
            sb.append("Fecha de alta: " + cliente.fechaDeAlta + ", ");
            sb.append("Tarida: " + cliente.tarifa + ", ");
        }
        return sb.toString();
    }
}