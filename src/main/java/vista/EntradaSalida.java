package vista;

import java.time.LocalDate;
import java.util.Scanner;

public class EntradaSalida implements EntradaSalidaInterfaz {
    private Scanner sc;

    public EntradaSalida() {
        super();
        sc = new Scanner(System.in);
    }

    @Override
    public String pedirTelf() {
        imprimirSinSalto("Introduce el telefono del cliente: ");
        return sc.next();
    }

    @Override
    public String pedirTelfDestino() {
        imprimirSinSalto("Introduce el telefono del destino: ");
        return sc.next();
    }

    @Override
    public String pedirNif() {
        imprimirSinSalto("Introduce el NIF: ");
        return sc.next();
    }

    @Override
    public LocalDate pedirFechaIni() {
        imprimirSinSalto("Introduce la fecha de inicio (formato aaaa-mm-dd): ");
        return LocalDate.parse(sc.next());
    }

    @Override
    public LocalDate pedirFechaFin() {
        imprimirSinSalto("Introduce la fecha de fin (formato aaaa-mm-dd): ");
        return LocalDate.parse(sc.next());
    }

    @Override
    public int pedirDuracion() {
        imprimirSinSalto("Introduce la duracion de la llamada (en segundos): ");
        return sc.nextInt();
    }

    @Override
    public int pedirCodFactura() {
        imprimirSinSalto("Introduce el codigo de la factura: ");
        return sc.nextInt();
    }

    @Override
    public Byte pedirOpcion() {
        imprimirSinSalto("Introduce una opcion: ");
        return sc.nextByte();
    }

    @Override
    public String pedirCP() {
        imprimirSinSalto("Introduce el codigo postal: ");
        return sc.next();
    }

    @Override
    public String pedirEmail() {
        imprimirSinSalto("Introduce el email: ");
        return sc.next();
    }

    @Override
    public String pedirProvincia() {
        imprimirSinSalto("Introduce la provincia: ");
        sc.nextLine();
        return sc.nextLine();
    }

    @Override
    public String pedirPoblacion() {
        imprimirSinSalto("Introduce la poblacion: ");
        return sc.nextLine();
    }

    @Override
    public String pedirNombre() {
        imprimirSinSalto("Introduce el nombre: ");
        return sc.next();
    }

    @Override
    public String pedirApellidos() {
        imprimirSinSalto("Introduce los apellidos: ");
        return sc.next();
    }

    @Override
    public void imprimirConSalto(String string) {
        System.out.println(string);
    }

    @Override
    public void imprimirSinSalto(String string) {
        System.out.print(string);
    }
}
