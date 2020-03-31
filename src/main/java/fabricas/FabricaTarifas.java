package fabricas;

import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaBasica;
import datos.contrato.tarifas.TarifaPorDia;
import datos.contrato.tarifas.TarifaPorHoras;
import interfaces.InterfazFabricaTarifas;
import menus.MenuCambiarTarifa;

public class FabricaTarifas implements InterfazFabricaTarifas {
    public FabricaTarifas() {
        super();
    }

    @Override
    public Tarifa getBasica() {
        return new TarifaBasica(0.05f);
    }

    @Override
    public Tarifa getOferta(MenuCambiarTarifa elemento, Tarifa tarifa) {
        Tarifa tarifaEspecial = new TarifaPorHoras(tarifa, 0.03f);
        switch(elemento) {
            case TARIFA_POR_DIA:
                tarifaEspecial = new TarifaPorDia(tarifa, 0.00f);
                break;
        }
        return tarifaEspecial;
    }
}
