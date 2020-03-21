package acciones;

import interfaces.Accion;
import principal.BaseDeDatos;

public class DatosFactura implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nRECUPERAR DATOS DE UNA FACTURA");
            System.out.print("- Introduce su codigo (numero entero): ");
            int cod = sc.nextInt();
            String res = baseDeDatos.listarDatosFactura(cod);
            System.out.println(res + "\n");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
