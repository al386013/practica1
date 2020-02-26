package principal;

import datos.clientes.Direccion;
import es.uji.www.GeneradorDatosINE;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class GestorClientesTest {
    @BeforeAll
    public void inicializaClientes(){
        GestorClientes gestorClientes = new GestorClientes();
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



    }
    //@AfterAll
}
