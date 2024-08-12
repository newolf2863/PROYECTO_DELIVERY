package mod_facturacion;

import mod_paquetes.Paquete;

/**
 * Calcula el precio basado en la distancia del paquete.
 * Extiende la clase {@link CalculoPrecio} para implementar el cálculo específico basado en distancia.
 */
public class PrecioDistancia extends CalculoPrecio {
    private double precioPorKm;

    /**
     * Constructor que inicializa el precio por kilómetro.
     *
     * @param precioPorKm el precio que se aplicará por cada kilómetro de distancia.
     */
    public PrecioDistancia(double precioPorKm) {
        this.precioPorKm = precioPorKm;
    }

    /**
     * Calcula el valor del precio basado en la distancia del paquete.
     *
     * @param paquete el paquete del cual se calculará el precio basado en la distancia.
     * @return el monto calculado basado en la distancia del paquete.
     */
    @Override
    public double calcularValor(Paquete paquete) {
        monto = paquete.calcularDistancia() * precioPorKm;
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
