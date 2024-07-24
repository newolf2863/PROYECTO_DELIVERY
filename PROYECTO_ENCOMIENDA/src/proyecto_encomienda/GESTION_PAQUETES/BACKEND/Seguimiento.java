/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.GESTION_PAQUETES.BACKEND;

import java.util.ArrayList;

public class Seguimiento {
    private EstadoDelPaquete estadoActual;
    private ArrayList<String> estadosAnteriores;

    public Seguimiento(EstadoDelPaquete estado) {
        this.estadoActual = estado;
        this.estadosAnteriores = new ArrayList<>();
    }

    public void notificar(EstadoDelPaquete estado) {
        estadosAnteriores.add(estadoActual.toString()); // Agrega el estado actual anterior
        this.estadoActual = estado; // Actualiza al nuevo estado
    }
    
    public boolean verificarEntregaPendiente() {
        return estadoActual instanceof Pendiente; // Verifica si el estado actual es Pendiente
    }
    
    public ArrayList<String> obtenerEstadosAnteriores() {
        return estadosAnteriores; // Retorna la lista de estados anteriores
    } 
}
