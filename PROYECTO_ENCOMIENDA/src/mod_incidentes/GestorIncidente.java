/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

import mod_paquetes.Paquete;
import mod_paquetes.Seguimiento;

/**
 * Clase que gestiona los incidentes relacionados con paquetes.
 * Permite crear y resolver incidentes utilizando un objeto de tipo Incidente.
 * 
 * @autor Rodrigo Haro
 */
public class GestorIncidente {
    // Atributo que representa el incidente a gestionar
    Incidente incidente;
    
    /**
     * Constructor de la clase GestorIncidente.
     * Inicializa el gestor con un objeto de tipo Incidente.
     * 
     * @param incidente El incidente que será gestionado por esta clase.
     */
    public GestorIncidente(Incidente incidente) {
        this.incidente = incidente;
    }
    
//    /**
//     * Método para crear un incidente asociado a un paquete.
//     * Registra el incidente y lo añade al seguimiento del paquete.
//     * 
//     * @param paquete El paquete al cual se le registrará el incidente.
//     */
    public void crearIncidente(Paquete paquete) {
        // Registrar el incidente utilizando el método registrar del objeto incidente
        String registro = incidente.registrar();
        // Obtener el objeto Seguimiento del paquete
        Seguimiento seguimiento = paquete.obtenerSeguimiento();
        // Registrar el incidente en el seguimiento del paquete
        seguimiento.registrarIncidente(registro);
    }
    
    /**
     * Método para resolver un incidente asociado a un paquete.
     * Resuelve el incidente con los argumentos proporcionados y actualiza el seguimiento del paquete.
     * 
     * @param paquete El paquete cuyo incidente será resuelto.
     * @param argumentos Argumentos necesarios para resolver el incidente.
     */
    public void iniciarSoporte(Paquete paquete, String ... argumentos) {
        // Resolver el incidente utilizando el método resolver del objeto incidente
        String registro = incidente.resolver(argumentos);
        // Obtener el objeto Seguimiento del paquete
        Seguimiento seguimiento = paquete.obtenerSeguimiento();
        // Registrar la resolución del incidente en el seguimiento del paquete
        seguimiento.resolverIncidente(registro);
    }
}
