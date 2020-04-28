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

<<<<<<< HEAD
    void listadoLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin)
            throws DateTimeParseException;

=======
    void listadoLlamadas(String telf);

    void listadoLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin);
>>>>>>> 219729386696027208545c6e03775cc956955ff3
}
