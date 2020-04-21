package controlador.acciones;

import modelo.principal.BaseDeDatos;

public class DatosFactura implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entradaSalida.imprimirConSalto("\nRECUPERAR DATOS DE UNA FACTURA");
            int cod = entradaSalida.pedirCodFactura();
            entradaSalida.imprimirConSalto(baseDeDatos.listarDatosFactura(cod) + "\n");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
