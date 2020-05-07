
/**ESTE TEST NO FUNCIONA YA QUE LOS TESTS NO CONOCEN LA VISTA Y NO PUEDEN EJECUTARSE
 * YA QUE LOS METODOS DE BASE DE DATOS QUE SE USAN MUESTRAN POR VISTA UNA VENTANA **/

/*package modelo.principal;

import modelo.datos.clientes.Cliente;
import modelo.datos.clientes.Direccion;
import modelo.datos.clientes.Empresa;
import modelo.datos.clientes.Particular;
import modelo.datos.llamadas.Llamada;
import es.uji.www.GeneradorDatosINE;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Formatter;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GestorClientesTest {
    private static BaseDeDatos baseDeDatos;
    private static Cliente alberto;
    private static Direccion dirAlberto;
    private static Cliente pamesa;
    private static Direccion dirPamesa;
    private static FabricaTarifas fabricaTarifas;

    @BeforeAll
    public static void inicializa() {
        GestorClientes gestorClientes = new GestorClientes();
        GestorFacturas gestorFacturas = new GestorFacturas();
        baseDeDatos = new BaseDeDatos(gestorClientes, gestorFacturas);
        fabricaTarifas = new FabricaTarifas();

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

        dirAlberto = new Direccion("12005", "Castellon de la plana", "Castelllon");
        baseDeDatos.anadirParticular("alberto", "prado banarro", "692242216", "20925403",
                dirAlberto, "albertoprado@gmail.com");
        alberto = gestorClientes.devuelveCliente("20925403");

        dirPamesa = new Direccion("12006", "VillaReal", "Castelllon");
        baseDeDatos.anadirEmpresa("pamesa", "964246252", "63302284", dirPamesa, "pamesa@gmail.com");
        pamesa = gestorClientes.devuelveCliente("63302284");
    }

    @Test
    public void existeClienteTest() { //devuelve true si el nif existe
        assertThat(baseDeDatos.existeCliente("20925403"), is(true));
        assertThat(baseDeDatos.existeCliente("22921854"), is(false));
        assertThat(baseDeDatos.existeCliente("63302284"), is(true));
        assertThat(baseDeDatos.existeCliente("00000000"), is(false));
    }

    @Test
    public void existeTelfTest() { //devuelve true si el telf existe
        assertThat(baseDeDatos.existeTelf("692242216"), is(true));
        assertThat(baseDeDatos.existeTelf("999999999"), is(false));
        assertThat(baseDeDatos.existeTelf("964246252"), is(true));
        assertThat(baseDeDatos.existeTelf("00000000"), is(false));
    }

    @Test
    public void anadirParticularTest() {
        //Se busca el cliente alberto anadido en el BeforeAll
        Assert.assertEquals(alberto, new Particular("alberto", "prado banarro", "692242216",
                "20925403", dirAlberto, "albertoprado@gmail.com", fabricaTarifas.getBasica()));
    }

    @Test
    public void anadirEmpresaTest() {
        //Se busca la empresa pamesa anadida en el BeforeAll
        Assert.assertEquals(pamesa, new Empresa("pamesa", "964246252", "63302284", dirPamesa,
                "pamesa@gmail.com", fabricaTarifas.getBasica()));
    }

    @Test
    public void borrarClienteTest() {
        //creamos un cliente
        baseDeDatos.anadirParticular("maria", "gracia rubio", "123456789", "X1234567S",
                dirAlberto, "mariagracia@gmail.com");
        //vemos que se ha anadido
        assertTrue(baseDeDatos.existeCliente("X1234567S"));
        //lo borramos
        baseDeDatos.borrarCliente("123456789");
        //vemos que se ha borrado
        assertFalse(baseDeDatos.existeCliente("X1234567S"));
    }

    @Test
    public void contratarTarifaEspecialTest() {
        //comprobamos que alberto tiene la tarifa basica
        String descripcion = "Tarifa basica";
        assertEquals(pamesa.getTarifa().descripcion(), descripcion);

        //alberto contrata la tarifa especial de tardes reducida
        baseDeDatos.contratarTarifaEspecial("tardes", alberto.getNIF());
        descripcion += " + tardes reducida";
        assertEquals(alberto.getTarifa().descripcion(), descripcion);

        //alberto contrata tambien la tarifa especial de domingos gratis
        baseDeDatos.contratarTarifaEspecial("domingo", alberto.getNIF());
        descripcion += " + domingos gratis";
        assertEquals(alberto.getTarifa().descripcion(), descripcion);
    }

    @Test
    public void listarDatosClienteTest() {
        Formatter obj = new Formatter();
        //test con particular
        assertEquals(baseDeDatos.listarDatosCliente("20925403"),
                "prado banarro, alberto<br/>" +
                "<ul><li> NIF: 20925403</li>" +
                "<li> Telefono: 692242216</li>" +
                "<li> Direccion: Castelllon - Castellon de la plana - 12005</li>" +
                "<li> Email: albertoprado@gmail.com</li>" +
                "<li> Fecha de alta: " + LocalDate.now() + "</li>" +
                "<li> Hora de alta: " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute()) + "</li>" +
                "<li>" + alberto.getTarifa().descripcion() + "</li></ul>");
        obj = new Formatter();
        //test con empresa
        assertEquals(baseDeDatos.listarDatosCliente("63302284"),
        "pamesa<br/>" +
                "<ul><li> NIF: 63302284</li>" +
                "<li> Telefono: 964246252</li>" +
                "<li> Direccion: Castelllon - VillaReal - 12006</li>" +
                "<li> Email: pamesa@gmail.com</li>" +
                "<li> Fecha de alta: " + LocalDate.now() + "</li>" +
                "<li> Hora de alta: " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute()) + "</li>" +
                "<li>" + pamesa.getTarifa().descripcion() + "</li></ul>");
        obj = new Formatter();
        //test listarClietnes

    }

    //comprueba darDeAltaLlamada
    @Test
    public void darDeAltaLlamadaTest() {
        baseDeDatos.darDeAltaLlamada("692242216", "000000000", 120);
        Formatter obj = new Formatter();
        assertEquals(baseDeDatos.listarLlamadasCliente("692242216"),
                "<html>- Llamada realizada por 692242216 el " + LocalDate.now()
                        + " a las " + obj.format("%02d:%02d", LocalTime.now().getHour(), LocalTime.now().getMinute())
                        + " con una duracion de 120 segundos al telefono 000000000 -<br/></html>");
        for (Llamada llamada : alberto.getLlamadas()) { //solo hay una
            assertEquals(llamada.getTelfDest(), "000000000");
            assertEquals(llamada.getDuracion(), 120);
            assertEquals(llamada.getFecha(), LocalDate.now());
        }
    }

    @AfterAll
    public static void borraTodo() {
        baseDeDatos = null;
    }
} */