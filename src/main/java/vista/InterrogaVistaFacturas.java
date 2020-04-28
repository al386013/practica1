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

    void listadoFacturasEntreFechas(String nif, LocalDate fechaIni, LocalDate fechaFin)
            throws DateTimeParseException;

}
