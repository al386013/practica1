package interfaces;

import datos.contrato.tarifas.Tarifa;

import java.util.Enumeration;

public interface InterfazFabricaTarifas {
    Tarifa getBasica();
    Tarifa getOferta(Enumeration elemento, Tarifa recubierta);
}
