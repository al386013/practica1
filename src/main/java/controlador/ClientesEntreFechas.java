package controlador;

import modelo.principal.IntervaloFechasIncorrectoException;
import vista.InterrogaVistaClientes;
import java.time.LocalDate;

public class ClientesEntreFechas extends Accion {
    public void ejecutaAccion() throws IntervaloFechasIncorrectoException {
        InterrogaVistaClientes vistaClientes = vista.getPanelClientes();
        LocalDate fechaIni = vistaClientes.getFechaIni();
        LocalDate fechaFin = vistaClientes.getFechaFin();
        baseDeDatos.compruebaFechas(fechaIni, fechaFin);
        vista.getPanelClientes().listadoClientesEntreFechas(fechaIni, fechaFin);
    }
}
