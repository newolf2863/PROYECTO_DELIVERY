package mod_facturacion;

import java.io.Serializable;
import mod_paquetes.Paquete;

/**
 * Clase abstracta para el cálculo de precios en un sistema de facturación.
 * Implementa la interfaz {@link Serializable} para permitir la serialización.
 */
public abstract class CalculoPrecio implements Serializable {

    /** Monto calculado por la implementación del cálculo de precios. */
    protected double monto;

    /**
     * Obtiene el monto calculado.
     *
     * @return el monto calculado.
     */
    public double obtenerMonto() {
        return Math.round(monto * 100.0) / 100.0;
    }

    /**
     * Calcula el valor del paquete basado en la implementación concreta.
     *
     * @param paquete el paquete del cual se calculará el valor.
     * @return el valor calculado para el paquete.
     */
    public abstract double calcularValor(Paquete paquete);

    /**
     * Calcula el valor dependiente del monto base.
     *
     * @param montoBase el monto base sobre el cual se calcula el valor dependiente.
     * @return el valor calculado dependiente del monto base.
     */
    public abstract double calcularValorDependiente(double montoBase);
}
