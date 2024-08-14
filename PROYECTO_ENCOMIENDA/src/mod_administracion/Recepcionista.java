package mod_administracion;

import mod_facturacion.Cotizacion;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_paquetes.Pendiente;

import java.util.ArrayList;
import java.util.HashMap;
import mod_facturacion.Factura;
import mod_facturacion.Precio;
import mod_incidentes.PaqueteNoTieneIncidente;
import mod_incidentes.PaqueteYaTieneIncidente;
import mod_paquetes.Entregado;
import mod_transporte.FlotaVehiculo;
import mod_transporte.Provincia;
import mod_transporte.Vehiculo;

/**
 * Representa a un recepcionista que maneja paquetes y realiza varias
 * operaciones relacionadas con el inventario y la cotización.
 * Extiende la clase {@link Usuario} para incluir funcionalidades específicas
 * para recepcionistas.
 */
public class Recepcionista extends Usuario {
    private Provincia sucursal;
    private Cotizacion cotizacion;

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
    public Precio consultarPrecioPaquete(Paquete paqueteEnCotizacion) {
        if (paqueteEnCotizacion == null) {
            return null;
        }
        return cotizacion.obtenerPrecioPaquete(paqueteEnCotizacion);
    }


    /**
     * Agrega el paquete actualmente registrado al inventario.
     */
    public void agregarPaqueteInventario(Paquete paqueteEnCotizacion) {
        if (paqueteEnCotizacion != null) {
            Inventario.obtenerInstancia().agregarPaquete(paqueteEnCotizacion);
        }
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
        return asignacionPaquete.asignarPaquetesAVehiculo(vehiculo, destino);
    }

    public void asignarConductorAVehiculo(Conductor conductor, Vehiculo vehiculo) {
        asignacionConductor.asignarConductorAVehiculo(conductor, vehiculo);
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
        return asignacionPaquete.obtenerVehiculo(placa);
    }

    public HashMap<Vehiculo, ArrayList<Paquete>> obtenerRelacionPaqueteVehiculo() {
        return asignacionPaquete.obtenerRelacionPaqueteVehiculo();
    }

    public Conductor obtenerConductorPorCedula(String cedula) {
        return asignacionConductor.obtenerConductorPorCedula(cedula);
    }

    public Conductor obtenerConductorDeVehiculo(Vehiculo vehiculo) {
        return asignacionConductor.obtenerConductorDeVehiculo(vehiculo);
    }

    public void agregarConductor(Conductor conductor) {
        asignacionConductor.agregarConductor(conductor);
    }

    public void eliminarConductor(Conductor conductor) {
        asignacionConductor.eliminarConductor(conductor);
    }

    public void borrarRelacionConductorVehiculo(Conductor conductor) {
        asignacionConductor.borrarRelacionConductorVehiculo(conductor);
    }

    public ArrayList<Conductor> obtenerConductores() {
        return asignacionConductor.obtenerConductores();
    }

    public ArrayList<Vehiculo> obtenerVehiculos() {
        return asignacionPaquete.obtenerVehiculos();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        asignacionPaquete.agregarVehiculo(vehiculo);
    }




}
