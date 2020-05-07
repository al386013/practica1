package vista;

import modelo.datos.clientes.Cliente;
import java.time.LocalDate;
import java.util.Collection;

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

    void listado(Collection<Cliente> clientes);

    void listadoClientes();

    void listadoClientesEntreFechas(LocalDate fechaIni, LocalDate fechaFin);

    void datosCliente(String nif);
}
