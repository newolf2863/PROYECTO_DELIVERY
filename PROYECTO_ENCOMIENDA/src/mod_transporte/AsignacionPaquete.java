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
import mod_paquetes.EnCurso;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

public class AsignacionPaquete implements Serializable {
    private HashMap<Vehiculo, ArrayList<Paquete>> asignacionPaquetes;
    private FlotaVehiculo flotaVehiculo;
    
    public AsignacionPaquete() {
        this.asignacionPaquetes = new HashMap<Vehiculo, ArrayList<Paquete>>();
        this.flotaVehiculo = new FlotaVehiculo();
        cargarRelacionPaquetes();
    }
       
    public boolean asignarPaquetesAVehiculo(Vehiculo vehiculo, Provincia destino) {
        ArrayList<Paquete> paquetesPendientes = Inventario.obtenerInstancia().obtenerPaquetesPendientes();
        ArrayList<Paquete> paquetes;
        Vehiculo vehiculoAUsar = null;
        int conteoPaquetes = 0;
        for (Map.Entry<Vehiculo, ArrayList<Paquete>> entry : asignacionPaquetes.entrySet()) {
            if (entry.getKey().getNumeroPlaca().equals(vehiculo.getNumeroPlaca())) {
                vehiculoAUsar = entry.getKey();
                break;
            }
        }

        if (paquetesPendientes.isEmpty()) {
            return false;
        } else if (vehiculoAUsar == null) {
            paquetes = new ArrayList<>();
            asignacionPaquetes.put(vehiculo, paquetes);
        } else {
            paquetes = asignacionPaquetes.get(vehiculoAUsar);
            conteoPaquetes = paquetes.size();
        }
        double capacidad = vehiculo.getCapacidad();

        for (Paquete paquete : paquetesPendientes) {
            if (capacidad >= paquete.getVolumen()) {
                if (paquete.getProvinciaDestino() == destino) {
                    paquetes.add(paquete);
                    paquete.cambiarEstado(new EnCurso(paquete));
                    capacidad -= paquete.getVolumen();
                }
            } else {
                break;
            }
        }
        if (paquetes == null || paquetes.size() == conteoPaquetes) {
            return false;
        }

        vehiculo.setCapacidad(capacidad);
        if (vehiculoAUsar != null) {
            asignacionPaquetes.remove(vehiculoAUsar);
            asignacionPaquetes.put(vehiculo, paquetes);
        }
        flotaVehiculo.guardarVehiculo();
        guardarRelacionPaquetes();
        Inventario.obtenerInstancia().guardarInventario();
        return true;
    }
    
    public ArrayList<Paquete> obtenerPaquetesVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return null;
        }
        for (Map.Entry<Vehiculo, ArrayList<Paquete>> entry : asignacionPaquetes.entrySet()) {
            if (entry.getKey().getNumeroPlaca().equals(vehiculo.getNumeroPlaca())) {
                return entry.getValue();
            }
        }
        return null;
    }
    
    public void guardarRelacionPaquetes() {
        String filePath = "src\\archivos\\AsignacionPaquetes.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(asignacionPaquetes);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarRelacionPaquetes() {
        String filePath = "src\\archivos\\AsignacionPaquetes.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            asignacionPaquetes = (HashMap<Vehiculo, ArrayList<Paquete>>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
        }
    }
    
    public HashMap<Vehiculo, ArrayList<Paquete>> obtenerRelacionPaqueteVehiculo() {
        return asignacionPaquetes;
    }

    public Vehiculo obtenerVehiculo(String placa) {
        return flotaVehiculo.obtenerVehiculo(placa);
    }

    public ArrayList<Vehiculo> obtenerVehiculos() {
        return flotaVehiculo.obtenerVehiculos();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        flotaVehiculo.agregarVehiculo(vehiculo);
    }
}
