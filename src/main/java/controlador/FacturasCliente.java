package controlador;

import modelo.principal.NifNoExistenteException;
import vista.InterrogaVistaFacturas;
import java.time.LocalDate;

class FacturasCliente extends Accion {
    public void ejecutaAccion() throws NifNoExistenteException {
        InterrogaVistaFacturas vistaFacturas = vista.getPanelFacturas();
        String nif = vistaFacturas.getNifFacCli();
        baseDeDatos.compruebaNifExistente(nif);
        LocalDate fechaIni = LocalDate.parse("1999-01-01");
        LocalDate hoy = LocalDate.now();
        vista.getPanelFacturas().listadoFacturasEntreFechas(nif, fechaIni, hoy);
    }
}
