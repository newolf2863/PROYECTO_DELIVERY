/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.LOGISTICA_TRANSPORTE;

/**
 *
 * @author ediso
 */
public class Camion extends Vehiculo {

    // Constructor
    public Camion(String marca, String placa, int capacidad, Ubicacion ubicacion) {
        super(marca, placa, capacidad, ubicacion);
    }

    // Implementación de los métodos abstractos
    @Override
    public void obtenerPaquete() {
        System.out.println("Obteniendo paquete en el camión con placa: " + placa);
    }

    @Override
    public void iniciarViaje() {
        System.out.println("Iniciando viaje en el camión con placa: " + placa);
    }

    @Override
    public void finalizarViaje() {
        System.out.println("Finalizando viaje en el camión con placa: " + placa);
    }
}
