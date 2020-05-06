package modelo;

import modelo.principal.BaseDeDatos;
import vista.InformaVista;

public interface CambioModelo {
    void setBaseDeDatos(BaseDeDatos baseDeDatos);

    void setVista(InformaVista informaVista);

    BaseDeDatos getBaseDeDatos();
}
