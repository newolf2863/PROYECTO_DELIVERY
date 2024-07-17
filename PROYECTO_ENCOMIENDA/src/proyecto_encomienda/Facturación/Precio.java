
package proyecto_encomienda.Facturación;

/**
 *
 * @author Xelan
 */
public class Precio {
    
    private double precioFinal;
    private double precioInicial;//
 
    
    //////
    private PrecioDistancia precioDistancia;
    private PrecioPaquete precioPaquete;
    private Impuesto impuesto;


    public Precio(double precioFinal,double peso, double dimension, double distancia) {
        this.precioFinal = precioFinal;
        this.precioDistancia = new PrecioDistancia();
       
        this.impuesto = new Impuesto();
       
    }
    
 

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public PrecioDistancia getPrecioDistancia() {
        return precioDistancia;
    }

    public void setPrecioDistancia(PrecioDistancia precioDistancia) {
        this.precioDistancia = precioDistancia;
    }

    public PrecioPaquete getPrecioPaquete() {
        return precioPaquete;
    }

    public void setPrecioPaquete(PrecioPaquete precioPaquete) {
        this.precioPaquete = precioPaquete;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }
    
    
 
}
 

