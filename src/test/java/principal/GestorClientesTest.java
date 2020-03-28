package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.llamadas.Llamada;
import es.uji.www.GeneradorDatosINE;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Formatter;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GestorClientesTest {
    private static BaseDeDatos baseDeDatos;
    private static Cliente alberto;
    private static Direccion dirAlberto;
    private static Cliente pamesa;
    private static Direccion dirPamesa;

    @BeforeAll
    public static void inicializa() {
        GestorClientes gestorClientes = new GestorClientes();
        GestorFacturas gestorFacturas = new GestorFacturas();
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
    }

    @Test
    public void testExisteCliente() { //devuelve true si el nif existe
        assertThat(baseDeDatos.existeCliente("20925403"), is(true));
        assertThat(baseDeDatos.existeCliente("22921854"), is(false));
        assertThat(baseDeDatos.existeCliente("63302284"), is(true));
        assertThat(baseDeDatos.existeCliente("00000000"), is(false));
    }

    @Test
    public void testExisteTelf() { //devuelve true si el telf existe
        assertThat(baseDeDatos.existeTelf("692242216"), is(true));
        assertThat(baseDeDatos.existeTelf("999999999"), is(false));
        assertThat(baseDeDatos.existeTelf("964246252"), is(true));
        assertThat(baseDeDatos.existeTelf("00000000"), is(false));
    }

    //comprueba que lanza la excepcion NifRepetidoException si al anadir un particular el nif ya existia

    @Test
    public void testAnadirParticular() {
        //Se busca el cliente alberto anadido en el BeforeAll
        assertEquals(alberto.getNIF(), "20925403");
        assertEquals(alberto.getNombre(), "alberto");
        assertEquals(alberto.getEmail(), "albertoprado@gmail.com");
        assertEquals(alberto.getTelf(), "692242216");
        assertEquals(alberto.getFecha(), LocalDate.now());
        assertEquals(alberto.getDireccion(), dirAlberto);
        assertEquals(pamesa.getTarifa().descripcion(), "Tarifa basica");
    }

    @Test
    public void testAnadirEmpresa() {
        //Se busca la empresa pamesa anadida en el BeforeAll
        assertEquals(pamesa.getNIF(), "63302284");
        assertEquals(pamesa.getNombre(), "pamesa");
        assertEquals(pamesa.getEmail(), "pamesa@gmail.com");
        assertEquals(pamesa.getTelf(), "964246252");
        assertEquals(pamesa.getFecha(), LocalDate.now());
        assertEquals(pamesa.getDireccion(), dirPamesa);
        assertEquals(pamesa.getTarifa().descripcion(), "Tarifa basica");
    }

    @Test
    public void testBorrarCliente() {
        //creamos un cliente
        baseDeDatos.anadirParticular("maria", "gracia rubio", "123456789", "X1234567S", dirAlberto, "mariagracia@gmail.com");
        //vemos que se ha anadido
        assertTrue(baseDeDatos.existeCliente("X1234567S"));
        //lo borramos
        baseDeDatos.borrarCliente("123456789");
        //vemos que se ha borrado
        assertFalse(baseDeDatos.existeCliente("X1234567S"));
    }

    @Test
    public void testContratarTarifaEspecial() {
        //comprobamos que alberto tiene la tarifa basica
        String descripcion = "Tarifa basica";
        assertEquals(pamesa.getTarifa().descripcion(), descripcion);

        //alberto contrata la tarifa especial por horas
        baseDeDatos.contratarTarifaPorHoras(alberto.getNIF());
        descripcion += ", con tarifa especial por horas";
        assertEquals(alberto.getTarifa().descripcion(), descripcion);

        //alberto contrata tambien la tarifa especial por dias
        baseDeDatos.contratarTarifaPorDias(alberto.getNIF());
        descripcion += ", con tarifa especial por dia";
        assertEquals(alberto.getTarifa().descripcion(), descripcion);
    }

    @Test
    public void testListarDatosCliente() {
        Formatter obj = new Formatter();
        assertEquals(baseDeDatos.listarDatosCliente("20925403"), "\nprado banarro, alberto" +
                "\n\tNIF: 20925403" +
                "\n\tTelefono: 692242216" +
                "\n\tDireccion: Castelllon - Castellon de la plana - 12005" +
                "\n\tEmail: albertoprado@gmail.com" +
                "\n\tFecha de alta: " + LocalDate.now() +
                "\n\tHora de alta: " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute()) +
                "\n\t" + alberto.getTarifa());
        obj = new Formatter();
        assertEquals(baseDeDatos.listarDatosCliente("63302284"), "\npamesa" +
                "\n\tNIF: 63302284" +
                "\n\tTelefono: 964246252" +
                "\n\tDireccion: Castelllon - VillaReal - 12006" +
                "\n\tEmail: pamesa@gmail.com" +
                "\n\tFecha de alta: " + LocalDate.now() +
                "\n\tHora de alta: " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute()) +
                "\n\t" + pamesa.getTarifa());
    }

    //comprueba darDeAltaLlamada
    @Test
    public void testDarDeAltaLlamada() {
        baseDeDatos.darDeAltaLlamada("692242216", "000000000", 120);
        Formatter obj = new Formatter();
        assertEquals(baseDeDatos.listarLlamadasCliente("692242216"),
                "\t- Llamada realizada el " + LocalDate.now()
                        + " a las " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute())
                        + " con una duracion de 120 segundos al telefono 000000000\n");
        for(Llamada llamada : alberto.getLlamadas()) { //solo hay una
            assertEquals(llamada.getTelfDest(), "000000000");
            assertEquals(llamada.getDuracion(), 120);
            assertEquals(llamada.getFecha(), LocalDate.now());
        }
    }

    //comprueba que lanza la excepcion si la duracion de la llamada es negativa
    @Test
    public void testDuracionNegativa() {
        assertThrows(IllegalArgumentException.class,
                () -> baseDeDatos.darDeAltaLlamada("692242216", "987654321", -1));
    }

    @AfterAll
    public static void borraTodo(){
        baseDeDatos = null;
    }
}