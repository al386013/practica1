package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;

import java.util.Scanner;

public class MostrarSalida {
    Scanner sc = new Scanner(System.in);

    //He pensado tener esta clase para que devuelva a App la salida con la cadena que aparece en la APP
    public static void main(String[] args) {
        MostrarSalida obj = new MostrarSalida();
        System.out.println(obj.crearSalida());
        int op = obj.leerOpcion();
        System.out.println("Has elegido la opción " + op);
        GestorClientes cartera = new GestorClientes();
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

    public void lanzarMetodo(int op, GestorClientes cartera) {
        switch (op) {
            case 1:
                lanzarMetodo1(cartera);
                break;
            case 2:
               lanzarMetodo2(cartera);
                break;
            case 3:
                lanzarMetodo3(cartera);
                break;
            case 4:
                lanzarMetodo4(cartera);
                break;
            case 5:
                lanzarMetodo5(cartera);
                break;
            case 6:
                lanzarMetodo6(cartera);
                break;
            case 7:
                lanzarMetodo7(cartera);
                break;
            case 8:
                lanzarMetodo8(cartera);
                break;
            case 9:
                lanzarMetodo9(cartera);
                break;
            case 10:
                lanzarMetodo10(cartera);
                break;
            case 11:
               lanzarMetodo11(cartera);
                break;
        }
    }

    public void lanzarMetodo1(GestorClientes cartera) {
        Cliente cliente;
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
        System.out.println("Introduce telefono: ");
        String telf = sc.next();
        System.out.println("Introduce NIF: ");
        String nif = sc.next();
        System.out.println("Introduce CP: ");
        String cp = sc.next();
        System.out.println("Introduce provincia: ");
        String provincia = sc.next();
        System.out.println("Introduce poblacion: ");
        String poblacion = sc.next();
        Direccion direccion = new Direccion(cp, provincia, poblacion);
        System.out.println("Introduce email: ");
        String email = sc.next();
        if(letra == "p") { //anadir particular
            System.out.println("Introduce apellidos: ");
            String apellidos = sc.next();
            cliente = cartera.anadirParticular(nombre, apellidos, telf, nif, direccion, email);
        }
        else cliente = cartera.anadirEmpresa(nombre, telf, nif, direccion, email);
        if(cliente == null)
            System.out.println("Cliente ya existente en la base de datos. ");
        else System.out.println("Operación realizada con éxito");
    }

    public void lanzarMetodo2(GestorClientes cartera) {
        System.out.println("Borrar un cliente.\n");
        System.out.println("Introduce su NIF: \n");
        String nif = sc.next();
        Cliente cliente = cartera.borrarCliente(nif);
        if(cliente == null) System.out.println("Cliente no existente en la base de datos. ");
        else System.out.println("Operación realizada con éxito");
    }

    public void lanzarMetodo3(GestorClientes cartera) {
        System.out.println("Cambiar la tarifa de un cliente. \n");
        System.out.println("Introduce su NIF: \n");
        String nif = sc.next();
        Cliente cliente = cartera.devuelveCliente(nif);
        if(cliente == null)
            System.out.println("Cliente no existente en la base de datos. ");
        else {
            System.out.println("Introduce la tarifa deseada (en €/min): \n");
            double tarifa = sc.nextDouble();
            while (tarifa < 0 || tarifa > 100) {
                System.out.println("Tarifa no permitida, vuelve a introducir la tarifa deseada: ");
                tarifa = sc.nextDouble();
            }
            cliente.cambiarTarifa(tarifa);
            System.out.println("Operación realizada con éxito");
        }
    }

    public void lanzarMetodo4(GestorClientes cartera) {
        System.out.println("Recuperar los datos de un cliente. \n");
        System.out.println("Introduce su NIF: \n");
        String nif = sc.next();
        String res = cartera.recDatosCliente(nif);
        if(res == null) System.out.println("Cliente no existente en la base de datos. ");
        else System.out.println(res);
    }

    public void lanzarMetodo5(GestorClientes cartera) {
        System.out.println("Recuperar el listado de todos los clientes:\n");
        System.out.println(cartera.listarClientes());
    }

    public void lanzarMetodo6(GestorClientes cartera) {
        System.out.println("Dar de alta una llamada:\n");
        System.out.println("Introduce el telefono del cliente que hace la llamada: \n");
        String tel = sc.next();
        System.out.println("Introduce el telefono de destino: ");
        String telf = sc.next();
        System.out.println("Introduce la fecha de la llamada (formato dd/mm/aaaa)"); //comprobar que está correcta??
        String fecha = sc.next();
        System.out.println("Introduce la hora de la llamada (formato hh:hh)");
        String hora = sc.next();
        System.out.println("Introduce la duración de la llamada (en segundos)");
        int duracion = sc.nextInt();
        while(duracion < 0) {
            System.out.println("Duracion incorrecta. Vuelve a introducir la duracion (en segundos): ");
            duracion = sc.nextInt();
        }
    }

    public void lanzarMetodo7(GestorClientes cartera) {
        System.out.println("Listar todas las llamadas de un cliente:\n");
        System.out.println("Introduce su NIF: \n");
        String nif = sc.next();
    }

    public void lanzarMetodo8(GestorClientes cartera) {
        System.out.println("Emitir factura para un cliente:\n");
        System.out.println("Introduce su NIF: \n");
        String nif = sc.next();
    }

    public void lanzarMetodo9(GestorClientes cartera) {
        System.out.println("Recuperar datos de una factura:\n");
        System.out.println("Introduce su codigo: \n");
        int cod = sc.nextInt();
    }

    public void lanzarMetodo10(GestorClientes cartera) {
        System.out.println("Listar todas las facturas de un cliente:\n");
        System.out.println("Introduce su NIF: \n");
        String nif = sc.next();
    }

    public void lanzarMetodo11(GestorClientes cartera) {
        System.out.println("Cierre del programa");
    }
}
