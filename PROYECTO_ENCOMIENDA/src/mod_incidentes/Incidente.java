/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

import java.io.Serializable;
import mod_paquetes.Paquete;
import mod_paquetes.Seguimiento;

public abstract class Incidente implements Serializable {
    protected String feedback;
    
    public boolean registrar(Paquete paquete) {
        Seguimiento seguimiento = paquete.obtenerSeguimiento();
        if (seguimiento.tieneIncidente()) {
            return false;
        }
        seguimiento.registrarIncidente(this.toString(), getMensajeRegistro(paquete));
        return true;
    }
            
    public boolean resolver(Paquete paquete, String[] argumentos) {
        Seguimiento seguimiento = paquete.obtenerSeguimiento();
        if (!seguimiento.tieneIncidente()) {
            return false;
        }
        manejar(paquete, argumentos);
        seguimiento.registrarResolucion(getMensajeResolucion(paquete));
        return true;
    }
    
    public abstract String getMensajeRegistro(Paquete paquete);
    public abstract String getMensajeResolucion(Paquete paquete);
    public abstract String getMensajeSolicitud();
    public abstract void manejar(Paquete paquete, String[] argumentos);
}
