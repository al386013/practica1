package datos;

import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaBasica;
import datos.contrato.tarifas.TarifaPorDia;
import datos.contrato.tarifas.TarifaPorHoras;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.is;

public class TarifaTest {
    @Test
    public void testFamiliar() {
        //se crea una tarifa basica
        Tarifa tarifa = new TarifaBasica(0.05f);
        assertThat(tarifa.getPrecio(), is(0.05f));
        String salida = "Tarifa basica";
        assertEquals(tarifa.descripcion(), salida);

        //se contrata la tarifa especial por dia
        tarifa = new TarifaPorDia(tarifa, 0.00f);
        salida += ", con tarifa especial por dia";
        assertEquals(tarifa.descripcion(), salida);

        //tambien se contrata la tarifa especial por horas
        tarifa = new TarifaPorHoras(tarifa, 0.03f);
        salida += ", con tarifa especial por horas";
        assertEquals(tarifa.descripcion(), salida);
    }
}
