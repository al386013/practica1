package controlador.acciones;

import modelo.principal.*;
import vista.InterrogaVista;

public interface Accion {
    void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws TelfRepetidoException, TelfNoExistenteException,
            NifNoExistenteException, NifRepetidoException, IntervaloFechasIncorrectoException;
}
