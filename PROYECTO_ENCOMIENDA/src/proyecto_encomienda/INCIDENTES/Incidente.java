package proyecto_encomienda.INCIDENTES;

import java.time.LocalDateTime;

public abstract class Incidente {
    private String descripcion;
    private LocalDateTime fecha;
    private int idPaquete;
    private String estado;
    private int idIncidente;

    public Incidente(String descripcion, int idPaquete, int idIncidente, String estado) {
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
        this.idPaquete = idPaquete;
        this.idIncidente = idIncidente;
        this.estado = estado;
    }

    public abstract void actuar();
    public abstract void registrarIncidente();
    public abstract void actualizarIncidente(String tabla,
            String columnaId, String id, String[] columnas, Object[] valores);

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

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }

    public void notificarCliente() {
        // Lógica para notificar al cliente sobre el incidente
        System.out.println("Cliente notificado sobre el incidente del paquete: " + idPaquete);
    }
}


