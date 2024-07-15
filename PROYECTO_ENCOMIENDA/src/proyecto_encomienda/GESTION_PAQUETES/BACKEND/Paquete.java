/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.GESTION_PAQUETES.BACKEND;

import java.util.ArrayList;

/**
 *
 * @author Issac
 */
public class Paquete {
    private EstadoDelPaquete estado;
    private Seguimiento seguimiento;
    private String codigoTracking;
    private double peso;
    private double ancho;
    private double largo;
    private String contenido;
    //private Perfil remitente;
    private String direccionDestino;

    public Paquete(String codigoTracking, double ancho, double largo, String contenido, String destino) {
        this.estado = new Pendiente(this);
        this.seguimiento = new Seguimiento(estado);
        this.codigoTracking = codigoTracking;
        this.ancho = ancho;
        this.largo = largo;
        this.contenido = contenido;
        this.direccionDestino = destino;
    }
    
    public void cambiarEstado(EstadoDelPaquete estado) {
        this.estado = estado;
        seguimiento.notificar(estado);
    }
    
    public ArrayList<String> obtenerHistorialEstados() {
        return seguimiento.obtenerEstadosAnteriores();
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
