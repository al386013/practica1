package vista;

import modelo.datos.llamadas.Llamada;
import java.time.LocalDate;
import java.util.Collection;

public interface InterrogaVistaLlamadas {
    String getTelfOrigen();

    String getTelfDestino();

    int getDuracion();

    String getTelfListado();

    String getTelfListadoFechas();

    LocalDate getFechaIniListado();

    LocalDate getFechaFinListado();

    void listado(Collection<Llamada> llamadas);

    void listadoLlamadas(String telf);

    void listadoLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin);

    void datosLlamada(String telfOrigen, String telfDest, LocalDate fecha, String hora, int duracion);
}
