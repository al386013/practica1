package modelo.principal;

import modelo.datos.clientes.Cliente;
import modelo.datos.contrato.tarifas.Tarifa;
import modelo.datos.clientes.Direccion;

public interface InterfazFabricaClientes {
        Cliente getParticular(String nombre, String apellidos, String telf, String nif, Direccion dir, String email, Tarifa tarifa);

        Cliente getEmpresa(String nombre, String telf, String nif, Direccion dir, String email, Tarifa tarifa);
}
