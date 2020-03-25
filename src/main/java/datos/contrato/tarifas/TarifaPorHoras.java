package datos.contrato.tarifas;

public class TarifaPorHoras extends TarifaEspecial {
    public TarifaPorHoras(Tarifa tarifa) {
        super(tarifa, 0.03f);
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", con tarifa por horas";
    }
}
