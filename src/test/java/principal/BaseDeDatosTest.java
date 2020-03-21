package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.contrato.Factura;
import es.uji.www.GeneradorDatosINE;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Formatter;
import static org.junit.Assert.assertEquals;

public class BaseDeDatosTest {
    private static BaseDeDatos baseDeDatos;
    private static GestorClientes gestorClientes;
    private static GestorFacturas gestorFacturas;
    private static Cliente alberto;
    private static Direccion dirAlberto;
    private static Cliente pamesa;
    private static Direccion dirPamesa;

    @BeforeAll
    public static void inicializa() throws IllegalArgumentException {
        gestorClientes = new GestorClientes();
        gestorFacturas = new GestorFacturas();
        baseDeDatos = new BaseDeDatos(gestorClientes, gestorFacturas);

        for (int i = 0; i < 100; i++) {
            GeneradorDatosINE generadorDatosINE = new GeneradorDatosINE();
            String nombre = generadorDatosINE.getNombre();
            String nif = generadorDatosINE.getNIF();
            String provincia = generadorDatosINE.getProvincia();
            //String poblacion = generadorDatosINE.getPoblacion(provincia); nos da error el generador
            String cp = "12005"; //GENERADOR INE NO TIENE CP
            Direccion direccion = new Direccion(cp, provincia, "Poblacion");
            //creamos 50 particulares y 50 empresas
            if (i < 50) {
                String apellidos = generadorDatosINE.getApellido();
                baseDeDatos.anadirParticular(nombre, apellidos, "5555555" + i, nif, direccion, "particular@gmail.com");
            } else baseDeDatos.anadirEmpresa(nombre, "6666666" + i, nif, direccion, "empresa@gmail.com");
        }

        dirAlberto = new Direccion("12005", "Castellon de la plana", "Castelllon");
        baseDeDatos.anadirParticular("alberto", "prado banarro", "692242216", "20925403", dirAlberto, "albertoprado@gmail.com");
        alberto = gestorClientes.devuelveCliente("20925403");

        dirPamesa = new Direccion("12006", "VillaReal", "Castelllon");
        baseDeDatos.anadirEmpresa("pamesa", "964246252", "63302284", dirPamesa, "pamesa@gmail.com");
        pamesa = gestorClientes.devuelveCliente("63302284");

        //realizamos llamadas para pamesa
        for (int i = 0; i < 50; i++)
            baseDeDatos.darDeAltaLlamada("964246252", "666666" + i, 120);

        //alberto hace una llamada
        baseDeDatos.darDeAltaLlamada("692242216", "000000000", 120);
    }

    //comprueba listarLlamadasCliente() y listarLlamadasEntreFechas()
    @Test
    public void testLlamadasCliente() throws IntervaloFechasIncorrectoException {
        Formatter obj = new Formatter();
        //test listarLlamadasCliente()
        assertEquals(baseDeDatos.listarLlamadasCliente("692242216"),
                "\t- Llamada realizada el " + LocalDate.now()
                        + " a las " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute())
                        + " con una duracion de 120 segundos al telefono 000000000\n");
        //test listarLlamadasEntreFechas()
        obj = new Formatter();
        assertEquals(baseDeDatos.listarLlamadasEntreFechas("692242216", LocalDate.now().minusDays(1), LocalDate.now()),
                "\t- Llamada realizada el " + LocalDate.now()
                        + " a las " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute())
                        + " con una duracion de 120 segundos al telefono 000000000\n");
    }

    //comprueba listarFacturasCliente() y listarFacturasEntreFechas()
    @Test
    public void testFacturasCliente() throws IntervaloFechasIncorrectoException {
        //emite una factura para pamesa con todas las llamadas desde ayer a hoy (las 50 anadidas)
        Formatter obj = new Formatter();
        baseDeDatos.emitirFactura(LocalDate.now().minusDays(1), LocalDate.now(), "63302284");
        for (Factura factura : alberto.getFacturas()) { //solo hay una
            int codFact = factura.getCodigo();
            assertEquals(baseDeDatos.listarFacturasCliente("20925403"),
                    "\nCodigo de factura: " + codFact + ":" +
                            "\n\tNIF: 20925403" +
                            "\n\tTarifa: 0.05 €/min" +
                            "\n\tFecha de emision: " + LocalDate.now() +
                            "\n\tHora de emision: " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute()) +
                            "\n\tPeriodo de facturacion: " + LocalDate.now().minusDays(1) + " - " + LocalDate.now() +
                            "\n\tImporte: 0.2€" +
                            "\n\tLista de llamadas de esta factura:\n" +
                            "\n\t- Llamada realizada el " + LocalDate.now() +
                            " a las " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute()) +
                            " con una duracion de 120 segundos al telefono 000000000");
            obj = new Formatter();
            assertEquals(baseDeDatos.listarFacturasEntreFechas("20925403", LocalDate.now().minusDays(1), LocalDate.now()),
                    "\nCodigo de factura: " + codFact + ":" +
                            "\n\tNIF: 20925403" +
                            "\n\tTarifa: 0.05 €/min" +
                            "\n\tFecha de emision: " + LocalDate.now() +
                            "\n\tHora de emision: " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute()) +
                            "\n\tPeriodo de facturacion: " + LocalDate.now().minusDays(1) + " - " + LocalDate.now() +
                            "\n\tImporte: 0.2€" +
                            "\n\tLista de llamadas de esta factura:\n" +
                            "\n\t- Llamada realizada el " + LocalDate.now() +
                            " a las " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute()) +
                            " con una duracion de 120 segundos al telefono 000000000");
        }
    }

    @AfterAll
    public static void borraTodo(){
        baseDeDatos = null;
    }
}