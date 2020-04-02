package acciones;

import principal.BaseDeDatos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ImportarDatos implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        ObjectInputStream ois = null;
        try {
            try {
                FileInputStream fis = new FileInputStream("baseDeDatos.bin");
                ois = new ObjectInputStream(fis);
                SeleccionaOpcionPrincipal.baseDeDatos = (BaseDeDatos) ois.readObject();
                entrada.imprimir("\n-------> DATOS IMPORTADOS CORRECTAMENTE <-------\n");
            } finally {
                if (ois != null) ois.close();
            }
        } catch (FileNotFoundException e) {
            entrada.imprimir("\n-----> ERROR: NO SE HA PODIDO ENCONTRAR EL FICHERO <-----\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
