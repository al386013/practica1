package controlador.acciones;

import modelo.CambioModelo;
import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import static controlador.acciones.Accion.entradaSalida;

public class ImportarDatos {
    public void cargarDatos(CambioModelo modelo, InterrogaVista vista) {
        ObjectInputStream ois = null;
        try {
            try {
                FileInputStream fis = new FileInputStream("baseDeDatos.bin");
                ois = new ObjectInputStream(fis);
                modelo.setBaseDeDatos((BaseDeDatos) ois.readObject());
                entradaSalida.imprimirConSalto("\n-------> DATOS IMPORTADOS CORRECTAMENTE <-------");
                vista.importadoCorrectamente();
            } finally {
                if (ois != null) ois.close();
            }
        } catch (FileNotFoundException e) {
            entradaSalida.imprimirConSalto("\n-----> ERROR: NO SE HA PODIDO ENCONTRAR EL FICHERO <-----");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*public class ImportarDatos implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        ObjectInputStream ois = null;
        try {
            try {
                FileInputStream fis = new FileInputStream("baseDeDatos.bin");
                ois = new ObjectInputStream(fis);
                SeleccionaOpcionPrincipal.baseDeDatos = (BaseDeDatos) ois.readObject();
                entradaSalida.imprimirConSalto("\n-------> DATOS IMPORTADOS CORRECTAMENTE <-------");
            } finally {
                if (ois != null) ois.close();
            }
        } catch (FileNotFoundException e) {
            entradaSalida.imprimirConSalto("\n-----> ERROR: NO SE HA PODIDO ENCONTRAR EL FICHERO <-----");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
