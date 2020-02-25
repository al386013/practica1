package datos.contrato;

public class Tarifa {
    //ATRIBUTO
    private float tarifa = (float)0.05;

    //CONSTRUCTOR
    public Tarifa() { }

    //METODOS
    public float getTarifa() { return tarifa; }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public String toString() {
        return tarifa + " €/min";
    }
}
