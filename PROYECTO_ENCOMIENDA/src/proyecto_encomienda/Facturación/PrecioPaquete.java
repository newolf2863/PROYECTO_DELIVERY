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
    private double precioPorDimensión;
    private double precioPorKg;
    private double precio;

    // Constructor
    public PrecioPaquete(double precioPorDimensión, double precioPorKg) {
        this.precioPorDimensión = precioPorDimensión;
        this.precioPorKg = precioPorKg;
    }

    public void calcularPorDimension(Paquete paquete) {
        precio += paquete.getDimension() * precioPorDimensión;
    }

    public void calcularPorKg(Paquete paquete) {
        precio += paquete.getPeso() * precioPorKg;
    }

    @Override
    public void calcularValor(Paquete paquete) {
        calcularPorDimension(paquete);
        calcularPorKg(paquete);
    }

    @Override
    public void actualizarParámetro(double parametro) {
        // Implementación para actualizar parámetros si es necesario
    }

    public double getPrecio() {
        return precio;
    }

    // Getters y setters
    public double getPrecioPorDimensión() {
        return precioPorDimensión;
    }

    public void setPrecioPorDimensión(double precioPorDimensión) {
        this.precioPorDimensión = precioPorDimensión;
    }

    public double getPrecioPorKg() {
        return precioPorKg;
    }

    public void setPrecioPorKg(double precioPorKg) {
        this.precioPorKg = precioPorKg;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}