/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

/**
 * La clase ErrorDireccion representa un tipo específico de incidente relacionado con errores en la dirección de entrega.
 * Extiende la clase base Incidente.
 * 
 * @autor Rodrigo Haro
 */
public class ErrorDireccion extends EstadoIncidente {

    /**
     * Método para registrar el incidente de error en la dirección.
     * 
     * @return String con el mensaje de registro del incidente.
     */
    @Override
    public String registrar() {
        return "No se ha podido entregar el paquete en la dirección proporcionada";
    }

    /**
     * Método para resolver el incidente de error en la dirección.
     * 
     * @param argumentos Un array de Strings que contiene los argumentos necesarios para resolver el incidente.
     *                   En este caso, se espera que el primer argumento sea la nueva dirección de entrega.
     * @return String con el mensaje de resolución del incidente.
     */
    @Override
    public String resolver(String[] argumentos) {
        return "Se ha entregado el paquete en una nueva dirección: " + argumentos[0];
    }
}
