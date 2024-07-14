/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.RECEPCION_PAQUETES.FACTURA;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo Haro
 */
public class Inventario {
    private ArrayList<Paquete> paquetes;

    public Inventario() {
        paquetes = new ArrayList<>();
    }
    
    public void agregarPaquete(Paquete paquete) {
        paquetes.add(paquete);
    }
    
    public Paquete obtenerPaquete(String codigoTracking) {
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerCodigo().equals(codigoTracking)) {
                return paquete;
            }
        }
        return null;
    }
    
    public EstadoDelPaquete verificarEstadoPaquete(String codigoTracking) {
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerCodigo().equals(codigoTracking)) {
                return paquete.obtenerEstado();
            }
        }
        return null;
    }
}
