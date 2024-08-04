/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

/**
 * Clase que representa un incidente de tipo Paquete Estropeado.
 * Hereda de la clase abstracta Incidente.
 * Gestiona incidentes relacionados con paquetes en malas condiciones.
 * Implementa métodos para registrar y resolver el incidente.
 * 
 * @autor Rodrigo Haro
 */
public class PaqueteEstropeado extends Incidente {

    /**
     * Método para registrar el incidente de paquete estropeado.
     * Sobrescribe el método registrar() de la clase base Incidente.
     * 
     * @return Un mensaje indicando que el paquete se encuentra en malas condiciones.
     */
    @Override
    public String registrar() {
        return "El paquete se encuentra en malas condiciones";
    }

    /**
     * Método para resolver el incidente de paquete estropeado.
     * Sobrescribe el método resolver() de la clase base Incidente.
     * 
     * @param argumentos Un array de Strings que contiene los argumentos necesarios para resolver el incidente.
     *                    Se espera que el primer argumento indique si el incidente es remunerado o no ("Remunerado" o "NoRemunerado").
     *                    Si es remunerado, el segundo argumento debe ser el monto de la compensación.
     * @return Un mensaje indicando la resolución del incidente, ya sea con compensación o sin ella.
     */
    @Override
    public String resolver(String[] argumentos) {
        // Verificar si el incidente es remunerado
        if (argumentos[0].equals("Remunerado")) {
            return "Por los daños presentados en su paquete se le entregará una compensación de " + argumentos[1] + " dólares";
        // Verificar si el incidente no es remunerado
        } else if (argumentos[0].equals("NoRemunerado")) {
            return "No se pueden cubrir los daños que su paquete ha presentado. La empresa se deslinda de toda responsabilidad";
        }
        // Retornar una cadena vacía en caso de que los argumentos no correspondan a ninguna de las opciones anteriores
        return "";    
    }
}
