package mod_administracion;

import mod_paquetes.EnCurso;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Paquete;
import mod_transporte.Asignacion;

import java.util.ArrayList;

/**
 * Representa un conductor que puede reportar incidentes y consultar paquetes asignados.
 * Extiende la clase {@link Usuario} para incluir funcionalidades específicas para conductores.
 */
public class Conductor extends Usuario {

    /**
     * Constructor que inicializa los datos del conductor.
     *
     * @param nombres el nombre del conductor.
     * @param apellidos los apellidos del conductor.
     * @param identificacion el identificador único del conductor.
     * @param direccion la dirección del conductor.
     * @param telefono el número de teléfono del conductor.
     * @param email la dirección de correo electrónico del conductor.
     */
    public Conductor(String nombres, String apellidos, String identificacion, String direccion, String telefono, String email) {
        super(nombres, apellidos, identificacion, direccion, telefono, email);
    }

    /**
     * Reporta un incidente para un paquete basado en el código de seguimiento.
     * El incidente solo puede ser reportado si el paquete está en curso.
     *
     * @param codigoTracking el código de seguimiento del paquete para el cual se reporta el incidente.
     */
    @Override
    public void reportarIncidente(String codigoTracking) {
        Paquete paquete = obtenerPaquete(codigoTracking);
        if (paquete != null && !(paquete.obtenerEstado() instanceof EnCurso)) {
            System.out.println("El paquete se encuentra en otro estado fuera de su jurisdicción, no se puede reportar el incidente.");
            // Delegar a módulo de incidentes aquí
        } else {
            System.out.println("No se puede reportar el incidente, el paquete está en curso.");
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
     * Consulta los paquetes que están asignados al conductor.
     * Imprime la información de cada paquete asignado y devuelve una lista de paquetes.
     *
     * @return una lista de paquetes asignados al conductor.
     */
    public ArrayList<Paquete> consultarPaquetesAsignados() {
        ArrayList<Paquete> paquetes = Asignacion.obtenerInstancia().obtenerPaquetesDeConductor(this);
        for (Paquete paquete : paquetes) {
            System.out.println(paquete);
        }
        return paquetes;
    }
}
