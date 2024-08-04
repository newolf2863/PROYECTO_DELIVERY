/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

/**
 * Clase que representa un incidente de tipo Error de Dirección.
 * Hereda de la clase Incidente.
 * Gestiona errores relacionados con la imposibilidad de entregar un paquete en la dirección proporcionada.
 * Implementa métodos para registrar y resolver el incidente.
 * 
 * @autor Rodrigo Haro
 */
public class ErrorDireccion extends Incidente {

    /**
     * Método para registrar el incidente de error en la dirección.
     * Sobrescribe el método registrar() de la clase base Incidente.
     * 
     * @return Un mensaje indicando que no se ha podido entregar el paquete en la dirección proporcionada.
     */
    @Override
    public String registrar() {
        return "No se ha podido entregar el paquete en la dirección proporcionada";
    }

    /**
     * Método para resolver el incidente de error en la dirección.
     * Sobrescribe el método resolver() de la clase base Incidente.
     * 
     * @param argumentos Un array de Strings que contiene los argumentos necesarios para resolver el incidente.
     *                   Se espera que el primer argumento sea la nueva dirección.
     * @return Un mensaje indicando que el paquete se ha entregado en una nueva dirección.
     */
    @Override
    public String resolver(String[] argumentos) {
        return "Se ha entregado el paquete en una nueva dirección: " + argumentos[0];
    }
}
