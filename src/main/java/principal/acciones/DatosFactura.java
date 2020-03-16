package principal.acciones;

import interfaces.Accion;

public class DatosFactura implements Accion {
    @Override
    public void ejecutaAccion() {
        System.out.println("\nRECUPERAR DATOS DE UNA FACTURA");
        System.out.print("- Introduce su codigo: ");
        int cod = sc.nextInt();
        String res = baseDeDatos.listarDatosFactura(cod);
        if (res == null) System.out.println("* Codigo de factura no existente en la base de datos.\n");
        else System.out.println(res + "\n");
    }
}
