package datos;

import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaBasica;
import datos.contrato.tarifas.TarifaDomingosGratis;
import datos.contrato.tarifas.TarifaTardesReducida;
import datos.llamadas.Llamada;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;

public class TarifaCalculaPrecioTest {
    private static Tarifa tarifaBasica;
    private static Tarifa tarifaDomingos;
    private static Tarifa tarifaTardes;
    private static Tarifa tarifaTotal;
    private static Tarifa tarifaTotal2;

    @BeforeAll
    public static void inicializa() {
        //creamos una tarifa basica
        tarifaBasica = new TarifaBasica(0.05f);
        //creamos una tarifa basica + tarifa de domingos gratis
        tarifaDomingos = new TarifaDomingosGratis(tarifaBasica, 0.00f);
        //creamos una tarifa basica + tarifa de tardes reducida
        tarifaTardes = new TarifaTardesReducida(tarifaBasica, 0.03f);
        //creamos una tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        tarifaTotal = new TarifaTardesReducida(tarifaDomingos, 0.03f);
        //creamos una tarifa basica + tarifa de tardes reducida + tarifa de domingos gratis
        tarifaTotal2 = new TarifaDomingosGratis(tarifaTardes, 0.00f);
    }

    @Test
    public void TestTarifaLlamadaLunesManana() {
        Llamada llamada = new Llamada("666777888", 120);
        llamada.setFecha(LocalDate.parse("2020-03-23")); //un lunes
        llamada.setHora(LocalTime.parse("10:00:00")); //por la manana
        float importe = (llamada.getDuracion() / 60.0f) * 0.05f;
        //con tarifa basica
        assertEquals(tarifaBasica.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis
        assertEquals(tarifaDomingos.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa de tardes reducida
        assertEquals(tarifaTardes.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        assertEquals(tarifaTotal.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa de tardes reducida + tarifa de domingos gratis
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
        //con tarifa basica + tarifa de domingos gratis
        assertEquals(tarifaDomingos.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa de tardes reducida
        importe = (llamada.getDuracion() / 60.0f) * 0.03f;
        assertEquals(tarifaTardes.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        assertEquals(tarifaTotal.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa de tardes reducida + tarifa de domingos gratis
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
        //con tarifa basica + tarifa de domingos gratis
        assertEquals(tarifaDomingos.calcularPrecioLlamada(llamada), 0.00f, 0.005f);
        //con tarifa basica + tarifa de tardes reducida
        assertEquals(tarifaTardes.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        assertEquals(tarifaTotal.calcularPrecioLlamada(llamada), 0.00f, 0.005f);
        //con tarifa basica + tarifa de tardes reducida + tarifa de domingos gratis
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
        //con tarifa basica + tarifa de domingos gratis
        assertEquals(tarifaDomingos.calcularPrecioLlamada(llamada), 0.00f, 0.005f);
        //con tarifa basica + tarifa de tardes reducida
        importe = (llamada.getDuracion() / 60.0f) * 0.03f;
        assertEquals(tarifaTardes.calcularPrecioLlamada(llamada), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        assertEquals(tarifaTotal.calcularPrecioLlamada(llamada), 0.00f, 0.005f);
        //con tarifa basica + tarifa de tardes reducida + tarifa de domingos gratis
        assertEquals(tarifaTotal2.calcularPrecioLlamada(llamada), 0.00f, 0.005f);
    }
}
