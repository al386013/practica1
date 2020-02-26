package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.clientes.Particular;
import es.uji.www.GeneradorDatosINE;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class GestorClientesTest {
    GestorClientes gestorClientes;

    @BeforeAll
    public void inicializaClientes(){
        gestorClientes = new GestorClientes();
        for(int i = 0; i < 100 ; i++){
            GeneradorDatosINE generadorDatosINE = new GeneradorDatosINE();
            String provincia = generadorDatosINE.getProvincia();
            String poblacion = generadorDatosINE.getPoblacion(provincia);
            String Cp = "12005"; //GENERADOR INE NO TIENE CP
            Direccion direccion = new Direccion(Cp, provincia, poblacion);
            gestorClientes.anadirParticular(generadorDatosINE.getNombre(), generadorDatosINE.getApellido(), "666666666",generadorDatosINE.getNIF(), direccion, "ejemplo@gmail.com" );
        }

    }

    @Test
    public void testDevuelveCliente(){
        Direccion direccion = new Direccion("12005", "Castellon de la plana", "Castelllon");
        gestorClientes.anadirParticular("miguel", "pardo navarro","692242216","20925403",direccion,"miguelpardo@gmail.com");
        Cliente miguel = new Particular("miguel", "pardo navarro","692242216","20925403", direccion,"miguelpardo@gmail.com");
        assertThat(gestorClientes.devuelveCliente("20925403"), is(miguel));
    }

    @AfterAll
    public void borrado(){
        gestorClientes = null;
    }
}
