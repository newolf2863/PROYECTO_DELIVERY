/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

/**
 * Clase abstracta que representa un incidente.
 * Define los métodos que deben ser implementados por las clases que hereden de esta.
 * 
 * @autor Rodrigo Haro
 */
public abstract class Incidente {
    
    /**
     * Método abstracto para registrar un incidente.
     * Debe ser implementado por las clases que hereden de Incidente.
     * 
     * @return Una cadena de texto con la descripción del registro del incidente.
     */
    public abstract String registrar();
    
    /**
     * Método abstracto para resolver un incidente.
     * Debe ser implementado por las clases que hereden de Incidente.
     * 
     * @param argumentos Un array de Strings que contiene los argumentos necesarios para resolver el incidente.
     * @return Una cadena de texto con la descripción de la resolución del incidente.
     */
    public abstract String resolver(String[] argumentos);
}
