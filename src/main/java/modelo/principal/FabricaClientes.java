package modelo.principal;

import modelo.datos.clientes.Cliente;
import modelo.datos.clientes.Empresa;
import modelo.datos.clientes.Particular;
import modelo.datos.contrato.tarifas.Tarifa;
import modelo.datos.clientes.Direccion;

public class FabricaClientes implements InterfazFabricaClientes {
    public FabricaClientes() {
        super();
    }

    @Override
    public Cliente getParticular(String nombre, String apellidos, String telf, String nif, Direccion dir, String email,
                                 Tarifa tarifa) {
        return new Particular(nombre, apellidos, telf, nif, dir, email, tarifa);
    }

    @Override
    public Cliente getEmpresa(String nombre, String telf, String nif, Direccion dir, String email, Tarifa tarifa) {
        return new Empresa(nombre, telf, nif, dir, email, tarifa);
    }
}
