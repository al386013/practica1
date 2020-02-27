package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.clientes.Empresa;
import datos.clientes.Particular;
import es.uji.www.GeneradorDatosINE;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BaseDeDatosTest {
    BaseDeDatos baseDeDatos;
    Cliente alberto;
    Cliente pamesa;

    @BeforeAll
    public void inicializa(){
        baseDeDatos = new BaseDeDatos();
        for (int i = 0; i < 100; i ++){
            GeneradorDatosINE generadorDatosINE = new GeneradorDatosINE();
            String provincia = generadorDatosINE.getProvincia();
            String poblacion = generadorDatosINE.getPoblacion(provincia);
            String Cp = "12005"; //GENERADOR INE NO TIENE CP
            Direccion direccion = new Direccion(Cp, provincia, poblacion);
            baseDeDatos.anadirParticular(generadorDatosINE.getNombre(), generadorDatosINE.getApellido(), "666666666",generadorDatosINE.getNIF(), direccion, "ejemplo@gmail.com" );
        }
        Direccion direccion = new Direccion("12005", "Castellon de la plana", "Castelllon");
        baseDeDatos.anadirParticular("alberto", "prado banarro","692242216","20925403",direccion,"albertoprado@gmail.com");
        alberto = new Particular("alberto", "prado banarro","692242216","20925403", direccion,"albertoprado@gmail.com");

        Direccion direccionPamesa = new Direccion("12006", "VillaReal", "Castelllon");
        baseDeDatos.anadirEmpresa("pamesa", "964246252", "63302284",direccionPamesa, "pamesa@gmail.com");
        pamesa = new Empresa("pamesa","964246252", "63302284", direccionPamesa, "pamesa@gmail.com");

    }


    @Test
    public void testExisteCliente(){
        assertThat(baseDeDatos.existeCliente("20925403"), is(true));
        assertThat(baseDeDatos.existeCliente("22921854"), is(false));
        assertThat(baseDeDatos.existeCliente("63302284"), is(true));
        assertThat(baseDeDatos.existeCliente("00000000"), is(false));

    }

    @Test
    public void testAñadirParticular(){
        //El cliente que se busca se ha añadido en el BeforeAll ("alberto")
        assertThat(baseDeDatos.existeCliente("20925403") , is(true));


    }

    @Test
    public void testAñadirEmpresa(){
        //El cliente que se busca se ha añadido en el BeforeAll ("pamesa")
        assertThat(baseDeDatos.existeCliente("63302284"), is(true));

    }

    @Test
    public void testDarDeAltaLlamada(){
        

    }


    @AfterAll
    public void borra(){
        baseDeDatos = null;
    }


}
