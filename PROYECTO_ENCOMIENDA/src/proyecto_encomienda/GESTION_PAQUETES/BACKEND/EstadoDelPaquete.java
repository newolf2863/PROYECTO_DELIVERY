/**
 *
 * @author Juguitos
 */
package proyecto_encomienda.GESTION_PAQUETES.BACKEND;

public abstract class EstadoDelPaquete {
    protected Paquete paquete;
    protected String estado;

    public EstadoDelPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public String getEstado() {
        return estado;
    }
    
    void setEstado(String nuevoEstado) {
      this.estado = estado;
    }
    
    public abstract void iniciarEnvio();
    public abstract void completarEnvio();

    
}
