/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.INCIDENTES;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;

/**
 *
 * @author Issac
 */
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;
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
            //inventario.actualizarEstadoPaquete(idPaquete, "Incidente Reportado");
            incidente.guardarPaquete();
        } else {
            System.out.println("Paquete no encontrado: " + idPaquete);
        }
    }
}
