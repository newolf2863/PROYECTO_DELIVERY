/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

import mod_paquetes.Paquete;
import mod_paquetes.Seguimiento;

/**
 * La clase GestorIncidente maneja la creación y resolución de incidentes asociados a paquetes.
 * Utiliza una instancia de la clase Incidente para realizar las operaciones correspondientes.
 * 
 * @autor Rodrigo Haro
 */
public class GestorIncidente {
    // Instancia de Incidente que será manejada por este gestor
    Incidente incidente;
    
    /**
     * Constructor de la clase GestorIncidente.
     * 
     * @param incidente Instancia de la clase Incidente que será gestionada.
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
        // Registra el incidente utilizando el método registrar() de la instancia incidente
        String registro = incidente.registrar();
        // Obtiene el seguimiento del paqueteguimiento seguimiento = paquete.obtenerS
        Seguimiento seguimiento = paquete.obtenerSeguimiento();
        // Registra el incidente en el seguimiento del paquete
        seguimiento.registrarIncidente(registro);
    }
    
    /**
     * Método para resolver un incidente asociado a un paquete.
     * 
     * @param paquete El paquete al cual se le resolverá el incidente.
     * @param argumentos Argumentos necesarios para resolver el incidente.
     */
    public void iniciarSoporte(Paquete paquete, String ... argumentos) {
        // Resolver el incidente utilizando el método resolver del objeto incidente
        String registro = incidente.resolver(argumentos);
        // Obtiene el seguimiento del paquete
        Seguimiento seguimiento = paquete.obtenerSeguimiento();
        // Registra la resolución del incidente en el seguimiento del paquete
        seguimiento.resolverIncidente(registro);
    }
}
