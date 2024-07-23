/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.INCIDENTES;

/**
 *
 * @author Issac
 */
public class DañoPaquete extends Incidente{
    @Override
    public void actuar() {
        // Lógica específica para Daño de Paquete
        System.out.println("Actuando sobre daño de paquete.");
    }

    @Override
    public void guardarEnArchivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void registrarIncidente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
