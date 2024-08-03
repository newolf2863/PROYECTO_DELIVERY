package mod_administracion;

import mod_paquetes.Entregado;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Paquete;

public class Cliente extends Usuario {

    public Cliente(String nombres, String apellidos, String identificacion, String direccion, String telefono, String email) {
        super(nombres, apellidos, identificacion, direccion, telefono, email);
    }

    @Override
    public void reportarIncidente(String codigoTracking) {
        Paquete paquete = obtenerPaquete(codigoTracking);
        if (!(paquete.obtenerEstado() instanceof Entregado)) {
            System.out.println("El paquete se encuentra en otro estado fuera de su jurisdiccion, no se puede reportar el incidente");
        }
        // Delegar a modulo de incidentes
    }

    @Override
    public void cambiarEstadoPaquete(String codigoTracking, EstadoDelPaquete estado) {

    }

    public EstadoDelPaquete consultarEstadoPaquete() {
        return null;
    }
}
