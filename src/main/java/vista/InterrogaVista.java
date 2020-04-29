package vista;

public interface InterrogaVista {
    VistaClientes getVistaClientes();

    VistaLlamadas getVistaLlamadas();

    VistaFacturas getVistaFacturas();

    void accionDenegada(String cadena); //este metodo preguntar

    void accionCorrecta(String cadena); //este metodo se debe ir fuera!!
}
