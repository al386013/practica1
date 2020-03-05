package datos.contrato;

import java.io.Serializable;

public class Tarifa implements Serializable {
    //ATRIBUTO
    private float tarifa;

    //CONSTRUCTOR POR DEFECTO
    public Tarifa() {
        tarifa = 0.05f;
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
