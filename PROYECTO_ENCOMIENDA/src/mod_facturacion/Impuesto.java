package mod_facturacion;

import mod_paquetes.Paquete;

public class Impuesto extends CalculoPrecio {
    private double iva;

    public Impuesto(double iva) {
        this.iva = iva;
    }

    @Override
    public double calcularValor(Paquete paquete) {
        return 0;
    }

    @Override
    public double calcularValorDependiente(double montoBase) {
        monto = montoBase * iva;
        return monto;
    }
}
