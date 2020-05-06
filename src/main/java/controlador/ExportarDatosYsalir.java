package controlador;

import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class ExportarDatosYsalir {
    public void guardarDatos(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        ObjectOutputStream oos = null;
        try {
            try {
                FileOutputStream fos = new FileOutputStream("baseDeDatos.bin");
                oos = new ObjectOutputStream(fos);
                oos.writeObject(baseDeDatos);
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
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
