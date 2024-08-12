package mod_facturacion;

import java.io.Serializable;
import mod_paquetes.Paquete;
import java.util.ArrayList;

/**
 * Representa el cálculo del precio total de un paquete, considerando distintos tipos de cálculos de precios.
 * Implementa la interfaz {@link Serializable} para permitir la serialización del objeto.
 */
public class Precio implements Serializable {
    private double precioTotalPaquete;
    private ArrayList<CalculoPrecio> precios;

    /**
     * Constructor que inicializa el cálculo del precio total del paquete.
     *
     * @param paquete el paquete sobre el cual se calculará el precio.
     * @param precioPorDefecto el cálculo de precio por defecto que se aplicará al paquete.
     * @param preciosAdicionales cálculos de precios adicionales que se aplicarán al paquete.
     */
    public Precio(Paquete paquete, CalculoPrecio precioPorDefecto, CalculoPrecio ... preciosAdicionales) {
        precios = new ArrayList<>();
        precioTotalPaquete = 0;
        precioTotalPaquete += precioPorDefecto.calcularValor(paquete);
        precios.add(precioPorDefecto);
        for (CalculoPrecio precio : preciosAdicionales) {
            double monto = precio.calcularValor(paquete);
            if (monto == 0) {
                monto = precio.calcularValorDependiente(precioTotalPaquete);
            }
            precioTotalPaquete += monto;
            precios.add(precio);
        }
    }

    /**
     * Muestra el desglose del precio total del paquete, mostrando cada cálculo de precio individual.
     */
    public void desglosarPrecioTotal() {
        for (CalculoPrecio precio : precios) {
            System.out.println(precio);
        }
    }

    /**
     * Obtiene el precio total del paquete.
     *
     * @return el precio total calculado para el paquete.
     */
    public double getPrecioTotalPaquete() {
        return precioTotalPaquete;
    }

    /**
     * Obtiene una lista de todos los cálculos de precios individuales utilizados para calcular el precio total.
     *
     * @return una lista de objetos {@link CalculoPrecio} que representan los cálculos de precios individuales.
     */
    public ArrayList<CalculoPrecio> obtenerPreciosIndividuales() {
        return precios;
    }
}
