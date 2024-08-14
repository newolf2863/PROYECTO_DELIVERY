/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_administracion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Haro
 */
public class FlotaConductores implements Serializable {

    private ArrayList<Conductor> conductores;
    
    public FlotaConductores(){
        conductores = new ArrayList<Conductor>();
        cargarConductores();
    }
    
    public void agregarConductor(Conductor usuario) {
        conductores.add(usuario);
        guardarConductores();
    }
    
    public void eliminarConductor(Conductor conductor) {
        conductores.remove(conductor);
        guardarConductores();
    }
    
    public void guardarConductores() {
        String filePath = "src\\archivos\\Conductores.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(conductores);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarConductores() {
        String filePath = "src\\archivos\\Conductores.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            conductores = (ArrayList<Conductor>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
        }
    }
    
    public ArrayList<Conductor> obtenerConductores() {
        return conductores;
    }
    
    public Conductor obtenerConductorPorCedula(String cedula) {
        for (Conductor conductor : conductores) {
            if (conductor.getCedula().equals(cedula)) {
                return conductor;
            }
        }
        return null;
    }
}

