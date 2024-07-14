/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.RECEPCION_PAQUETES.FACTURA;

/**
 *
 * @author Issac
 */
public class Paquete {
    private EstadoDelPaquete estado;
    private Seguimiento seguimiento;
    private String codigoTracking;
    private double peso;
    private double dimension;
    private String contenido;
    //private Perfil remitente;
    private String direccionDestino;

    public Paquete() {
        this.estado = new Pendiente(this);
    }
    
    public void cambiarEstado(EstadoDelPaquete estado) {
        this.estado = estado;
        seguimiento.notificar(estado);
    }
    
    public EstadoDelPaquete obtenerEstado() {
        return estado;
    }
    
    public String obtenerCodigo() {
        return codigoTracking;
    }
    
    public void iniciarEnvio() {
        estado.iniciarEnvio();
    }
    
    public void completarEnvio() {
        estado.completarEnvio();
    }
}
