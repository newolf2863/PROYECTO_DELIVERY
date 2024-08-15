package mod_facturacion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mod_administracion.Usuario;
import mod_paquetes.Paquete;
import mod_transporte.Provincia;

/**
 * Representa una factura en el sistema de facturación.
 * Implementa Serializable para permitir la persistencia de objetos.
 */
public class Factura implements Serializable {
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

    /**
     * Constructor que inicializa una factura con los datos del paquete y el precio.
     *
     * @param id el identificador de la factura.
     * @param paquete el paquete asociado con la factura.
     * @param precio el precio calculado para el paquete.
     */
    public Factura(String id, Paquete paquete, Precio precio) {
        this.id = id;
        this.precio = precio;
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String fechaFormateada = fechaHoraActual.format(formatoFecha);
        fechaEmision = fechaFormateada;
        this.cliente = paquete.getRemitente();
        this.destinatario = paquete.getNombreDestinatario();
        this.direccionDestino = paquete.getDireccionDestino();
        this.provinciaOrigen = paquete.getProvinciaOrigen();
        this.provinciaDestino = paquete.getProvinciaDestino();
        this.descripcion = paquete.getContenido();
        this.codigoTracking = paquete.obtenerCodigo();
        this.pesoPaquete = paquete.getPeso();
    }

    /**
     * Obtiene el código identificador de la factura.
     *
     * @return el código de la factura.
     */
    public String obtenerCodigo() {
        return this.id;
    }

    /**
     * Obtiene el precio total del paquete en la factura.
     *
     * @return el precio total del paquete como una cadena de texto.
     */
    public String obtenerPrecioTotal() {
        return String.valueOf(this.precio.getPrecioTotalPaquete());
    }

    /**
     * Obtiene el objeto Precio asociado con la factura.
     *
     * @return el objeto Precio de la factura.
     */
    public Precio obtenerPrecio() {
        return precio;
    }

    /**
     * Obtiene la fecha de emisión de la factura.
     *
     * @return la fecha de emisión de la factura como una cadena de texto.
     */
    public String obtenerFechaEmision() {
        return this.fechaEmision;
    }

    /**
     * Obtiene el cliente asociado con la factura.
     *
     * @return el objeto Usuario que representa al cliente.
     */
    public Usuario obtenerCliente() {
        return this.cliente;
    }

    /**
     * Obtiene la provincia de destino del paquete.
     *
     * @return la provincia de destino como una cadena de texto.
     */
    public String obtenerProvinciaDestino() {
        return this.provinciaDestino.toString();
    }

    /**
     * Obtiene la provincia de origen del paquete.
     *
     * @return la provincia de origen como una cadena de texto.
     */
    public String obtenerProvinciaOrigen() {
        return this.provinciaOrigen.toString();
    }

    /**
     * Obtiene la dirección de destino del paquete.
     *
     * @return la dirección de destino como una cadena de texto.
     */
    public String obtenerDireccionDestino() {
        return this.direccionDestino;
    }

    /**
     * Obtiene el nombre del destinatario del paquete.
     *
     * @return el nombre del destinatario como una cadena de texto.
     */
    public String obtenerNombreDestinatario() {
        return this.destinatario;
    }

    /**
     * Obtiene la descripción del contenido del paquete.
     *
     * @return la descripción del contenido como una cadena de texto.
     */
    public String obtenerDescripcion() {
        return this.descripcion;
    }

    /**
     * Obtiene el código de seguimiento del paquete.
     *
     * @return el código de seguimiento como una cadena de texto.
     */
    public String obtenerCodigoTracking() {
        return this.codigoTracking;
    }

    /**
     * Obtiene el peso del paquete.
     *
     * @return el peso del paquete como una cadena de texto.
     */
    public String obtenerPesoPaquete() {
        return String.valueOf(pesoPaquete);
    }
}
