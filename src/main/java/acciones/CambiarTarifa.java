package acciones;

import interfaces.Accion;
import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class CambiarTarifa implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nCAMBIAR LA TARIFA DE UN CLIENTE");
            System.out.print("- Introduce el NIF del cliente: ");
            String nif = sc.next();
            baseDeDatos.compruebaNifExistente(nif);
            System.out.print("- Introduce la tarifa deseada (en _,_ €/min): ");
            float tarifa = sc.nextFloat();
            while (tarifa < 0 || tarifa > 100) {
                System.out.print("* Tarifa no permitida, vuelve a introducir la tarifa deseada: ");
                tarifa = sc.nextFloat();
            }
            baseDeDatos.cambiarTarifa(tarifa, nif);
            System.out.println("\n\tTarifa del cliente con NIF " + nif + " cambiada a " + tarifa + " €/min.\n");
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
