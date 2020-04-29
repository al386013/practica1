package controlador;

import modelo.principal.NifNoExistenteException;
import vista.InterrogaVistaFacturas;
import java.time.LocalDate;

public class FacturasCliente extends Accion {
    public void ejecutaAccion() throws NifNoExistenteException {
        InterrogaVistaFacturas vistaFacturas = vista.getVistaFacturas();
        String nif = vistaFacturas.getNifFacCli();
        baseDeDatos.compruebaNifExistente(nif);
        LocalDate fechaIni = LocalDate.parse("1999-01-01");
        LocalDate hoy = LocalDate.now();
        vista.getVistaFacturas().listadoFacturasEntreFechas(nif, fechaIni, hoy);
    }
}
