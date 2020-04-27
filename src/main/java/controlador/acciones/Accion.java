package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.NifRepetidoException;
import modelo.principal.TelfRepetidoException;
import vista.InterrogaVista;

public interface Accion {
    void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista interrogaVista) throws NifRepetidoException, TelfRepetidoException;
}
