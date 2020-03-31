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
    }
}
