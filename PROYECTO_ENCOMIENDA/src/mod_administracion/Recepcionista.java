package mod_administracion;

import mod_facturacion.Cotizacion;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_paquetes.Pendiente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import mod_facturacion.Factura;
import mod_facturacion.Precio;
import mod_incidentes.PaqueteNoTieneIncidente;
import mod_incidentes.PaqueteYaTieneIncidente;
import mod_paquetes.Entregado;
import mod_transporte.Asignacion;
import mod_transporte.Provincia;
import mod_transporte.Vehiculo;

/**
 * Representa a un recepcionista que maneja paquetes y realiza varias
 * operaciones relacionadas con el inventario y la cotización.
 * Extiende la clase {@link Usuario} para incluir funcionalidades específicas
 * para recepcionistas.
 */
public class Recepcionista extends Usuario {
    private Paquete paqueteEnCotizacion;
    private Provincia sucursal;
    private Cotizacion cotizacion;
    private Asignacion asignacion;

    /**
     * Constructor que inicializa los datos del recepcionista y la sucursal a la que
     * pertenece.
     *
     * @param nombres        el nombre del recepcionista.
     * @param apellidos      los apellidos del recepcionista.
     * @param identificacion el identificador único del recepcionista.
     * @param direccion      la dirección del recepcionista.
     * @param telefono       el número de teléfono del recepcionista.
     * @param email          la dirección de correo electrónico del recepcionista.
     * @param sucursal       la provincia donde se encuentra la sucursal del
     *                       recepcionista.
     */
    public Recepcionista(String nombres, String apellidos, String identificacion, String direccion, String telefono,
            String email, Provincia sucursal) {
        super(nombres, apellidos, identificacion, direccion, telefono, email);
        this.sucursal = sucursal;
        this.cotizacion = Cotizacion.obtenerInstancia();
        this.asignacion = Asignacion.obtenerInstancia();
    }

    @Override
    public void reportarIncidente(Paquete paquete) throws ReporteNoPermitido, PaqueteYaTieneIncidente {
        if (paquete == null || !(paquete.obtenerEstado() instanceof Pendiente)) {
            throw new ReporteNoPermitido();
        }
        gestorIncidente.crearIncidente(paquete);
    }
    
    
    @Override
    public void resolverIncidente(Paquete paquete, String[] argumentos) throws ReporteNoPermitido, PaqueteNoTieneIncidente {
        if (paquete == null || !(paquete.obtenerEstado() instanceof Pendiente || paquete.obtenerEstado() instanceof Entregado)) {
            throw new ReporteNoPermitido();
        }
        gestorIncidente.solucionarIncidente(paquete, argumentos);
    }


    /**
     * Consulta el precio del paquete actualmente registrado en la cotización.
     *
     * @return el precio del paquete, o {@code null} si no hay un paquete
     *         registrado.
     */
    public Precio consultarPrecioPaquete() {
        if (paqueteEnCotizacion == null) {
            return null;
        }
        return cotizacion.obtenerPrecioPaquete(paqueteEnCotizacion);
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
     * Obtiene la provincia de la sucursal del recepcionista.
     *
     * @return la provincia donde se encuentra la sucursal del recepcionista.
     */
    public Provincia obtenerSucursal() {
        return this.sucursal;
    }

    public boolean asignarPaquetesAVehiculo(Vehiculo vehiculo, Provincia destino) {
        return asignacion.asignarPaquetesAVehiculo(vehiculo, destino);
    }

    public void asignarConductorAVehiculo(Conductor conductor, Vehiculo vehiculo) {
        asignacion.asignarConductorAVehiculo(conductor, vehiculo);
    }

    public ArrayList<Paquete> obtenerPaquetes() {
        return inventario.obtenerPaquetes();
    }

    public String obtenerSiguienteCodigoPaquete() {
        return inventario.getSiguienteCodigoTracking();
    }

    public void guardarInventario() {
        inventario.guardarInventario();
    }

    public void eliminarPaquete(Paquete paquete) {
        inventario.eliminarPaquete(paquete);
    }

    public boolean consultarSiPaqueteExiste(String codigo) {
        return inventario.existePaquete(codigo);
    }

    public Factura buscarFactura(String codigoFactura) {
        ArrayList<Factura> facturas = cotizacion.obtenerFacturas();
        for (Factura factura : facturas) {
            if (factura.obtenerCodigo().equals(codigoFactura)) {
                return factura;
            }
        }
        return null;
    }

    public void emitirFacturaPaquete(Paquete paquete) {
        cotizacion.emitirFacturaPaquete(paquete);
    }

    public String getSiguienteCodigoFactura() {
        return cotizacion.getSiguienteCodigoFactura();
    }

    public Precio obtenerPrecioPaquete(Paquete paquete) {
        return cotizacion.obtenerPrecioPaquete(paquete);
    }

    public Vehiculo obtenerVehiculo(String placa) {
        return asignacion.obtenerVehiculo(placa);
    }

    public HashMap<Vehiculo, ArrayList<Paquete>> obtenerRelacionPaqueteVehiculo() {
        return asignacion.obtenerRelacionPaqueteVehiculo();
    }
}
