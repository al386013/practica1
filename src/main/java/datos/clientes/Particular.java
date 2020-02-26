package datos.clientes;

public class Particular extends Cliente {
    //ATRIBUTOS (EL RESTO LO HEREDA DE CLIENTE)
    private final String apellidos;

    //CONSTRUCTOR
    public Particular(String nombre, String apellidos, String telefono, String NIF, Direccion direccion, String email){
        super(nombre,telefono, NIF, direccion, email);
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(apellidos + ", ");
        sb.append(super.toString());
        return sb.toString();
    }
}
