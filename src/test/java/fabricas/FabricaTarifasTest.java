package fabricas;

import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaBasica;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class FabricaTarifasTest {
    private static FabricaTarifas fabricaTarifas;
    private static Tarifa tarifa;

    @BeforeAll
    public static void inicializa() {
        fabricaTarifas = new FabricaTarifas();
        tarifa = new TarifaBasica(0.05f);
    }

    @Test
    public void getTarifaBasicaTest() {
        assertEquals(fabricaTarifas.getBasica().descripcion(), tarifa.descripcion());
    }

    @Test
    public void getTarifaPorHorasTest() {

    }

    @Test
    public void getTarifaPorDiaTest() {

    }
}
