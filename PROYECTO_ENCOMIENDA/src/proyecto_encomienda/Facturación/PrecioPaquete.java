/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.Facturación;

/**
 *
 * @author Xelan
 */
public class PrecioPaquete implements CalculoPrecio {
    private double precioPorDimension;
    private double precioPorKg;
    private double precio;

    // Constructor
    public PrecioPaquete(double precioPorDimensión, double precioPorKg) {
        this.precioPorDimension = precioPorDimensión;
        this.precioPorKg = precioPorKg;
    }

    public double calcularPorDimension(Paquete paquete) {
        double dimension = paquete.getAncho()*paquete.getLargo();
        return dimension* precioPorDimension;
    }

    public double  calcularPorKg(Paquete paquete) {
        return paquete.getPeso() * precioPorKg;
    }

    @Override
    public void calcularValor(Paquete paquete) {
        this.precio = calcularPorDimension(paquete)+calcularPorKg(paquete);
    }


    public double getPrecio() {
        return precio;
    }

    // Getters y setters

    public void setPrecioPorDimension(double precioPorDimensión) {
        this.precioPorDimension = precioPorDimensión;
    }

    public void setPrecioPorKg(double precioPorKg) {
        this.precioPorKg = precioPorKg;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}