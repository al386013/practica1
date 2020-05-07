package vista;

import modelo.datos.contrato.Factura;
import java.time.LocalDate;
import java.util.Collection;

public interface InterrogaVistaFacturas {
    String getNifFac();

    LocalDate getFechaIniFac();

    LocalDate getFechaFinFac();

    int getCodFac();

    String getNifFacCli();

    String getNifFechas();

    LocalDate getFechaIniFechas();

    LocalDate getFechasFinFechas();

    void listado(Collection<Factura> facturas);

    void listadoFacturas(String nif);

    void listadoFacturasEntreFechas(String nif, LocalDate fechaIni, LocalDate fechaFin);

    void datosFactura(int cod);
}
