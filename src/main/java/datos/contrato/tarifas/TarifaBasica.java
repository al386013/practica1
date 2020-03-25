package datos.contrato.tarifas;

public class TarifaBasica extends Tarifa {
    public TarifaBasica() {
        super(0.05f);
    }

    @Override
    public String descripcion() {
        return "Tarifa básica";
    }
}
