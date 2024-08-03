package mod_facturacion;

import java.io.Serializable;
import java.time.LocalDate;
import mod_administracion.Usuario;
import mod_paquetes.Paquete;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mod_paquetes.Provincia;

public class Factura implements Serializable{
    private String id;
    private Precio precio;
    private String fechaEmision;
    private Usuario cliente;
    private String destinatario;
    private Provincia provinciaOrigen;
    private Provincia provinciaDestino;
    private String direccionDestino;
    private String descripcion;
    private String codigoTracking;
    private double pesoPaquete;
    public Factura(String id,Paquete paquete, Precio precio) {
        this.id = id;
        this.precio = precio;
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter  formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String fechaFormateada = fechaHoraActual.format(formatoFecha);
        fechaEmision = fechaFormateada;
        this.cliente = paquete.getRemitente();
        this.destinatario = paquete.getNombreDestinatario();
        this.direccionDestino = paquete.getDireccionDestino();
        this.provinciaOrigen = paquete.getProvinciaOrigen();
        this.provinciaDestino = paquete.getProvinciaDestino();
        this.descripcion = paquete.getContenido();
        this.codigoTracking = paquete.getCodigoTracking();
        this.pesoPaquete = paquete.getPeso();

    }


    public String obtenerCodigo() {
        return this.id;
    }
    
    public String obtenerPrecioTotal(){
        return String.valueOf(this.precio.getPrecioTotalPaquete());
    }
    
    public Precio obtenerPrecio(){
        return precio;
    }
      
    
    public String obtenerFechaEmision(){
        return this.fechaEmision;
    }
    
    public Usuario obtenerCliente(){
        return this.cliente;
    }
    
    public String obtenerProvinciaDestino(){
        return this.provinciaDestino.toString();
    }
    
    public String obtenerProvinciaOrigen(){
        return this.provinciaOrigen.toString();
    }
    
    public String obtenerDireccionDestino(){
        return this.direccionDestino;
    }
    
    public String obtenerNombreDestinatario(){
        return this.destinatario;
    }
    
    public String obtenerDescripcion(){
        return this.descripcion;
    }
    
    public String obtenerCodigoTracking(){
        return this.codigoTracking;
    }
        
    public String obtenerPesoPaquete(){
        return String.valueOf(pesoPaquete);
    }
    
}
