package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.contrato.tarifas.Tarifa;

public interface InterfazFabricaClientes {
        Cliente getParticular(String nombre, String apellidos, String telf, String nif, Direccion dir, String email, Tarifa tarifa);
        Cliente getEmpresa(String nombre, String telf, String nif, Direccion dir, String email, Tarifa tarifa);
}
