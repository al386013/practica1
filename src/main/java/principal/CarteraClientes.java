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

public class CarteraClientes {
    //ATRIBUTOS
    private static int codFac = 0;
    private HashMap<String, Cliente> clientes;


    public CarteraClientes(){
        this.clientes = new HashMap<String, Cliente>();
    }

    //Metodo devulveCliente, si no existe devuelve null
    public Cliente devulveCliente(String NIF){
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
        if(!clientes.containsKey(NIF)) return null;
        else {
            Cliente cliente = clientes.get(NIF);
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

    //listar clientes
    public String listarClientes() {
        Iterator<Cliente> iter = clientes.values().iterator();
        StringBuilder sb = new StringBuilder();
        while(iter.hasNext()) {
            Cliente cliente = iter.next();
            sb.append(recDatosCliente(cliente.getNIF()));
        }
        return sb.toString();
    }

    //recuperarFacturasCliente devuelve un String de todas las facturas del cliente, si no existe el cliente devuelve null
    public String recuperarFacturasCliente(String NIF){
        if(!clientes.containsKey(NIF)) return null;
        else{
            StringBuilder sb = new StringBuilder();
            Cliente cliente = clientes.get(NIF);
            for(Factura factura : cliente.getFacturas().values()){

                sb.append("Codigo factura: " + factura.getCodigo() + ", ");
                sb.append("Fecha: " + factura.getFecha() + ", ");
                sb.append("Fecha de emision: " + factura.getFecha_emision() + ", ");
                sb.append("Periodo de Facturacion: " + factura.getPeriodo_fact() + ", ");
                sb.append("Importe: " + factura.getImporte()  + ", ");
                sb.append("Tarifa: " + factura.getTarifa() + ", ");

            }
            return sb.toString();
        }
    }

    //Metodo emitirFactura, devuelve null si no existe el cliente
    public Factura emitirFactura(String nifCliente){
        if(!clientes.containsKey(nifCliente)) return null;
        else {
            Calendar fechaActual = Calendar.getInstance();
            Factura nuevaFactura = new Factura(codFac++, clientes.get(nifCliente).getTarifa(),fechaActual.getTime().toString(),30);
            return nuevaFactura;
        }
    }
}
