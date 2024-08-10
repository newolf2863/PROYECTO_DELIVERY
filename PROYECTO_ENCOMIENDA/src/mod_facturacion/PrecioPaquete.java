package mod_facturacion;

import mod_paquetes.Paquete;

/**
 * Calcula el precio basado en las dimensiones y el peso del paquete.
 * Extiende la clase {@link CalculoPrecio} para implementar el cálculo específico basado en el tamaño y peso del paquete.
 */
public class PrecioPaquete extends CalculoPrecio {
    private double precioPorDimension;
    private double precioPorKg;

    /**
     * Constructor que inicializa los precios por dimensión y por kilogramo.
     *
     * @param precioPorDimension el precio que se aplicará por cada unidad de volumen del paquete.
     * @param precioPorKg el precio que se aplicará por cada kilogramo del paquete.
     */
    public PrecioPaquete(double precioPorDimension, double precioPorKg) {
        this.precioPorDimension = precioPorDimension;
        this.precioPorKg = precioPorKg;
    }

    /**
     * Calcula el valor del precio basado en las dimensiones y el peso del paquete.
     *
     * @param paquete el paquete del cual se calculará el precio basado en sus dimensiones y peso.
     * @return el monto calculado basado en las dimensiones y el peso del paquete.
     */
    @Override
    public double calcularValor(Paquete paquete) {
        monto = paquete.getVolumen() * precioPorDimension;
        monto += paquete.getPeso() * precioPorKg;
        return monto;
    }

    /**
     * Calcula el valor dependiente basado en un monto base. Este método no se utiliza en esta clase.
     *
     * @param montoBase el monto base sobre el cual se calcularía el valor dependiente.
     * @return siempre retorna 0, ya que el cálculo dependiente no se aplica en esta clase.
     */
    @Override
    public double calcularValorDependiente(double montoBase) {
        return 0;
    }
}
