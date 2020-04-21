package modelo.datos;

import modelo.datos.contrato.tarifas.Tarifa;
import modelo.datos.contrato.tarifas.TarifaDomingosGratis;
import modelo.datos.contrato.tarifas.TarifaBasica;
import modelo.datos.contrato.tarifas.TarifaTardesReducida;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class TarifaTest {
    @Test
    public void testDescripciones1() {
        //se crea una tarifa basica
        Tarifa tarifa = new TarifaBasica(0.05f);
        String salida = "Tarifa basica";
        assertEquals(tarifa.descripcion(), salida);

        //se contrata la tarifa especial de domingos gratis
        tarifa = new TarifaDomingosGratis(tarifa, 0.00f);
        salida += ", con tarifa especial de domingos gratis";
        assertEquals(tarifa.descripcion(), salida);

        //tambien se contrata la tarifa especial de tardes reducida
        tarifa = new TarifaTardesReducida(tarifa, 0.03f);
        salida += ", con tarifa especial de tardes reducida";
        assertEquals(tarifa.descripcion(), salida);
    }

    @Test
    public void testDescripciones2() {
        //se crea una tarifa basica
        Tarifa tarifa = new TarifaBasica(0.05f);
        String salida2 = "Tarifa basica";
        assertEquals(tarifa.descripcion(), salida2);

        //se contrata la tarifa especial de tardes reducida
        tarifa = new TarifaTardesReducida(tarifa, 0.03f);
        salida2 += ", con tarifa especial de tardes reducida";
        assertEquals(tarifa.descripcion(), salida2);

        //tambien se contrata la tarifa especial de domingos gratis
        tarifa = new TarifaDomingosGratis(tarifa, 0.00f);
        salida2 += ", con tarifa especial de domingos gratis";
        assertEquals(tarifa.descripcion(), salida2);
    }
}
