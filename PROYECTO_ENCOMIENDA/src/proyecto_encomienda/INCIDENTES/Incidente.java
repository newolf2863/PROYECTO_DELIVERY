/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.INCIDENTES;

/**
 *
 * @author Issac
 */
abstract class Incidente {
    public abstract void actuar();
    
    public void guardarPaquete() {
        // Lógica para guardar el paquete
        System.out.println("Estado de paquete guardado.");
    }
}
