/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.Facturación;

/**
 *
 * @author USUARIO
 */
public class Paquete {
    private double peso;
    private double dimension;
    private String contenido;
    private String remitente;
    private String direccion;

    // Constructor
    public Paquete(double peso, double dimension, String contenido, String remitente, String direccion) {
        this.peso = peso;
        this.dimension = dimension;
        this.contenido = contenido;
        this.remitente = remitente;
        this.direccion = direccion;
    }

    // Getters y setters
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getDimension() {
        return dimension;
    }

    public void setDimension(double dimension) {
        this.dimension = dimension;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
