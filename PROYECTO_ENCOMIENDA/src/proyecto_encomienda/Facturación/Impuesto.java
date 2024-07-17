/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.Facturación;

/**
 *
 * @author Xelan
 */
public class Impuesto implements CalculoPrecio {
    private double iva;
    private double precio;

    // Constructor
    public Impuesto(double iva) {
        this.iva = iva;
    }

    @Override
    public void calcularValor(Paquete paquete) {
        precio = paquete.getDimension() * iva;
    }

    @Override
    public void actualizarParámetro(double parametro) {
        this.iva = parametro;
    }

    public double getPrecio() {
        return precio;
    }

    // Getters y setters
    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}