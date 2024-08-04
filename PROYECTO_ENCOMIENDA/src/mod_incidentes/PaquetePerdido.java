/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

/**
 * Clase que representa un incidente de tipo Paquete Perdido.
 * Hereda de la clase abstracta Incidente.
 * Gestiona incidentes relacionados con paquetes cuya ubicación es desconocida.
 * Implementa métodos para registrar y resolver el incidente.
 * 
 * @autor Rodrigo Haro
 */
public class PaquetePerdido extends Incidente {

    /**
     * Método para registrar el incidente de paquete perdido.
     * Sobrescribe el método registrar() de la clase base Incidente.
     * 
     * @return Un mensaje indicando que la ubicación del paquete es desconocida.
     */
    @Override
    public String registrar() {
        return "La ubicación de su paquete es desconocida";
    }

    /**
     * Método para resolver el incidente de paquete perdido.
     * Sobrescribe el método resolver() de la clase base Incidente.
     * 
     * @param argumentos Un array de Strings que contiene los argumentos necesarios para resolver el incidente.
     *                   Se espera que el primer argumento indique si el paquete ha sido recuperado ("Recuperado") o no ("Desconocido").
     * @return Un mensaje indicando la resolución del incidente, ya sea que el paquete haya sido recuperado o no.
     */
    @Override
    public String resolver(String[] argumentos) {
        // Verificar si el paquete ha sido recuperado
        if (argumentos[0].equals("Recuperado")) {
            return "Se ha recuperado su paquete y pronto se le será entregado";
        // Verificar si la ubicación del paquete sigue siendo desconocida
        } else if (argumentos[0].equals("Desconocido")) {
            return "Su paquete no se ha podido encontrar, por favor, acérquese a la agencia más cercana para recibir una compensación";
        }
        // Retornar una cadena vacía en caso de que los argumentos no correspondan a ninguna de las opciones anteriores
        return "";
    }
}
