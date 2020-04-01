package fabricas;

import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaBasica;
import datos.contrato.tarifas.TarifaDomingosGratis;
import datos.contrato.tarifas.TarifaTardesReducida;
import menus.MenuCambiarTarifa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import principal.FabricaTarifas;
import static org.junit.Assert.assertEquals;

public class FabricaTarifasTest {
    private static FabricaTarifas fabricaTarifas;
    private static Tarifa tarifaBasica;
    private static Tarifa tarifaDomingos;
    private static Tarifa tarifaTardes;
    private static Tarifa tarifaTotal;

    @BeforeAll
    public static void inicializa() {
        fabricaTarifas = new FabricaTarifas();
        //creamos tarifa basica
        tarifaBasica = new TarifaBasica(0.05f);
        //creamos una tarifa basica + tarifa de domingos gratis
        tarifaDomingos = new TarifaDomingosGratis(tarifaBasica, 0.00f);
        //creamos una tarifa basica + tarifa de tardes reducida
        tarifaTardes = new TarifaTardesReducida(tarifaBasica, 0.03f);
        //creamos una tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        tarifaTotal = new TarifaTardesReducida(tarifaDomingos, 0.03f);
    }

    @Test
    public void getTarifaBasicaTest() {
        //tarifa basica
        assertEquals(fabricaTarifas.getBasica().descripcion(), tarifaBasica.descripcion());
    }

    @Test
    public void getTarifaTardesTest() {
        //tarifa basica + tarifa de tardes reducida
        assertEquals(fabricaTarifas.getOferta(MenuCambiarTarifa.TARIFA_TARDES_REDUCIDA, tarifaBasica).descripcion(),
                tarifaTardes.descripcion());
        //tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        assertEquals(fabricaTarifas.getOferta(MenuCambiarTarifa.TARIFA_TARDES_REDUCIDA, tarifaDomingos).descripcion(),
                tarifaTotal.descripcion());
    }

    @Test
    public void getTarifaDomingosTest() {
        //tarifa basica + tarifa de domingos gratis
        assertEquals(fabricaTarifas.getOferta(MenuCambiarTarifa.TARIFA_DOMINGOS_GRATIS, tarifaBasica).descripcion(),
                tarifaDomingos.descripcion());
        //tarifa basica + tarifa de tardes reducida + tarifa de domingos gratis
        assertEquals(fabricaTarifas.getOferta(MenuCambiarTarifa.TARIFA_DOMINGOS_GRATIS, tarifaTardes).descripcion(),
                tarifaTardes.descripcion() + ", con tarifa especial de domingos gratis"); //pq se imprimen en otro orden
    }
}
