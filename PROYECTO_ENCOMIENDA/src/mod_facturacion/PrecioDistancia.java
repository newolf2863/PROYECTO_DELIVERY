package mod_facturacion;

import mod_paquetes.Paquete;

public class PrecioDistancia extends CalculoPrecio {
    private double precioPorKm;

    public PrecioDistancia(double precioPorKm) {
        this.precioPorKm = precioPorKm;
    }

    @Override
    public double calcularValor(Paquete paquete) {
        monto = paquete.calcularDistancia() * precioPorKm;
        return monto;
    }

    @Override
    public double calcularValorDependiente(double montoBase) {
        return 0;
    }
}
