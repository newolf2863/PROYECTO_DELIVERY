/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.INCIDENTES;

import java.time.LocalDateTime;

abstract class Incidente {
    private String descripcion;
    private LocalDateTime fecha;
    private String idPaquete;
    private String estado;

    public abstract void actuar();
    public abstract void guardarEnArchivo();
    public abstract void registrarIncidente();

    public void guardarPaquete() {
        // Lógica para guardar el paquete
        System.out.println("Estado de paquete guardado.");
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void notificarCliente() {
        // Lógica para notificar al cliente sobre el incidente
        System.out.println("Cliente notificado sobre el incidente del paquete: " + idPaquete);
    }
}


