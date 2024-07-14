/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.ArrayList;

/**
 *
 * @author juand_jus2zd
 */
public class AsignacionConductorVehiculo {
    
    private ArrayList <Conductor> listaConductores;
    private ArrayList <Vehiculo> listaVehiculos;
    
    public String fechaAsignacion;
    
    
     public AsignacionConductorVehiculo() {
        this.listaConductores = new ArrayList<>();
        this.listaVehiculos = new ArrayList<>();
        this.fechaAsignacion = "";
    }
    
    
    public void asignarConductorPaquetes() {
        
    }

    public void generarRutaParaConductor() {
        
    }

    public void obtenerAsignacion() {
        
    } 
     
    // Getters y setters para los atributos
    public ArrayList<Conductor> getListaConductores() {
        return listaConductores;
    }

    public void setListaConductores(ArrayList<Conductor> listaConductores) {
        this.listaConductores = listaConductores;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}
