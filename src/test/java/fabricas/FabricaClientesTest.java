package fabricas;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.contrato.tarifas.Tarifa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class FabricaClientesTest {
    private static FabricaClientes fabricaClientes;
    private static Direccion dir;
    private static Tarifa tarifa;

    @BeforeAll
    public static void inicializa() {
        fabricaClientes = new FabricaClientes();
        FabricaTarifas fabricaTarifas = new FabricaTarifas(); //????????????????????????????????????????????????
        dir = new Direccion("12005", "Castellon de la plana", "Castelllon");
        tarifa = fabricaTarifas.getBasica();
    }

    @Test
    public void getEmpresaTest() {
        Cliente empresa = fabricaClientes.getEmpresa("Empresa", "666666666", "12341234", dir,
                "empresa@gmail.com", tarifa);
        assertEquals(empresa.getNombre(), "Empresa");
        assertEquals(empresa.getTelf(), "666666666");
        assertEquals(empresa.getNIF(), "12341234");
        assertEquals(empresa.getDireccion(), dir);
        assertEquals(empresa.getEmail(), "empresa@gmail.com");
        assertEquals(empresa.getFecha(), LocalDate.now());
        assertEquals(empresa.getTarifa().descripcion(), "Tarifa basica");

        Cliente empresa2 = fabricaClientes.getEmpresa("Pamesa", "999999999", "56565656", dir,
                "pamesa@gmail.com", tarifa);
        assertEquals(empresa2.getNombre(), "Pamesa");
        assertEquals(empresa2.getTelf(), "999999999");
        assertEquals(empresa2.getNIF(), "56565656");
        assertEquals(empresa2.getDireccion(), dir);
        assertEquals(empresa2.getEmail(), "pamesa@gmail.com");
        assertEquals(empresa2.getFecha(), LocalDate.now());
        assertEquals(empresa2.getTarifa().descripcion(), "Tarifa basica");
    }

    @Test
    public void getParticularTest() {
        Cliente particular = fabricaClientes.getParticular("Marta", "Prado Banarro", "678678678", "X123123T",
                dir, "mgomez@gmail.com", tarifa);
        assertEquals(particular.getNombre(), "Marta");
        //assertEquals(particular.getApellidos(), "Prado Banarro"); ?????????????????????????
        assertEquals(particular.getTelf(), "678678678");
        assertEquals(particular.getNIF(), "X123123T");
        assertEquals(particular.getDireccion(), dir);
        assertEquals(particular.getEmail(), "mgomez@gmail.com");
        assertEquals(particular.getFecha(), LocalDate.now());
        assertEquals(particular.getTarifa().descripcion(), "Tarifa basica");

        Cliente particular2 = fabricaClientes.getParticular("Andres", "Moreno Igual", "964222222", "25925403",
                dir, "amorenoigual@gmail.com", tarifa);
        assertEquals(particular2.getNombre(), "Andres");
        //assertEquals(particular.getApellidos(), "Moreno Igual"); ?????????????????????????
        assertEquals(particular2.getTelf(), "964222222");
        assertEquals(particular2.getNIF(), "25925403");
        assertEquals(particular2.getDireccion(), dir);
        assertEquals(particular2.getEmail(), "amorenoigual@gmail.com");
        assertEquals(particular2.getFecha(), LocalDate.now());
        assertEquals(particular2.getTarifa().descripcion(), "Tarifa basica");
    }
}
