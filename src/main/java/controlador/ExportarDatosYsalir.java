package controlador;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ExportarDatosYsalir extends Accion {
    public void ejecutaAccion() {
        ObjectOutputStream oos = null;
        try {
            try {
                FileOutputStream fos = new FileOutputStream("baseDeDatos.bin");
                oos = new ObjectOutputStream(fos);
                oos.writeObject(baseDeDatos);
                vista.accionCorrecta("Datos guardados correctamente");
            } finally {
                oos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
