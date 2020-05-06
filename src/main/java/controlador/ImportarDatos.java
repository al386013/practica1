package controlador;

import modelo.CambioModelo;
import modelo.principal.BaseDeDatos;
import vista.ImplementacionVista;
import vista.InterrogaVista;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

class ImportarDatos {
    public void cargarDatos(InterrogaVista vista, CambioModelo modelo) {
        ObjectInputStream ois = null;
        try {
            try {
                FileInputStream fis = new FileInputStream("baseDeDatos.bin");
                ois = new ObjectInputStream(fis);
                BaseDeDatos nueva = (BaseDeDatos) ois.readObject();
                modelo.setBaseDeDatos(nueva);
                nueva.setVista( new ImplementacionVista());
                Accion.baseDeDatos = nueva;
                JOptionPane.showMessageDialog(null, "Datos importados correctamente");
            } finally {
                if (ois != null) ois.close();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el fichero",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
