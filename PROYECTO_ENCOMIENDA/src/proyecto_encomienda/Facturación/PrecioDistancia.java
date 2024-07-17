/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.Facturación;

/**
 *
 * @author Xelan
 */
public class PrecioDistancia implements CalculoPrecio {
    private double precioPorKm;
    private double precio;

    // Constructor
    public PrecioDistancia(double precioPorKm) {
        this.precioPorKm = precioPorKm;
    }

    @Override
    public void calcularValor(Paquete paquete) {
        // Suponiendo una distancia fija de 100 km para el ejemplo
        double distancia = 100; // km
        precio = distancia * precioPorKm;
        System.out.println("Precio de envio: "+this.precio);
    }

    @Override
    public void actualizarParámetro(double parametro) {
        this.precioPorKm = parametro;
    }

    public double getPrecio() {
        return precio;
    }

    // Getters y setters
    public double getPrecioPorKm() {
        return precioPorKm;
    }

    public void setPrecioPorKm(double precioPorKm) {
        this.precioPorKm = precioPorKm;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
