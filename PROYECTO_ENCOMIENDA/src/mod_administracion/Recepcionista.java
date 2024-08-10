package mod_administracion;

import mod_facturacion.Cotizacion;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_paquetes.Pendiente;

import java.util.ArrayList;
import mod_facturacion.Precio;
import mod_transporte.Provincia;

/**
 * Representa a un recepcionista que maneja paquetes y realiza varias operaciones relacionadas con el inventario y la cotización.
 * Extiende la clase {@link Usuario} para incluir funcionalidades específicas para recepcionistas.
 */
public class Recepcionista extends Usuario {
    private Paquete paqueteEnCotizacion;
    private Provincia sucursal;

    /**
     * Constructor que inicializa los datos del recepcionista y la sucursal a la que pertenece.
     *
     * @param nombres el nombre del recepcionista.
     * @param apellidos los apellidos del recepcionista.
     * @param identificacion el identificador único del recepcionista.
     * @param direccion la dirección del recepcionista.
     * @param telefono el número de teléfono del recepcionista.
     * @param email la dirección de correo electrónico del recepcionista.
     * @param sucursal la provincia donde se encuentra la sucursal del recepcionista.
     */
    public Recepcionista(String nombres, String apellidos, String identificacion, String direccion, String telefono, String email, Provincia sucursal) {
        super(nombres, apellidos, identificacion, direccion, telefono, email);
        this.sucursal = sucursal;
    }

    /**
     * Reporta un incidente para un paquete basado en el código de seguimiento.
     * El incidente solo puede ser reportado si el paquete está en estado pendiente.
     *
     * @param codigoTracking el código de seguimiento del paquete para el cual se reporta el incidente.
     */
    @Override
    public void reportarIncidente(String codigoTracking) {
        Paquete paquete = obtenerPaquete(codigoTracking);
        if (paquete != null && !(paquete.obtenerEstado() instanceof Pendiente)) {
            System.out.println("El paquete se encuentra en otro estado fuera de su jurisdicción, no se puede reportar el incidente.");
            // Delegar a módulo de incidentes aquí
        } else {
            System.out.println("No se puede reportar el incidente, el paquete está pendiente.");
        }
    }

    /**
     * Cambia el estado de un paquete basado en el código de seguimiento.
     * Este método debe ser implementado para modificar el estado del paquete.
     *
     * @param codigoTracking el código de seguimiento del paquete cuyo estado se cambiará.
     * @param estado el nuevo estado del paquete.
     */
    @Override
    public void cambiarEstadoPaquete(String codigoTracking, EstadoDelPaquete estado) {
        // Implementar el cambio de estado aquí
    }

    /**
     * Elimina un paquete del inventario.
     *
     * @param paquete el paquete a eliminar del inventario.
     */
    public void eliminarPaqueteInventario(Paquete paquete) {
        Inventario.obtenerInstancia().eliminarPaquete(paquete);
    }

    /**
     * Obtiene el paquete actualmente registrado en la cotización.
     *
     * @return el paquete registrado en la cotización, o {@code null} si no hay ninguno.
     */
    public Paquete obtenerPaqueteRegistrado() {
        return paqueteEnCotizacion;
    }

    /**
     * Consulta el precio del paquete actualmente registrado en la cotización.
     *
     * @return el precio del paquete, o {@code null} si no hay un paquete registrado.
     */
    public Precio consultarPrecioPaquete() {
        if (paqueteEnCotizacion == null) {
            return null;
        }
        return Cotizacion.obtenerPrecioPaquete(paqueteEnCotizacion);
    }

    /**
     * Registra un paquete en la cotización.
     *
     * @param paquete el paquete a registrar.
     */
    public void registrarPaquete(Paquete paquete) {
        paqueteEnCotizacion = paquete;
    }

    /**
     * Agrega el paquete actualmente registrado al inventario.
     */
    public void agregarPaqueteInventario() {
        if (paqueteEnCotizacion != null) {
            Inventario.obtenerInstancia().agregarPaquete(paqueteEnCotizacion);
        }
    }

    /**
     * Elimina el paquete actualmente registrado en la cotización.
     */
    public void eliminarPaqueteRegistrado() {
        paqueteEnCotizacion = null;
    }

    /**
     * Obtiene el código del paquete actualmente registrado en la cotización.
     *
     * @return el código del paquete, o una cadena vacía si no hay ningún paquete registrado.
     */
    public String obtenerCodigoPaquete() {
        if (paqueteEnCotizacion == null) {
            return "";
        }
        return paqueteEnCotizacion.obtenerCodigo();
    }

    /**
     * Consulta todos los paquetes en el inventario.
     *
     * @return una lista de paquetes en el inventario.
     */
    public ArrayList<Paquete> consultarPaquetesInventario() {
        return Inventario.obtenerInstancia().obtenerPaquetes();
    }

    /**
     * Obtiene la provincia de la sucursal del recepcionista.
     *
     * @return la provincia donde se encuentra la sucursal del recepcionista.
     */
    public Provincia obtenerSucursal() {
        return this.sucursal;
    }
}
