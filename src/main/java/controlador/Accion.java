package controlador;

import modelo.principal.*;
import vista.InterrogaVista;

public abstract class Accion {
    static BaseDeDatos baseDeDatos;
    static InterrogaVista vista;

    public Accion() { super(); }

    public abstract void ejecutaAccion() throws TelfRepetidoException, TelfNoExistenteException,
            NifNoExistenteException, NifRepetidoException, IntervaloFechasIncorrectoException;
}