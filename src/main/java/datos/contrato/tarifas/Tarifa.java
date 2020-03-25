package datos.contrato.tarifas;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {
    private float precio;

    //CONSTRUCTOR
    public Tarifa(float precio) {
        this.precio = precio;
    }

    //METODOS
    public float getPrecio() {
        return precio;
    }

    public abstract String descripcion();

    @Override
    public String toString() {
        return precio + " €/min";
    }
}
