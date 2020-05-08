package vista;

import java.time.LocalDate;

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

    LocalDate getFechaIni();

    LocalDate getFechaFin();

    void listadoClientes();

    void listadoClientesEntreFechas(LocalDate fechaIni, LocalDate fechaFin);

    void datosCliente(String nif);
}
