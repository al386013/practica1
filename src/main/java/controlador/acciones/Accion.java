package controlador.acciones;

import modelo.principal.*;
import vista.InterrogaVista;

import java.time.format.DateTimeParseException;

public interface Accion {
    void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws TelfRepetidoException, TelfNoExistenteException,
            NifNoExistenteException, NifRepetidoException, IntervaloFechasIncorrectoException, IllegalArgumentException,
            DateTimeParseException;
}
