package acciones;

import interfaces.Accion;
import principal.BaseDeDatos;
import principal.NifNoExistenteException;

public class ContratarTarifaEspecial implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nCONTRATAR UNA TARIFA ESPECIAL");
            System.out.print("- Introduce el NIF del cliente: ");
            String nif = sc.next();
            baseDeDatos.compruebaNifExistente(nif);
            System.out.println(" TARIFAS ESPECIALES:\n");
            System.out.print("\ta) Tarifa por dias: domingos gratis.\n");
            System.out.print("\tb) Tarifa por horas: tardes a 0.03 €/min.\n");
            System.out.print("\n\t- Introduce la tarifa a contratar: ");
            String opcion = sc.next();
            while (!opcion.equals("a") && !opcion.equals("b")) {
                System.out.print("* Parametro incorrecto. Vuelve a intentarlo: ");
                opcion = sc.next();
            }
            baseDeDatos.contratarTarifaEspecial(opcion, nif);
            System.out.println("\n\tTarifa especial contratada.\n");
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
