package vista;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public interface InterrogaVistaFacturas {
    String getNifFac();

    LocalDate getFechaIniFac()throws DateTimeParseException;

    LocalDate getFechaFinFac() throws DateTimeParseException;

    int getCodFac();

    String getNifFacCli();

    String getNifFechas();

    LocalDate getFechaIniFechas() throws DateTimeParseException;

    LocalDate getFechasFinFechas() throws DateTimeParseException;

    void datosFactura(int cod);

<<<<<<< HEAD
    void listadoFacturasEntreFechas(String nif, LocalDate fechaIni, LocalDate fechaFin)
            throws DateTimeParseException;


=======
    void listadoFacturas(String nif);

    void listadoFacturasEntreFechas(String nif, LocalDate fechaIni, LocalDate fechaFin);
>>>>>>> 219729386696027208545c6e03775cc956955ff3
}
