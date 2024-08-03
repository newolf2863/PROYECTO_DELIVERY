package mod_facturacion;

import mod_paquetes.Paquete;

public class PrecioPaquete extends CalculoPrecio {
    private double precioPorDimension;
    private double precioPorKg;

    public PrecioPaquete(double precioPorDimension, double precioPorKg) {
        this.precioPorDimension = precioPorDimension;
        this.precioPorKg = precioPorKg;
    }

    @Override
    public double calcularValor(Paquete paquete) {
        monto = paquete.getVolumen() * precioPorDimension;
        monto += paquete.getPeso() * precioPorKg;
        return monto;
    }

    @Override
    public double calcularValorDependiente(double montoBase) {
        return 0;
    }
}
