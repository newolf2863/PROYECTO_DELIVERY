/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;
import mod_paquetes.Paquete;
import mod_facturacion.Precio;
/**
 *
 * @author Issac
 */
public class SolucionDevolucion extends SoporteYResolucion{
    @Override
    public void resolverIncidente(Paquete paquete, EstadoIncidente incidente) {
        // Obtener el precio del envío desde el módulo de facturación
        double precioEnvio = Precio.obtenerPrecioEnvio(paquete);

        // Calcular el valor a devolver basado en el precio del envío
        double valorDevolucion = calcularValorDevolucion(precioEnvio);

        // Lógica específica para resolver devoluciones
        super.resolverIncidente(paquete, incidente);

        // Imprimir o registrar el valor de la devolución
        System.out.println("Resolución de Devolución completada. Valor a devolver: $" + valorDevolucion);
    }

    /**
     * Método para calcular el valor a devolver basado en el precio del envío.
     * 
     * @param precioEnvio El precio del envío del paquete.
     * @return El valor a devolver.
     */
    private double calcularValorDevolucion(double precioEnvio) {
        // Lógica para calcular el valor de la devolución, por ejemplo, devolver el 100% del precio del envío
        return precioEnvio; 
    }
}
