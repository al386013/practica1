package interfaces;

import datos.contrato.tarifas.Tarifa;
import menus.MenuCambiarTarifa;

public interface InterfazFabricaTarifas {
    Tarifa getBasica();
    Tarifa getOferta(MenuCambiarTarifa elemento, Tarifa recubierta);
}
