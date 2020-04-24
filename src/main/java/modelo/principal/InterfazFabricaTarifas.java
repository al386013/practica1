package modelo.principal;

import modelo.datos.contrato.tarifas.Tarifa;

public interface InterfazFabricaTarifas {
    Tarifa getBasica();

    Tarifa getOferta(String tipo, Tarifa recubierta);
}

