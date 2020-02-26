package principal;

import datos.clientes.Direccion;

import java.time.LocalDate;
import java.time.LocalTime;
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
        System.out.print("- Introduce 'e' para empresa o 'p' para particular: ");
        String letra = sc.next();
        while(!letra.equals("e") && !letra.equals("p")) {
            System.out.print("Parámetro incorrecto. Vuelve a intentarlo: ");
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
        System.out.print("- Introduce telefono: ");
        String telf = sc.next();
        System.out.print("- Introduce el NIF del cliente: ");                  //excepción por si YA existe el NIF!!!
        String nif = sc.next();
        while(baseDeDatos.existeCliente(nif)) {
            System.out.println("El NIF del cliente ya existe en la base de datos. Prueba otro NIF: ");
            nif = sc.next();
        }
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
        if(letra.equals("p"))  //anadir particular
            baseDeDatos.anadirParticular(nombre, apellidos, telf, nif, direccion, email);
        else baseDeDatos.anadirEmpresa(nombre, telf, nif, direccion, email);
        mensajeExito();
    }

    public void lanzarMetodo2() {
        System.out.println("\n2) Borrar un cliente.");
        String telf = pedirTelf();
        baseDeDatos.borrarCliente(telf);
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
        String telfOrigen = pedirTelf(); //pedir telfOrigen
        System.out.print("- Introduce el telefono de destino: ");
        String telfDest = sc.next();
        System.out.print("- Introduce la fecha de la llamada (formato aaaa-mm-dd)"); //comprobar que está correcta
        String fechaCadena = sc.next();
        LocalDate fecha = LocalDate.parse(fechaCadena);
        System.out.print("- Introduce la hora de la llamada (formato hh:mm:ss)");
        String horaCadena = sc.next();
        LocalTime hora = LocalTime.parse(horaCadena);
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
        String telf = pedirTelf();
        baseDeDatos.listarLlamadasCliente(telf);
    }

    public void lanzarMetodo8() {
        System.out.println("\n8) Emitir factura para un cliente. ");
        String NIF = pedirNIF();
        System.out.print("- Introduce la fecha de inicio de la factura (formato aaaa-mm-dd): ");
        String fechaIniCadena = sc.next();
        LocalDate fechaIni = LocalDate.parse(fechaIniCadena);
        LocalDate fechaFin = LocalDate.now();
        //comprobar que la fecha de inicio de factura sea anterior a la fecha actual
        while(!fechaIni.isBefore(fechaFin)) {
            System.out.println("Fecha de inicio posterior a la fecha actual. Vuelve a introducirla (aaaa-mm-dd)");
            fechaIniCadena = sc.next();
            fechaIni = LocalDate.parse(fechaIniCadena);
        }
        baseDeDatos.emitirFactura(fechaIni, fechaFin, NIF);
        mensajeExito();
    }

    public void lanzarMetodo9() {
        System.out.println("\n9) Recuperar datos de una factura. ");
        System.out.print("- Introduce su codigo: \n");
        int cod = sc.nextInt();
        String res = baseDeDatos.listarDatosFactura(cod);
        if(res == null) System.out.println("Codigo de factura no existente en la base de datos.\n");
        else System.out.println(res);
    }

    public void lanzarMetodo10() {
        System.out.println("\n10) Listar todas las facturas de un cliente:\n");
        String NIF = pedirNIF();
        System.out.println(baseDeDatos.listarFacturasCliente(NIF));
    }

    public void lanzarMetodo11() {
        System.out.println("\n11) Programa cerrado.");
    }

    public String pedirNIF() {
        System.out.print("- Introduce el NIF del cliente: ");
        String NIF = sc.next();
        boolean existeCliente = baseDeDatos.existeCliente(NIF);
        while(!existeCliente) {
            System.out.print("Cliente no existente en la base de datos. Vuelve a introducir el NIF: ");
            NIF = sc.next();
        }
        return NIF;
    }

    public String pedirTelf() {
        System.out.print("- Introduce el telefono del cliente: ");
        String telf = sc.next();
        boolean existeTelf = baseDeDatos.existeTelf(telf);
        while(!existeTelf) {
            System.out.print("Telefono del cliente no existente en la base de datos. Vuelve a introducirlo: ");
            telf = sc.next();
        }
        return telf;
    }

    public void mensajeExito() {
        System.out.println("Operación realizada con éxito.\n");
    }
}
