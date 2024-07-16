/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.GESTION_PAQUETES.BACKEND;

/**
 *
 * @author Rodrigo Haro y Amigos
 */
public class EnCurso extends EstadoDelPaquete {

    public EnCurso(Paquete paquete) {
        super(paquete);
    }

    @Override
    public void iniciarEnvio() {
        // TODO: Error
    }

    @Override
    public void completarEnvio() {
        paquete.cambiarEstado(new Entregado(paquete));
        // TODO: Feedback
    }
    
    @Override
    public String toString() {
        return "En curso";
    }
}
