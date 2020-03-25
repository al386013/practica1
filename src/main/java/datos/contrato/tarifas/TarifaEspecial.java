package datos.contrato.tarifas;

public abstract class TarifaEspecial extends Tarifa {
    private Tarifa tarifa;

    public TarifaEspecial(Tarifa tarifa, float precio) {
        super(precio);
        this.tarifa = tarifa;
    }

    @Override
    public float getPrecio() {
        return tarifa.getPrecio() + super.getPrecio();
    }

}
