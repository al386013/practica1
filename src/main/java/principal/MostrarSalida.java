package principal;

public class MostrarSalida {
    //He pensado tener esta clase para que devuelva a App la salida con la cadena que aparece en la APP

    public static void main(String[] args) {
        new MostrarSalida().crearSalida();
    }
    public void crearSalida(){
        String salida = "";
        salida += "Escoja una de las siguientes opciones: \n";
        salida += "1) Dar de alta un nuevo cliente \n";
        salida += "2) Borrar un cliente \n";
        salida += "3) Cambiar la tarifa de un cliente \n";
        salida += "4) Recuperar los datos de un cliente a partir de su NIF \n";
        salida += "5) Recuperar el listado de todos los clientes \n";
        salida += "6) Salir \n";

        //Hay que pensar como deshacernos del siguiente print;
        System.out.println(salida);

    }
}
