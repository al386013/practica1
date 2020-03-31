package datos;

import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaBasica;
import datos.contrato.tarifas.TarifaDomingosGratis;
import datos.contrato.tarifas.TarifaTardesReducida;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TarifaTest {
    @Test
    public void testDescripciones() {
        //se crea una tarifa basica
        Tarifa tarifa = new TarifaBasica(0.05f);
        String salida = "Tarifa basica";
        assertEquals(tarifa.descripcion(), salida);

        //se contrata la tarifa especial por dia
        tarifa = new TarifaDomingosGratis(tarifa, 0.00f);
        salida += ", con tarifa especial por dia";
        assertEquals(tarifa.descripcion(), salida);

        //tambien se contrata la tarifa especial por horas
        tarifa = new TarifaTardesReducida(tarifa, 0.03f);
        salida += ", con tarifa especial por horas";
        assertEquals(tarifa.descripcion(), salida);
    }
}
