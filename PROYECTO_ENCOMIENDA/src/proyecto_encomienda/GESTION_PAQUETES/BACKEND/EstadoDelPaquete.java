/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.GESTION_PAQUETES.BACKEND;

/**
 *
 * @author Rodrigo Haro
 */
public abstract class EstadoDelPaquete {
    protected Paquete paquete;
    
    public EstadoDelPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
    
    public abstract void iniciarEnvio();
    public abstract void completarEnvio();
}
