package modelo.principal;

import modelo.datos.contrato.tarifas.TarifaDomingosGratis;
import modelo.datos.contrato.tarifas.Tarifa;
import modelo.datos.contrato.tarifas.TarifaBasica;
import modelo.datos.contrato.tarifas.TarifaTardesReducida;

public class FabricaTarifas implements InterfazFabricaTarifas {
    public FabricaTarifas() {
        super();
    }

    @Override
    public Tarifa getBasica() {
        return new TarifaBasica(0.05f);
    }

    @Override
    public Tarifa getOferta(String tipo, Tarifa tarifa) {
        Tarifa tarifaEspecial = new TarifaTardesReducida(tarifa, 0.03f);
        switch (tipo) {
            case "domingo":
                tarifaEspecial = new TarifaDomingosGratis(tarifa, 0.00f);
                break;
        }
        return tarifaEspecial;
    }
}
