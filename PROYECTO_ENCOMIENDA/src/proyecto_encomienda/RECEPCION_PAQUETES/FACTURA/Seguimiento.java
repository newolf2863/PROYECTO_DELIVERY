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
public class Seguimiento {
    private EstadoDelPaquete estadoActual;
    private ArrayList<String> estadosAnteriores;

    public Seguimiento(EstadoDelPaquete estado) {
        this.estadoActual = estado;
        this.estadosAnteriores = new ArrayList<>();
    }

    public void notificar(EstadoDelPaquete estado) {
        estadosAnteriores.add(estadoActual.toString());
        this.estadoActual = estado;
    }
    
    public boolean verificarEntregaPendiente() {
        return estadoActual instanceof Pendiente;
    }
    
    public ArrayList<String> obtenerEstadosAnteriores() {
        return estadosAnteriores;
    } 
}
