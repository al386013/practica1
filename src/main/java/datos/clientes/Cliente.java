package datos.clientes;

import datos.contrato.Factura;
import datos.contrato.Tarifa;

import java.util.HashSet;
import java.util.Set;

//preguntar si los constructores son public

public abstract class Cliente {
    private String nombre;
    private String NIF;
    private Direccion direccion;
    private String email;
    private String fechaDeAlta;
    private Tarifa tarifa;
    private Set<Factura> facturas;

    public Cliente(final String nombre, final String NIF, final Direccion direccion, final String email, final Tarifa tarifa){
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        //Averiguar como se obtiene la fecha actual:
        //tarifa
        facturas = new HashSet<Factura>();
    }
}
