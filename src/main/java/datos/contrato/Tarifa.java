package datos.contrato;

public class Tarifa {
    //ATRIBUTO
    private float tarifa;

    //CONSTRUCTOR POR DEFECTO
    public Tarifa() {
        tarifa = 0.05f;
    }

    public Tarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    //METODOS
    public float getTarifa() { return tarifa; }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return tarifa + " €/min";
    }
}
