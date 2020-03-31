package fabricas;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.clientes.Empresa;
import datos.clientes.Particular;
import datos.contrato.tarifas.Tarifa;
import interfaces.InterfazFabricaClientes;

public class FabricaClientes implements InterfazFabricaClientes {
    public FabricaClientes() { super(); }

    @Override
    public Cliente getParticular(String nombre, String apellidos, String telf, String nif, Direccion dir, String email, Tarifa tarifa){
        return new Particular(nombre, apellidos, telf, nif, dir, email, tarifa);
    }

    @Override
    public Cliente getEmpresa(String nombre, String telf, String nif, Direccion dir, String email, Tarifa tarifa){
        return new Empresa(nombre, telf, nif, dir, email, tarifa);
    }

}
