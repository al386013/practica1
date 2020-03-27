package datos.contrato.tarifas;

public class TarifaPorHoras extends TarifaEspecial {
    public TarifaPorHoras(Tarifa tarifa, float precioEspecial) {
        super(tarifa, precioEspecial);
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", con tarifa especial por horas";
    }
}
