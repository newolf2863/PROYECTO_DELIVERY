package mod_administracion;

import mod_facturacion.Cotizacion;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_paquetes.Pendiente;

import java.util.ArrayList;
import mod_facturacion.Precio;
import mod_paquetes.Provincia;

public class Recepcionista extends Usuario {
    private Paquete paqueteEnCotizacion;
    private Provincia sucursal;

    public Recepcionista(String nombres, String apellidos, String identificacion, String direccion, String telefono, String email, Provincia sucursal) {
        super(nombres, apellidos, identificacion, direccion, telefono, email);
        this.sucursal = sucursal;
    }

    @Override
    public void reportarIncidente(String codigoTracking) {
       Paquete paquete = obtenerPaquete(codigoTracking);
       if (!(paquete.obtenerEstado() instanceof Pendiente)) {
           System.out.println("El paquete se encuentra en otro estado fuera de su jurisdiccion, no se puede reportar el incidente");
       }
       // Delegar a modulo de incidentes
    }

    @Override
    public void cambiarEstadoPaquete(String codigoTracking, EstadoDelPaquete estado) {

    }

    public void eliminarPaqueteInventario(Paquete paquete) {
        Inventario.obtenerInstancia().eliminarPaquete(paquete);
    }
    
    public Paquete obtenerPaqueteRegistrado() {
        return paqueteEnCotizacion;
    }

    public Precio consultarPrecioPaquete() {
        if (paqueteEnCotizacion == null) {
            return null;
        }
        return Cotizacion.obtenerPrecioPaquete(paqueteEnCotizacion);
    }

    public void registrarPaquete(Paquete paquete) {
        paqueteEnCotizacion = paquete;
    }
    
    public void agregarPaqueteInventario() {
        Inventario.obtenerInstancia().agregarPaquete(paqueteEnCotizacion);
    }
    
    public void eliminarPaqueteRegistrado() {
        paqueteEnCotizacion = null;
    }
    
    public String obtenerCodigoPaquete() {
        if (paqueteEnCotizacion == null) {
            return "";
        }
        return paqueteEnCotizacion.obtenerCodigo();
    }

    public ArrayList<Paquete> consultarPaquetesInventario() {
        return Inventario.obtenerInstancia().obtenerPaquetes();
    }
    
    public Provincia obtenerSucursal() {
        return this.sucursal;
    }
}
