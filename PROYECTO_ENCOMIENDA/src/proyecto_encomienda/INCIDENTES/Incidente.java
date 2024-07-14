/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.INCIDENTES;

import java.time.LocalDateTime;

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
    private String descripcion;
    private LocalDateTime fecha;
    private String idPaquete;

// Getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(String idPaquete) {
        this.idPaquete = idPaquete;
    }

    public void registrarIncidente() {
        // Lógica para registrar el incidente en la base de datos o sistema de seguimiento
        System.out.println("Incidente registrado: " + descripcion);
    }

    public void notificarCliente() {
        // Lógica para notificar al cliente sobre el incidente
        System.out.println("Cliente notificado sobre el incidente del paquete: " + idPaquete);
    }

}
