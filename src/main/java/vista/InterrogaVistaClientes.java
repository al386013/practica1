package vista;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public interface InterrogaVistaClientes {
    String getTipoCliente();

    String getNifAnadir();

    String getNombre();

    String getApellido();

    String getTelfAnadir();

    String getEmail();

    String getProvincia();

    String getPoblacion();

    String getCP();

    String getTelfBorrar();

    String getNifTarifa();

    String getTipoTarifa();

    String getNifCli();

    LocalDate getFechaIni() throws DateTimeParseException;

    LocalDate getFechaFin() throws DateTimeParseException;


    void listadoClientesEntreFechas(LocalDate fechaIni, LocalDate fechaFin) throws DateTimeParseException;

    void datosCliente(String nif);
}
