/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.LOGISTICA_TRANSPORTE;

/**
 *
 * @author USUARIO
 */
public class Carro extends Vehiculo {

    // Constructor
    public Carro(String marca, String placa, int capacidad, Ubicacion ubicacion) {
        super(marca, placa, capacidad, ubicacion);
    }

    // Implementación de los métodos abstractos
    @Override
    public void obtenerPaquete() {
        System.out.println("Obteniendo paquete en el carro con placa: " + placa);
    }

    @Override
    public void iniciarViaje() {
        System.out.println("Iniciando viaje en el carro con placa: " + placa);
    }

    @Override
    public void finalizarViaje() {
        System.out.println("Finalizando viaje en el carro con placa: " + placa);
    }
}