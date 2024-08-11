package mod_paquetes;

public class Entregado extends EstadoDelPaquete {
    public Entregado(Paquete paquete) {
        super(paquete);
    }

    @Override
    public void iniciarEnvio() {
    }

    @Override
    public void completarEnvio() {

    }


    @Override
    public String toString() {
        return "Entregado";
    }
}
