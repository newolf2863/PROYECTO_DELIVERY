package mod_incidentes;

import mod_facturacion.Factura;
import mod_facturacion.Precio;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SolucionDevolucion extends SoporteYResolucion {
    public void resolverIncidente(String codigoTracking) {
        Inventario inventario = Inventario.obtenerInstancia();
        Paquete paquete = inventario.obtenerPaquete(codigoTracking);

        if (paquete == null) {
            System.out.println("Paquete no encontrado para el código de tracking: " + codigoTracking);
            return;
        }
        // Cargar las facturas desde el archivo
        ArrayList<Factura> facturas = cargarFacturas();

        // Buscar la factura asociada al código de tracking
        Factura factura = obtenerFacturaPorCodigoTracking(facturas, codigoTracking);
        if (factura == null) {
            System.out.println("Factura no encontrada para el código de tracking: " + codigoTracking);
            return;
        }

        // Obtener el precio del envío desde la factura
        Precio precio = factura.obtenerPrecio();
        double precioEnvio = precio.getPrecioTotalPaquete();

        // Calcular el valor a devolver basado en el precio del envío
        double valorDevolucion = calcularValorDevolucion(precioEnvio);

        // Lógica específica para resolver devoluciones
        EstadoIncidente incidente = new PaqueteEstropeado(); // Supone que tienes una clase Devolucion que extiende EstadoIncidente
        super.resolverIncidente(paquete, incidente);

        // Imprimir o registrar el valor de la devolución
        System.out.println("Resolución de Devolución completada. Valor a devolver: $" + valorDevolucion);
    }

    public ArrayList<Factura> cargarFacturas() {
        String filePath = "src/archivos/facturas.ser";
        ArrayList<Factura> facturas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            facturas = (ArrayList<Factura>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las facturas: " + e.getMessage());
        }
        return facturas;
    }

    public Factura obtenerFacturaPorCodigoTracking(ArrayList<Factura> facturas, String codigoTracking) {
        for (Factura factura : facturas) {
            if (factura.obtenerCodigoTracking().equals(codigoTracking)) {
                return factura;
            }
        }
        return null;
    }

    private double calcularValorDevolucion(double precioEnvio) {
        // Lógica para calcular el valor de la devolución, por ejemplo, devolver el 100% del precio del envío
        return precioEnvio; 
    }
}
