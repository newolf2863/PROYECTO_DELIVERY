package mod_administracion;

import mod_paquetes.EnCurso;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Paquete;

import java.util.ArrayList;
import mod_incidentes.PaqueteNoTieneIncidente;
import mod_incidentes.PaqueteYaTieneIncidente;
import mod_paquetes.Entregado;
import mod_paquetes.Inventario;
import mod_transporte.AsignacionConductor;
import mod_transporte.Vehiculo;

/**
 * Representa un conductor que puede reportar incidentes y consultar paquetes
 * asignados.
 * Extiende la clase {@link Usuario} para incluir funcionalidades específicas
 * para conductores.
 */
public class Conductor extends Usuario {

    /**
     * Constructor que inicializa los datos del conductor.
     *
     * @param nombres        el nombre del conductor.
     * @param apellidos      los apellidos del conductor.
     * @param identificacion el identificador único del conductor.
     * @param direccion      la dirección del conductor.
     * @param telefono       el número de teléfono del conductor.
     * @param email          la dirección de correo electrónico del conductor.
     */
    public Conductor(String nombres, String apellidos, String identificacion, String direccion, String telefono,
            String email) {
        super(nombres, apellidos, identificacion, direccion, telefono, email);
    }

    @Override
    public void reportarIncidente(Paquete paquete) throws ReporteNoPermitido, PaqueteYaTieneIncidente {
        if (paquete == null || !(paquete.obtenerEstado() instanceof EnCurso)) {
            throw new ReporteNoPermitido();
        }
        gestorIncidente.crearIncidente(paquete);
    }
    
    
    @Override
    public void resolverIncidente(Paquete paquete, String[] argumentos) throws ReporteNoPermitido, PaqueteNoTieneIncidente {
        if (paquete == null || !(paquete.obtenerEstado() instanceof EnCurso)) {
            throw new ReporteNoPermitido();
        }
        gestorIncidente.solucionarIncidente(paquete, argumentos);
    }

    /**
     * Consulta los paquetes que están asignados al conductor.
     * Imprime la información de cada paquete asignado y devuelve una lista de
     * paquetes.
     *
     * @return una lista de paquetes asignados al conductor.
     */

    public ArrayList<Paquete> consultarPaquetesAsignados() {
        Vehiculo vehiculo = asignacionConductor.obtenerVehiculoDeConductor(this);
        if(vehiculo == null){
            return null;
        }
        return asignacionPaquete.obtenerPaquetesVehiculo(vehiculo);
    }

    public void entregarPaquete(String codigo) {
        Paquete paqueteCambio = Inventario.obtenerInstancia().obtenerPaquete(codigo);
        paqueteCambio.cambiarEstado(new Entregado(paqueteCambio));

        Inventario.obtenerInstancia().guardarInventario();
        asignacionPaquete.guardarRelacionPaquetes();
    }
}
