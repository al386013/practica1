package controlador.acciones;

import modelo.CambioModelo;
import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ImportarDatos {
    public BaseDeDatos cargarDatos(9InterrogaVista vista) {
        ObjectInputStream ois = null;
        try {
            try {
                FileInputStream fis = new FileInputStream("baseDeDatos.bin");
                ois = new ObjectInputStream(fis);
                return (BaseDeDatos) ois.readObject();
            } finally {
                if (ois != null) ois.close();
            }
        } catch (FileNotFoundException e) {
            vista.accionDenegada("No se ha encontrado el fichero");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
