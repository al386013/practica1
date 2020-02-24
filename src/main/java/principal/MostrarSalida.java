package principal;

import datos.clientes.Direccion;

import java.util.Scanner;

public class MostrarSalida {
    //He pensado tener esta clase para que devuelva a App la salida con la cadena que aparece en la APP
    public static void main(String[] args) {
        MostrarSalida obj = new MostrarSalida();
        System.out.println(obj.crearSalida());
        int op = obj.leerOpcion();
        System.out.println("Has elegido la opción " + op);
        CarteraClientes cartera = new CarteraClientes();
        obj.lanzarMetodo(op, cartera);
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

    public void lanzarMetodo(int op, CarteraClientes cartera) {
        Scanner sc = new Scanner(System.in);
        switch (op) {
            case 1:
                System.out.println("Dar de alta un nuevo cliente.\n");
                System.out.println("Introduce e para empresa o p para particular: \n");
                String letra = sc.next();
                while(letra != "e" && letra != "p") {
                    System.out.println("Parámetro incorrecto. Vuelve a intentarlo: ");
                    System.out.println("Introduce e para empresa o p para particular: \n");
                    letra = sc.next();
                }
                System.out.println("Introduce nombre: ");
                String nombre = sc.next();
                System.out.println("Introduce NIF: ");
                String nif = sc.next();
                System.out.println("Introduce CP: ");
                int cp = sc.nextInt();
                System.out.println("Introduce provincia: ");
                String provincia = sc.next();
                System.out.println("Introduce poblacion: ");
                String poblacion = sc.next();
                Direccion direccion = new Direccion(cp, provincia, poblacion);
                System.out.println("Introduce email: ");
                String email = sc.next();
                boolean res;
                if(letra == "p") { //anadir particular
                    System.out.println("Introduce apellidos: ");
                    String apellidos = sc.next();
                    res = cartera.anadirParticular(nombre, apellidos, nif, direccion, email);
                }
                else res = cartera.anadirEmpresa(nombre, nif, direccion, email);
                if(!res)
                    System.out.println("Cliente ya existente en la base de datos. ");
                break;

            case 2:
                System.out.println("Borrar un cliente.\n");
                System.out.println("Introduce su NIF: \n");
                nif = sc.next();
                res = cartera.borrarCliente(nif);
                if(!res)
                    System.out.println("Cliente no existente en la base de datos. ");
                break;

            case 3:
                System.out.println("Cambiar la tarifa de un cliente. \n");
                break;

            case 4:
                System.out.println("Recuperar los datos de un cliente. \n");
                System.out.println("Introduce su NIF: \n");
                nif = sc.next();
                break;

            case 5:
                System.out.println("Recuperar el listado de todos los clientes:\n");
                System.out.println(cartera.listarClientes());
                break;

            case 6:
                System.out.println("Dar de alta una llamada:\n");
                break;

            case 7:
                System.out.println("Listar todas las llamadas de un cliente:\n");
                System.out.println("Introduce su NIF: \n");
                nif = sc.next();
                break;

            case 8:
                System.out.println("Emitir factura para un cliente:\n");
                System.out.println("Introduce su NIF: \n");
                nif = sc.next();
                break;

            case 9:
                System.out.println("Recuperar datos de una factura:\n");
                System.out.println("Introduce su codigo: \n");
                int cod = sc.nextInt();
                break;

            case 10:
                System.out.println("Listar todas las facturas de un cliente:\n");
                System.out.println("Introduce su NIF: \n");
                nif = sc.next();
                break;

            case 11:
                System.out.println("Cierre del programa");
                break;
        }
    }
}
