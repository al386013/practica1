package datos.contrato.tarifas;

public class TarifaBasica extends Tarifa {
    public TarifaBasica(float precio) {
        super(precio);
    }

    @Override
    public Tarifa getTarifa() {
        return null;
    }

    @Override
    public String descripcion() {
        return "Tarifa basica";
    }
}
