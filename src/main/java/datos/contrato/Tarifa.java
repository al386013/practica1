package datos.contrato;

public class Tarifa {
    private double tarifa = 0.05;

    public Tarifa() { }

    public double getTarifa() { return tarifa; }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String toString() {
        return tarifa + " €/min";
    }
}
