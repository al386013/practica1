package principal;

import static org.junit.Assert.assertEquals;
import datos.clientes.Direccion;
import datos.contrato.Factura;
import es.uji.www.GeneradorDatosINE;
import excepciones.NifRepetidoException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import datos.clientes.Cliente;
import java.time.LocalDate;

public class GestorFacturasTest {
    private static BaseDeDatos baseDeDatos;
    private static Cliente alberto;
    private static Cliente pamesa;

    @BeforeAll
    public static void inicializa() throws NifRepetidoException {
        baseDeDatos = new BaseDeDatos();

        //cargamos la base de datos con algunos clientes
        for (int i = 0; i < 100; i++) {
            GeneradorDatosINE generadorDatosINE = new GeneradorDatosINE();
            String nombre = generadorDatosINE.getNombre();
            String nif = generadorDatosINE.getNIF();
            String provincia = generadorDatosINE.getProvincia();
            String poblacion = generadorDatosINE.getPoblacion(provincia);
            String cp = "12005"; //GENERADOR INE NO TIENE CP
            Direccion direccion = new Direccion(cp, provincia, poblacion);
            //creamos 50 particulares y 50 empresas
            if (i < 50) {
                String apellidos = generadorDatosINE.getApellido();
                baseDeDatos.anadirParticular(nombre, apellidos, "666666666", nif, direccion, "particular@gmail.com");
            } else baseDeDatos.anadirEmpresa(nombre, "666666666", nif, direccion, "empresa@gmail.com");
        }

        //insertamos un particular y una empresa
        Direccion dirAlberto = new Direccion("12005", "Castellon de la plana", "Castelllon");
        baseDeDatos.anadirParticular("alberto", "prado banarro", "692242216", "20925403", dirAlberto, "albertoprado@gmail.com");
        alberto = baseDeDatos.devuelveCliente("20925403");

        Direccion dirPamesa = new Direccion("12006", "VillaReal", "Castelllon");
        baseDeDatos.anadirEmpresa("pamesa", "964246252", "63302284", dirPamesa, "pamesa@gmail.com");
        pamesa = baseDeDatos.devuelveCliente("63302284");

        //realizamos llamadas
        for (int i = 0; i < 50; i++)
            baseDeDatos.darDeAltaLlamada("692242216", "666666" + i, 90);
        for (int i = 0; i < 50; i++)
            baseDeDatos.darDeAltaLlamada("964246252", "666666" + i, 120);
    }

    @Test
    public void testEmitirListarFactura() {
        //emite una factura para alberto con todas las llamadas desde ayer a hoy (las 50 anadidas)
        baseDeDatos.emitirFactura(LocalDate.now().minusDays(1), LocalDate.now(), "20925403");
        //comprobar que los datos de la factura son correctos
        int codFact = 0;
        for (Factura factura : alberto.getFacturas()) { //solo hay una
            codFact = factura.getCodigo();
            assertEquals(factura.getTarifa().getTarifa(), 0.05f, 0);
            assertEquals(factura.getFecha(), LocalDate.now());
            assertEquals(factura.getNifCliente(), "20925403");
            assertEquals(factura.getImporte(), ((50 * 90) / 60.0) * 0.05f, 0.001);
        }
        //listar los datos de la factura
        assertEquals(baseDeDatos.listarDatosFactura(codFact), "NIF: 20925403, Codigo: " + codFact + ", Tarifa: 0.05 €/min, " +
                "Fecha de emision: " + LocalDate.now() + ", Periodo de facturacion: " + LocalDate.now().minusDays(1) + " - " + LocalDate.now() +
                ", Importe: 3.75€.");
    }

    @Test
    public void testListarFacturasCliente() {
        //emite una factura para pamesa con todas las llamadas desde ayer a hoy (las 50 anadidas)
        baseDeDatos.emitirFactura(LocalDate.now().minusDays(1), LocalDate.now(), "63302284");
        //comprobamos que lista correctamente la factura
        for (Factura factura : pamesa.getFacturas()) { //solo hay una
            int codFact = factura.getCodigo();
            assertEquals(baseDeDatos.listarFacturasCliente("63302284"), "NIF: 63302284, Codigo: " + codFact +
                    ", Tarifa: 0.05 €/min, Fecha de emision: " + LocalDate.now() + ", Periodo de facturacion: "
                    + LocalDate.now().minusDays(1) + " - " + LocalDate.now() + ", Importe: 5.0€.\n");
        }
    }

    @AfterAll
    public static void borraTodo(){
        baseDeDatos = null;
    }

}
