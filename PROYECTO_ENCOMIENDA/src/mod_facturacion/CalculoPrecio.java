package mod_facturacion;

import java.io.Serializable;
import mod_paquetes.Paquete;

public abstract class CalculoPrecio implements Serializable {
    protected double monto;

    public double obtenerMonto() {
        return monto;
    }
    
    public abstract double calcularValor(Paquete paquete);
    public abstract double calcularValorDependiente(double montoBase);
}
