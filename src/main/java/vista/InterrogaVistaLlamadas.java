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

    void llamadaHecha(String telfOrigen, String telfDest);
}
