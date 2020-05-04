package modelo.datos;
import modelo.datos.contrato.Factura;
import modelo.datos.contrato.tarifas.Tarifa;
import modelo.datos.contrato.tarifas.TarifaDomingosGratis;
import modelo.datos.llamadas.Llamada;
import modelo.datos.contrato.PeriodoFacturacion;
import modelo.datos.contrato.tarifas.TarifaBasica;
import modelo.datos.contrato.tarifas.TarifaTardesReducida;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class FacturaTest {
    private static Tarifa tarifaBasica;
    private static Tarifa tarifaDomingos;
    private static Tarifa tarifaTardes;
    private static Tarifa tarifaTotal;
    private static Tarifa tarifaTotal2;
    private static PeriodoFacturacion periodoFact;

    @BeforeAll
    public static void inicializa() {
        periodoFact = new PeriodoFacturacion(LocalDate.parse("2020-01-01"), LocalDate.parse("2020-03-27"));
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
    public void precioLlamadaLunesMananaTest() {
        Llamada llamada = new Llamada("666666666", "666777888", 120);
        llamada.setFecha(LocalDate.parse("2020-03-23")); //un lunes
        llamada.setHora(LocalTime.parse("10:00:00")); //por la manana
        Set<Llamada> llamadas = new HashSet<Llamada>();
        llamadas.add(llamada);
        //con tarifa basica
        Factura factura = new Factura(periodoFact, "1234", llamadas, tarifaBasica);
        float importe = (llamada.getDuracion() / 60.0f) * 0.05f;
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis
        factura = new Factura(periodoFact, "1234", llamadas, tarifaDomingos);
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de tardes reducida
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTardes);
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTotal);
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de tardes reducida + tarifa de domingos gratis
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTotal2);
        assertEquals(factura.getImporte(), importe, 0.005f);
    }

    @Test
    public void precioLlamadaLunesTardeTest() {
        Llamada llamada = new Llamada("666666666", "666777888", 70);
        llamada.setFecha(LocalDate.parse("2020-03-23")); //un lunes
        llamada.setHora(LocalTime.parse("18:00:00")); //por la tarde
        Set<Llamada> llamadas = new HashSet<Llamada>();
        llamadas.add(llamada);
        //con tarifa basica
        Factura factura = new Factura(periodoFact, "1234", llamadas, tarifaBasica);
        float importe = (llamada.getDuracion() / 60.0f) * 0.05f;
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis
        factura = new Factura(periodoFact, "1234", llamadas, tarifaDomingos);
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de tardes reducida
        importe = (llamada.getDuracion() / 60.0f) * 0.03f;
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTardes);
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTotal);
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de tardes reducida + tarifa de domingos gratis
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTotal2);
        assertEquals(factura.getImporte(), importe, 0.005f);
    }

    @Test
    public void precioLlamadaDomingoMananaTest() {
        Llamada llamada = new Llamada("666666666", "666777888", 30);
        llamada.setFecha(LocalDate.parse("2020-03-22")); //un domingo
        llamada.setHora(LocalTime.parse("10:00:00")); //por la manana
        Set<Llamada> llamadas = new HashSet<Llamada>();
        llamadas.add(llamada);
        //con tarifa basica
        Factura factura = new Factura(periodoFact, "1234", llamadas, tarifaBasica);
        float importe = (llamada.getDuracion() / 60.0f) * 0.05f;
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de tardes reducida
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTardes);
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis
        factura = new Factura(periodoFact, "1234", llamadas, tarifaDomingos);
        assertEquals(factura.getImporte(), 0.00f, 0.005f);
        //con tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTotal);
        assertEquals(factura.getImporte(), 0.00f, 0.005f);
        //con tarifa basica + tarifa de tardes reducida + tarifa de domingos gratis
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTotal2);
        assertEquals(factura.getImporte(), 0.00f, 0.005f);
    }

    @Test
    public void precioLlamadaDomingoTardeTest() {
        Llamada llamada = new Llamada("666666666", "666777888", 110);
        llamada.setFecha(LocalDate.parse("2020-03-22")); //un domingo
        llamada.setHora(LocalTime.parse("19:30:00")); //por la tarde
        Set<Llamada> llamadas = new HashSet<Llamada>();
        llamadas.add(llamada);
        //con tarifa basica
        Factura factura = new Factura(periodoFact, "1234", llamadas, tarifaBasica);
        float importe = (llamada.getDuracion() / 60.0f) * 0.05f;
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis
        factura = new Factura(periodoFact, "1234", llamadas, tarifaDomingos);
        assertEquals(factura.getImporte(), 0.00f, 0.005f);
        //con tarifa basica + tarifa de tardes reducida
        importe = (llamada.getDuracion() / 60.0f) * 0.03f;
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTardes);
        assertEquals(factura.getImporte(), importe, 0.005f);
        //con tarifa basica + tarifa de domingos gratis + tarifa de tardes reducida
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTotal);
        assertEquals(factura.getImporte(), 0.00f, 0.005f);
        //con tarifa basica + tarifa de tardes reducida + tarifa de domingos gratis
        factura = new Factura(periodoFact, "1234", llamadas, tarifaTotal2);
        assertEquals(factura.getImporte(), 0.00f, 0.005f);
    }
}
