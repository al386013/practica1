package datos.contrato.tarifas;

public class TarifaPorDia extends TarifaEspecial {
    public TarifaPorDia(Tarifa tarifa, float precioEspecial) {
        super(tarifa, precioEspecial);
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", con tarifa especial por dia";
    }
}
