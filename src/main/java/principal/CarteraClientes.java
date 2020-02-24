package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.clientes.Empresa;
import datos.clientes.Particular;
import datos.contrato.Factura;

import java.util.HashMap;

public class CarteraClientes {
    private HashMap<String, Cliente> clientes;

    public CarteraClientes(){
        this.clientes = new HashMap<String, Cliente>();
    }


    //Metodo añadirParticular, llama al constructor de Cliente, lo crea y lo añadimos a la cartera.
    //Devuelve false si ya existe el cliente y no lo modifica
    public boolean añadirParticular(String nombre,String apellidos, String NIF, Direccion direccion, String email){
        //Comprobar que no existe el cliente:
        if(clientes.containsKey(NIF)) return false;
        else {
            Cliente nuevo = new Particular(nombre, apellidos, NIF, direccion, email);
            clientes.put(NIF, nuevo);
            return true;
        }
    }
    //Metodo añadirEmpresa, llama al constructor de Cliente, lo crea y lo añadimos a la cartera.
    //Devuelve false si ya existe el cliente y no lo modifica
    public boolean añadirEmpresa(String nombre, String NIF, Direccion direccion, String email){
        //Comprobar que no existe el cliente:
        if(clientes.containsKey(NIF)) return false;
        else {
            Cliente nuevo = new Empresa(nombre, NIF, direccion, email);
            clientes.put(NIF, nuevo);
            return true;
        }
    }

    //Metodo borrarCliente, lo elimina de clientes
    //Devuelve false si no existe el cliente
    public boolean borrarCliente(String NIF){
        //Comprobamos que existe el cliente:
        if(!clientes.containsKey(NIF)) return false;
        else{
            clientes.remove(NIF);
            return true;
        }
    }


    //Metodo emitirFactura, devuelve null si no existe el cliente
    public Factura emitirFactura(String nifCliente){
        if(!clientes.containsKey(nifCliente)) return null;
        else {
            Cliente cliente = clientes.get(nifCliente);
            return null;
        }
    }
}
