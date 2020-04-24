package modelo;

import modelo.principal.BaseDeDatos;

public interface CambioModelo {
    void setBaseDeDatos(BaseDeDatos baseDeDatos);
    BaseDeDatos getBaseDeDatos();
}
