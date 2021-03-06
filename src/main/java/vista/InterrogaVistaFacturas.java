package vista;

import java.time.LocalDate;

public interface InterrogaVistaFacturas {
    String getNifFac();

    LocalDate getFechaIniFac();

    LocalDate getFechaFinFac();

    int getCodFac();

    String getNifFacCli();

    String getNifFechas();

    LocalDate getFechaIniFechas();

    LocalDate getFechasFinFechas();

    void listadoFacturas(String nif);

    void listadoFacturasEntreFechas(String nif, LocalDate fechaIni, LocalDate fechaFin);

    void datosFactura(int cod);
}
