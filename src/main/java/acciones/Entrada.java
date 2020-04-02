package acciones;

import java.time.LocalDate;
import java.util.Scanner;

public class Entrada implements EntradaInterfaz {
    private Scanner sc;

    public Entrada() {
        super();
        sc = new Scanner(System.in);
    }
    
}
