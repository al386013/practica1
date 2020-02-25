package datos.contrato;

public class Tarifa {
    private float tarifa = (float)0.05;

    public Tarifa() { }

    public float getTarifa() { return tarifa; }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public String toString() {
        return tarifa + " €/min";
    }
}
