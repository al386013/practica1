package controlador;

import java.time.LocalDate;

class ListadoClientes extends Accion {
    public void ejecutaAccion() {
        LocalDate fechaIni = LocalDate.parse("1999-01-01");
        LocalDate hoy = LocalDate.now();
        vista.getPanelClientes().listadoClientesEntreFechas(fechaIni, hoy);
    }
}