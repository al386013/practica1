package principal;

import datos.clientes.Direccion;
import excepciones.DuracionNegativaException;
import excepciones.NifRepetidoException;

import java.time.LocalDate;
import java.util.Scanner;

public class Salida {
    private BaseDeDatos baseDeDatos;
    private Scanner sc = new Scanner(System.in);

    public Salida() {
        this.baseDeDatos =  new BaseDeDatos();
    }

    public String mostrarMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n* * * * * ¿QUE OPCION DESEA REALIZAR? * * * * * \n\n");
        sb.append("----> CLIENTES \n");
        sb.append("\t1) Dar de alta un nuevo cliente \n");
        sb.append("\t2) Borrar un cliente \n");
        sb.append("\t3) Cambiar la tarifa de un cliente \n");
        sb.append("\t4) Recuperar los datos de un cliente a partir de su NIF \n");
        sb.append("\t5) Recuperar el listado de todos los clientes \n");
        sb.append("\t6) Mostrar listado de clientes dados de alta entre dos fechas \n\n");
        sb.append("----> LLAMADAS \n");
        sb.append("\t7) Dar de alta una llamada \n");
        sb.append("\t8) Listar todas las llamadas de un cliente \n");
        sb.append("\t9) Mostrar listado de llamadas de un cliente realizadas entre dos fechas \n\n");
        sb.append("----> FACTURAS \n");
        sb.append("\t10) Emitir una factura para un cliente \n");
        sb.append("\t11) Recuperar los datos de una factura a partir de su codigo \n");
        sb.append("\t12) Recuperar todas las facturas de un cliente \n");
        sb.append("\t13) Mostrar listado de facturas de un cliente emitidas entre dos fechas \n\n");
        sb.append("\t14) Salir \n");
        return sb.toString();
    }

    public int leerOpcion() {
        System.out.print("Introduce una opcion: ");
        int op = sc.nextInt();
        while(op < 1 || op > 11) {
            System.out.println("* Opcion incorrecta, vuelve a intentarlo.\n");
            System.out.print("Introduce otra opcion: ");
            op = sc.nextInt();
        }
        return op;
    }

    public void lanzarMetodo(int op) {
        switch (op) {
            case 1:
                try {
                    lanzarMetodo1();
                } catch (NifRepetidoException e) {
                    e.printStackTrace();
                }
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
                try {
                    lanzarMetodo7();
                } catch (DuracionNegativaException e) {
                    e.printStackTrace();
                }
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
            case 12:
                lanzarMetodo12();
            case 13:
                lanzarMetodo13();
            case 14:
                lanzarMetodo14();
                break;
        }
    }

    public void lanzarMetodo1() throws NifRepetidoException {
        System.out.println("\n1) DAR DE ALTA UN NUEVO CLIENTE");
        System.out.print("--> Introduce 'e' para empresa o 'p' para particular: ");
        String letra = sc.next();
        while(!letra.equals("e") && !letra.equals("p")) {
            System.out.print("* Parametro incorrecto. Vuelve a intentarlo: ");
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
        System.out.print("- Introduce NIF: ");
        String nif = sc.next();
        String telf = pedirTelfUnico();
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
        System.out.println("\n\tCreado cliente " + nombre + " con NIF " + nif + " y telefono " + telf + ".\n");
    }

    public void lanzarMetodo2() {
        System.out.println("\n2) BORRAR UN CLIENTE");
        String telf = pedirTelfExistente();
        baseDeDatos.borrarCliente(telf);
        System.out.println("\n\tCliente con numero " + telf + " borrado con exito.\n");
    }

    public void lanzarMetodo3() {
        System.out.println("\n3) CAMBIAR LA TARIFA DE UN CLIENTE");
        String nif = pedirNifExistente();
        System.out.print("- Introduce la tarifa deseada (en _,_ €/min): ");
        float tarifa = sc.nextFloat();
        while (tarifa < 0 || tarifa > 100) {
            System.out.print("* Tarifa no permitida, vuelve a introducir la tarifa deseada: ");
            tarifa = sc.nextFloat();
        }
        baseDeDatos.cambiarTarifa(tarifa, nif);
        System.out.println("\n\tTarifa del cliente con NIF " + nif + " cambiada a " + tarifa + " €/min.\n");
    }

    public void lanzarMetodo4() {
        System.out.println("\n4) RECUPERAR LOS DATOS DE UN CLIENTE");
        String nif = pedirNifExistente();
        System.out.println(baseDeDatos.listarDatosCliente(nif) + "\n");
    }

    public void lanzarMetodo5() {
        System.out.println("\n5) RECUPERAR EL LISTADO DE TODOS LOS CLIENTES");
        System.out.println(baseDeDatos.listarClientes());
    }

    public void lanzarMetodo6() {
        System.out.println("\n6) MOSTRAR LISTADO DE LOS CLIENTES DADOS DE ALTA ENTRE DOS FECHAS");
        System.out.print("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
        LocalDate fechaIni = LocalDate.parse(sc.next());
        System.out.print("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
        LocalDate fechaFin = LocalDate.parse(sc.next());
        //comprobar que la fecha de inicio de factura sea anterior a la fecha de fin
        while(!fechaIni.isBefore(fechaFin)) {
            System.out.println("* Fecha de inicio posterior a la fecha de fin. Vuelve a introducirlas (aaaa-mm-dd): ");
            System.out.print("- Fecha de inicio: ");
            fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Fecha de fin: ");
            fechaFin = LocalDate.parse(sc.next());
        }
    }

    public void lanzarMetodo7() throws DuracionNegativaException {
        System.out.println("\n7) DAR DE ALTA UNA LLAMADA");
        String telfOrigen = pedirTelfExistente(); //pedir telfOrigen
        System.out.print("- Introduce el telefono de destino: ");
        String telfDest = sc.next();
        System.out.print("- Introduce la duracion de la llamada (en segundos): ");
        int duracion = sc.nextInt();
        baseDeDatos.darDeAltaLlamada(telfOrigen, telfDest, duracion);
        System.out.println("\n\tLlamada de " + telfOrigen + " a " + telfDest + " realizada con exito.\n");
    }

    public void lanzarMetodo8() {
        System.out.println("\n8) LISTAR TODAS LAS LLAMADAS DE UN CLIENTE");
        String telf = pedirTelfExistente();
        System.out.println(baseDeDatos.listarLlamadasCliente(telf));
    }

    public void lanzarMetodo9() {
        System.out.println("\n9) MOSTRAR LISTADO DE LAS LLAMAS DADOS DE ALTA ENTRE DOS FECHAS");
        System.out.print("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
        LocalDate fechaIni = LocalDate.parse(sc.next());
        System.out.print("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
        LocalDate fechaFin = LocalDate.parse(sc.next());
        //comprobar que la fecha de inicio de factura sea anterior a la fecha de fin
        while(!fechaIni.isBefore(fechaFin)) {
            System.out.println("* Fecha de inicio posterior a la fecha de fin. Vuelve a introducirlas (aaaa-mm-dd): ");
            System.out.print("- Fecha de inicio: ");
            fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Fecha de fin: ");
            fechaFin = LocalDate.parse(sc.next());
        }
    }

    public void lanzarMetodo10() {
        System.out.println("\n10) EMITIR FACTURA PARA UN CLIENTE");
        String nif = pedirNifExistente();
        System.out.print("- Introduce la fecha de inicio de la factura (formato aaaa-mm-dd): ");
        LocalDate fechaIni = LocalDate.parse(sc.next());
        System.out.print("- Introduce la fecha de fin de la factura (formato aaaa-mm-dd): ");
        LocalDate fechaFin = LocalDate.parse(sc.next());
        //comprobar que la fecha de inicio de factura sea anterior a la fecha de fin
        while(!fechaIni.isBefore(fechaFin)) {
            System.out.println("* Fecha de inicio posterior a la fecha de fin. Vuelve a introducirlas (aaaa-mm-dd): ");
            System.out.print("- Fecha de inicio: ");
            fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Fecha de fin: ");
            fechaFin = LocalDate.parse(sc.next());
        }
        baseDeDatos.emitirFactura(fechaIni, fechaFin, nif);
        System.out.println("\n\tFactura del cliente con NIF " + nif + " emitida con exito.\n");
    }

    public void lanzarMetodo11() {
        System.out.println("\n11) RECUPERAR DATOS DE UNA FACTURA");
        System.out.print("- Introduce su codigo: ");
        int cod = sc.nextInt();
        String res = baseDeDatos.listarDatosFactura(cod);
        if(res == null) System.out.println("* Codigo de factura no existente en la base de datos.\n");
        else System.out.println(res + "\n");
    }

    public void lanzarMetodo12() {
        System.out.println("\n12) LISTAR LAS FACTURAS DE UN CLIENTE");
        String NIF = pedirNifExistente();
        System.out.println(baseDeDatos.listarFacturasCliente(NIF));
    }

    public void lanzarMetodo13() {
        System.out.println("\n13) MOSTRAR LISTADO DE LAS FACTURAS DADAS DE ALTA ENTRE DOS FECHAS");
        System.out.print("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
        LocalDate fechaIni = LocalDate.parse(sc.next());
        System.out.print("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
        LocalDate fechaFin = LocalDate.parse(sc.next());
        //comprobar que la fecha de inicio de factura sea anterior a la fecha de fin
        while(!fechaIni.isBefore(fechaFin)) {
            System.out.println("* Fecha de inicio posterior a la fecha de fin. Vuelve a introducirlas (aaaa-mm-dd): ");
            System.out.print("- Fecha de inicio: ");
            fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Fecha de fin: ");
            fechaFin = LocalDate.parse(sc.next());
        }
    }

    public void lanzarMetodo14() {
        System.out.println("\n -----> Programa cerrado <----- ");
    }

    private String pedirNifExistente() {
        System.out.print("- Introduce el NIF del cliente: ");
        String NIF = sc.next();
        while(!baseDeDatos.existeCliente(NIF)) {
            System.out.print("* Cliente no existente en la base de datos.\nVuelve a introducir el NIF: ");
            NIF = sc.next();
        }
        return NIF;
    }

    private String pedirTelfExistente() {
        System.out.print("- Introduce el telefono del cliente: ");
        String telf = sc.next();
        while(!baseDeDatos.existeTelf(telf)) {
            System.out.print("* Telefono del cliente no existente en la base de datos.\nVuelve a introducirlo: ");
            telf = sc.next();
        }
        return telf;
    }

    private String pedirTelfUnico() {
        System.out.print("- Introduce el telefono del cliente: ");
        String telf = sc.next();
        while (baseDeDatos.existeTelf(telf)) {
            System.out.print("* Telefono ya existente en la base de datos.\nVuelve a introducir el telefono: ");
            telf = sc.next();
        }
        return telf;
    }
}
