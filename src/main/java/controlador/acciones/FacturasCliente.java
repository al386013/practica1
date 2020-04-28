package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaFacturas;

import java.time.LocalDate;

public class FacturasCliente implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws NifNoExistenteException {
        InterrogaVistaFacturas vistaFacturas = vista.getVistaFacturas();
        String nif = vistaFacturas.getNifFacCli();
        baseDeDatos.compruebaNifExistente(nif);
        LocalDate fechaIni = LocalDate.parse("1999-01-01");
        LocalDate hoy = LocalDate.now();
        vista.getVistaFacturas().listadoFacturasEntreFechas(nif, fechaIni, hoy);
    }
}
