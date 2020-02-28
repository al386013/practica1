package principal;

import datos.contrato.PeriodoFacturacion;
import org.junit.jupiter.api.Test;
import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.clientes.Empresa;
import datos.clientes.Particular;
import datos.llamadas.Llamada;
import es.uji.www.GeneradorDatosINE;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GestorFacturasTest {
    GestorFacturas gestorFacturas = new GestorFacturas();

//    @Test
//    public void emitirFactura(){
//        Direccion direccion = new Direccion("12005", "Castellon", "Castellon de la plana");
//        Cliente cliente = new Particular("alberto", "prado banarro","692242216","20925403",direccion,"albertoprado@gmail.com")
//        LocalDate localDate1 = LocalDate.now();
//        LocalDate localDate2 = localDate1.plusMonths(1);
//        PeriodoFacturacion periodoFacturacion = new PeriodoFacturacion(localDate1, localDate2);
//        gestorFacturas.emitirFactura(periodoFacturacion, cliente);
//        assertThat(gestorFacturas.obtenerFactura());
//    }
}
