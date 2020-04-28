package vista;

import java.time.LocalDate;

public interface InterrogaVistaLlamadas {
    String getTelfOrigen();

    String getTelfDestino();

    int getDuracion();

    String getTelfListado();

    String getTelfListadoFechas();

    LocalDate getFechaIniListado();

    LocalDate getFechaFinListado();

    void listadoLlamadas(String telf);

    void listadoLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin);
}
