/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

import java.io.Serializable;
import mod_paquetes.Paquete;

/**
 * La clase GestorIncidente maneja la creación y resolución de incidentes asociados a paquetes.
 * Utiliza una instancia de la clase Incidente para realizar las operaciones correspondientes.
 * 
 */
public class GestorIncidente implements Serializable {
    // Instancia de Incidente que será manejada por este gestor
    Incidente incidente;
    
    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public void crearIncidente(Paquete paquete) throws PaqueteYaTieneIncidente {
        if (this.incidente == null) {
            return;
        }
        if(incidente.registrar(paquete)) {
            return;
        }
        throw new PaqueteYaTieneIncidente();
    }
    
    public void solucionarIncidente(Paquete paquete, String ... argumentos) throws PaqueteNoTieneIncidente {
        if (this.incidente == null) {
            return;
        }
        if(incidente.resolver(paquete, argumentos)) {
            return;
        }
        throw new PaqueteNoTieneIncidente();
    }
    
    public String getMensaje() {
        if (this.incidente == null) {
            return "";
        }
        return this.incidente.getMensajeSolicitud();
    }
}
