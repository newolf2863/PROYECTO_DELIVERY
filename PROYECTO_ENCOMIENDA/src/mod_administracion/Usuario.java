package mod_administracion;

import java.io.Serializable;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

/**
 * Representa a un usuario en el sistema. Esta clase es abstracta y sirve como base para diferentes tipos de usuarios,
 * como clientes, conductores y recepcionistas.
 */
public abstract class Usuario implements Serializable {
    private String nombres;
    private String apellidos;
    private String cedula;
    private String direccion;
    private String telefono;
    private String email;

    /**
     * Constructor para crear un nuevo usuario con la información proporcionada.
     *
     * @param nombres el nombre del usuario.
     * @param apellidos los apellidos del usuario.
     * @param cedula el número de cédula del usuario.
     * @param direccion la dirección del usuario.
     * @param telefono el número de teléfono del usuario.
     * @param email la dirección de correo electrónico del usuario.
     */
    public Usuario(String nombres, String apellidos, String cedula, String direccion, String telefono, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Obtiene un paquete del inventario basado en el código de seguimiento.
     *
     * @param codigoTracking el código de seguimiento del paquete.
     * @return el paquete correspondiente al código de seguimiento, o {@code null} si no se encuentra.
     */
    public Paquete obtenerPaquete(String codigoTracking) {
        return Inventario.obtenerInstancia().obtenerPaquete(codigoTracking);
    }

    /**
     * Representa una cadena de texto que contiene la cédula del usuario.
     *
     * @return la cédula del usuario.
     */
    @Override
    public String toString() {
        return cedula;
    }

    /**
     * Reporta un incidente para un paquete basado en el código de seguimiento.
     * Este método debe ser implementado por las clases concretas que extienden {@link Usuario}.
     *
     * @param codigoTracking el código de seguimiento del paquete para el cual se reporta el incidente.
     */
    public abstract void reportarIncidente(String codigoTracking);

    /**
     * Cambia el estado de un paquete basado en el código de seguimiento.
     * Este método debe ser implementado por las clases concretas que extienden {@link Usuario}.
     *
     * @param codigoTracking el código de seguimiento del paquete cuyo estado se cambiará.
     * @param estado el nuevo estado del paquete.
     */
    public abstract void cambiarEstadoPaquete(String codigoTracking, EstadoDelPaquete estado);

    /**
     * Obtiene el nombre del usuario.
     *
     * @return el nombre del usuario.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Obtiene los apellidos del usuario.
     *
     * @return los apellidos del usuario.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Obtiene el número de cédula del usuario.
     *
     * @return el número de cédula del usuario.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Obtiene la dirección del usuario.
     *
     * @return la dirección del usuario.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     *
     * @return el número de teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene la dirección de correo electrónico del usuario.
     *
     * @return la dirección de correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }
}
