package mod_facturacion;

import mod_paquetes.Paquete;

/**
 * Representa el cálculo del impuesto aplicado al precio de un paquete.
 * Hereda de la clase {@link CalculoPrecio} para implementar el cálculo específico del impuesto.
 */
public class Impuesto extends CalculoPrecio {
    private double iva;

    /**
     * Constructor que inicializa el porcentaje de IVA a aplicar.
     *
     * @param iva el porcentaje de IVA a aplicar (por ejemplo, 0.12 para un 12%).
     */
    public Impuesto(double iva) {
        this.iva = iva;
    }

    /**
     * Calcula el valor del impuesto para el paquete dado.
     *
     * En esta implementación, el valor del impuesto no se calcula en base al paquete.
     *
     * @param paquete el paquete sobre el cual se calcula el impuesto.
     * @return el valor del impuesto, que en esta implementación es 0.
     */
    @Override
    public double calcularValor(Paquete paquete) {
        return 0;
    }

    /**
     * Calcula el valor del impuesto en base al monto base proporcionado.
     *
     * El monto del impuesto se calcula multiplicando el monto base por el porcentaje de IVA.
     *
     * @param montoBase el monto base sobre el cual se calcula el impuesto.
     * @return el valor del impuesto calculado.
     */
    @Override
    public double calcularValorDependiente(double montoBase) {
        monto = montoBase * iva;
        return monto;
    }
}
