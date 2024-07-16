/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.GESTION_PAQUETES.BACKEND;

/**
 *
 * @author Rodrigo Haro y Amigos
 */
public class Entregado extends EstadoDelPaquete {

    public Entregado(Paquete paquete) {
        super(paquete);
    }

    @Override
    public void iniciarEnvio() {
        // TODO: Error
    }

    @Override
    public void completarEnvio() {
        // TODO: Error
    }
    
    @Override
    public String toString() {
        return "Entregado";
    }
}
