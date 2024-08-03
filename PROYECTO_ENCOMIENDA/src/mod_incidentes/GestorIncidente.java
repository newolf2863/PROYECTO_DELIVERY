/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

import mod_paquetes.Paquete;
import mod_paquetes.Seguimiento;

/**
 *
 * @author Rodrigo Haro
 */
public class GestorIncidente {
    Incidente incidente;
    
    public GestorIncidente(Incidente incidente) {
        this.incidente = incidente;
    }
    
    public void crearIncidente(Paquete paquete) {
        String registro = incidente.registrar();
        Seguimiento seguimiento = paquete.obtenerSeguimiento();
        seguimiento.registrarIncidente(registro);
    }
    
    public void resolverIncidente(Paquete paquete, String ... argumentos) {
        String registro = incidente.resolver(argumentos);
        Seguimiento seguimiento = paquete.obtenerSeguimiento();
        seguimiento.resolverIncidente(registro);
    }
}
