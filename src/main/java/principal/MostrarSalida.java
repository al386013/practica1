package principal;

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
        StringBuilder sb = new StringBuilder();
        sb.append("Escoja una de las siguientes opciones: \n");
        sb.append("1) Dar de alta un nuevo cliente \n");
        sb.append("2) Borrar un cliente \n");
        sb.append("3) Cambiar la tarifa de un cliente \n");
        sb.append("4) Recuperar los datos de un cliente a partir de su NIF \n");
        sb.append("5) Recuperar el listado de todos los clientes \n");
        sb.append("\n");
        sb.append("6) Dar de alta una llamada \n");
        sb.append("7) Listar todas las llamadas de un cliente \n");
        sb.append("\n");
        sb.append("8) Emitir una factura para un cliente \n");
        sb.append("9) Recuperar los datos de una factura a partir de su código \n");
        sb.append("10) Recuperar todas las facturas de un cliente \n");
        sb.append("\n");
        sb.append("11) Salir \n");
        return sb.toString();
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
        switch (op) {
            default:
                System.out.println("JEJe");
        }
    }
}
