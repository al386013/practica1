package datos.clientes;

import datos.contrato.Factura;
import datos.contrato.Tarifa;

import java.util.Set;

//preguntar si los constructores son public

public abstract class Cliente {
    private String nombre;
    private String NIF;
    private Direccion direccion;
    private String email;
    private String fechaDeAlta;
    private Tarifa tarifa;

    Set<Factura> facturas; //Utilizamos un conjunto?

    public Cliente(final String nombre, final String NIF, final Direccion direccion, final String email){
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        //Averiguar como se obtiene la fehca actual:
        //tarifa
        //facturas
    }
}
