package mod_paquetes;

import java.io.Serializable;

public abstract class EstadoDelPaquete implements Serializable {
    protected Paquete paquete;

    public EstadoDelPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public abstract void iniciarEnvio();
    public abstract void completarEnvio();
}