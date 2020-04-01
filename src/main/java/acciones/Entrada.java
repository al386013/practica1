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
    public String pedirTelf(String string) {
        imprimir(string);
        return sc.next();
    }

    @Override
    public String pedirNif() {
        imprimir("Introduce el NIF del cliente: ");
        return sc.next();
    }

    @Override
    public LocalDate pedirFecha(String string) {
        imprimir(string);
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
        imprimir("Introduce una opcion: ");
        return sc.nextByte();
    }

    @Override
    public String pedirPoblacion() {
        imprimir("Introduce poblacion: ");
        return sc.next();
    }

    @Override
    public String pedirCP() {
        imprimir("Introduce codigo postal: ");
        return sc.next();
    }

    @Override
    public String pedirEmail() {
        imprimir("Introduce email: ");
        return sc.next();
    }

    @Override
    public String pedirProvincia() {
        imprimir("Introduce provincia: ");
        return sc.next();
    }

    @Override
    public String pedirNombre() {
        imprimir("Introduce nombre: ");
        return sc.next();
    }

    @Override
    public String pedirApellidos() {
        imprimir("Introduce apellidos: ");
        return sc.next();
    }

    @Override
    public void imprimir(String string) {
        System.out.println(string);
    }
}
