package principal;

import datos.clientes.Direccion;

import java.util.Scanner;

public class Salida {
    BaseDeDatos baseDeDatos;
    Scanner sc = new Scanner(System.in);

    public Salida(BaseDeDatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public String mostrarMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Escoja una de las siguientes opciones: \n");
        sb.append("1) Dar de alta un nuevo cliente \n");
        sb.append("2) Borrar un cliente \n");
        sb.append("3) Cambiar la tarifa de un cliente \n");
        sb.append("4) Recuperar los datos de un cliente a partir de su NIF \n");
        sb.append("5) Recuperar el listado de todos los clientes \n");
        sb.append("6) Dar de alta una llamada \n");
        sb.append("7) Listar todas las llamadas de un cliente \n");
        sb.append("8) Emitir una factura para un cliente \n");
        sb.append("9) Recuperar los datos de una factura a partir de su código \n");
        sb.append("10) Recuperar todas las facturas de un cliente \n");
        sb.append("11) Salir \n");
        return sb.toString();
    }

    public int leerOpcion() {
        System.out.print("Introduce una opción: ");
        int op = sc.nextInt();
        while(op < 1 || op > 11) {
            System.out.println("Opción incorrecta, vuelve a intentarlo.");
            System.out.print("Introduce otra opción: ");
            op = sc.nextInt();
        }
        return op;
    }

    public void lanzarMetodo(int op) {
        switch (op) {
            case 1:
                lanzarMetodo1();
                break;
            case 2:
               lanzarMetodo2();
                break;
            case 3:
                lanzarMetodo3();
                break;
            case 4:
                lanzarMetodo4();
                break;
            case 5:
                lanzarMetodo5();
                break;
            case 6:
                lanzarMetodo6();
                break;
            case 7:
                lanzarMetodo7();
                break;
            case 8:
                lanzarMetodo8();
                break;
            case 9:
                lanzarMetodo9();
                break;
            case 10:
                lanzarMetodo10();
                break;
            case 11:
               lanzarMetodo11();
                break;
        }
    }

    public void lanzarMetodo1() {
        System.out.println("\n1) Dar de alta un nuevo cliente.\n");
        System.out.print("- Introduce 'e' para empresa o 'p' para particular: \n");
        String letra = sc.next();
        while(letra != "e" && letra != "p") {
            System.out.print("Parámetro incorrecto. Vuelve a intentarlo: ");
            letra = sc.next();
        }
        System.out.print("- Introduce nombre: ");
        String nombre = sc.next();
        System.out.print("- Introduce telefono: ");
        String telf = sc.next();
        String nif = pedirNIF();
        System.out.print("- Introduce CP: ");
        String cp = sc.next();
        System.out.print("- Introduce provincia: ");
        String provincia = sc.next();
        System.out.print("- Introduce poblacion: ");
        String poblacion = sc.next();
        Direccion direccion = new Direccion(cp, provincia, poblacion);
        System.out.print("- Introduce email: ");
        String email = sc.next();
        if(letra == "p") { //anadir particular
            System.out.print("- Introduce apellidos: ");
            String apellidos = sc.next();
            baseDeDatos.anadirParticular(nombre, apellidos, telf, nif, direccion, email);
        }
        else baseDeDatos.anadirEmpresa(nombre, telf, nif, direccion, email);
        mensajeExito();
    }

    public void lanzarMetodo2() {
        System.out.println("\n2) Borrar un cliente.");
        String nif = pedirNIF();
        baseDeDatos.borrarCliente(nif);
        mensajeExito();
    }

    public void lanzarMetodo3() {
        System.out.println("\n3) Cambiar la tarifa de un cliente. ");
        String nif = pedirNIF();
        System.out.print("- Introduce la tarifa deseada (en €/min): ");
        float tarifa = sc.nextFloat();
        while (tarifa < 0 || tarifa > 100) {
            System.out.print("Tarifa no permitida, vuelve a introducir la tarifa deseada: ");
            tarifa = sc.nextFloat();
        }
        baseDeDatos.cambiarTarifa(tarifa, nif);
        mensajeExito();
    }

    public void lanzarMetodo4() {
        System.out.println("\n4) Recuperar los datos de un cliente. ");
        String nif = pedirNIF();
        System.out.println(baseDeDatos.listarDatosCliente(nif) + "\n");
    }

    public void lanzarMetodo5() {
        System.out.println("\n5) Recuperar el listado de todos los clientes:\n");
        System.out.println(baseDeDatos.listarClientes());
    }

    public void lanzarMetodo6() {
        System.out.println("\n6) Dar de alta una llamada.\n");
        System.out.print("- Introduce el telefono de origen: ");
        String telfOrigen = sc.next();
        System.out.print("- Introduce el telefono de destino: ");
        String telfDest = sc.next();
        System.out.print("- Introduce la fecha de la llamada (formato dd/mm/aaaa)"); //comprobar que está correcta??
        String fecha = sc.next();
        System.out.print("- Introduce la hora de la llamada (formato hh:hh)");
        String hora = sc.next();
        System.out.print("- Introduce la duración de la llamada (en segundos)");
        int duracion = sc.nextInt();
        while(duracion < 0) {
            System.out.print("Duracion incorrecta. Vuelve a introducir la duracion (en segundos): ");
            duracion = sc.nextInt();
        }
        baseDeDatos.darDeAltaLlamada(telfOrigen, telfDest, fecha, hora, duracion);
        mensajeExito();
    }

    public void lanzarMetodo7() {
        System.out.println("\n7) Listar todas las llamadas de un cliente: \n");
        String nif = pedirNIF();
        String res = gestorLlamadas.listarLlamadas(nif);
        if(res == null) System.out.println("El cliente todavia no ha efectuado ninguna llamada.\n");
        else System.out.println(res);
    }

    public void lanzarMetodo8() {
        System.out.println("\n8) Emitir factura para un cliente. ");
        String NIF = pedirNIF();
        gestorFacturas.emitirFactura(gestorClientes, NIF);
        System.out.println("Operación realizada con exito.\n");
    }

    public void lanzarMetodo9() {
        System.out.println("\n9) Recuperar datos de una factura. ");
        System.out.print("- Introduce su codigo: \n");
        int cod = sc.nextInt();
        String res = gestorFacturas.recDatosFactura(cod);
        if(res == null) System.out.println("Codigo de factura no existente en la base de datos.\n");
        else System.out.println(res);
    }

    public void lanzarMetodo10() {
        System.out.println("\n10) Listar todas las facturas de un cliente:\n");
        String NIF = pedirNIF();
        System.out.println(gestorFacturas.listarFacturasCliente(gestorClientes, NIF));
    }

    public void lanzarMetodo11() {
        System.out.println("\n11) Programa cerrado.");
    }

    public String pedirNIF() {
        System.out.print("- Introduce el NIF del cliente: ");
        String NIF = sc.next();
        boolean existeCliente = gestorClientes.existeCliente(NIF);
        while(!existeCliente) {
            System.out.print("Cliente no existente en la base de datos. Vuelve a introducir el NIF: ");
            NIF = sc.next();
        }
        return NIF;
    }

    public void mensajeExito() {
        System.out.println("Operación realizada con éxito.\n");
    }
}

//al borrar un cliente, se borra tmb de llamadas y facturas??
