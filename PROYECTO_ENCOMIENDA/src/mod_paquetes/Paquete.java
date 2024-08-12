package mod_paquetes;

import mod_transporte.Provincia;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import mod_administracion.Usuario;

import java.util.ArrayList;

public class Paquete implements Serializable {
    private String codigoTracking;
    private double volumen;
    private double peso;
    private String contenido;
    private Usuario remitente;
    private Provincia provinciaOrigen;
    private Provincia provinciaDestino;
    private String direccionDestino;
    private String nombreDestinatario;
    private EstadoDelPaquete estado;
    private Seguimiento seguimiento;

    public Paquete(String codigoTracking, double volumen, double peso, String contenido, Usuario remitente, Provincia provinciaOrigen, Provincia provinciaDestino, String direccionDestino, String nombreDestinatario) {
        this.codigoTracking = codigoTracking;
        this.volumen = volumen;
        this.peso = peso;
        this.contenido = contenido;
        this.remitente = remitente;
        this.provinciaOrigen = provinciaOrigen;
        this.provinciaDestino = provinciaDestino;
        this.direccionDestino = direccionDestino;
        this.nombreDestinatario = nombreDestinatario;
        this.estado = new Pendiente(this);
        this.seguimiento = new Seguimiento(estado);
    }

    public void cambiarEstado(EstadoDelPaquete estado) {
        this.estado = estado;
        seguimiento.notificar(estado);
    }
    
    public ArrayList<String> obtenerHistorialEstados() {
        return seguimiento.obtenerEstadosAnteriores();
    }

    public double calcularDistancia() {
        double longitude1 = provinciaOrigen.getLongitud();
        double longitude2 = provinciaDestino.getLongitud();
        double latitude1 = provinciaOrigen.getLatitud();
        double latitude2 = provinciaDestino.getLatitud();
        double theta = longitude1 - longitude2;
        double distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
                Math.sin(latitude1 * (Math.PI/180)) * Math.sin(latitude2 * (Math.PI/180)) +
                        Math.cos(latitude1 * (Math.PI/180)) * Math.cos(latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
        );
        double convertedDistance = Math.round(distance * 1.609344);
        BigDecimal bd = new BigDecimal(convertedDistance);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        double roundedDistance = bd.doubleValue();
        return roundedDistance;
    }

    public EstadoDelPaquete obtenerEstado() {
        return estado;
    }

    public String obtenerCodigo() {
        return codigoTracking;
    }

    public double getVolumen() {
        return volumen;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public double getPeso() {
        return peso;
    }
    
    public Provincia getProvinciaOrigen() {
        return provinciaOrigen;
    }

    public Provincia getProvinciaDestino() {
        return provinciaDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }
    
    public String getCodigoTracking(){
        return codigoTracking;
    }
    
    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public String toString() {
        return "Paquete: \n" +
                "Código Tracking = '" + codigoTracking + "'\n" +
                "Volumen = " + volumen + " m3\n" +
                "Peso = " + peso + " Kg\n" +
                "Contenido = '" + contenido + "'\n" +
                "Remitente = " + remitente + "\n" +
                "Provincia de Origen = " + provinciaOrigen.name() + "\n" +
                "Provincia de Destino = " + provinciaDestino.name() + "\n" +
                "Dirección de Destino = '" + direccionDestino + '\'' + "\n" +
                "Estado = " + estado + "\n" +
                "Distancia Estimada = " + calcularDistancia() + " Km\n" +
                "Destinatario = " + nombreDestinatario + "\n";
    }

    public String getContenido() {
        return this.contenido;
    }

    public Seguimiento obtenerSeguimiento() {
        return this.seguimiento;
    }
    
    public void setDireccionDestino(String nuevaDireccion) {
        this.direccionDestino = nuevaDireccion;
    }
}
