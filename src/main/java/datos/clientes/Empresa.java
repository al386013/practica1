package datos.clientes;

public class Empresa extends Cliente {
    //TODOS SUS ATRIBUTOS LOS HEREDA DE CLIENTE

    //CONSTRUCTOR
    Empresa(String nombre, String NIF, String direccion, String email) {
        super(nombre, NIF, direccion, email);
    }

}
