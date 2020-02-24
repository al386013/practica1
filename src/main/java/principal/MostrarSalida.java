package principal;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class MostrarSalida {
    //He pensado tener esta clase para que devuelva a App la salida con la cadena que aparece en la APP
    public static void main(String[] args) {
        MostrarSalida obj = new MostrarSalida();
        System.out.println(obj.crearSalida());
        int op = obj.leerOpcion();
        System.out.println("Has elegido la opción " + op);
        obj.lanzarMetodo(op);
    }

    public String crearSalida(){
        String salida = "";
        salida += "Escoja una de las siguientes opciones: \n";
        salida += "\n";
        salida += "1) Dar de alta un nuevo cliente \n";
        salida += "2) Borrar un cliente \n";
        salida += "3) Cambiar la tarifa de un cliente \n";
        salida += "4) Recuperar los datos de un cliente a partir de su NIF \n";
        salida += "5) Recuperar el listado de todos los clientes \n";
        salida += "\n";
        salida += "6) Dar de alta una llamada \n";
        salida += "7) Listar todas las llamadas de un cliente \n";
        salida += "\n";
        salida += "8) Emitir una factura para un cliente \n";
        salida += "9) Recuperar los datos de una factura a partir de su código \n";
        salida += "10) Recuperar todas las facturas de un cliente \n";
        salida += "\n";
        salida += "11) Salir \n";
        return salida;
    }

    public int leerOpcion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una opción: ");
        int op = sc.nextInt();
        while(op < 1 || op > 11) {
            System.out.println("Opción incorrecta, vuelve a intentarlo.");
            System.out.println("Introduce otra opción: ");
            op = sc.nextInt();
        }
        return op;
    }

    public void lanzarMetodo(int op) {

    }
}
