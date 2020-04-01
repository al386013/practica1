package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.contrato.Factura;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Formatter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BaseDeDatosTest {
    private static BaseDeDatos baseDeDatos;
    private static Cliente pamesa;

    @BeforeAll
    public static void inicializa() throws IllegalArgumentException {
        GestorClientes gestorClientes = new GestorClientes();
        GestorFacturas gestorFacturas = new GestorFacturas();
        baseDeDatos = new BaseDeDatos(gestorClientes, gestorFacturas);

        //se anade la empresa pamesa
        Direccion dirPamesa = new Direccion("12006", "VillaReal", "Castelllon");
        baseDeDatos.anadirEmpresa("pamesa", "964246252", "63302284", dirPamesa, "pamesa@gmail.com");
        pamesa = gestorClientes.devuelveCliente("63302284");
        //pamesa hace una llamada
        baseDeDatos.darDeAltaLlamada("964246252", "666666666", 130);
    }


    //COMPROBACION DE LAS EXCEPCIONES QUE LANZA BASE DE DATOS

    //comprueba que lanza IntervaloFechasIncorrectoException si fechaFin es anterior a fechaIni
    @Test
    public void testIntervaloFechasIncorrectoException() {
        assertThrows(IntervaloFechasIncorrectoException.class,
                () -> baseDeDatos.compruebaFechas(LocalDate.now(), LocalDate.now().minusDays(1)));
    }

    //comprueba que lanza NifNoExistenteException si se llama a compruebaNifExistente con un NIF no existente
    @Test
    public void testNifNoExistenteException() {
        assertThrows(NifNoExistenteException.class,
                () -> baseDeDatos.compruebaNifExistente("xxxxxxxxx")); //nif no existente
    }

    //comprueba que lanza TelfNoExistenteException si se llama a compruebaTelfExistente con un telf no existente
    @Test
    public void testTelfNoExistenteException() {
        assertThrows(TelfNoExistenteException.class,
                () -> baseDeDatos.compruebaTelfExistente("090909090")); //telf no existente
    }

    //comprueba que lanza NifRepetidoException si se llama a compruebaNifNoExistente con un nif existente
    @Test
    public void testNifRepetidoException() {
        assertThrows(NifRepetidoException.class,
                () -> baseDeDatos.compruebaNifNoExistente("63302284")); //nif de pamesa
    }

    //comprueba que lanza TelfRepetidoException si se llama a compruebaTelfNoExistente con un telf existente
    @Test
    public void testTelfRepetidoException() {
        assertThrows(TelfRepetidoException.class,
                () -> baseDeDatos.compruebaTelfNoExistente("964246252")); //telf de pamesaa
    }


    //COMPROBACION METODOS LISTAR

    //comprueba metodo listarClientes()
    @Test
    public void testListarClientes() {
        Formatter obj = new Formatter();
        assertEquals(baseDeDatos.listarClientes(), "\npamesa" +
                "\n\tNIF: 63302284" +
                "\n\tTelefono: 964246252" +
                "\n\tDireccion: Castelllon - VillaReal - 12006" +
                "\n\tEmail: pamesa@gmail.com" +
                "\n\tFecha de alta: " + LocalDate.now() +
                "\n\tHora de alta: " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute()) +
                "\n\tTarifa basica\n");
    }

    //comprueba listarLlamadasCliente() y listarLlamadasEntreFechas(); vemos que se imprimen siempre ordenadas por fecha
    @Test
    public void testListarLlamadasCliente() {
        //se anade un particular
        Direccion dirAlberto = new Direccion("12005", "Castellon de la plana", "Castelllon");
        baseDeDatos.anadirParticular("alberto", "prado banarro", "692242216", "20925403",
                dirAlberto, "albertoprado@gmail.com");
        //alberto hace una llamada
        baseDeDatos.darDeAltaLlamada("692242216", "000000000", 120);
        Formatter hora = new Formatter();
        hora.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute());
        String res = "\t- Llamada realizada el " + LocalDate.now() + " a las " + hora +
                " con una duracion de 120 segundos al telefono 000000000\n";

        //tests metodos listar llamadas: se imprimen siempre ordenadas por fecha y hora
        assertEquals(baseDeDatos.listarLlamadasCliente("692242216"), res);
        assertEquals(baseDeDatos.listarLlamadasEntreFechas("692242216", LocalDate.now().minusDays(1), LocalDate.now()), res);

        //borramos a alberto de la base de datos
        baseDeDatos.borrarCliente("692242216");
    }

    //comprueba listarFacturasCliente() y listarFacturasEntreFechas()
    @Test
    public void testListarFacturasCliente() {
        //pamesa hace otra llamada
        baseDeDatos.darDeAltaLlamada("964246252", "123412341", 40);
        //emite una factura para pamesa con todas las llamadas desde ayer a hoy (son dos)
        baseDeDatos.emitirFactura(LocalDate.now().minusDays(1), LocalDate.now(), "63302284");
        int codFact = -1;
        for (Factura factura : pamesa.getFacturas()) //solo hay una
            codFact = factura.getCodigo();

        Formatter hora = new Formatter();
        hora.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute());
        String res = "\nCodigo de factura: " + codFact + ":" +
                "\n\tNIF: 63302284" +
                "\n\tFecha de emision: " + LocalDate.now() +
                "\n\tHora de emision: " + hora +
                "\n\tPeriodo de facturacion: " + LocalDate.now().minusDays(1) + " - " + LocalDate.now() +
                "\n\tImporte: 0.14€" +
                "\n\tLista de llamadas de esta factura:\n\n" +
                "\t- Llamada realizada el " + LocalDate.now() + " a las " + hora +
                " con una duracion de 130 segundos al telefono 666666666\n" +
                "\t- Llamada realizada el " + LocalDate.now() + " a las " + hora +
                " con una duracion de 40 segundos al telefono 123412341\n";

        //tests metodos listar facturas: se imprimen siempre ordenadas por fecha y hora
        assertEquals(baseDeDatos.listarFacturasCliente("63302284"), res);
        assertEquals(baseDeDatos.listarFacturasEntreFechas("63302284", LocalDate.now().minusDays(1), LocalDate.now()), res);
    }

    @AfterAll
    public static void borraTodo() {
        baseDeDatos = null;
    }
}