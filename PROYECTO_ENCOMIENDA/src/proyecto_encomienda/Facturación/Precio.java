
package proyecto_encomienda.Facturación;

/**
 *
 * @author Xelan
 */
public class Precio {
    
    private double precioFinal;
    private String inventario;
   
    public Precio(String inventario) {
        this.inventario = inventario;
        this.precioFinal = agregarPrecioFinal(inventario);
    }
   
    public double agregarPrecioFinal(String inventario) {
        double total = 0.0;
        // Aquí iría la lógica para calcular el precio total basado en el inventario
       
        return total;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
        this.precioFinal = agregarPrecioFinal(inventario); // Recalcula el precio final al cambiar el inventario
    }

    public String getInventario() {
        return inventario;
    }
}

