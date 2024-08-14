/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_transporte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mod_administracion.Conductor;
import mod_administracion.FlotaConductores;

/**
 *
 * @author Rodrigo Haro
 */
public class AsignacionConductor implements Serializable {
    
    private HashMap<Conductor, Vehiculo> asignacionConductores;
    private final FlotaConductores flotaConductores;
    
    public AsignacionConductor(){
        asignacionConductores = new HashMap<Conductor, Vehiculo>();
        flotaConductores = new FlotaConductores();
        cargarRelacionConductores();
      
    }
    
    
    public void borrarRelacionConductorVehiculo(Conductor conductor) {
        for (Map.Entry<Conductor, Vehiculo> entry : asignacionConductores.entrySet()) {
            if (entry.getKey().getCedula().equals(conductor.getCedula())) {
                asignacionConductores.remove(conductor);
                break;
            }
        }
        guardarRelacionConductores();
    }
    
    public void asignarConductorAVehiculo(Conductor conductor, Vehiculo vehiculo) {
        if (asignacionConductores.containsKey(conductor)) {
            return;
        }
        if (asignacionConductores.containsValue(vehiculo)) {
            return;
        }
        asignacionConductores.put(conductor, vehiculo);
        guardarRelacionConductores();
    }
    
    public Conductor obtenerConductorDeVehiculo(Vehiculo vehiculo) {
        for (Map.Entry<Conductor, Vehiculo> entry : asignacionConductores.entrySet()) {
            if (entry.getValue().getNumeroPlaca().equals(vehiculo.getNumeroPlaca())) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    public void guardarRelacionConductores() {
        String filePath = "src\\archivos\\AsignacionConductores.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(asignacionConductores);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarRelacionConductores() {
        String filePath = "src\\archivos\\AsignacionConductores.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            asignacionConductores = (HashMap<Conductor, Vehiculo>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
        }
    }
    
    public Vehiculo obtenerVehiculoDeConductor(Conductor conductor){
        Vehiculo vehiculo = null;
        for (Map.Entry<Conductor, Vehiculo> entry : asignacionConductores.entrySet()) {
            if (entry.getKey().getCedula().equals(conductor.getCedula())) {
                return entry.getValue();
            }
        }
        return vehiculo;
    }

    public Conductor obtenerConductorPorCedula(String cedula) {
        return flotaConductores.obtenerConductorPorCedula(cedula);
    }

    public void agregarConductor(Conductor conductor) {
        flotaConductores.agregarConductor(conductor);
    }

    public void eliminarConductor(Conductor conductor) {
        flotaConductores.eliminarConductor(conductor);
    }

    public ArrayList<Conductor> obtenerConductores() {
        return flotaConductores.obtenerConductores();
    }
}
