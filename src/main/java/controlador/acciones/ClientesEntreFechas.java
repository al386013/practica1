package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.IntervaloFechasIncorrectoException;
import vista.InterrogaVista;
import vista.InterrogaVistaClientes;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ClientesEntreFechas implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws IntervaloFechasIncorrectoException, DateTimeParseException {
        InterrogaVistaClientes vistaClientes = vista.getVistaClientes();
        LocalDate fechaIni = vistaClientes.getFechaIni();
        LocalDate fechaFin = vistaClientes.getFechaFin();
        baseDeDatos.compruebaFechas(fechaIni, fechaFin);
        vista.getVistaClientes().listadoClientesEntreFechas(fechaIni, fechaFin);
    }
}
