package controlador.acciones;

import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;

public class DatosFactura implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            int cod = entradaSalida.pedirCodFactura();
            entradaSalida.imprimirConSalto(baseDeDatos.listarDatosFactura(cod) + "\n");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
