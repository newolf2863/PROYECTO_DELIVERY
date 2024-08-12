package mod_administracion;

import java.io.Serializable;
import mod_incidentes.GestorIncidente;
import mod_incidentes.Incidente;
import mod_incidentes.PaqueteNoTieneIncidente;
import mod_incidentes.PaqueteYaTieneIncidente;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

/**
 * Representa a un usuario en el sistema. Esta clase es abstracta y sirve como
 * base para diferentes tipos de usuarios,
 * como clientes, conductores y recepcionistas.
 */
public abstract class Usuario implements Serializable {
    private String nombres;
    private String apellidos;
    private String cedula;
    private String direccion;
    private String telefono;
    private String email;
    protected Inventario inventario;
    protected GestorIncidente gestorIncidente;

    /**
     * Constructor para crear un nuevo usuario con la información proporcionada.
     *
     * @param nombres   el nombre del usuario.
     * @param apellidos los apellidos del usuario.
     * @param cedula    el número de cédula del usuario.
     * @param direccion la dirección del usuario.
     * @param telefono  el número de teléfono del usuario.
     * @param email     la dirección de correo electrónico del usuario.
     */
    public Usuario(String nombres, String apellidos, String cedula, String direccion, String telefono, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.inventario = Inventario.obtenerInstancia();
        this.gestorIncidente = new GestorIncidente();
    }

    /**
     * Obtiene un paquete del inventario basado en el código de seguimiento.
     *
     * @param codigoTracking el código de seguimiento del paquete.
     * @return el paquete correspondiente al código de seguimiento, o {@code null}
     *         si no se encuentra.
     */
    public Paquete obtenerPaquete(String codigoTracking) {
        return inventario.obtenerPaquete(codigoTracking);
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
    
    public void setIncidenteAManejar(Incidente incidente) {
        this.gestorIncidente.setIncidente(incidente);
    }
    
    public String getMensajeIncidente() {
        return gestorIncidente.getMensaje();
    }
    
    public abstract void reportarIncidente(Paquete paquete) throws ReporteNoPermitido, PaqueteYaTieneIncidente;
    public abstract void resolverIncidente(Paquete paquete, String[] argumentos) throws ReporteNoPermitido, PaqueteNoTieneIncidente;
}
