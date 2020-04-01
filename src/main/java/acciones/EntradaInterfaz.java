package acciones;

import java.time.LocalDate;
import java.util.Enumeration;

public interface EntradaInterfaz {
    String pedirTelf(String string);
    String pedirNif();
    LocalDate pedirFecha(String string);
    int pedirDuracion();
    int pedirCodFactura();
    Byte pedirOpcion();
    void imprimir(String string);
    String pedirPoblacion();
    String pedirCP();
    String pedirEmail();
    String pedirProvincia();
    String pedirApellidos();
    String pedirNombre();
}
