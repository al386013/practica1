package controlador.acciones;

import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ExportarDatosYsalir implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
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
