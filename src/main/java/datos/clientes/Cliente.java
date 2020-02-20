package datos.clientes;

import datos.contrato.Factura;
import datos.contrato.Tarifa;

import java.util.Set;

public abstract class Cliente {
    private String nombre;
    private String NIF;
    private String direccion;
    private String email;
    private String fechaDeAlta;
    private Tarifa tarifa;

    Set<Factura> facturas; //Utilizamos un conjunto?


    Cliente(String nombre, String NIF, String direccion, String email){
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        //Averiguar como se obtiene la fehca actual:
        //tarifa
        //facturas
    }
}
