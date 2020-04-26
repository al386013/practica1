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

    void clienteAnadido(String nombre, String nif, String telf);

    void clienteBorrado(String telf);

    void tarifaContratada(String nif);

    void listadoClientes();
}
