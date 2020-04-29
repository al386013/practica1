package vista;

public interface InterrogaVista {
    PanelClientes getPanelClientes();

    PanelLlamadas getPanelLlamadas();

    PanelFacturas getPanelFacturas();

    void accionDenegada(String cadena); //este metodo preguntar

    void accionCorrecta(String cadena); //este metodo se debe ir fuera!!
}
