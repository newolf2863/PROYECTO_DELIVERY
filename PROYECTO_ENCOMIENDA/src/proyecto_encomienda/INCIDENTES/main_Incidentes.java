/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.INCIDENTES;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;


/**
 *
 * @author Issac
 */
public class main_Incidentes {      
    public void iniciar(){
        Inventario inventario = new Inventario();
        GestorIncidentes gestor = new GestorIncidentes(inventario);

        Incidente errorDireccion = new ErrorDireccion();
        Incidente paquetePerdido = new PaquetePerdido();
        Incidente dañoPaquete = new DañoPaquete();
        Incidente rechazarEntre = new RechazoEntrega();

        gestor.crearIncidente(errorDireccion, "2");
//        gestor.crearIncidente(paquetePerdido);
//        gestor.crearIncidente(dañoPaquete);
//        gestor.crearIncidente(rechazarEntre);

        errorDireccion.actuar();
        paquetePerdido.actuar();
        dañoPaquete.actuar();
        rechazarEntre.actuar();
    }
    
}
