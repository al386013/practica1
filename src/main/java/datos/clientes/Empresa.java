package datos.clientes;

public class Empresa extends Cliente {
    //TODOS SUS ATRIBUTOS LOS HEREDA DE CLIENTE

    //CONSTRUCTOR
    public Empresa(String nombre,String telefono ,String NIF, Direccion direccion, String email) {
        super(nombre,telefono, NIF, direccion, email);
    }

}
