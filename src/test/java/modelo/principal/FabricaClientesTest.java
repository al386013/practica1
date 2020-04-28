package modelo.principal;

import modelo.datos.clientes.Cliente;
import modelo.datos.clientes.Direccion;
import modelo.datos.clientes.Empresa;
import modelo.datos.clientes.Particular;
import modelo.datos.contrato.tarifas.Tarifa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import modelo.principal.FabricaClientes;
import modelo.principal.FabricaTarifas;
import static org.junit.Assert.assertEquals;

public class FabricaClientesTest {
    private static FabricaClientes fabricaClientes;
    private static Direccion dir;
    private static Tarifa tarifa;

    @BeforeAll
    public static void inicializa() {
        fabricaClientes = new FabricaClientes();
        FabricaTarifas fabricaTarifas = new FabricaTarifas();
        dir = new Direccion("12005", "Castellon de la plana", "Castelllon");
        tarifa = fabricaTarifas.getBasica();
    }

    @Test
    public void getEmpresaTest() {
        Cliente empresa = fabricaClientes.getEmpresa("Empresa", "666666666", "12341234", dir,
                "empresa@gmail.com", tarifa);
        assertEquals(empresa, new Empresa("Empresa", "666666666", "12341234", dir,
                "empresa@gmail.com", tarifa));

        Cliente empresa2 = fabricaClientes.getEmpresa("Pamesa", "999999999", "56565656", dir,
                "pamesa@gmail.com", tarifa);
        assertEquals(empresa2, new Empresa("Pamesa", "999999999", "56565656", dir,
                "pamesa@gmail.com", tarifa));
    }

    @Test
    public void getParticularTest() {
        Cliente particular = fabricaClientes.getParticular("Marta", "Prado Banarro", "678678678", "X123123T",
                dir, "mgomez@gmail.com", tarifa);
        assertEquals(particular, new Particular("Marta", "Prado Banarro", "678678678", "X123123T",
                dir, "mgomez@gmail.com", tarifa));

        Cliente particular2 = fabricaClientes.getParticular("Andres", "Moreno Igual", "964222222", "25925403",
                dir, "amorenoigual@gmail.com", tarifa);
        assertEquals(particular2, new Particular("Andres", "Moreno Igual", "964222222", "25925403",
                dir, "amorenoigual@gmail.com", tarifa));
    }
}
