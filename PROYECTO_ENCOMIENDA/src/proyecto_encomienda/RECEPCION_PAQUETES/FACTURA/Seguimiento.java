/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.RECEPCION_PAQUETES.FACTURA;

/**
 *
 * @author Rodrigo Haro
 */
public class Seguimiento {
    private EstadoDelPaquete estado;

    public Seguimiento(EstadoDelPaquete estado) {
        this.estado = estado;
    }

    public void notificar(EstadoDelPaquete estado) {
        this.estado = estado;
    }
    
    public boolean verificarEntregaPendiente() {
        return estado instanceof Pendiente;
    }
}
