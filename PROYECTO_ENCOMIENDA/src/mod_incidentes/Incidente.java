/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

/**
 * La clase abstracta Incidente define el comportamiento general para manejar incidentes.
 * Esta clase debe ser extendida por clases concretas que implementen los métodos abstractos.
 * 
 * @autor Rodrigo Haro
 */
public abstract class Incidente {
    
    /**
     * Método abstracto para registrar un incidente.
     * Las clases que extiendan esta clase deben proporcionar una implementación concreta.
     * 
     * @return Una cadena que describe el registro del incidente.
     */
    public abstract String registrar();
    
    /**
     * Método abstracto para resolver un incidente.
     * Las clases que extiendan esta clase deben proporcionar una implementación concreta.
     * 
     * @param argumentos Argumentos necesarios para resolver el incidente.
     * @return Una cadena que describe la resolución del incidente.
     */
    public abstract String resolver(String[] argumentos);
}
