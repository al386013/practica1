package vista;

public interface InterrogaVista {
    VistaClientes getVistaClientes();

    VistaLlamadas getVistaLlamadas();

    VistaFacturas getVistaFacturas();

    void accionCorrecta(String cadena);

    void accionDenegada(String cadena);
}
