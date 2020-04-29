package controlador.acciones;

import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;

import java.time.LocalDate;

public class ListadoClientes implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        LocalDate fechaIni = LocalDate.parse("1999-01-01");
        LocalDate hoy = LocalDate.now();
        vista.getVistaClientes().listadoClientesEntreFechas(fechaIni, hoy);
    }
}
