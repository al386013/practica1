package vista;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public interface InterrogaVistaLlamadas {
    String getTelfOrigen();

    String getTelfDestino();

    int getDuracion();

    String getTelfListado();

    String getTelfListadoFechas()throws DateTimeParseException;

    LocalDate getFechaIniListado();

    LocalDate getFechaFinListado();

    void datosLlamada(String telfOrigen, String telfDest, LocalDate fecha, String hora, int duracion);

    void listadoLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin)
            throws DateTimeParseException;

}
