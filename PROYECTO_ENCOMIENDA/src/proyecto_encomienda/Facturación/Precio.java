
package proyecto_encomienda.Facturación;

/**
 *
 * @author Xelan
 */
public class Precio {
    private double precioFinal;
    private double subtotal;
    private Paquete paquete;
public Precio(Paquete paquete){
    this.paquete = paquete;
    
}
   
    public double calcularTotal() {
        Impuesto impuesto = new Impuesto(0.15); // Suponiendo un 15% de IVA
        PrecioPaquete precioPaquete = new PrecioPaquete(0.5, 1.0); // Precios por dimensión y peso
        PrecioDistancia precioDistancia = new PrecioDistancia(); // Precio por km
        
        precioDistancia.calcularValor(paquete);
        precioPaquete.calcularValor(paquete);
        
       this.subtotal =  precioDistancia.getPrecio()+precioPaquete.getPrecio();
        
        impuesto.calcularValor(subtotal);
       this.precioFinal= impuesto.getPrecio();
        return precioFinal;
    }

    // Getters y setters
    public double getPrecioFinal() {
        return precioFinal;
    }
      public double getSubtotal() {
        return subtotal;
    }
}
