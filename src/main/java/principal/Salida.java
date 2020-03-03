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
                    daAltaCliente();
                } catch (NifRepetidoException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
               borraCliente();
                break;
            case 3:
                cambiaTarifa();
                break;
            case 4:
                datosCliente();
                break;
            case 5:
                listadoClientes();
                break;
            case 6:
                clientesEntreFechas();
                break;
            case 7:
                try {
                    daAltaLlamada();
                } catch (DuracionNegativaException e) {
                    e.printStackTrace();
                }
                break;
            case 8:
                llamadasCliente();
                break;
            case 9:
                llamadasCliEntreFechas();
                break;
            case 10:
                emiteFactura();
                break;
            case 11:
               datosFactura();
            case 12:
                facturasCliente();
            case 13:
                facturasCliEntreFechas();
            case 14:
                salir();
                break;
        }
    }

    public void daAltaCliente() throws NifRepetidoException {
        System.out.println("\nDAR DE ALTA UN NUEVO CLIENTE");
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

    public void borraCliente() {
        System.out.println("\nBORRAR UN CLIENTE");
        String telf = pedirTelfExistente();
        baseDeDatos.borrarCliente(telf);
        System.out.println("\n\tCliente con numero " + telf + " borrado con exito.\n");
    }

    public void cambiaTarifa() {
        System.out.println("\nCAMBIAR LA TARIFA DE UN CLIENTE");
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

    public void datosCliente() {
        System.out.println("\nRECUPERAR LOS DATOS DE UN CLIENTE");
        String nif = pedirNifExistente();
        System.out.println(baseDeDatos.listarDatosCliente(nif) + "\n");
    }

    public void listadoClientes() {
        System.out.println("\nRECUPERAR EL LISTADO DE TODOS LOS CLIENTES");
        System.out.println(baseDeDatos.listarClientes());
    }

    public void clientesEntreFechas() {
        System.out.println("\nMOSTRAR LISTADO DE LOS CLIENTES DADOS DE ALTA ENTRE DOS FECHAS");
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
        System.out.println(baseDeDatos.listarClientesEntreFechas(fechaIni, fechaIni));
    }

    public void daAltaLlamada() throws DuracionNegativaException {
        System.out.println("\nDAR DE ALTA UNA LLAMADA");
        String telfOrigen = pedirTelfExistente(); //pedir telfOrigen
        System.out.print("- Introduce el telefono de destino: ");
        String telfDest = sc.next();
        System.out.print("- Introduce la duracion de la llamada (en segundos): ");
        int duracion = sc.nextInt();
        baseDeDatos.darDeAltaLlamada(telfOrigen, telfDest, duracion);
        System.out.println("\n\tLlamada de " + telfOrigen + " a " + telfDest + " realizada con exito.\n");
    }

    public void llamadasCliente() {
        System.out.println("\nLISTAR TODAS LAS LLAMADAS DE UN CLIENTE");
        String telf = pedirTelfExistente();
        System.out.println(baseDeDatos.listarLlamadasCliente(telf));
    }

    public void llamadasCliEntreFechas() {
        System.out.println("\nMOSTRAR LISTADO DE LAS LLAMADAS REALIZADAS ENTRE DOS FECHAS");
        String telf = pedirTelfExistente();
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
        System.out.println(baseDeDatos.listarLlamadasEntreFechas(telf, fechaIni, fechaIni));
    }

    public void emiteFactura() {
        System.out.println("\nEMITIR FACTURA PARA UN CLIENTE");
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

    public void datosFactura() {
        System.out.println("\nRECUPERAR DATOS DE UNA FACTURA");
        System.out.print("- Introduce su codigo: ");
        int cod = sc.nextInt();
        String res = baseDeDatos.listarDatosFactura(cod);
        if(res == null) System.out.println("* Codigo de factura no existente en la base de datos.\n");
        else System.out.println(res + "\n");
    }

    public void facturasCliente() {
        System.out.println("\nLISTAR LAS FACTURAS DE UN CLIENTE");
        String nif = pedirNifExistente();
        System.out.println(baseDeDatos.listarFacturasCliente(nif));
    }

    public void facturasCliEntreFechas() {
        System.out.println("\nMOSTRAR LISTADO DE LAS FACTURAS DADAS DE ALTA ENTRE DOS FECHAS");
        String nif = pedirNifExistente();
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
        System.out.println(baseDeDatos.listarFacturasEntreFechas(nif, fechaIni, fechaIni));
    }

    public void salir() {
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
