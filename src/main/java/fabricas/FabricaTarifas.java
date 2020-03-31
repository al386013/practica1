package fabricas;

import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaBasica;
import datos.contrato.tarifas.TarifaDomingosGratis;
import datos.contrato.tarifas.TarifaTardesReducida;
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
        Tarifa tarifaEspecial = new TarifaTardesReducida(tarifa, 0.03f);
        switch(elemento) {
            case TARIFA_POR_DIA:
                tarifaEspecial = new TarifaDomingosGratis(tarifa, 0.00f);
                break;
        }
        return tarifaEspecial;
    }
}
