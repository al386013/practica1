package acciones;

import java.time.LocalDate;

public interface EntradaInterfaz {
    String pedirTelf();

    String pedirTelfDestino();

    String pedirNif();

    LocalDate pedirFechaIni();

    LocalDate pedirFechaFin();

    int pedirDuracion();

    int pedirCodFactura();

    Byte pedirOpcion();

    String pedirPoblacion();

    String pedirCP();

    String pedirEmail();

    String pedirProvincia();

    String pedirApellidos();

    String pedirNombre();

    void imprimirConSalto(String string);

    void imprimirSinSalto(String string);
}
