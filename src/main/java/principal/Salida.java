package principal;

import datos.clientes.Direccion;
import excepciones.DuracionNegativaException;
import excepciones.IntervaloFechasIncorrectoException;
import excepciones.NifRepetidoException;
import excepciones.TelfRepetidoException;
import menus.MenuClientes;
import menus.MenuFacturas;
import menus.MenuLlamadas;
import menus.MenuPrincipal;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Salida implements Serializable {
    private BaseDeDatos baseDeDatos;
    private Scanner sc = new Scanner(System.in);
    private MenuPrincipal opcionMenu = null;

    public Salida(BaseDeDatos baseDeDatos) {
        this.baseDeDatos =  baseDeDatos;
    }

    public void menuYopcion() {
        while (opcionMenu != MenuPrincipal.SALIR_GUARDAR) {
            System.out.println("\n* * * * * * * OPCIONES DISPONIBLES * * * * * * *\n");
            System.out.println(MenuPrincipal.getMenu());
            System.out.print("Introduce una opción: ");
            byte opcion = sc.nextByte();
            opcionMenu = MenuPrincipal.getOpcion(opcion);
            lanzarOpcionPrincipal(opcionMenu);
        }
    }

    private void lanzarOpcionPrincipal(MenuPrincipal opcionMenu) {
        switch (opcionMenu) {
            case CARGAR_DATOS:
                importarDatos();
                System.out.println("\n* * * * * DATOS IMPORTADOS CORRECTAMENTE * * * * *\n");
                break;
            case CLIENTES:
                System.out.println("\n* * * * * * * OPCIONES DE CLIENTES * * * * * * *\n");
                System.out.println(MenuClientes.getMenu());
                System.out.print("Introduce una opción: ");
                byte opcion = sc.nextByte();
                MenuClientes opcionClientes = MenuClientes.getOpcion(opcion);
                lanzarOpcionClientes(opcionClientes);
                break;
            case LLAMADAS:
                System.out.println("\n* * * * * * * OPCIONES DE LLAMADAS * * * * * * *\n");
                System.out.println(MenuLlamadas.getMenu());
                System.out.print("Introduce una opción: ");
                opcion = sc.nextByte();
                MenuLlamadas opcionLlamadas = MenuLlamadas.getOpcion(opcion);
                lanzarOpcionLlamadas(opcionLlamadas);
                break;
            case FACTURAS:
                System.out.println("\n* * * * * * * OPCIONES DE FACTURAS * * * * * * *\n");
                System.out.println(MenuFacturas.getMenu());
                System.out.print("Introduce una opción: ");
                opcion = sc.nextByte();
                MenuFacturas opcionFacturas = MenuFacturas.getOpcion(opcion);
                lanzarOpcionFacturas(opcionFacturas);
                break;
            case SALIR_GUARDAR:
                exportarDatosYsalir();
                break;
        }
    }

    private void lanzarOpcionClientes(MenuClientes opcionClientes) {
        switch (opcionClientes) {
            case DAR_ALTA_CLIENTE:
                daAltaCliente();
                break;
            case BORRAR_CLIENTE:
                borraCliente();
                break;
            case CAMBIAR_TARIFA:
                cambiaTarifa();
                break;
            case DATOS_CLIENTE:
                datosCliente();
                break;
            case LISTAR_CLIENTES:
                listadoClientes();
                break;
            case CLIENTES_ENTRE_FECHAS:
                clientesEntreFechas();
                break;
            case VOLVER_MENU_PRINCIPAL:
                menuYopcion();
                break;
            case SALIR_GUARDAR:
                exportarDatosYsalir();
                break;
        }
    }

    private void lanzarOpcionLlamadas(MenuLlamadas opcionLlamadas) {
        switch (opcionLlamadas) {
            case DAR_ALTA_LLAMADA:
                daAltaLlamada();
                break;
            case LLAMADAS_CLIENTE:
                llamadasCliente();
                break;
            case LLAMADAS_ENTRE_FECHAS:
                llamadasCliEntreFechas();
                break;
            case VOLVER_MENU_PRINCIPAL:
                menuYopcion();
                break;
            case SALIR_GUARDAR:
                exportarDatosYsalir();
                break;
        }
    }

    private void lanzarOpcionFacturas(MenuFacturas opcionFacturas) {
        switch (opcionFacturas) {
            case EMITIR_FACTURA:
                emiteFactura();
                break;
            case DATOS_FACTURA:
                datosFactura();
            case FACTURAS_CLIENTE:
                facturasCliente();
            case FACTURAS_ENTRE_FECHAS:
                facturasCliEntreFechas();
            case VOLVER_MENU_PRINCIPAL:
                menuYopcion();
                break;
            case SALIR_GUARDAR:
                exportarDatosYsalir();
                break;
        }
    }

    private void daAltaCliente() {
        try {
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
            System.out.print("- Introduce el telefono del cliente: ");
            String telf = sc.next();
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
        } catch (NifRepetidoException e) {
            e.printStackTrace();
        } catch (TelfRepetidoException e) {
            e.printStackTrace();
        }

    }

    private void borraCliente() {
        System.out.println("\nBORRAR UN CLIENTE");
        String telf = pedirTelfExistente();
        baseDeDatos.borrarCliente(telf);
        System.out.println("\n\tCliente con numero " + telf + " borrado con exito.\n");
    }

    private void cambiaTarifa() {
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

    private void datosCliente() {
        System.out.println("\nRECUPERAR LOS DATOS DE UN CLIENTE");
        String nif = pedirNifExistente();
        System.out.println(baseDeDatos.listarDatosCliente(nif) + "\n");
    }

    private void listadoClientes() {
        System.out.println("\nRECUPERAR EL LISTADO DE TODOS LOS CLIENTES");
        System.out.println(baseDeDatos.listarClientes());
    }

    private void clientesEntreFechas() {
        try {
            System.out.println("\nMOSTRAR LISTADO DE LOS CLIENTES DADOS DE ALTA ENTRE DOS FECHAS");
            System.out.print("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
            LocalDate fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
            LocalDate fechaFin = LocalDate.parse(sc.next());
            System.out.println(baseDeDatos.listarClientesEntreFechas(fechaIni, fechaFin));
        } catch (IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }

    private void daAltaLlamada() {
        try {
            System.out.println("\nDAR DE ALTA UNA LLAMADA");
            String telfOrigen = pedirTelfExistente(); //pedir telfOrigen
            System.out.print("- Introduce el telefono de destino: ");
            String telfDest = sc.next();
            System.out.print("- Introduce la duracion de la llamada (en segundos): ");
            int duracion = sc.nextInt();
            baseDeDatos.darDeAltaLlamada(telfOrigen, telfDest, duracion);
            System.out.println("\n\tLlamada de " + telfOrigen + " a " + telfDest + " realizada con exito.\n");
        } catch (DuracionNegativaException e) {
            e.printStackTrace();
        }
    }

    private void llamadasCliente() {
        System.out.println("\nLISTAR TODAS LAS LLAMADAS DE UN CLIENTE");
        String telf = pedirTelfExistente();
        System.out.println(baseDeDatos.listarLlamadasCliente(telf));
    }

    private void llamadasCliEntreFechas() {
        try {
            System.out.println("\nMOSTRAR LISTADO DE LAS LLAMADAS REALIZADAS ENTRE DOS FECHAS");
            String telf = pedirTelfExistente();
            System.out.print("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
            LocalDate fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
            LocalDate fechaFin = LocalDate.parse(sc.next());
            System.out.println(baseDeDatos.listarLlamadasEntreFechas(telf, fechaIni, fechaFin));
        } catch (IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }

    private void emiteFactura() {
        try {
            System.out.println("\nEMITIR FACTURA PARA UN CLIENTE");
            String nif = pedirNifExistente();
            System.out.print("- Introduce la fecha de inicio de la factura (formato aaaa-mm-dd): ");
            LocalDate fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Introduce la fecha de fin de la factura (formato aaaa-mm-dd): ");
            LocalDate fechaFin = LocalDate.parse(sc.next());
            //comprobar que la fecha de inicio de factura sea anterior a la fecha de fin
            baseDeDatos.emitirFactura(fechaIni, fechaFin, nif);
            System.out.println("\n\tFactura del cliente con NIF " + nif + " emitida con exito.\n");
        } catch (IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }

    private void datosFactura() {
        System.out.println("\nRECUPERAR DATOS DE UNA FACTURA");
        System.out.print("- Introduce su codigo: ");
        int cod = sc.nextInt();
        String res = baseDeDatos.listarDatosFactura(cod);
        if(res == null) System.out.println("* Codigo de factura no existente en la base de datos.\n");
        else System.out.println(res + "\n");
    }

    private void facturasCliente() {
        System.out.println("\nLISTAR LAS FACTURAS DE UN CLIENTE");
        String nif = pedirNifExistente();
        System.out.println(baseDeDatos.listarFacturasCliente(nif));
    }

    private void facturasCliEntreFechas() {
        try {
            System.out.println("\nMOSTRAR LISTADO DE LAS FACTURAS DADAS DE ALTA ENTRE DOS FECHAS");
            String nif = pedirNifExistente();
            System.out.print("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
            LocalDate fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
            LocalDate fechaFin = LocalDate.parse(sc.next());
            System.out.println(baseDeDatos.listarFacturasEntreFechas(nif, fechaIni, fechaFin));
        } catch (IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }

    private void salir() {
        opcionMenu = MenuPrincipal.SALIR_GUARDAR;
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

    //El metodo exportatDatos se encarga de guardar los datos en la base de datos previamente antes de finalizar el programa
    private void exportarDatosYsalir(){
        FileOutputStream fos = new FileOutputStream("agenda.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(agenda);
        oos.close();
    }

    //El metodo importar datos se encarga de cargar los datos que ya habiamos obtenido en nuestra base de datos
    private void importarDatos(){
        FileInputStream fis = new FileInputStream("agenda.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        agenda = (Agenda) ois.readObject();
        ois.close();
    }
}
