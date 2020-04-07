package fabricas;

import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaBasica;
import datos.contrato.tarifas.TarifaDomingosGratis;
import datos.contrato.tarifas.TarifaTardesReducida;
import datos.llamadas.Llamada;
import menus.MenuCambiarTarifa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import principal.FabricaTarifas;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class FabricaTarifasTest {
    private static FabricaTarifas fabricaTarifas;
    private static Tarifa tarifaBasica;
    private static Tarifa tarifaPorDias;
    private static Tarifa tarifaPorHoras;
    private static Tarifa tarifaTotal;
    private static Tarifa tarifaTotal2;


    @BeforeAll
    public static void inicializa() {
        fabricaTarifas = new FabricaTarifas();
        //creamos tarifa basica
        tarifaBasica = new TarifaBasica(0.05f);
        //creamos una tarifa basica + tarifa de domingos gratis
        tarifaPorDias = new TarifaDomingosGratis(tarifaBasica, 0.00f);
        //creamos una tarifa basica + tarifa de tardes reducida
        tarifaPorHoras = new TarifaTardesReducida(tarifaBasica, 0.03f);
        //creamos una tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        tarifaTotal = new TarifaTardesReducida(tarifaPorDias, 0.03f);
        //creamos una tarifa basica + tarifa por horas + tarifa por dias
        tarifaTotal2 = new TarifaDomingosGratis(tarifaPorHoras, 0.00f);
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
                tarifaPorHoras.descripcion());
        //tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        assertEquals(fabricaTarifas.getOferta(MenuCambiarTarifa.TARIFA_TARDES_REDUCIDA, tarifaPorDias).descripcion(),
                tarifaTotal.descripcion());
    }

    @Test
    public void getTarifaDomingosTest() {
        //tarifa basica + tarifa de domingos gratis
        assertEquals(fabricaTarifas.getOferta(MenuCambiarTarifa.TARIFA_DOMINGOS_GRATIS, tarifaBasica).descripcion(),
                tarifaPorDias.descripcion());
        //tarifa basica + tarifa de tardes reducida + tarifa de domingos gratis
        assertEquals(fabricaTarifas.getOferta(MenuCambiarTarifa.TARIFA_DOMINGOS_GRATIS, tarifaPorHoras).descripcion(),
                tarifaPorHoras.descripcion() + ", con tarifa especial de domingos gratis"); //pq se imprimen en otro orden
    }

    @Test
    public void TestTarifaLlamadaLunesManana() {
        Llamada llamada = new Llamada("666777888", 120);
        llamada.setFecha(LocalDate.parse("2020-03-23")); //un lunes
        llamada.setHora(LocalTime.parse("10:00:00")); //por la manana
        float importe = (llamada.getDuracion() / 60.0f) * 0.05f;
        //con tarifa basica
        assertEquals(tarifaBasica.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por dias
        assertEquals(tarifaPorDias.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por horas
        assertEquals(tarifaPorHoras.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por dias + tarifa por horas
        assertEquals(tarifaTotal.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por horas + tarifa por dias
        assertEquals(tarifaTotal2.calcularPrecioLlamada(llamada), importe, 0.005f);

    }

    @Test
    public void TestTarifaLlamadaLunesTarde() {
        Llamada llamada = new Llamada("666777888", 70);
        llamada.setFecha(LocalDate.parse("2020-03-23")); //un lunes
        llamada.setHora(LocalTime.parse("18:00:00")); //por la tarde
        float importe = (llamada.getDuracion() / 60.0f) * 0.05f;
        //con tarifa basica
        assertEquals(tarifaBasica.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por dias
        assertEquals(tarifaPorDias.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por horas
        importe = (llamada.getDuracion() / 60.0f) * 0.03f;
        assertEquals(tarifaPorHoras.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por dias + tarifa por horas
        assertEquals(tarifaTotal.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por horas + tarifa por dias
        assertEquals(tarifaTotal2.calcularPrecioLlamada(llamada), importe, 0.005f);
    }

    @Test
    public void TestTarifaLlamadaDomingoManana() {
        Llamada llamada = new Llamada("666777888", 30);
        llamada.setFecha(LocalDate.parse("2020-03-22")); //un domingo
        llamada.setHora(LocalTime.parse("10:00:00")); //por la manana
        float importe = (llamada.getDuracion() / 60.0f) * 0.05f;
        //con tarifa basica
        assertEquals(tarifaBasica.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por dias
        assertEquals(tarifaPorDias.calcularPrecioLlamada(llamada), 0.00f, 0.005f);
        //con tarifa basica + tarifa por horas
        assertEquals(tarifaPorHoras.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por dias + tarifa por horas
        assertEquals(tarifaTotal.calcularPrecioLlamada(llamada), 0.00f, 0.005f);
        //con tarifa basica + tarifa por horas + tarifa por dias
        assertEquals(tarifaTotal2.calcularPrecioLlamada(llamada), 0.00f, 0.005f);
    }

    @Test
    public void TestTarifaLlamadaDomingoTarde() {
        Llamada llamada = new Llamada("666777888", 110);
        llamada.setFecha(LocalDate.parse("2020-03-22")); //un domingo
        llamada.setHora(LocalTime.parse("19:30:00")); //por la tarde
        float importe = (llamada.getDuracion() / 60.0f) * 0.05f;
        //con tarifa basica
        assertEquals(tarifaBasica.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por dias
        assertEquals(tarifaPorDias.calcularPrecioLlamada(llamada), 0.00f, 0.005f);
        //con tarifa basica + tarifa por horas
        importe = (llamada.getDuracion() / 60.0f) * 0.03f;
        assertEquals(tarifaPorHoras.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa por dias + tarifa por horas
        assertEquals(tarifaTotal.calcularPrecioLlamada(llamada), 0.00f, 0.005f);
        //con tarifa basica + tarifa por horas + tarifa por dias
        assertEquals(tarifaTotal2.calcularPrecioLlamada(llamada), 0.00f, 0.005f);
    }
}
