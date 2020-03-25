package datos.contrato.tarifas;

public class TarifaPorDia extends TarifaEspecial {

    public TarifaPorDia(Tarifa tarifa) {
        super(tarifa, 0.00f);
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", con tarifa por dia";
    }
}
