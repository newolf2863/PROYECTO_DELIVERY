package mod_paquetes;

public class Pendiente extends EstadoDelPaquete{
    public Pendiente(Paquete paquete) {
        super(paquete);
    }

    @Override
    public void iniciarEnvio() {
        paquete.cambiarEstado(new EnCurso(paquete));
    }

    @Override
    public void completarEnvio() {

    }

    @Override
    public String toString() {
        return "Pendiente";
    }
}
