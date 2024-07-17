
package proyecto_encomienda.Facturación;

/**
 *
 * @author Xelan
 */
public class Precio {
    private double precioFinal;

    public void agregarPrecioFinal(double precio) {
        this.precioFinal += precio;
    }

    public double calcularTotal(Paquete paquete) {
        Impuesto impuesto = new Impuesto(0.15); // Suponiendo un 15% de IVA
        PrecioPaquete precioPaquete = new PrecioPaquete(10.0, 5.0); // Precios por dimensión y peso
        PrecioDistancia precioDistancia = new PrecioDistancia(2.0); // Precio por km

        impuesto.calcularValor(paquete);
        precioPaquete.calcularValor(paquete);
        precioDistancia.calcularValor(paquete);

        agregarPrecioFinal(impuesto.getPrecio());
        agregarPrecioFinal(precioPaquete.getPrecio());
        agregarPrecioFinal(precioDistancia.getPrecio());

        return precioFinal;
    }

    // Getters y setters
    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}