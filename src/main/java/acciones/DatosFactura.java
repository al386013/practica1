package acciones;

import principal.BaseDeDatos;

public class DatosFactura implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimir("\nRECUPERAR DATOS DE UNA FACTURA");
            int cod = entrada.pedirCodFactura();
            entrada.imprimir(baseDeDatos.listarDatosFactura(cod) + "\n");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
