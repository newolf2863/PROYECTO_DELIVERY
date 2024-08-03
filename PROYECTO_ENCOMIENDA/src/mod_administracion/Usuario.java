package mod_administracion;

import java.io.Serializable;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

public abstract class Usuario implements Serializable {
    private String nombres;
    private String apellidos;
    private String cedula;
    private String direccion;
    private String telefono;
    private String email;

    public Usuario(String nombres, String apellidos, String cedula, String direccion, String telefono, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Paquete obtenerPaquete(String codigoTracking) {
        return Inventario.obtenerInstancia().obtenerPaquete(codigoTracking);
    }

    @Override
    public String toString() {
        return cedula;
    }

    public abstract void reportarIncidente(String codigoTracking);
    public abstract void cambiarEstadoPaquete(String codigoTracking, EstadoDelPaquete estado);

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
}
