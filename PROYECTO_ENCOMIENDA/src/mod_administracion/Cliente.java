package mod_administracion;

import mod_paquetes.Entregado;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Paquete;

/**
 * Representa un cliente que puede reportar incidentes y consultar el estado de los paquetes.
 * Extiende la clase {@link Usuario} para incluir funcionalidades específicas para clientes.
 */
public class Cliente extends Usuario {

    /**
     * Constructor que inicializa los datos del cliente.
     *
     * @param nombres el nombre del cliente.
     * @param apellidos los apellidos del cliente.
     * @param identificacion el identificador único del cliente.
     * @param direccion la dirección del cliente.
     * @param telefono el número de teléfono del cliente.
     * @param email la dirección de correo electrónico del cliente.
     */
    public Cliente(String nombres, String apellidos, String identificacion, String direccion, String telefono, String email) {
        super(nombres, apellidos, identificacion, direccion, telefono, email);
    }

    /**
     * Reporta un incidente para un paquete basado en el código de seguimiento.
     * El incidente solo puede ser reportado si el paquete no ha sido entregado.
     *
     * @param codigoTracking el código de seguimiento del paquete para el cual se reporta el incidente.
     */
    @Override
    public void reportarIncidente(String codigoTracking) {
        Paquete paquete = obtenerPaquete(codigoTracking);
        if (paquete != null && !(paquete.obtenerEstado() instanceof Entregado)) {
            System.out.println("El paquete se encuentra en otro estado fuera de su jurisdicción, no se puede reportar el incidente.");
            // Delegar a módulo de incidentes aquí
        } else {
            System.out.println("No se puede reportar el incidente, el paquete ya ha sido entregado.");
        }
    }

    /**
     * Cambia el estado de un paquete basado en el código de seguimiento.
     *
     * @param codigoTracking el código de seguimiento del paquete cuyo estado se cambiará.
     * @param estado el nuevo estado del paquete.
     */
    @Override
    public void cambiarEstadoPaquete(String codigoTracking, EstadoDelPaquete estado) {
        // Implementar el cambio de estado aquí
    }

    /**
     * Consulta el estado del paquete. Este método no está implementado y siempre retorna null.
     *
     * @return el estado del paquete, actualmente retorna null.
     */
    public EstadoDelPaquete consultarEstadoPaquete() {
        return null;
    }
}
