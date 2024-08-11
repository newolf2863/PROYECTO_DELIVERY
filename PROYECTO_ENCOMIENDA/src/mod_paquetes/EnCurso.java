package mod_paquetes;

public class EnCurso extends EstadoDelPaquete {
    public EnCurso(Paquete paquete) {
        super(paquete);
    }

    @Override
    public void iniciarEnvio() {

    }

    @Override
    public void completarEnvio() {
        paquete.cambiarEstado(new Entregado(paquete));
    }

    @Override
    public String toString() {
        return "En curso";
    }
}
