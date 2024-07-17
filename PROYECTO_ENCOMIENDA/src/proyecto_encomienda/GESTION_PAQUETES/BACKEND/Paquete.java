package proyecto_encomienda.GESTION_PAQUETES.BACKEND;

import java.util.ArrayList;

public class Paquete {
    private EstadoDelPaquete estado;
    private Seguimiento seguimiento;
    private String codigoTracking;
    private double peso;
    private double ancho;
    private double largo;
    private String contenido;
    private String direccionDestino;
    
    public Paquete(String codigoTracking, double ancho, double largo, String contenido, String destino) {
        this.estado = new Pendiente(this); // Asume que Pendiente es una subclase de EstadoDelPaquete
        this.seguimiento = new Seguimiento(estado); // Asume que Seguimiento está correctamente definido
        this.codigoTracking = codigoTracking;
        this.ancho = ancho;
        this.largo = largo;
        this.contenido = contenido;
        this.direccionDestino = destino;
    }
    
    public void cambiarEstado(EstadoDelPaquete estado) {
        this.estado = estado;
        seguimiento.notificar(estado); // Asume que Seguimiento tiene el método notificar
    }
    
    public ArrayList<String> obtenerHistorialEstados() {
        return seguimiento.obtenerEstadosAnteriores(); // Asume que Seguimiento tiene el método obtenerEstadosAnteriores
    }
    
    public EstadoDelPaquete obtenerEstado() {
        return estado;
    }
    

    public void iniciarEnvio() {
        estado.iniciarEnvio(); // Asume que EstadoDelPaquete tiene el método iniciarEnvio
    }
    
    public void completarEnvio() {
        estado.completarEnvio(); // Asume que EstadoDelPaquete tiene el método completarEnvio
    }

    public EstadoDelPaquete getEstado() {
        return estado;
    }

    public void setEstado(EstadoDelPaquete estado) {
        this.estado = estado;
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    public String getCodigoTracking() {
        return codigoTracking;
    }

    public void setCodigoTracking(String codigoTracking) {
        this.codigoTracking = codigoTracking;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }
    

    public void setEstado(String nuevoEstado) {
        // Convertir el estado a la enum correspondiente y actualizar el estado
        try {
            EstadoDelPaquete estado = EstadoDelPaquete.valueOf(nuevoEstado.toUpperCase());
            this.estado = estado;
            seguimiento.notificar(estado);
        } catch (IllegalArgumentException e) {
            throw new UnsupportedOperationException("Estado no soportado: " + nuevoEstado);
        }
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "codigoTracking='" + codigoTracking + '\'' +
                ", ancho=" + ancho +
                ", largo=" + largo +
                ", contenido='" + contenido + '\'' +
                ", direccionDestino='" + direccionDestino + '\'' +
                ", estado=" + estado +
                '}';
    }
}
