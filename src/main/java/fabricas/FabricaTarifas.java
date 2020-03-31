package fabricas;

import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaBasica;
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
        return new TarifaBasica(0.05f); //OBVIAMENTE NO ES ASI, LE HE PREGUNTADO SI HAY QUE PONER UN SWITCH O COMO SE HACE
    }

    //en los test tenemos que eliminar los new y crear factorías? en el test de factoriaClientes usamos facturiaTarifas?
}
