package datos;
import datos.clientes.Cliente;
import datos.contrato.Factura;
import datos.contrato.PeriodoFacturacion;
import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaBasica;
import datos.contrato.tarifas.TarifaPorDia;
import datos.contrato.tarifas.TarifaPorHoras;
import datos.llamadas.Llamada;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FacturaTest {
    private static Tarifa tarifaBasica;
    private static Tarifa tarifaPorDias;
    private static Tarifa tarifaPorHoras;
    private static Tarifa tarifaTotal;
    private static PeriodoFacturacion periodoFact;
    private static ComparadorFechaHora comparador;

    @BeforeAll
    public static void inicializa() {
        periodoFact = new PeriodoFacturacion(LocalDate.parse("2020-01-01"),  LocalDate.parse("2020-03-27"));
        comparador = new ComparadorFechaHora<>();

        //creamos tarifa basica
        tarifaBasica = new TarifaBasica(0.05f);
        //creamos una tarifa basica + tarifa por dias
        tarifaPorDias = new TarifaPorDia(tarifaBasica, 0.00f);
        //creamos una tarifa basica + tarifa por horas
        tarifaPorHoras = new TarifaPorHoras(tarifaBasica, 0.03f);
        //creamos una tarifa basica + tarifa por dias + tarifa por horas
        tarifaTotal = new TarifaPorHoras(tarifaPorDias, 0.03f);
    }

    @Test
    public void TestPrecioLlamadaLunesManana() {
        Llamada llamada = new Llamada("666777888", 120);
        llamada.setFecha(LocalDate.parse("2020-03-23")); //un lunes
        llamada.setHora(LocalTime.parse("10:00:00")); //por la manana
        Set<Llamada> llamadas = new HashSet<Llamada>();
        llamadas.add(llamada);
        //con tarifa basica
        Factura factura = new Factura(periodoFact, "1234", llamadas, tarifaBasica);
        float importe = (llamada.getDuracion() / 60.0f) * 0.05f;
        assertEquals(factura.calcularPrecioLlamada(tarifaBasica, llamada), importe, 0.005f);
        //con tarifa basica + tarifa por dias
        assertEquals(factura.calcularPrecioLlamada(tarifaPorDias, llamada), importe, 0.005f);
        //con tarifa basica + tarifa por horas
        assertEquals(factura.calcularPrecioLlamada(tarifaPorHoras, llamada), importe, 0.005f);
        //con tarifa basica + tarifa por dias + tarifa por horas
        assertEquals(factura.calcularPrecioLlamada(tarifaTotal, llamada), importe, 0.005f);
    }
}
