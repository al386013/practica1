package principal;

import static org.junit.Assert.assertEquals;
import datos.clientes.Direccion;
import datos.contrato.Factura;
import es.uji.www.GeneradorDatosINE;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import datos.clientes.Cliente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Formatter;

public class GestorFacturasTest {
    private static BaseDeDatos baseDeDatos;
    private static Cliente maria;

    @BeforeAll
    public static void inicializa() throws IllegalArgumentException {
        GestorClientes gestorClientes = new GestorClientes();
        GestorFacturas gestorFacturas = new GestorFacturas();
        baseDeDatos = new BaseDeDatos(gestorClientes, gestorFacturas);

        //insertamos un particular
        Direccion dirMaria = new Direccion("12005", "Castellon de la plana", "Castelllon");
        baseDeDatos.anadirParticular("alberto", "prado banarro", "600600600", "12341234",
                dirMaria, "mariaprado@gmail.com");
        maria = gestorClientes.devuelveCliente("12341234");
        //maria hace una llamada
        baseDeDatos.darDeAltaLlamada("600600600", "000000000", 130);

        //cargamos la base de datos con algunos clientes
        for (int i = 0; i < 100; i++) {
            GeneradorDatosINE generadorDatosINE = new GeneradorDatosINE();
            String nombre = generadorDatosINE.getNombre();
            String nif = generadorDatosINE.getNIF();
            String provincia = generadorDatosINE.getProvincia();
            String cp = "12005";
            Direccion direccion = new Direccion(cp, provincia, "Poblacion");
            //creamos 50 particulares y 50 empresas
            if (i < 50) {
                String apellidos = generadorDatosINE.getApellido();
                baseDeDatos.anadirParticular(nombre, apellidos, "5555555" + i, nif, direccion, "particular@gmail.com");
            } else baseDeDatos.anadirEmpresa(nombre, "6666666" + i, nif, direccion, "empresa@gmail.com");
        }
    }

    //test de emitirFactura y listarDatosFactura
    @Test
    public void testEmitirListarFactura() {
        baseDeDatos.darDeAltaLlamada("600600600", "111111111", 40);
        //emite una factura para alberto con todas las llamadas desde ayer a hoy (las 50 anadidas)
        baseDeDatos.emitirFactura(LocalDate.now().minusDays(1), LocalDate.now(), "12341234");

        //comprobar que los datos de la factura son correctos
        int codFact = 0;
        for (Factura factura : maria.getFacturas()) { //solo hay una
            codFact = factura.getCodigo();
            assertEquals(factura.getFecha(), LocalDate.now());
            assertEquals(factura.getHora().getHour(), LocalTime.now().getHour());
            assertEquals(factura.getHora().getMinute(), LocalTime.now().getMinute());
            assertEquals(factura.getNifCliente(), "12341234");
            assertEquals(factura.getImporte(), (170 / 60.0) * 0.05f, 0.005);
        }
        //listar los datos de la factura
        Formatter hora = new Formatter();
        hora.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute());
        assertEquals(baseDeDatos.listarDatosFactura(codFact), "\nCodigo de factura: " + codFact + ":" +
                "\n\tNIF: 12341234" +
                "\n\tFecha de emision: " + LocalDate.now() +
                "\n\tHora de emision: " + hora +
                "\n\tPeriodo de facturacion: " + LocalDate.now().minusDays(1) + " - " + LocalDate.now() +
                "\n\tImporte: 0.14€" +
                "\n\tLista de llamadas de esta factura:\n" +
                "\n\t- Llamada realizada el " + LocalDate.now() +
                " a las " + hora + " con una duracion de 130 segundos al telefono 000000000" +
                "\n\t- Llamada realizada el " + LocalDate.now() +
                " a las " + hora + " con una duracion de 40 segundos al telefono 111111111");
    }

    @AfterAll
    public static void borraTodo() {
        baseDeDatos = null;
    }
}
