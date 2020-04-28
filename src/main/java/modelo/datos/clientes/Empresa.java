package modelo.datos.clientes;

import modelo.datos.contrato.tarifas.Tarifa;

public class Empresa extends Cliente {
    //TODOS SUS ATRIBUTOS LOS HEREDA DE CLIENTE

    //CONSTRUCTOR POR DEFECTO
    public Empresa() {
        super();
    }

    public Empresa(String nombre, String telefono, String NIF, Direccion direccion, String email, Tarifa tarifa) {
        super(nombre, telefono, NIF, direccion, email, tarifa);
    }

    @Override
    public String toString() {
        return super.toString(); //insertamos el salto de linea antes del nombre
    }
}
