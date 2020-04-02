package acciones;

import java.time.LocalDate;
import java.util.Scanner;

public class Entrada implements EntradaInterfaz {
    private Scanner sc;

    public Entrada() {
        super();
        sc = new Scanner(System.in);
    }

    @Override
    public String pedirTelf() {
        imprimir("Introduce el telefono del cliente: ");
        return sc.next();
    }

    @Override
    public String pedirTelfDestino() {
        imprimir("Introduce el telefono del destino: ");
        return sc.next();
    }

    @Override
    public String pedirNif() {
        imprimir("Introduce el NIF: ");
        return sc.next();
    }

    @Override
    public LocalDate pedirFechaIni() {
        imprimir("Introduce la fecha de inicio (formato aaaa-mm-dd): ");
        return LocalDate.parse(sc.next());
    }

    @Override
    public LocalDate pedirFechaFin() {
        imprimir("Introduce la fecha de fin (formato aaaa-mm-dd): ");
        return LocalDate.parse(sc.next());
    }

    @Override
    public int pedirDuracion() {
        imprimir("Introduce la duracion de la llamada (en segundos): ");
        return sc.nextInt();
    }

    @Override
    public int pedirCodFactura() {
        imprimir("Introduce el codigo de la factura: ");
        return sc.nextInt();
    }

    @Override
    public Byte pedirOpcion() {
        imprimir("\nIntroduce una opcion: ");
        return sc.nextByte();
    }

    @Override
    public String pedirPoblacion() {
        imprimir("Introduce la poblacion: ");
        return sc.nextLine();
    }

    @Override
    public String pedirCP() {
        imprimir("Introduce el codigo postal: ");
        return sc.next();
    }

    @Override
    public String pedirEmail() {
        imprimir("Introduce el email: ");
        return sc.next();
    }

    @Override
    public String pedirProvincia() {
        imprimir("Introduce la provincia: ");
        return sc.nextLine();
    }

    @Override
    public String pedirNombre() {
        imprimir("Introduce el nombre: ");
        return sc.next();
    }

    @Override
    public String pedirApellidos() {
        imprimir("Introduce los apellidos: ");
        return sc.nextLine();
    }

    @Override
    public void imprimir(String string) {
        System.out.print(string);
    }
}
