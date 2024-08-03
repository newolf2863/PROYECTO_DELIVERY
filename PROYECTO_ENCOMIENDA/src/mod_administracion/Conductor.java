package mod_administracion;

import mod_paquetes.EnCurso;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Paquete;
import mod_transporte.Asignacion;

import java.util.ArrayList;

public class Conductor extends Usuario {
    public Conductor(String nombres, String apellidos, String identificacion, String direccion, String telefono, String email) {
        super(nombres, apellidos, identificacion, direccion, telefono, email);
    }

    @Override
    public void reportarIncidente(String codigoTracking) {
        Paquete paquete = obtenerPaquete(codigoTracking);
        if (!(paquete.obtenerEstado() instanceof EnCurso)) {
            System.out.println("El paquete se encuentra en otro estado fuera de su jurisdiccion, no se puede reportar el incidente");
        }
        // Delegar a modulo de incidentes
    }

    @Override
    public void cambiarEstadoPaquete(String codigoTracking, EstadoDelPaquete estado) {

    }

    public ArrayList<Paquete> consultarPaquetesAsignados() {
        ArrayList<Paquete> paquetes = Asignacion.obtenerInstancia().obtenerPaquetesConductor(this);
        for (Paquete paquete : paquetes) {
            System.out.println(paquete);
        }
        return paquetes;
    }
}
