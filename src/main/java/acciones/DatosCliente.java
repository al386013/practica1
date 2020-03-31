package acciones;

import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class DatosCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nRECUPERAR LOS DATOS DE UN CLIENTE");
            System.out.print("- Introduce el NIF del cliente: ");
            String nif = sc.next();
            baseDeDatos.compruebaNifExistente(nif);
            System.out.println(baseDeDatos.listarDatosCliente(nif) + "\n");
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
