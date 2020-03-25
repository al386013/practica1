package datos.contrato.tarifas;

public class TarifaEspecial extends Tarifa {
    private Tarifa tarifa;

    public TarifaEspecial(Tarifa tarifa, float precioEspecial) {
        super(precioEspecial);
        this.tarifa = tarifa;
    }

    @Override
    public float getPrecio() {
        return tarifa.getPrecio() + super.getPrecio();
    }
    
}
