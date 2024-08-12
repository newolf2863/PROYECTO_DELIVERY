/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

import mod_paquetes.Paquete;
import mod_paquetes.Seguimiento;

/**
 *
 * @author Issac
 */
public class SoporteYResolucion {
    public void resolverIncidente(Paquete paquete, EstadoIncidente incidente) {
        // Lógica para resolver el incidente
        String registroResolucion = incidente.resolver();
        // Obtiene el seguimiento del paquete
        Seguimiento seguimiento = paquete.obtenerSeguimiento();
        // Registra la resolución del incidente en el seguimiento del paquete
        seguimiento.resolverIncidente(registroResolucion);
    }
}
