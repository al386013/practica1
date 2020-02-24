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
        sb.append(getNombre() + " ");
        sb.append(apellidos + ", ");
        sb.append("NIF: " + getNIF() + ", ");
        sb.append("Direccion: " + getDireccion() + ", ");
        sb.append("Email: " + getEmail() + ", ");
        sb.append("Fecha de alta: " + getFechaDeAlta() + ", ");
        sb.append("Tarifa: " + getTarifa() + ".");
        return sb.toString();
    }
}
