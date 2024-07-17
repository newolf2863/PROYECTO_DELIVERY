/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * @author ediso
 */
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.EstadoDelPaquete;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;
import proyecto_encomienda.GESTOR_PERFILES.Conductor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Asignacion {
    private List<Conductor> listaAsignacionesConductor;
    private List<Vehiculo> listaAsignacionesVehiculo;
    private Map<Conductor, Vehiculo> asignaciones; // Mapa para almacenar asignaciones entre conductores y vehículos
    private Map<Conductor, Date> fechasAsignaciones; // Mapa para almacenar fechas de asignaciones
    private Inventario inventario;
    private Map<Conductor, List<Paquete>> paquetesAsignados; // Paquetes asignados a conductores

    // Constructor
    public Asignacion() {
        this.listaAsignacionesConductor = new ArrayList<>();
        this.listaAsignacionesVehiculo = new ArrayList<>();
        this.asignaciones = new HashMap<>();
        this.fechasAsignaciones = new HashMap<>();
        this.inventario = new Inventario();
        this.paquetesAsignados = new HashMap<>();
    }

    // Método para agregar un conductor a la lista
    public void agregarConductor(Conductor conductor) {
        listaAsignacionesConductor.add(conductor);
    }

    // Método para agregar un vehículo a la lista
    public void agregarVehiculo(Vehiculo vehiculo) {
        listaAsignacionesVehiculo.add(vehiculo);
    }

    // Método para agregar un paquete al inventario
    public void agregarPaqueteAlInventario(Paquete paquete) {
        inventario.agregarPaquete(paquete);
    }

    // Método para verificar el estado de un paquete
    public EstadoDelPaquete verificarEstadoPaquete(String codigoTracking) {
        if (codigoTracking == null) {
            return null;
        }
        for (Paquete paquete : paquetesAsignados.values().stream().flatMap(List::stream).toList()) {
            String codigo = paquete.obtenerCodigo();
            if (codigo != null && codigo.equals(codigoTracking)) {
                return paquete.obtenerEstado();
            }
        }
        return null;
    }

    // Método para obtener la lista de conductores
    public List<Conductor> getListaAsignacionesConductor() {
        return listaAsignacionesConductor;
    }

    // Método para obtener la lista de vehículos
    public List<Vehiculo> getListaAsignacionesVehiculo() {
        return listaAsignacionesVehiculo;
    }

    // Método para asignar vehículos y paquetes a conductores de manera automática
    public void asignarVehiculosYPaquetesAutomatica(List<Paquete> paquetes) {
        int paqueteIndex = 0;
        for (Conductor conductor : listaAsignacionesConductor) {
            for (Vehiculo vehiculo : listaAsignacionesVehiculo) {
                if (!asignaciones.containsKey(conductor) && !asignaciones.containsValue(vehiculo)) {
                    // Realizar la asignación de vehículo
                    asignaciones.put(conductor, vehiculo);
                    fechasAsignaciones.put(conductor, new Date());

                    // Asignar paquetes al conductor
                    List<Paquete> paquetesAsignar = new ArrayList<>();
                    while (paqueteIndex < paquetes.size() && paquetesAsignar.size() < vehiculo.getCapacidad()) {
                        Paquete paquete = paquetes.get(paqueteIndex);
                        paquetesAsignar.add(paquete);
                        inventario.agregarPaquete(paquete);
                        paqueteIndex++;
                    }
                    paquetesAsignados.put(conductor, paquetesAsignar);
                    break; // Salir del bucle interno para asignar el siguiente conductor
                }
            }
        }
    }

    // Método para obtener la fecha de asignación de un conductor
    public Date getFechaAsignacion(Conductor conductor) {
        return fechasAsignaciones.get(conductor);
    }

    // Método para obtener los paquetes asignados a un conductor
    public List<Paquete> getPaquetesAsignados(Conductor conductor) {
        return paquetesAsignados.get(conductor);
    }

    // Método para imprimir las asignaciones actuales
    public void imprimirAsignaciones() {
        for (Map.Entry<Conductor, Vehiculo> entry : asignaciones.entrySet()) {
            Conductor conductor = entry.getKey();
            Vehiculo vehiculo = entry.getValue();
            Date fechaAsignacion = fechasAsignaciones.get(conductor);
            List<Paquete> paquetes = paquetesAsignados.get(conductor);

            System.out.println("Conductor: " + conductor.getNombre() + " - Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getPlaca() + " - Fecha: " + fechaAsignacion);
            if (paquetes != null && !paquetes.isEmpty()) {
                System.out.println("  Paquetes asignados:");
                for (Paquete paquete : paquetes) {
                    System.out.println("    Número de Tracking: " + paquete.obtenerCodigo());
                }
            } else {
                System.out.println("  No hay paquetes asignados a este conductor.");
            }
        }
    }

    // Método para obtener el inventario
    public Inventario getInventario() {
        return inventario;
    }

    // Método para obtener la asignación de un conductor
    public Vehiculo getVehiculoAsignado(Conductor conductor) {
        return asignaciones.get(conductor);
    }
}
