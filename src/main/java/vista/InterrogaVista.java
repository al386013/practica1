package vista;

public interface InterrogaVista {
    VistaClientes getVistaClientes();

    VistaLlamadas getVistaLlamadas();

    VistaFacturas getVistaFacturas();

    void importadoCorrectamente();

    void guardadoCorrectamente();
}
