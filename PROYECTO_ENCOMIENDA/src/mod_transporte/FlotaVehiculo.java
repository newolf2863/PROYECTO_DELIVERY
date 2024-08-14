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

public class FlotaVehiculo implements Serializable {
    private ArrayList<Vehiculo> vehiculos;
    
    public FlotaVehiculo() {
        this.vehiculos = new ArrayList<Vehiculo>();
        cargarVehiculos();
    }
    

    
    public ArrayList<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }
    
    public Vehiculo obtenerVehiculo(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getNumeroPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }
    
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        guardarVehiculo();
    }
    
    public void guardarVehiculo() {
        String filePath = "src\\archivos\\FlotaVehiculos.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(vehiculos);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void cargarVehiculos() {
        String filePath = "src\\archivos\\FlotaVehiculos.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            vehiculos = (ArrayList<Vehiculo>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}
