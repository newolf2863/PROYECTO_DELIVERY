/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.RECEPCION_PAQUETES.FACTURA;

/**
 *
 * @author Rodrigo Haro
 */
public class Pendiente extends EstadoDelPaquete {

    public Pendiente(Paquete paquete) {
        super(paquete);
    }

    @Override
    public void iniciarEnvio() {
        paquete.cambiarEstado(new EnCurso(paquete));
        // TODO: Feedback
    }

    @Override
    public void completarEnvio() {
        // TODO: Error
    }
    
}
