package datos.contrato.tarifas;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {
    private float valor;

    //CONSTRUCTOR
    public Tarifa() {
        valor = 0.05f;
    }

    //METODOS
    public float getPrecio() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + " €/min";
    }
}
