package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.clientes.Empresa;
import datos.clientes.Particular;
import datos.contrato.Factura;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class GestorClientes {
    //ATRIBUTOS

    private HashMap<String, Cliente> clientes;


    public GestorClientes(){
        this.clientes = new HashMap<String, Cliente>();
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    //Metodo devulveCliente, si no existe devuelve null
    public Cliente devuelveCliente(String NIF){
        return clientes.get(NIF);
    }

    //Metodo anadirParticular, llama al constructor de Cliente, lo crea, lo añadimos a la cartera y lo devolvemos.
    //Devuelve null si ya existe el cliente y no lo modifica
    public Cliente anadirParticular(String nombre,String apellidos, String telefono, String NIF, Direccion direccion, String email){
        //Comprobar que no existe el cliente:
        if(clientes.containsKey(NIF)) return null;
        else {
            Cliente nuevo = new Particular(nombre, apellidos, telefono, NIF, direccion, email);
            clientes.put(NIF, nuevo);
            return nuevo;
        }
    }
    //Metodo anadirEmpresa, llama al constructor de Cliente, lo crea, lo añadimos a la cartera y lo devolvemos.
    //Devuelve null si ya existe el cliente y no lo modifica
    public Cliente anadirEmpresa(String nombre, String telefono, String NIF, Direccion direccion, String email){
        //Comprobar que no existe el cliente:
        if(clientes.containsKey(NIF)) return null;
        else {
            Cliente nuevo = new Empresa(nombre, telefono, NIF, direccion, email);
            clientes.put(NIF, nuevo);
            return nuevo;
        }
    }

    //Metodo borrarCliente, lo elimina de clientes y lo devuelve
    //Devuelve null si no existe el cliente,
    public Cliente borrarCliente(String NIF){
        //Comprobamos que existe el cliente:
        if(!clientes.containsKey(NIF)) return null;
        else{
            Cliente cliente = clientes.get(NIF);
            clientes.remove(NIF);
            return cliente;
        }
    }

    //recuperar todos los datos de un cliente a partir del NIF
    public String recDatosCliente(String NIF) {
        Cliente cliente = clientes.get(NIF);
        if(clientes == null) return null;
        else {
            StringBuilder sb = new StringBuilder();
                sb.append("Nombre: " + cliente.getNombre() + ", ");
                sb.append("NIF: " + cliente.getNIF() + ", ");
                sb.append("Direccion: " + cliente.getDireccion() + ", ");
                sb.append("Email: " + cliente.getEmail() + ", ");
                sb.append("Fecha de alta: " + cliente.getFechaDeAlta() + ", ");
                sb.append("Tarifa: " + cliente.getTarifa() + ", ");
            return sb.toString();
        }
    }

    //listar todos los clientes
    public String listarClientes() {
        Iterator<Cliente> iter = clientes.values().iterator();
        StringBuilder sb = new StringBuilder();
        while(iter.hasNext()) {
            Cliente cliente = iter.next();
            sb.append(recDatosCliente(cliente.getNIF()));
        }
        return sb.toString();
    }


    public boolean contieneClienteConTelefono(String telefono){
        Set<String> nifsClientes = this.clientes.keySet();
        for(String nif : nifsClientes){
            if(clientes.get(nif).getTelf().equals(telefono)) return true;
        }
        return false;
    }

}
