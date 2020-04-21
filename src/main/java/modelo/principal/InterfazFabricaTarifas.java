package modelo.principal;

import modelo.datos.contrato.tarifas.Tarifa;
import controlador.menus.MenuCambiarTarifa;

public interface InterfazFabricaTarifas {
    Tarifa getBasica();

    Tarifa getOferta(MenuCambiarTarifa elemento, Tarifa recubierta);
}

