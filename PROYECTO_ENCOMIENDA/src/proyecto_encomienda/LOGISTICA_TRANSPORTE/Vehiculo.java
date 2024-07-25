/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.LOGISTICA_TRANSPORTE;

/**
 *
 * @author ediso
 */
public abstract class Vehiculo {
    protected String marca;
    protected String placa;
    protected int capacidad;
    protected Ubicacion ubicacion;

    // Constructor
    public Vehiculo(String marca, String placa, int capacidad, Ubicacion ubicacion) {
        this.marca = marca;
        this.placa = placa;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getPlaca() {
        return placa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    // Métodos abstractos
    public abstract void obtenerPaquete();
    public abstract void iniciarViaje();
    public abstract void finalizarViaje();
}
