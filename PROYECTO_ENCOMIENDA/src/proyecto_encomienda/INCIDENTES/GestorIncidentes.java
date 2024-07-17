/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.INCIDENTES;

import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;

public class GestorIncidentes {
    private Inventario inventario;

    public GestorIncidentes(Inventario inventario) {
        this.inventario = inventario;
    }

    public void crearIncidente(Incidente incidente, String idPaquete) {
        Paquete paquete = inventario.obtenerPaquete(idPaquete);
        if (paquete != null) {
            incidente.setIdPaquete(idPaquete);
            incidente.registrarIncidente();
            incidente.notificarCliente();
            incidente.actuar();
            incidente.guardarPaquete();
            incidente.guardarEnArchivo();
        } else {
            System.out.println("Paquete no encontrado: " + idPaquete);
        }
    }
}

