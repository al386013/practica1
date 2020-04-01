package datos.clientes;

import datos.contrato.tarifas.Tarifa;

public class Particular extends Cliente {
    //ATRIBUTOS (EL RESTO LOS HEREDA DE CLIENTE)
    private final String apellidos;

    //CONSTRUCTOR POR DEFECTO
    public Particular() {
        super();
        this.apellidos = "";
    }

    public Particular(String nombre, String apellidos, String telefono, String NIF, Direccion direccion, String email, Tarifa tarifa) {
        super(nombre, telefono, NIF, direccion, email, tarifa);
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "\n" + apellidos + ", " + super.toString();
    }

}
