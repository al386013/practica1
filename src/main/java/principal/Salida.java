package principal;

import datos.clientes.Direccion;

import java.time.LocalDate;
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
        sb.append("9) Recuperar los datos de una factura a partir de su codigo \n");
        sb.append("10) Recuperar todas las facturas de un cliente \n");
        sb.append("11) Salir \n");
        return sb.toString();
    }

    public int leerOpcion() {
        System.out.print("Introduce una opcion: ");
        int op = sc.nextInt();
        while(op < 1 || op > 11) {
            System.out.println("Opcion incorrecta, vuelve a intentarlo.");
            System.out.print("Introduce otra opcion: ");
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
        System.out.println("\n1) Dar de alta un nuevo cliente.");
        System.out.print("- Introduce 'e' para empresa o 'p' para particular: ");
        String letra = sc.next();
        while(!letra.equals("e") && !letra.equals("p")) {
            System.out.print("Parametro incorrecto. Vuelve a intentarlo: ");
            letra = sc.next();
        }
        System.out.print("- Introduce nombre: ");
        sc.nextLine();
        String nombre = sc.nextLine();
        String apellidos = null;
        if(letra.equals("p")) {
            System.out.print("- Introduce apellidos: ");
            apellidos = sc.nextLine();
        }
        String nif = pedirNifUnico();
        String telf = pedirTelUnico();
        System.out.print("- Introduce CP: ");
        String cp = sc.next();
        System.out.print("- Introduce provincia: ");
        sc.nextLine();
        String provincia = sc.nextLine();
        System.out.print("- Introduce poblacion: ");
        String poblacion = sc.nextLine();
        Direccion direccion = new Direccion(cp, provincia, poblacion);
        System.out.print("- Introduce email: ");
        String email = sc.next();
        if(letra.equals("p"))
            baseDeDatos.anadirParticular(nombre, apellidos, telf, nif, direccion, email);
        else baseDeDatos.anadirEmpresa(nombre, telf, nif, direccion, email);
        mensajeExito();
    }

    public void lanzarMetodo2() {
        System.out.println("\n2) Borrar un cliente.");
        String telf = pedirTelfExistente();
        baseDeDatos.borrarCliente(telf);
        mensajeExito();
    }

    public void lanzarMetodo3() {
        System.out.println("\n3) Cambiar la tarifa de un cliente. ");
        String nif = pedirNifExistente();
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
        System.out.println("\n4) Recuperar los datos de un cliente.");
        String nif = pedirNifExistente();
        System.out.println(baseDeDatos.listarDatosCliente(nif) + "\n");
    }

    public void lanzarMetodo5() {
        System.out.println("\n5) Recuperar el listado de todos los clientes:");
        System.out.println(baseDeDatos.listarClientes());
    }

    public void lanzarMetodo6() {
        System.out.println("\n6) Dar de alta una llamada.");
        String telfOrigen = pedirTelfExistente(); //pedir telfOrigen
        System.out.print("- Introduce el telefono de destino: ");
        String telfDest = sc.next();
        System.out.print("- Introduce la duracion de la llamada (en segundos): ");
        int duracion = sc.nextInt();
        while(duracion < 0) {
            System.out.print("Duracion incorrecta. Vuelve a introducir la duracion (en segundos): ");
            duracion = sc.nextInt();
        }
        baseDeDatos.darDeAltaLlamada(telfOrigen, telfDest, duracion);
        mensajeExito();
    }

    public void lanzarMetodo7() {
        System.out.println("\n7) Listar todas las llamadas de un cliente: ");
        String telf = pedirTelfExistente();
        System.out.println(baseDeDatos.listarLlamadasCliente(telf));
    }

    public void lanzarMetodo8() {
        System.out.println("\n8) Emitir factura para un cliente. ");
        String NIF = pedirNifExistente();
        System.out.print("- Introduce la fecha de inicio de la factura (formato aaaa-mm-dd): ");
        LocalDate fechaIni = LocalDate.parse(sc.next());
        System.out.print("- Introduce la fecha de fin de la factura (formato aaaa-mm-dd): ");
        LocalDate fechaFin = LocalDate.parse(sc.next());
        //comprobar que la fecha de inicio de factura sea anterior a la fecha de fin
        while(!fechaIni.isBefore(fechaFin)) {
            System.out.println("Fecha de inicio posterior a la fecha de fin. Vuelve a introducirlas (aaaa-mm-dd): ");
            System.out.print("- Fecha de inicio: ");
            fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Fecha de fin: ");
            fechaFin = LocalDate.parse(sc.next());
        }
        baseDeDatos.emitirFactura(fechaIni, fechaFin, NIF);
        mensajeExito();
    }

    public void lanzarMetodo9() {
        System.out.println("\n9) Recuperar datos de una factura. ");
        System.out.print("- Introduce su codigo: ");
        int cod = sc.nextInt();
        String res = baseDeDatos.listarDatosFactura(cod);
        if(res == null) System.out.println("Codigo de factura no existente en la base de datos.\n");
        else System.out.println(res + "\n");
    }

    public void lanzarMetodo10() {
        System.out.println("\n10) Listar todas las facturas de un cliente:");
        String NIF = pedirNifExistente();
        System.out.println(baseDeDatos.listarFacturasCliente(NIF));
    }

    public void lanzarMetodo11() {
        System.out.println("\n --> Programa cerrado. <-- ");
    }

    public String pedirNifExistente() {
        System.out.print("- Introduce el NIF del cliente: ");
        String NIF = sc.next();
        while(!baseDeDatos.existeCliente(NIF)) {
            System.out.print("Cliente no existente en la base de datos. Vuelve a introducir el NIF: ");
            NIF = sc.next();
        }
        return NIF;
    }

    public String pedirTelfExistente() {
        System.out.print("- Introduce el telefono del cliente: ");
        String telf = sc.next();
        while(!baseDeDatos.existeTelf(telf)) {
            System.out.print("Telefono del cliente no existente en la base de datos. Vuelve a introducirlo: ");
            telf = sc.next();
        }
        return telf;
    }

    public String pedirNifUnico() {
        System.out.print("- Introduce el NIF del cliente: ");
        String nif = sc.next();
        while (baseDeDatos.existeCliente(nif)) {
            System.out.print("Nif ya existente en la base de datos. Vuelve a introducir el NIF: ");
            nif = sc.next();
        }
        return nif;
    }

    public String pedirTelUnico() {
        System.out.print("- Introduce el telefono del cliente: ");
        String telf = sc.next();
        while (baseDeDatos.existeTelf(telf)) {
            System.out.print("Telefono ya existente en la base de datos. Vuelve a introducir el telefono: ");
            telf = sc.next();
        }
        return telf;
    }

    public void mensajeExito() {
        System.out.println("Operacion realizada con exito.\n");
    }
}
